package com.techelevator.dao;

import com.techelevator.model.Card;

import java.util.List;

public interface MorbiusDao {
    List<Card> getShuffledDeck();

    List<Card> getCards();

    Card getCard(int cardId);

    int createNewCard(Card card);

    void updateCard(Card card);

    void deleteCard(int cardId);
}
