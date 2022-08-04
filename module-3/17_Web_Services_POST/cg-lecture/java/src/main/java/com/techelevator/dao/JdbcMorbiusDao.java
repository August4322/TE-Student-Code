package com.techelevator.dao;

import com.techelevator.model.Card;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcMorbiusDao implements MorbiusDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcMorbiusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> getShuffledDeck() {

        List<Card> shuffledDeck = new ArrayList<>();

        String sql = "SELECT card_id, img_path, title, caption, is_detrimental FROM cards;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            // do it twice to make sure each card is a pair
            shuffledDeck.add(mapRowToCard(results));
            shuffledDeck.add(mapRowToCard(results));
        }

        for(int i=0; i<shuffledDeck.size();i++) {
            shuffledDeck.get(i).setCardId(i+1);
        }

        return shuffledDeck;
    }

    @Override
    public List<Card> getCards() {
        List<Card> deck = new ArrayList<>();

        String sql = "SELECT card_id, img_path, title, caption, is_detrimental FROM cards;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            // do it twice to make sure each card is a pair
            deck.add(mapRowToCard(results));
        }

        return deck;
    }

    @Override
    public Card getCard(int cardId) {

        Card card = null;

        String sql = "SELECT card_id, img_path, title, caption, is_detrimental FROM cards" +
                " WHERE card_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cardId);
        if (results.next()) {
            card = mapRowToCard(results);
        }

        return card;
    }

    @Override
    public int createNewCard(Card card) {

        String sql = "INSERT INTO cards(img_path, title, caption, is_detrimental) " +
                "VALUES(?,?,?,?) RETURNING card_id;";

        int newCardId = jdbcTemplate.queryForObject(sql, Integer.class, card.getImg(),
                card.getTitle(), card.getCaption(), card.isDetrimental());

        return newCardId;

    }



    @Override
    public void updateCard(Card card) {

        String sql = "UPDATE cards " +
                "SET img_path = ?, " +
                "title = ?, " +
                "caption = ?, " +
                "is_detrimental = ? " +
                "WHERE card_id = ?;";

        jdbcTemplate.update(sql, card.getImg(), card.getTitle(), card.getCaption(), card.isDetrimental(), card.getCardId());

    }

    @Override
    public void deleteCard(int cardId) {

        String sql = "DELETE FROM cards " +
                     "WHERE card_id = ?;";

        jdbcTemplate.update(sql, cardId);
    }

    private Card mapRowToCard(SqlRowSet rs) {
        Card card = new Card();
        card.setCardId(rs.getInt("card_id"));
        card.setImg(rs.getString("img_path"));
        card.setTitle(rs.getString("title"));
        card.setCaption(rs.getString("caption"));
        card.setDetrimental(rs.getBoolean("is_detrimental"));
        return card;
    }
}
