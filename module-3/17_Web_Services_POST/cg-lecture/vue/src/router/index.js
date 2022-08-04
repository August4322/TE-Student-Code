import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import AddCardView from '../views/AddCardView.vue'
import ListCardsView from '../views/ListCardsView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/list',
    name: 'List',
    component: ListCardsView
  },
  {
    path: '/create',
    name: 'Create',
    component: AddCardView
  },
  {
    path: '/edit/:cardId',
    name: 'Edit',
    component: AddCardView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
