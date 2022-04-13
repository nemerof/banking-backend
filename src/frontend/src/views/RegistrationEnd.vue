<template>
  <h1>
    Some inputs and forms for finalizing profile content
  </h1>
  <form @submit.prevent="register()">
    <input class="form-user-data-input" type="text" placeholder="Login"
           v-model="login" name="login"/>
    <br/>
    <input class="form-user-data-input" type="password" placeholder="Password"
           v-model="password" name="password"/>
    <br/>


    <input class="form-user-data-input" type="text" placeholder="First Name"
           v-model="firstName" name="name"/>
    <br/>
    <input class="form-user-data-input" type="text" placeholder="Surname"
           v-model="surname" name="surname"/>
    <br/>
    <input class="form-user-data-input" type="text" placeholder="Address"
           v-model="address" name="address"/>
    <br/>
    <input class="form-user-data-input" type="date" placeholder="Date of Birth"
           v-model="birthDate" name="birth"/>
    <br/>

    <button class="user-form-button">Finish registration</button>
  </form>
</template>

<script>
import router from "../router";

export default {
  data() {
    return {
      login: '',
      password: '',
      firstName: '',
      surname: '',
      address: '',
      birthDate: null
    }
  },
  methods: {
    register() {
      const user = {
        login: this.login,
        password: this.password,
        firstName: this.firstName,
        surname: this.surname,
        address: this.address,
        birthDate: this.birthDate
      }

      fetch("/api/finish-reg", {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'X-XSRF-TOKEN': document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1')
        },
        body: JSON.stringify(user),
      })
          .then(response => {
            console.log(response)
            location.href = '/'
          })
          .catch(error => {
            // something bad happened during the request
            this.password = ''
            console.log(error)
          })
    }
  }
}
</script>