package com.techelevator.controller;

import com.techelevator.dao.MorbiusDao;
import com.techelevator.model.Card;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MorbiusController {

    private MorbiusDao dao;

    public MorbiusController(MorbiusDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value="/cards", method = RequestMethod.GET)
    public List<Card> getCards() {
        return dao.getShuffledDeck();
    };
}
