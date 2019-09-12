<template>
<div><Table :columns="columns1" :data="data"></Table></div>
</template>

<script>
export default {
  async created() {
    try {
      let res = await axios.post("/getbvip", {});
      this.data=res.data
      console.log(res.data);
    } catch (e) {
      console.log(e);
    }
  },
  name: "",
  data() {
    return {
        data:[]
    };
  }
};
</script>

<style  scoped>
</style>