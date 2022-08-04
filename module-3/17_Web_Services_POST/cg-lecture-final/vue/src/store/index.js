import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    cards: [],
    flippedCards: [],
    uniqueCards: []
  },
  mutations: {
    ON_MATCH(state) {
      state.flippedCards[0].matched = true;
      state.flippedCards[1].matched = true;
      state.flippedCards = [];
    },
    NO_MATCH(state){
      state.flippedCards[0].isFaceDown = true;
      state.flippedCards[1].isFaceDown = true;
      state.flippedCards = [];
    },
    FLIP_CARD(state, card) {

      if(!card.matched) {
        card.isFaceDown = false;
        state.flippedCards.push(card);
      }
   
    },
    SHUFFLE_DECK(state, deck) {

      deck = deck.sort(() => {
          //we can randomly shuffle the array
          return (Math.random() > .5) ? 1 : -1;
      });

      deck.forEach(
        (x) => {
          x.isFaceDown = true;
          x.matched = false;
        }
      );

      state.cards = deck;
    }, 
    SET_UNIQUE_CARD_LIST(state, cards) {
      state.uniqueCards = cards;
    }
  }
})
