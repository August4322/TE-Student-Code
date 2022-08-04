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
  }
}
