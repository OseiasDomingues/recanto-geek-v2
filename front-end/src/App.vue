<template>
  <div id="app">
    <HeaderApp />
  </div>
</template>

<script>
import "./styles/global.css";

import HeaderApp from "./components/header-app";
import produto from './services/api'

export default {
  name: "App",
  components: {
    HeaderApp,
  },

  data(){
    return{
      produtos:[]
    }
  },

  mounted(){
    produto.findAll().then(response =>{
      this.produtos = response.data

    })
  }
  
};

</script>

<style>
</style>
