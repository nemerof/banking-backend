<script>
import {RouterLink, RouterView} from 'vue-router'
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
  beforeCreate() {
    fetch('/api/auth', {
      headers: {
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
  <header class="u-clearfix u-custom-color-1 u-header u-sticky u-sticky-ba2e u-header" id="sec-bba8">
    <div class="u-clearfix u-sheet u-sheet-1">
      <RouterLink to="/" class="u-image u-logo u-image-1">
        <img src="/src/assets/default-logo.png" class="u-logo-image u-logo-image-1">
      </RouterLink>
      <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
        <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
          <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base"
             href="#">
            <svg class="u-svg-link" viewBox="0 0 24 24">
              <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use>
            </svg>
            <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px"
                 xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg">
              <g>
                <rect y="1" width="16" height="2"></rect>
                <rect y="7" width="16" height="2"></rect>
                <rect y="13" width="16" height="2"></rect>
              </g>
            </svg>
          </a>
        </div>
        <div class="u-nav-container"></div>
        <div class="u-nav-container-collapse">
          <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
            <div class="u-inner-container-layout u-sidenav-overflow">
              <div class="u-menu-close"></div>
              <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-1">
                <li class="u-nav-item"><a class="u-button-style u-nav-link" href="MainPage.html">MainPage</a>
                </li>
              </ul>
            </div>
          </div>
          <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
        </div>
      </nav>
      <a href="https://nicepage.com/k/retro-website-templates"
         class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-custom-color-2 u-btn-1">Wallet</a>
      <a href="https://nicepage.com/c/nature-html-templates"
         class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-custom-color-2 u-btn-2">Archive</a>
      <a href="http://localhost:8080/oauth2/authorization/google" v-if="!profile"
         class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-custom-color-2 u-btn-3">Log In</a>
      <a @click="logout()" v-else
         class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-custom-color-2 u-btn-3">Log Out</a>
      <RouterLink to="/currency"
         class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-none u-text-custom-color-2 u-btn-4">
        <svg height="24" width="24" version="1.1" viewBox="0 0 18 18" xmlns="http://www.w3.org/2000/svg"><path d="M12.192 10.868c-1.736-.438-2.294-.892-2.294-1.597 0-.81.772-1.373 2.065-1.373 1.362 0 1.867.631 1.913 1.56h1.69c-.054-1.28-.817-2.502-2.634-2.92V5h-1.805v1.517c-1.673.255-2.99 1.335-2.99 2.769 0 1.715 1.461 2.57 3.595 3.067 1.913.445 2.295 1.1 2.295 1.79 0 .512-.375 1.329-2.065 1.329-1.576 0-2.195-.683-2.295-1.56H8c.092 1.627 1.596 2.908 3.127 2.908v1.548h1.805v-1.53c1.498 0 2.855-1.18 2.855-2.703 0-2.109-1.859-2.822-3.595-3.267z" fill="#FFF" fill-rule="evenodd" stroke="none" stroke-width="1"></path></svg>
        1.0000 / 1.0000
      </RouterLink>
    </div>
  </header>
  <RouterView/>
</template>

<style>
@import '@/assets/base.css';
</style>
