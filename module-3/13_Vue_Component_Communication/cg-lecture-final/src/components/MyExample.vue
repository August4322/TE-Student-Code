<template>
    <div>

        <h1>Hello {{name}}! Today is {{dayOfWeekProp}}</h1>
        What time is it? <input v-on:keyup.enter="displayMessage('hello')" type="text" v-model="time" />
        <h3>You entered: {{time}} </h3>

        <add-student></add-student>

        <h3 v-show="$store.state.orangeStudents.length"   v-bind:title="'Title: Students In Orange - ' + $store.state.orangeStudents.length"> Students In Orange Classroom: </h3>
        <student  v-for="student in $store.state.orangeStudents" 
                v-bind:key="student.firstName"
                v-bind:person="student">
        </student>
            
        <button v-on:click.prevent="displayMessage('hello')" >Click Me</button>
    </div>
</template>

<script>

import Student from "./Student.vue"
import AddStudent from "./AddStudent.vue"

export default {
   name: "my-example",
   components: {
       Student, AddStudent
   },
   props: ['name', 'dayOfWeekProp', 'anythingElseIWant'],
   
   data() {
       return {
           time: "123"
          
       }
   } ,
   methods: {
       displayMessage(message) {
           alert(message);
       },
       onMouseOver(event) {
           alert(event.target.innerText);
       }
   }
}
</script>

<style scoped>
h1 {
    font-weight:bold;
}
</style>