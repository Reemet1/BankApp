package com.prometheus.bank.service;

import com.prometheus.bank.entity.Card;

import java.util.List;

public interface CardService extends IService<Card> {

    Card getCard(long id);

    List<Card> getAllCards();

    List<Card> getAllCardsForClient(String username);

    void saveCard(Card card);

    void updateCard(Card card);

    void deleteCard(long id);

}
