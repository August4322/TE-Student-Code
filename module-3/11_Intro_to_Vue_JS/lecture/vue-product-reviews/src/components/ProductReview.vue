<template>
    <div class = "main">
        <h2>Product Reviews for {{name}}</h2>
        <p class = "description">{{description}}</p>

        <div class = 'well-display'>
            <div class="well">
                <span class="amount"> {{averageRating}} </span>
                Average Rating
            </div>

            <div class="well">
                <span class="amount"> {{numberOfOneStarReviews}} </span>
                1 Star Reviews
            </div>
            
            <div class="well">
                <span class="amount"> {{numberOfTwoStarReviews}} </span>
                2 Star Reviews
            </div>

            <div class="well">
                <span class="amount"> {{numberOfThreeStarReviews}} </span>
                3 Star Reviews
            </div>

            <div class="well">
                <span class="amount"> {{numberOfFourStarReviews}} </span>
                4 Star Reviews
            </div>            

            <div class="well">
                <span class="amount"> {{numberOfFiveStarReviews}} </span>
                5 Star Reviews
            </div> 
        </div>

        <div v-for="review in reviews" v-bind:key="review.id" class = "review">
            <h4> {{review.reviewer}} </h4>
            <div class = "rating">
                <img v-for="n in review.rating" v-bind:key="n" v-bind:title="review.rating + ' Star Review'" src = "../assets/star.png" />
            </div>
            <h3> {{review.title}} </h3>
            <p> {{review.review}} </p>
        </div>

    </div>
</template>

<script>
export default {
    name: "product-review",
    data() {
        return {
            name: "Cigar Party for Dummies",
            description: "Host and plan the perfect for all your squirrelly friends!",
            reviews: [
                {
                reviewer: "Malcolm Gladwell",
                title: "This is a great book!",
                review: "This changed my life, it was an incredible book!",
                rating: 5
                },
                {
                    reviewer: "Tim Ferris",
                    title: "Pretty Okay Insight",
                    review: "Not shabby",
                    rating: 3
                },
            ]
        }
    },
    computed: {
        averageRating() {
            let sum = this.reviews.reduce(
                (sum, currentValue) => {
                    return sum + currentValue.rating;
                }, 0
            );
            return Number.parseInt(sum / this.reviews.length);
        },

        numberOfOneStarReviews() {
            let filteredReviews = this.reviews.filter(
                (x) => {
                    return x.rating === 1;
                }
            );
            return filteredReviews.length;
        },

        numberOfTwoStarReviews() {
            let filteredReviews = this.reviews.filter(
                (x) => {
                    return x.rating === 2;
                }
            );
            return filteredReviews.length;
        },

        numberOfThreeStarReviews() {
            let filteredReviews = this.reviews.filter(
                (x) => {
                    return x.rating === 3;
                }
            );
            return filteredReviews.length;
        },

        numberOfFourStarReviews() {
            let filteredReviews = this.reviews.filter(
                (x) => {
                    return x.rating === 4;
                }
            );
            return filteredReviews.length;
        },

        numberOfFiveStarReviews() {
            let filteredReviews = this.reviews.filter(
                (x) => {
                    return x.rating === 5;
                }
            );
            return filteredReviews.length;
        }

    }
}
</script>

<style scoped>
    .main {
        margin: 1rem 0;
    }

    div.main div.well-display {
        display: flex;
        justify-content: space-around;
    }

    div.main div.well-display div.well {
        display: inline-block;
        width: 15%;
        border: 1px black solid;
        border-radius: 6px;
        text-align: center;
        margin: 0.25rem;
    }

    div.main div.well-display div.well span.amount {
        color: darkslategray;
        display: block;
        font-size: 2.5rem;
    }

    div.main div.review {
        border: 1px black solid;
        border-radius: 6px;
        padding: 1rem;
        margin: 10px;
    }

    div.main div.review div.rating {
        height: 2rem;
        display: inline-block;
        vertical-align: top;
        margin: 0 0.5rem;
    }

    div.main div.review div.rating img {
        height: 100%;
    }

    div.main div.review p {
        margin: 20px;
    }

    div.main div.review h3 {
        display: inline-block;
    }

    div.main div.review h4 {
        font-size: 1rem;
    }

</style>