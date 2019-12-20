<template>
  <div id="app">
    <PetList/>
  </div>
</template>

<script>
  import PetList from './components/PetList.vue'

  export default {
    name: 'app',
    components: {
      PetList
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
