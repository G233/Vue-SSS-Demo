<template>
  <div>
    <Form></Form>

    <Button
      type="primary"
      @click="modal1 = true"
    >添加会员</Button>

  </div>
</template>

<script>
import Form from "../../components/form";
export default {
  components: {
    Form
  },
  data() {
    return {
      modal1: false,
    
    };
  },
  async created() {
    let res = await axios.post("getallvip", { name: "a" });
    console.log(res.data);
  },
  methods: {
    async ok() {
      let res = await axios.post("/addvip", this.formInline);
      console.log(res.data);

      this.$Message.success("会员添加成功");
      console.log(this.formInline);
    },
    cancel() {
      this.$Message.info("Clicked cancel");
    }
  }
};
</script>

<style lang="" scoped>
</style>