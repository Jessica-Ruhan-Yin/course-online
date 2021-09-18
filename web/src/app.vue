<template>
  <div>
    <the-header/>

    <router-view/>

    <the-footer/>
  </div>
</template>

<script>

import TheHeader from "@/components/the-header";
import TheFooter from "@/components/the-footer";

export default {
  name: 'app',
  components: {TheFooter, TheHeader},
}
</script>

