<template>
    <div>
        <label>First Name</label>
        <input type="text" v-model="firstName" />
        <label>Last Name</label>
        <input type="text" v-model="lastName" />
        <button v-on:click="addStudent">Add Student </button>
    </div>
</template>

<script>
export default {
    name: "add-student",
    data() {
        return {
            firstName: "",
            lastName: ""
        }
    },
    methods: {
        addStudent(){

           let student = {firstName: this.firstName,
                          lastName: this.lastName};
           this.$store.commit("ADD_STUDENT", student);
            this.firstName = "";
            this.lastName = "";
       }
    }
}
</script>