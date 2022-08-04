package com.techelevator.controller;

import com.techelevator.dao.MorbiusDao;
import com.techelevator.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MorbiusController {

    private MorbiusDao dao;

    public MorbiusController(MorbiusDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value="/shuffledDeck", method = RequestMethod.GET)
    public List<Card> getShuffledDeck() {
        return dao.getShuffledDeck();
    };

    @RequestMapping(value="/cards", method = RequestMethod.GET)
    public List<Card> getCards() {
        return dao.getCards();
    };


    @RequestMapping(value="/card/{cardId}", method = RequestMethod.GET)
    public Card getCard(@PathVariable int cardId) {
        return dao.getCard(cardId);
    };

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/card", method = RequestMethod.POST)
    public int createCard(@RequestBody Card card) {
        return dao.createNewCard(card);
    };

    @RequestMapping(value="/card", method = RequestMethod.PUT)
    public void updateCard(@RequestBody Card card) {
        dao.updateCard(card);
    };

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value="/card/{cardId}", method = RequestMethod.DELETE)
    public void deleteCard(@PathVariable int cardId) {
        dao.deleteCard(cardId);
    };
}
