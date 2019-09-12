<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
    >
      <Form v-on:OK="modal= false"></Form>
    </Modal>
  <Table border :columns="columns1" :data="data1"></Table>
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
        columns1: [
                    {
                        title: '姓名',
                        key: 'name'
                    },
                    {
                        title: '性别',
                        key: 'gender'
                    },
                    {
                        title: '手机号',
                        key: 'number'
                    },
                     {
                        title: '生日',
                        key: 'address'
                    }
                ],
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