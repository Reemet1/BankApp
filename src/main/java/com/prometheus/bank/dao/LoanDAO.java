package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Loan;

import java.util.List;

public interface LoanDAO extends IGenericDAO<Loan> {

    List<Loan> getAllLoans();

    List<Loan> getLoansForClient(long clientId);

    void addLoan(Loan loan);

    void updateLoan(Loan loan);

}
