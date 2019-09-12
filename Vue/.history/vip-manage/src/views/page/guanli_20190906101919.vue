<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
    >
      <Form v-on:OK="modal= false"></Form>
    </Modal>

    <Button
      type="primary"
      @click="modal= true"
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