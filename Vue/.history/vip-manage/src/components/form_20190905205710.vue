<template>
  <div >
   
      <Form style="margin-top:50px" ref="formInline" :model="formInline" :rules="ruleInline">
        <FormItem label="姓名" prop="name">
          <Input type="text" v-model="formInline.name" placeholder="请输入姓名"></Input>
        </FormItem>
        <FormItem label="手机号" prop="number">
          <Input type="number" v-model="formInline.author" placeholder="手机号"></Input>
        </FormItem>
        <FormItem label="" prop="price">
          <Input type="text" v-model="formInline.price" placeholder="生日"></Input>
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

</style>