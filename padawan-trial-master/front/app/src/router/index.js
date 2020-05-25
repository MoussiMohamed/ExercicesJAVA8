import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Recherche from '@/components/Recherche'
import Ventes from '@/components/Ventes'
import Lots from '@/components/Lots'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/recherche',
      name: 'Recherche',
      component: Recherche
    },
    {
      path: '/ventes',
      name: 'Ventes',
      component: Ventes
    },
    {
      path: '/lots',
      name: 'lots',
      component: Lots
    }
  ]
})
