package com.prometheus.bank.service;

import com.prometheus.bank.dao.LoanDAO;
import com.prometheus.bank.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl extends AbstractService<Loan> implements LoanService {

    @Autowired
    private LoanDAO loanDAO;

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
        loanDAO.addLoan(loan);
    }

    @Override
    public void updateLoan(Loan loan) {
        loanDAO.updateLoan(loan);
    }
}
