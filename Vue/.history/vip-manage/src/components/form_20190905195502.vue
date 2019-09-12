<template>
  <div>
   
      <Form ref="formInline" :model="formInline" :rules="ruleInline">
        <FormItem prop="name">
          <Input type="text" v-model="formInline.name" placeholder="书名"></Input>
        </FormItem>
        <FormItem prop="author">
          <Input type="text" v-model="formInline.author" placeholder="作者"></Input>
        </FormItem>
        <FormItem prop="price">
          <Input type="text" v-model="formInline.price" placeholder="书籍价格"></Input>
        </FormItem>
    
      </Form>
   
  </div>
</template>

<script>
export default {
  data() {
    return {
      formInline: {
        name: "",
        author: "",
        price: ""
      },
      ruleInline: {
        name: [
          {
            required: true,
            message: "请输入书名",
            trigger: "blur"
          }
        ],
        author: [
          {
            required: true,
            message: "请输入作者",
            trigger: "blur"
          }
        ],
        price: [
          {
            required: true,
            message: "请输入价格",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    if (this.$store.state.haschange) {
      this.formInline = this.$store.state.book;
    }
  },
  methods: {
    async addbook() {
      if (this.$store.state.haschange) {
        this.formInline.id=this.$store.state.book.id
           let res = await axios.post("/changebook",this.formInline);
            this.$Message.success("书籍信息更改成功");
      } else {
        let res = await axios.post("/addbook", this.formInline);
        this.$Message.success("书籍添加成功");
      }
      this.$router.back();
    }
  }
};
</script>

<style scoped>
.addcard {
  margin: auto;
  margin-top: 20rem;
  height: 250px;
  width: 500px;
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 1rpx 6rpx rgba(0, 0, 0, 0.1);
}
</style>