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
    mounted() {
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">

                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <RouterLink class="navbar-brand" to="/">USB</RouterLink>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="form-inline">
                            <input class="form-control mr-sm-2" type="text">
                            <button class="btn btn-primary my-2 my-sm-0" type="submit">
                                Search
                            </button>
                        </form>
                        <ul class="navbar-nav ml-md-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Link <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com"
                                   id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another
                                    action</a> <a class="dropdown-item" href="#">Something else here</a>
                                    <div class="dropdown-divider">
                                    </div>
                                    <a class="dropdown-item" href="http://localhost:8080/oauth2/authorization/google" v-if="!profile">Sign in</a>
                                    <a class="dropdown-item" @click="logout()" v-if="profile">Log out</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="jumbotron" style="padding: 2rem; text-align: center">
                    <h2>
                        Welcome!
                    </h2>
                    <p>
                        <RouterLink class="btn btn-primary btn-large" to="/info">Learn more</RouterLink>
                    </p>
                </div>
            </div>
        </div>
        <RouterView/>
    </div>
    <header>
        <RouterLink to="/">Home</RouterLink>
        &nbsp;
        <RouterLink to="/about">About</RouterLink>

        <RouterLink to="/profile" v-if="profile">Profile</RouterLink>
        &nbsp;

    </header>

</template>

<style>
@import '@/assets/base.css';

header {
    height: 50px;
    text-align: center;
}
</style>
