<template>
  <div id="app">
   <my-example v-bind:name="'Christopher'"
              v-bind:dayOfWeekProp="dayOfWeekValue"></my-example>
<product-review></product-review>
  <input type="date">
  
  </div>
</template>

<script>
import MyExample from "./components/MyExample.vue"
import ProductReview from "./components/ProductReview.vue"

export default {
  name: "app",
  components: {
    MyExample, ProductReview
  },
  data() {
    return {
     
    }
  },
  computed: {
    dayOfWeekValue(){
    const weekday = [
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
      ];

      const d = new Date();
      let day = weekday[d.getDay()];
      return day;

    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
