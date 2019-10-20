package com.prometheus.bank.service;

import com.prometheus.bank.dao.LoanDAO;
import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.Document;
import com.prometheus.bank.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl extends AbstractService<Loan> implements LoanService {

    @Autowired
    private LoanDAO loanDAO;

    @Autowired
    private UserService userService;

    @Override
    public List<Loan> getAllLoans() {
        return loanDAO.getAllLoans();
    }

    @Override
    public List<Loan> getLoansForClient(long clientId) {
        return loanDAO.getLoansForClient(clientId);
    }

    @Override
    public void addLoan(Loan loan) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = userService.getUser(user.getUsername()).getClient();
        loan.setClient(client);

        Document document = new Document();
        document.setClient(client);

        loan.setContract(document);
        loan.setClient(client);
        double interestRate = 0.04;
        double totalInterest = loan.getTotalPaybackTime()*interestRate;
        double totalPaybackAmount = loan.getLoanAmount()+loan.getLoanAmount()*totalInterest;
        double monthlyPay = totalPaybackAmount/loan.getTotalPaybackTime();

        loan.setInterestRate(interestRate);
        loan.setPaybackAmount(totalPaybackAmount);
        loan.setMonthlyPaymentAmount(monthlyPay);

        loanDAO.addLoan(loan);
    }


    @Override
    public void updateLoan(Loan loan) {
        loanDAO.updateLoan(loan);
    }
}
