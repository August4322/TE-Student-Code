<template>
    <div>
         <header>
            <h1>Morbin' Matching</h1>
            <p>
            Morbius has lost some of his most precious things. He always has two of everything he loves. 
            Helping him find each pair, without accidentally clicking on two bad reviews.
            </p>
            <button id="btnStartOver" v-on:click="resetBoard()">Start!</button>
        </header>
        <div class="message" v-if="matchedCards">
            <h1>Match Found!</h1>
        </div>
        <main >
           <morb-card v-for="card in $store.state.cards" v-bind:key="card.cardId"
            v-bind:card="card"> </morb-card>
        </main>
        
    </div>        
</template>

<script>
import morbService from '../services/MorbService';
import morbCard from './MorbCard.vue'

export default {
  name: "morb-board",
  components: {
      morbCard
  },
  computed: {
      matchedCards () {
          if(this.$store.state.flippedCards.length >= 2) {

              let title1 = this.$store.state.flippedCards[0].title;
              let title2 = this.$store.state.flippedCards[1].title;
              if(title1 === title2) {
                  this.indicateMatch(true);
                  return true;
              } else {
                  this.indicateMatch(false);
                  return false;
              }

          }

          return false;
      }
  },
  methods: {
      indicateMatch(match) {
          setTimeout(
              () => {
                  if(match) {
                      this.$store.commit("ON_MATCH");
                  } else {
                      this.$store.commit("NO_MATCH");
                  }
              }, 1500
          )
      },
      resetBoard(){
          morbService.getCards().then(response => {
            let cards = response.data;
            this.$store.commit("SHUFFLE_DECK", cards);
            });
      }
  }
}
</script>

