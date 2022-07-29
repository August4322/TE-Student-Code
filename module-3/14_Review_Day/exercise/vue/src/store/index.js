import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    cards: []
  },
  mutations: {
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
    }
  }
})
