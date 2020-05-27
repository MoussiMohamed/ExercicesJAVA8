import Vue from 'vue'
import Router from 'vue-router'
import Recherche from '@/components/Recherche'
import Ventes from '@/components/Ventes'
import Lots from '@/components/Lots'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Ventes',
      component: Ventes
    },
    {
      path: '/recherche',
      name: 'Recherche',
      component: Recherche
    },
    {
      path: '/lots/:sale_id/:title',
      name: 'lots',
      component: Lots
    }
  ]
})
