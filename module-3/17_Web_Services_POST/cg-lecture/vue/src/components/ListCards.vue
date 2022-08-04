<template>
  <div>
      <router-link v-bind:to="{name: 'Create'}">Create New Card</router-link>
      <div v-if="errorMsg"> 
          {{errorMsg}}
      </div>
      <table>
          <thead>
              <tr>
                  <th>Card Id</th>
                  <th>Title</th>
                  <th>Caption</th>
                  <th>Image</th>
                  <th>Detrimental</th>
                  <th>Actions</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="card in $store.state.uniqueCards" v-bind:key="card.cardId">
                  <td>{{card.cardId}}</td>
                  <td>{{card.title}}</td>
                  <td>{{card.caption}}</td>
                  <td>{{card.img}}</td>
                  <td>{{card.detrimental}}</td>
                  <td>
                      <router-link v-bind:to="{name: 'Edit', params: {cardId: card.cardId}}">Edit</router-link>
                      &nbsp; &nbsp;
                      <a href="#" v-on:click="deleteCard(card.cardId)" >Delete</a>
                  </td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
import morbService from "@/services/MorbService.js";

export default {
    name: 'list-cards',
    data() {
        return {
            cards: [],
            errorMsg: ""
        }
    },
    created() {
        this.loadCards();
    }, 
    methods: {
        loadCards() {
            morbService.getUniqueCards().then(
                response => {
                    const cards = response.data;
                    this.$store.commit("SET_UNIQUE_CARD_LIST", cards);
                }
            )
        },
        deleteCard(cardId) {
            console.log(cardId);
            //TODO
        }

    }
}
</script>

<style>

</style>