<script>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  components: {
    HelloWorld,
    RouterView,
    RouterLink
  },
  computed: {
    profile: {
      get() {
        return this.$store.state.userProfile
      },
      set(profile) {
        this.$store.commit('updateProfile', profile)
      }
    }
  },
  methods: {
    logout() {
      fetch("/api/logout", {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'X-XSRF-TOKEN': document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1')
        }
      })
          .then(response => {
            location.href = response.url
          })
    }
  },
  mounted() {
    fetch('/api/user', {
      headers : {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      }
    })
    .then(response => response.json())
    .then(profile => {
      console.log(profile)
      this.profile = profile
      this.$store.commit('updateProfile', this.profile)
    })
  }
}
</script>

<template>
  <header>
    <RouterLink to="/">Home</RouterLink>
    &nbsp;
    <RouterLink to="/about">About</RouterLink>
    &nbsp;
    <RouterLink to="/finish-reg">Finish reg</RouterLink>
    &nbsp;
    <a href="http://localhost:8080/oauth2/authorization/google">sign in</a>
    &nbsp;
    <button type="button" @click="logout()">logout</button>
  </header>

  <RouterView/>
</template>

<style>
@import '@/assets/base.css';
header {
  height: 50px;
  text-align: center;
}
</style>
