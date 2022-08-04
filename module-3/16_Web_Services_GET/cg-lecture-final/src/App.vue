<template>
  <div class="container">
    <nav>
      <router-link v-bind:to="{name: 'Home'}">Home</router-link>
      <router-link v-bind:to="{name: 'About'}">About</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style>
body {
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji',
    'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji';
}
.container {
  width: 100%;
  max-width: 1100px;
  margin: 0 auto;
}
.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
