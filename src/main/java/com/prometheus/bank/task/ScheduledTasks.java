package com.prometheus.bank.task;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Loan;
import com.prometheus.bank.entity.Transaction;
import com.prometheus.bank.logger.Logger;
import com.prometheus.bank.service.AccountService;
import com.prometheus.bank.service.FeeService;
import com.prometheus.bank.service.LoanService;
import com.prometheus.learning.utils.datetime.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private AccountService accountService;

    @Autowired
    private LoanService loanService;

    @Autowired
    private FeeService feeService;

    //second - minute - hour - day - month - year
    @Scheduled(cron = "0 0 0 * * *")
    public void handleMonthlyAccountFees() {
        Logger.logger.info("Scheduled task every minute");
        List<Account> accounts = accountService.getAllAccounts();
        for(Account account : accounts) {
            Transaction transaction = new Transaction();
            transaction.setSender(account.getOwner());
            transaction.setSenderAccount(account);
            transaction.setAmount(feeService.getServiceFee("monthly_account_fee").getFee());
            transaction.setSendDateTime(LocalDateTime.now());
            transaction.setComment("Konto hooldustasu");
            accountService.processTransaction(transaction);
        }
    }

    //second - minute - hour - day - month - year
    @Scheduled(cron = "0 0 0 * * *")
    public void handleLoans() {
        Logger.logger.info("Handling loans");
        List<Loan> loans = loanService.getAllLoans();
        for(Loan loan : loans) {
            Transaction transaction = new Transaction();
            transaction.setSender(loan.getClient());
            transaction.setSenderAccount(loan.getClient().getAccounts().get(0));
            transaction.setSendDateTime(LocalDateTime.now());
            transaction.setAmount(loan.getMonthlyPaymentAmount());
            transaction.setComment("Laenumakse: " + loan.getType());
            accountService.processTransaction(transaction);
        }

    }



}
