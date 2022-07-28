<template>
  <div class="main">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount"  v-on:click="whateverImFilteringBy = 0">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount" v-on:click="whateverImFilteringBy = 1">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount"  v-on:click="whateverImFilteringBy = 2">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount"  v-on:click="whateverImFilteringBy = 3">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount"  v-on:click="whateverImFilteringBy = 4">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount"  v-on:click="whateverImFilteringBy = 5">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <a href="#" v-on:click="showForm = true" v-if="!showForm">Show Form</a>
    <a href="#" v-on:click="showFavoritedFlag = !showFavoritedFlag">{{showFavoritedFlag ? "Hide Favorited" : "Show Favorited"}}</a>

    <form v-on:submit.prevent="addNewReview" v-if="showForm">
      <div class="form-element">
        <label for="reviewer">Reviewer:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model="newReview.rating">
          <option value=1>1 Star</option>
          <option value=2>2 Stars</option>
          <option value=3>3 Stars</option>
          <option value=4>4 Stars</option>
          <option value=5>5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <input type='submit' value="Save" />
      <input type="button" value="Cancel"  v-on:click.prevent="resetForm" />
    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      newReview: {},
      showForm: false,
      showFavoritedFlag: false,
      whateverImFilteringBy: 0
    };
  },
  computed: {
    averageRating() {
      let sum = this.$store.state.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / this.$store.state.reviews.length).toFixed(2);
    },
    numberOfOneStarReviews() {
       return this.numberOfReviews(1);
    },
    numberOfTwoStarReviews() {
       return this.numberOfReviews(2);
    },
    numberOfThreeStarReviews() {
       return this.numberOfReviews(3);
    },
    numberOfFourStarReviews() {
       return this.numberOfReviews(4);
    },
    numberOfFiveStarReviews() {
      return this.numberOfReviews(5);
    },
    filteredReviews() {

      if(this.showFavoritedFlag) {
        return this.showFavorited();
      }

      return this.$store.state.reviews.filter(
        (x) => {
          if(this.whateverImFilteringBy === 0) {
            return true;
          } else {
            return x.rating === this.whateverImFilteringBy;
          }
        }
      )
    }
  },
  methods: {
    showFavorited() {
      return this.$store.state.reviews.filter(
        (x) => {
          return x.favorited;
        }
      );
    },
    numberOfReviews(rating) {
    return this.$store.state.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === rating );
      }, 0);
    },
    addNewReview() {
      this.newReview.rating = Number.parseInt(this.newReview.rating);
      this.$store.state.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.newReview = {};
      this.showForm = false;
    },
    displayMessage(message){
     console.log(message);
    }
  }
};
</script>

<style scoped>
div.main {
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

div.main div.review.favorited {
  background-color: lightyellow;
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

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input, div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type=button] {
  width: 100px;
}
form > input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>

