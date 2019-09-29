package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Account;
import com.prometheus.bank.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account getAccount(long id){return get(id);}

    @Override
    public List<Account> getAllAccounts(){return getAll();}

    @Override
    public void saveAccount(Account account){save(account);}

    @Override
    public void updateAccount(Account account){update(account);}

    @Override
    public void deleteAccount(long id){delete(id);}

    @Override
    public void changeBalance(Account account, double byAmount) {

        account.setBalance(account.getBalance()+byAmount);
        updateAccount(account);

    }
}
