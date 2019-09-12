<template>
  <div>
    <Modal
      v-model="modal1"
      @on-ok="ok"
      @on-cancel="cancel"
    >
      <Form></Form>
    </Modal>
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
      formInline: {
        name: "",
        number: "",
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