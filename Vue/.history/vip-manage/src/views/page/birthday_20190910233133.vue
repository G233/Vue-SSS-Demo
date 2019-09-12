<template>
<div>  
    <Table :columns="columns" :data="data"></Table>
    </div>
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
          key: "name"
        },
        {
          title: "性别",
          key: "gender"
        },
        {
          title: "手机号",
        key: "number"
        },
        {
          title: "生日",
          key: "birthday"
        },
       
      ],
        data:[]
    };
  }
};
</script>

<style  scoped>
</style>