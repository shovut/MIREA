<template>
    <div class="petList">
        <ul class="list" id="pet-list">
            <li  v-for="item in this.$store.getters.allPets" v-bind:key="item.id">
                <Pet v-bind:id="item.id"/>
            </li>
        </ul>
        <button v-on:click="getPets">Get</button>
        <button v-on:click="deletePets">Delete</button>
    </div>
</template>

<script>
    import Pet from "@/components/Pet";
    export default {
        name: "PetList",
        components: {Pet},

        methods: {
            getPets(){
                this.$store.dispatch('fetchPets')
            },
            deletePets(){
                this.$store.dispatch('deletePets')
            }
        }
    }
</script>

<style scoped>
.petList{
    width: 50%;
    margin: auto;
}

.list{
    list-style-type: none;
    margin:20px;
}

</style>