<template>
    <div id="app" class="main">
        <h1>{{product.name}}</h1>
        <p class="description">{{product.description}}</p>
        <div class="actions">
            <router-link v-bind:to="{ name: 'products'}">Back to Products</router-link> &nbsp;

<!--
<router-link v-bind:to="{ name: 'product-details', params: {id: product.id}}"> 
                {{ product.name }} 
              </router-link>

-->

            <router-link v-bind:to="{name: 'add-review'}">Add Review</router-link>
        </div>
        <div class="well-display">
        <average-summary></average-summary>
            <star-summary rating="1" />
            <star-summary rating="2" />
            <star-summary rating="3" />
            <star-summary rating="4" />
            <star-summary rating="5" />
        </div>
        <review-list />
    </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary.vue'
import StarSummary from '@/components/StarSummary.vue'
import ReviewList from '@/components/ReviewList.vue'

export default {
    name: "product-details",
    components: {
        AverageSummary, StarSummary, ReviewList
    },
    created() {
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId)
    },
    computed: {
        product() {
            return this.$store.state.products.find(
                (x) => {
                    return x.id === this.$store.state.activeProduct;
                }
            )
        }
    }
}
</script>