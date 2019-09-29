package com.prometheus.bank.service;

import com.prometheus.bank.dao.CardDAO;
import com.prometheus.bank.dao.ClientDAO;
import com.prometheus.bank.dao.UserDAO;
import com.prometheus.bank.entity.Card;
import com.prometheus.bank.entity.Client;
import com.prometheus.bank.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardServiceImpl extends AbstractService<Card> implements CardService {

    @Autowired
    private CardDAO cardDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Card getCard(long id) {
        return get(id);
    }

    @Override
    public List<Card> getAllCards() {
        return getAll();
    }

    @Override
    public List<Card> getAllCardsForClient(String username) {
        long clientId = userDAO.getUser(username).getClient().getId();
        List<Card> cards = cardDAO.getCardsForClient(clientId);

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
