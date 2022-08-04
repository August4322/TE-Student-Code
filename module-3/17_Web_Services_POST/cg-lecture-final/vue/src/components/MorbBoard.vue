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
        <div class="message whiteBackground" v-if="matchedCards">
            <h1>Match Found!</h1>
        </div>
        <div v-if="hasWon" class="whiteBackground">YOU'VE WON!!!</div>
        <div v-if="hasLost" class="whiteBackground">YOU'VE LOST!!!</div>
        <main  v-if="!hasWon && !hasLost">
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
      },
      hasWon(){
          let won = true;

          if(!this.$store.state.cards.length) {
              won = false;
          }

          this.$store.state.cards.forEach(
              (x) => {
                  if(!x.detrimental && !x.matched) {
                      won = false;
                  }
              }
          )
          return won;
      },
      hasLost(){
          let lost = this.$store.state.cards.filter(
              (x) => x.matched && x.detrimental
          )
          return lost.length >= 2;
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

