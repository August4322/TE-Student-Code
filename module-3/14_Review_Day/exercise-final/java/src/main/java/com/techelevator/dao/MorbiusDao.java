package com.techelevator.dao;

import com.techelevator.model.Card;

import java.util.List;

public interface MorbiusDao {
    List<Card> getShuffledDeck();
}
