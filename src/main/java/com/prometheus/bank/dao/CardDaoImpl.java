package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Card;
import com.prometheus.bank.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CardDaoImpl extends GenericDaoImpl<Card> implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Card getCard(long id) {
        return get(id);
    }

    @Override
    public List<Card> getAllCards() {
        return getAll();
    }

    @Override
    public List<Card> getCardsForClient(long clientId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Card WHERE holder='"+clientId+"'", Card.class);
        List<Card> cards = query.getResultList();

        return cards;
    }

    @Override
    public void saveCard(Card card) {
        save(card);
    }

    @Override
    public void updateCard(Card card) {
        update(card);
    }

    @Override
    public void deleteCard(long id) {
        delete(id);
    }
}
