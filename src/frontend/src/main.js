import {createApp} from 'vue'
import {createStore} from 'vuex'
import App from './App.vue'
import router from './router'

const store = createStore({
    state() {
        return {
            userProfile: null
        }
    },
    mutations: {
        updateProfile(state, profile) {
            state.userProfile = profile
        }
    }
})

const app = createApp(App)

app.use(router).use(store)

app.mount('#app')
