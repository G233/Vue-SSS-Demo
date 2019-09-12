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
      name: 'vip',
      component: Index,
      children: [{
          path: '/',
          component: guanli
        },
        {
          path: '/record',
          component: record
        },
        {
          path: '/active ',
          component: active
        },
        {
          path: '/liushui',
          component: liushui
        }
      ]
    }

  ]
})