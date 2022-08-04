<template>
  <div v-if="isReady" class="whiteBackground">
      <add-card v-bind:existingCard="cardToEdit" />
  </div>
</template>

<script>
import morbService from "@/services/MorbService";
import AddCard from "@/components/AddCard.vue"
export default {
    components: {
        AddCard
    },
    data() {
        return {
            cardToEdit: {},
            isReady: false
        }
    },
    created() {
        if(this.$route.params.cardId) {
            morbService.getCard(this.$route.params.cardId).then(
                response => {
                    this.cardToEdit = response.data;
                    this.isReady = true;
                }
            );
        } else {
            this.isReady = true;
        }
    }
}
</script>

<style>

</style>