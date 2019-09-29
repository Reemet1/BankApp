package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDAO {

    @Override
    public Transaction getTransaction(long id) {
        return get(id);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return getAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        save(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        update(transaction);
    }

    @Override
    public void deleteTransaction(long id) {
        delete(id);
    }
}
