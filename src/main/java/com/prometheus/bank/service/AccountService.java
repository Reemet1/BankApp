package com.prometheus.bank.service;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Transaction;

import java.util.List;

public interface AccountService extends IService<Account> {

    Account getAccount(long id);

    List<Account> getAllAccounts();

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(long id);

    boolean processTransaction(Transaction transaction);

}
