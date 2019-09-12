<template>
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

</template>

<script>
export default {
  name: "",
  data() {
    return {
      number: "",
      data: []
    };
  },
  methods: {
    async gete() {
      let res = await axios.post("/getexchange", { number: this.number });
      this.data=res.data
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