<template>
    <div>
        <h4>First Name: {{person.firstName}}</h4>
        <h4>Last Name: {{person.lastName}}</h4>
    </div>
</template>

<script>
export default {
    name: "student",
    props: ["person"]
}
</script>