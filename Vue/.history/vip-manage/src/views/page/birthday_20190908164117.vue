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
        columns: [
        {
          title: "姓名",
          slot: "name"
        },
        {
          title: "性别",
          slot: "gender"
        },
        {
          title: "手机号",
          slot: "number"
        },
        {
          title: "生日",
          slot: "birthday"
        },
       
      ],
        data:[]
    };
  }
};
</script>

<style  scoped>
</style>