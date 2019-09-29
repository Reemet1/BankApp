package com.prometheus.bank.service;

import com.prometheus.bank.entity.Loan;

import java.util.List;

public interface LoanService extends IService<Loan> {

    List<Loan> getAllLoans();

    List<Loan> getLoansForClient(long clientId);

    void addLoan(Loan loan);

    void updateLoan(Loan loan);

}
