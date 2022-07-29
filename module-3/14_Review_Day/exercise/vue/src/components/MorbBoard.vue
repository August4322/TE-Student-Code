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

        <main >
           
        </main>
        
    </div>        
</template>

<script>
import morbService from '../services/MorbService';

export default {
  name: "morb-board",
  methods: {
      resetBoard(){
          morbService.getCards().then(response => {
            let cards = response.data;
            this.$store.commit("SHUFFLE_DECK", cards);
            });
      }
  }
}
</script>

