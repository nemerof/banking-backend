import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Profile from '../views/Profile.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView,
            meta: {requiresAuth: false}
        },
        {
            path: '/about',
            name: 'about',
            component: () => import('../views/AboutView.vue'),
            meta: {requiresAuth: true}
        },
        {
            path: '/currency',
            name: 'currency',
            // route level code-splitting
            // this generates a separate chunk (Currency.[hash].js) for this route
            // which is lazy-loaded when the route is visited.
            component: () => import('../views/Currency.vue'),
            meta: {requiresAuth: false}
        },
        {
            path: '/finish-reg',
            name: 'RegAfterOAuth',
            component: () => import('../views/RegistrationEnd.vue'),
            meta: {requiresAuth: true}
        },
        {
            path: '/profile',
            name: 'Profile',
            component: Profile,
            meta: {requiresAuth: true}
        }
    ]
})

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
        fetch('/api/auth/isAuthenticated')
            .then(response => {
                response.json().then(r => {
                    if (!r) {
                        let query = to.fullPath.match(/^\/$/) ? {} : { redirect: to.fullPath }
                        next(
                            {
                                path: '/',
                                query: query
                            }
                        )
                    } else {
                        next()
                    }
                })
            })
    } else {
        next()
    }

})

export default router
