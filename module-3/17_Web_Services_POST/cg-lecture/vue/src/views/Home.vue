<template>
  <div>
    <morb-board /> 
  </div>
</template>

<script>
// @ is an alias to /src
import MorbBoard from '@/components/MorbBoard.vue'

export default {
  name: 'Home',
  components: {
    MorbBoard
  }
}
</script>
