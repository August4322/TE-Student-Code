<template>
  <div>
      <form v-on:submit.prevent="saveCard()">
          <div>
              <label for="morbImg">Title</label>
              <input type="text" id="morbTitle" v-model="card.title" /> 
          </div>
          <div>
              <label for="morbImg">Caption</label>
              <input type="text" id="morbCaption" v-model="card.caption" /> 
          </div>          
          <div>
              <label for="morbImg">Img</label>
              <input type="text" id="morbImg" v-model="card.img" /> 
          </div>
          <div>
              <label for="morbImg">Detrimental</label>
              <input type="checkbox" id="morbImg" v-model="card.detrimental" /> 
          </div>
          <button>Submit</button>
      </form>
  </div>
</template>

<script>
import morbService from "@/services/MorbService.js";

export default {
    name: 'add-card',
    data() {
        return {
            errorMsg: "",
            card: {
                img: "",
                title: "",
                caption: "",
                detrimental: ""
            }
        }
    },
    props: ["existingCard"],
    created() {
        if(this.existingCard) {
            this.card = this.existingCard;
        }
    },
    methods: {
        saveCard() {

            morbService.saveCard(this.card).then(
                () => {
                    this.$router.push({name: "List"});
                }
            ).catch(
                error => {
                    if(error.response) {
                        this.errorMsg = error.response.statusText;
                    } else if (error.request) {
                        this.errorMsg = "We couldn't find the server";
                    } else {
                        this.errorMsg = "Error - we couldn't create the request";
                    }
                }
            );
        }
    }
}
</script>
