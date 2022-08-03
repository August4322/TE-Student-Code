<template>
  <div>
      <div v-for="book in this.$store.state.books" v-bind:key="book.isbn"> 
      <router-link v-bind:to="{name: 'bookDetails', params: {isbn: book.isbn}}">
      <reading-list></reading-list>
      </router-link>
      </div>
      <router-link v-bind:to="{name: 'addBook'}">Add Book to Reading List</router-link>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
  components: { 
      ReadingList 
    }

}
</script>

