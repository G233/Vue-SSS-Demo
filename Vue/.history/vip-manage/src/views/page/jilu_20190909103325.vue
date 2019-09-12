<template>
<div>
      <Row>
    <Input
      style="width:300px"
      v-model="number"
      placeholder="请输入查询会员手机号"
    ></Input>
    <Button
      @click="gete"
      style="margin-left:50px"
      type="primary"
    >查询</Button></div>
  </Row>
 <Table :columns="columns" :data="X?data:data1"></Table>
</div>

</template>

<script>
export default {
        columns: [
        {
          title: "会员",
          key: ""
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
    
  name: "",
  data() {
    return {
    X:true,
      number: "",
      data: [],
      data1:[]
    };
  },
  methods: {
    async gete() {
      let res = await axios.post("/getexchange", { number: this.number });
      this.data1=res.data
      this.X=false
      console.log(res.data)
    }
  },
  async created() {
     let res = await axios.post("/getallexchange", {});
     this.data=res.data
     console.log(res.data)
  }
};
</script>

<style lang="" scoped>
</style>