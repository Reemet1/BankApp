package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Account;

import java.util.List;

public interface AccountDAO extends IGenericDAO<Account> {

    Account getAccount(long id);

    List<Account> getAllAccounts();

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(long id);

    void changeBalance(Account account, double byAmount);

}
