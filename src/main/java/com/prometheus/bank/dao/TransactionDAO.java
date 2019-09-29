package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Transaction;

import java.util.List;

public interface TransactionDAO extends IGenericDAO<Transaction> {

    Transaction getTransaction(long id);

    List<Transaction> getAllTransactions();

    void saveTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    void deleteTransaction(long id);

}
