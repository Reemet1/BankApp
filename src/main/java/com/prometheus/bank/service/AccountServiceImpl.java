package com.prometheus.bank.service;

import com.prometheus.bank.dao.AccountDAO;
import com.prometheus.bank.dao.ClientDAO;
import com.prometheus.bank.dao.TransactionDAO;
import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl extends AbstractService<Account> implements AccountService {

    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account getAccount(long id) {
        return get(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return getAll();
    }

    @Override
    public void saveAccount(Account account) {
        save(account);
    }

    @Override
    public void updateAccount(Account account) {
        update(account);
    }

    @Override
    public void deleteAccount(long id) {
        delete(id);
    }

    @Override
    public boolean processTransaction(Transaction transaction) {

        accountDAO.changeBalance(transaction.getSenderAccount(), -transaction.getAmount());
        if(transaction.getReceiverAccount() != null) {
            accountDAO.changeBalance(transaction.getReceiverAccount(), transaction.getAmount());
        }

        transactionDAO.saveTransaction(transaction);
        processTransactionFee(transaction);

        return true;
    }

    private void processTransactionFee(Transaction transaction) {

        Account senderAccount = transaction.getSenderAccount();
        Transaction serviceFeeTransaction = new Transaction();
        serviceFeeTransaction.setSender(transaction.getSender());
        serviceFeeTransaction.setSenderAccount(transaction.getSenderAccount());
        serviceFeeTransaction.setComment("Teenustasu");
        serviceFeeTransaction.setAmount(0.2);
        accountDAO.changeBalance(transaction.getSenderAccount(), -transaction.getAmount());
        serviceFeeTransaction.setSendDateTime(LocalDateTime.now());

        transactionDAO.saveTransaction(serviceFeeTransaction);

    }


}
