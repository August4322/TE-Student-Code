<template>
  <div class="pic">
      <div v-if="isLoading">
          <img src="@/assets/ping_pong_loader.gif" />
      </div>
      <div class="pic" v-else>
        <h1>{{picOfDay.title}}</h1>
        <img v-bind:src="picOfDay.hdurl" />
        <p>{{picOfDay.copyright}}</p>
        <p>{{picOfDay.explanation}}</p>
      </div>
  </div>
</template>

<script>
import astronomyService from "@/services/AstronomyService.js"
export default {
    name: "astronomy",
    data() {
        return {
            picOfDay: null
        }
    },
    created() {
        astronomyService.getAstronomyPictureOfTheDay().then(
            (response) => {
                this.picOfDay = response.data;
            }
        );
    }
}
</script>

<style>
.pic {
    text-align: center;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
img {
    width: 300px;
}
</style>