<template>
  <div>
     <h2 class="book-title">{{ grabBook.title }}</h2>
     <h3 class="book-author">{{ grabBook.author }}</h3>
     <img v-bind:src="'http://covers.openlibrary.org/b/isbn/' + grabBook.isbn + '-M.jpg'" />
     <p v-if="grabBook.read">I have read this book.</p> 
     <p v-if="!grabBook.read">I have not read this book.</p>
  </div>
</template>

<script>
export default {
  name: 'book-details',
  computed: {
      grabBook() {
          return this.$store.state.books.find(
              (x) => {
                  return x.isbn === this.$route.params.isbn;
              });
      }
  } 
}
</script>