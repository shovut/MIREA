<template>
   <div class="card">
       <div class="pet">
           Id: {{pet.id}}<br/>
           Type: {{pet.type}}<br/>
           Color: {{pet.color}}<br/>
       </div>
       <input type="checkbox" @change="sendChange">
   </div>
</template>

<script>
    export default {
        name: 'Pet',

        props: {
            id: String,
            pet: Object
        },

        mounted() {
            this.pet = this.$store.getters.onePet(this.id)
        },

        methods: {
          sendChange(){
              this.$store.dispatch('updateForDelete', this.id)
          }
        }
    }
</script>

<style scoped>
.card{
    border-style: solid;
    border-width: 2px;
    text-align: center;
}
</style>