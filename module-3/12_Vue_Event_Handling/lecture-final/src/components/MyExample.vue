<template>
    <div>
        <h1>Hello {{name}}! Today is {{dayOfWeek}}</h1>
        What time is it? <input v-on:keyup.enter="displayMessage('hello')" type="text" v-model="time" />
        <h3>You entered: {{time}} </h3>

        <h3 v-show="orangeStudents.length"  v-on:mouseover="onMouseOver($event)" v-bind:title="'Title: Students In Orange - ' + orangeStudents.length"> Students In Orange Classroom: </h3>
        <div  v-for="student in orangeStudents" v-bind:key="student.firstName">
            <h4>First Name: {{student.firstName}}</h4>
            <h4>Last Name: {{student.lastName}}</h4>
        </div>
        <button v-on:click.prevent="displayMessage('hello')" >Click Me</button>
    </div>
</template>

<script>
export default {
   name: "my-example",
   data() {
       return {
           name: "Christopher",
           dayOfWeek: "Wednesday",
           time: "123",
           orangeStudents: [
               {
                   firstName: "Adam",
                   lastName: "Shaw"
               },
               {
                   firstName: "Cesar",
                   lastName: "Andino"
               },
               {
                   firstName: "Ugur",
                   lastName: "Tendurus"
               }
           ]
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