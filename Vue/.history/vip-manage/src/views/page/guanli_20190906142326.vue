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
        },
        {
          title: "操作",
          key: "action",
          width: 150,
          align: "center",
          render: (h, params) => {
            return h("div", [
              h(
                "Button",
                {
                  props:{
                    type: "primary",
                    size: "small"
                  },
                  style: {
                    marginRight: "5px"
                  },
                  on: {
                    click: () => {
                      this.show(params.index);
                    }
                  }
                },
                "更改"
              ),
              h(
                "Button",
                {
                  props: {
                    type: "error",
                    size: "small"
                  },
                  on: {
                    click: () => {
                      this.remove(params.index);
                    }
                  }
                },
                "删除"
              )
            ]);
          }
        }
      ],
      modal: false,
      data: []
    };
  },
  async created() {
    this.refresh();
  },
  methods: {
    async refresh() {
      let res = await axios.post("getallvip", { name: "a" });
      this.data = res.data;
      console.log(res.data);
    }
  }
};
</script>

<style lscoped>
</style>