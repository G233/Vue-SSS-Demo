<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
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
      modal: false
    };
  },
  async created() {
    let res = await axios.post("getallvip", { name: "a" });
    console.log(res.data);
  },
  methods: {}
};
</script>

<style lscoped>
</style>