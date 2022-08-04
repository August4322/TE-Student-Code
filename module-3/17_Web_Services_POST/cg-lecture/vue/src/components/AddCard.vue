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

export default {
    name: 'add-card',
    data() {
        return {
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
            // TODO 
        }
    }
}
</script>
