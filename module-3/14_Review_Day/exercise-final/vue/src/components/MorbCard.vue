<template>
    <div v-on:click="flipCard" class="cardContainer">
        <div class="card" v-bind:class="{faceDown: card.isFaceDown}">
            <h3 class="title">{{card.title}}</h3>
            <img v-bind:src="card.img" class="cardImg" />
            <p class="caption">{{card.caption}}</p>
        </div>
    </div>
</template>

<script>
export default {
    name: "morb-card",
    props: ["card"],
    methods: {
        flipCard() {
            this.$store.commit("FLIP_CARD", this.card);
        }
    }
}
</script>