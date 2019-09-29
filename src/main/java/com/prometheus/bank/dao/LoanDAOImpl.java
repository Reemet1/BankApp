package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Card;
import com.prometheus.bank.entity.Loan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LoanDAOImpl extends GenericDaoImpl<Loan> implements LoanDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Loan> getAllLoans() {
        return getAll();
    }

    @Override
    public List<Loan> getLoansForClient(long clientId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Loan WHERE client='"+clientId+"'", Loan.class);
        List<Loan> loans = query.getResultList();
        return loans;
    }

    @Override
    public void addLoan(Loan loan) {
        save(loan);
    }

    @Override
    public void updateLoan(Loan loan) {
        update(loan);
    }
}
