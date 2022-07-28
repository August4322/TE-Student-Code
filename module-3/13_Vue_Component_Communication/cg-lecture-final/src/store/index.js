import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    orangeStudents: [
      {
          firstName: "Adam",
          lastName: "Shaw"
      },
      {
          firstName: "Cesar",
          lastName: "Andino"
      },
      {
          firstName: "Ugur",
          lastName: "Tendurus"
      }
  ]
  },
  mutations: {
    ADD_STUDENT(state, student) {
      state.orangeStudents.push(student);
    }
  },
  actions: {
  },
  modules: {
  }
})
