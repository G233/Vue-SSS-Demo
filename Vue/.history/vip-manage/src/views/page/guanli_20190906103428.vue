<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
    >
      <Form v-on:OK="modal= false,refresh()"></Form>
    </Modal>
    <Table
      border
      :columns="columns"
      :data="data"
    ></Table>
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
      columns: [
        {
          title: "姓名",
          key: "name"
        },
        {
          title: "性别",
          key: "gender"
        },
        {
          title: "手机号",
          key: "number"
        },
        {
          title: "生日",
          key: "birthday"
        }
      ],
      modal: false,
      data: []
    };
  },
  async created() {
   this.refresh()
  },
  methods: {
     async refresh(){
 let res = await axios.post("getallvip", { name: "a" });
    this.data = res.data;
    console.log(res.data);
      }
  }
};
</script>

<style lscoped>
</style>