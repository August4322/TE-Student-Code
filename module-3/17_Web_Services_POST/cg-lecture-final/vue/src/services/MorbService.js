import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getCards() {
    return http.get('/shuffledDeck');
  },

  getUniqueCards() {
    return http.get('/cards');
  },

  getCard(cardId) {
    return http.get('/card/'+ cardId);
  },

  deleteCard(cardId) {
    const url = '/card/' + cardId;
    return http.delete(url);
  },

  saveCard(card) {
    if(card.cardId) {
      return this.updateCard(card);
    } else {
      return this.createNewCard(card);
    }
  },

  updateCard(card) {
    const url = "/card";
    return http.put(url, card);
  },

  createNewCard(card) {
    const url = "/card";
    return http.post(url, card);
  }
}
