<template>
  <div>
    <Row>
      <Input
        style="width:300px"
        v-model="number"
        placeholder="请输入查询会员手机号"
      ></Input>
      <Button
        v-if="X"
        @click="gete"
        class="anniu"
        style="margin-left:50px"
        :type="X?'primary':'success'"
      >{{返回}}</Button>

    </Row>
    <Table
      style="margin-top:50px"
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
        }
      ],

      X: false,
      number: "",
      data: [],
      data1: []
    };
  },
  methods: {
    back() {
        console.log("Aaaaa")
      this.X = true;
    },
    async gete() {
      let res = await axios.post("/checkphone", { number: this.number });
      console.log(res.data);
      if (res.data !== 200) {
        this.$Message.error("没有找到此手机号");
        return;
      }

      let res1 = await axios.post("/getexchange", { number: this.number });
      this.data1 = this.deal(res1.data);
      this.X = false;
      console.log(res1.data);
    },
    deal(data) {
      for (let x of data) {
        x.vipname = x.vip.name;
        x.pname = x.product.name;
        console.log(x);
      }
      return data;
    }
  },
  async created() {
    let res = await axios.post("/getallexchange", {});
    this.data = this.deal(res.data);
    console.log(this.data);
  }
};
</script>

<style  scoped>
.anniu {
  transition: all 2s;
}
</style>