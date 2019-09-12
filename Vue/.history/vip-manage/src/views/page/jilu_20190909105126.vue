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
      >查询</Button>
  
  </Row>
  <Table
    :columns="columns"
    :data="X?data:data1"
  ></Table>
  </div>

</template>

<script>
export default {
    
  name: "",
  data() {
    return {
          columns: [
      {
        title: "会员",
        key: "vipname"
      },
      {
        title: "商品名称",
        key: "pname"
      },
         {
        title: "商品类别",
        key: "kind"
      },
      {
        title: "商品价格",
        key: "value"
      },
      {
        title: "数量",
      key: "quantity"
      },
      {
        title: "消费时间",
        key: "date"
      },

    ],

      X: true,
      number: "",
      data: [],
      data1: []
    };
  },
  methods: {
    async gete() {
      let res = await axios.post("/getexchange", { number: this.number });
      this.data1 = this.deal(res.data);
      this.X = false;
      console.log(res.data);
    },
    deal(data){
        for(let x of data){
            data.vipname=x.vip.name
            data.pname=x.product.name
            console.log(data)
        }
        return data

    }
    
  },
  async created() {
    let res = await axios.post("/getallexchange", {});
    this.data = this.deal(res.data);
    console.log(this.data);
  }
};
</script>

<style lang="" scoped>
</style>