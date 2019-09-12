import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/Login.vue'
import Index from './views/index.vue'
import guanli from './views/page/guanli.vue'
import record from './views/page/jilu.vue'
import active from './views/page/huodong.vue'
import liushui from './views/page/liushui.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/VIP',
      component: Index,
      children: [{
          path: '',
          component: guanli,
          name: '1-1'
        },
        {
          path: 'record',
          component: record,
          name: '1-2'
        },
        {
          path: 'active ',
          component: active,
          name: '1-3'
        },
        {
          path: 'liushui',
          component: liushui,
          name: '1-4'
        }
      ]
    }

  ]
})