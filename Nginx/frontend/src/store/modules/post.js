export default {
    actions: {
        async fetchPets({commit}) {
            let res = await fetch(
                "/api/get/"
            )
            let pets = await res.json()
            commit('updatePets', pets)
        },
        updateForDelete({commit}, id) {
            commit('updateForDelete', id)
        },
        async deletePets({commit, state}) {
            let res = await fetch(
                "/api/delete/" + state.forDelete.join(','),
                {
                    method: "POST",
                    mode: 'no-cors', // no-cors, cors, *same-origin
                }
            )
            // eslint-disable-next-line no-console
            console.log(res.status)

            commit('deletePets')
        }
    },

    mutations: {
        updatePets(state, pets) {
            state.pets = pets
        },
        updateForDelete(state, id) {
            let index = state.forDelete.indexOf(id)
            if (index > -1) {
                state.forDelete.splice(index, 1)
            } else {
                state.forDelete.push(id)
            }
            // eslint-disable-next-line no-console
            console.log(state.forDelete, id, index)
        },
        deletePets(state) {
            for (let i = 0; i < state.forDelete.length; i++){
                let index = state.pets.findIndex(element => element.id === state.forDelete[i])
                state.pets.splice(index, 1)

            }
            state.forDelete = []
        }
    },

    state: {
        pets: [],
        forDelete: []
    },

    getters: {
        allPets(state) {
            return state.pets
        },
        onePet(state) {
            return function (id) {
                return state.pets.find(pet => pet.id == id)
            }
        },

    }


}