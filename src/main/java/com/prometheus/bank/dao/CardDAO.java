package com.prometheus.bank.dao;

import com.prometheus.bank.entity.Card;

import java.util.List;

public interface CardDAO extends IGenericDAO<Card> {

    Card getCard(long id);

    List<Card> getAllCards();

    List<Card> getCardsForClient(long clientId);

    void saveCard(Card card);

    void updateCard(Card card);

    void deleteCard(long id);

}
