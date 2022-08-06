<template>
  <div>
      <label for = "searchTerm">Search:</label>
      <input id = "searchTerm" type = "text" v-model="searchTerm" v-on:change="onSearch()" />
      <div v-for="movie in movies" v-bind:key="movie.id">
          <h2>{{movie.title}}</h2>
          <img v-bind:src="movie.img" />
          <p>{{movie.description}}</p>
      </div>
  </div>
</template>

<script>
import movieService from '@/services/MovieService.js'
export default {
    name: "movie-search",
    data() {
        return {
            searchTerm: "",
            movies: []
        }
    },
    methods: {
        onSearch() {
            movieService.searchMovies(this.searchTerm).then(
                (response) => {
                    this.movies = response.data;
                });
        }
    }
}
</script>

<style scoped>
img {
    width: 200px;
}
</style>