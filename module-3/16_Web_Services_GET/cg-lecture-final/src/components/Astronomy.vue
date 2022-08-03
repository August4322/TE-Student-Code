<template>
    <div>
        <div v-if="isLoading">
            <img src="@/assets/ping_pong_loader.gif" />
        </div>
        <div class='pic' v-else>
            <h1>{{picOfDay.title}}</h1>
            <img v-bind:src="picOfDay.hdurl" />
            <p>{{picOfDay.copyright}}</p>
            <p>{{picOfDay.explanation}}</p>

            <img v-for="pic in randomImages" v-bind:key="pic.hdurl"
                v-bind:src="pic.hdurl" />

        </div>
    </div>
</template>

<script>
import astronomyService from "@/services/AstronomyService.js"

export default {
    name: "astronomy",
    data() {
        return {
            picOfDay: null,
            isLoading: true,
            randomImages: []
        }
    },
    created() {
        astronomyService.getAstronomyPictureOfTheDay().then(
            (response) => {
            //    setTimeout( () => {  //artificially make it wait so we can see the is loading gif
                this.picOfDay = response.data;
                this.isLoading= false;
            //    }, 2000);
            }
        );

        astronomyService.getRandomImages(3).then(
            (response) => {
                this.randomImages = response.data;
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
    width:300px;
}
</style>