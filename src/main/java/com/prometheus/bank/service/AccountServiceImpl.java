package com.prometheus.bank.service;

import com.prometheus.bank.dao.AccountDAO;
import com.prometheus.bank.dao.ClientDAO;
import com.prometheus.bank.dao.TransactionDAO;
import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        accountDAO.changeBalance(transaction.getReceiverAccount(), transaction.getAmount());

        transactionDAO.saveTransaction(transaction);

        return true;
    }
}
