<template>
  <form class="new-book-form">
    <div class="title-input">
      <label for="title">Title:</label>
      <input id="title" type="text" v-model="title" />
    </div>
    <div class="author-input">
      <label for="author">Author:</label>
      <input id="author" type="text" v-model="author" />
    </div>
    <div class="isbn-input">
      <label for="isbn">ISBN:</label>
      <input id="isbn" type="number" v-model="isbn" />
    </div>
    <div>
      <button type="submit" v-on:click.prevent="addNewBook()">Submit</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "new-book-form",

  data() {
    return {
      title: "",
      author: "",
      isbn: "",
      read: false,
    };
  },
  methods: {
    addNewBook() {
        let book = {
            title: this.title, author: this.author, isbn: this.isbn, read: this.read
        };
      this.$store.commit("ADD_BOOK", book);
        this.title = "";
        this.author = "";
        this.isbn = "";
    }
    
  },
};
</script>
