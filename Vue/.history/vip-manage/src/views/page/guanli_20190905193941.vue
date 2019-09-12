<template>
  <div>
    <Modal
      v-model="modal1"
      @on-ok="ok"
      @on-cancel="cancel"
    >
      <Form
        ref="formInline"
        :model="formInline"
        :rules="ruleInline"
        style="margin-top:50px"
      >
        <FormItem prop="name">
          <Input
            type="text"
            v-model="formInline.name"
            placeholder="姓名"
          ></Input>
        </FormItem>
        <FormItem prop="author">
          <Input
            type="number"
            v-model="formInline.author"
            placeholder="手机号码"
          ></Input>
        </FormItem>
        <FormItem prop="price">
          <Input
            type="text"
            v-model="formInline.price"
            placeholder="书籍价格"
          ></Input>
        </FormItem>
    
      </Form>
    </Modal>
    <Button
      type="primary"
      @click="modal1 = true"
    >添加会员</Button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      modal1: false,
      formInline: {
        name: "",
        author: "",
        price: ""
      }
    };
  },
  methods: {
    ok() {
      this.$Message.info("Clicked ok");
    },
    cancel() {
      this.$Message.info("Clicked cancel");
    }
  }
};
</script>

<style lang="" scoped>
</style>