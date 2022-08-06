<template>
  <div class="home">
    <movie-search />
  </div>
</template>

<script>
import MovieSearch from '@/components/MovieSearch.vue';
export default {
  components: { 
    MovieSearch 
    },
  name: "home"
};
</script>
