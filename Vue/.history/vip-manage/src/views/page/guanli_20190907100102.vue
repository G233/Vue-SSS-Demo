<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
    >
      <Form v-on:OK="modal= false,refresh()">
      </Form>
    </Modal>
    <Table
      :columns="columns"
      :data="data"
    >
      <template
        slot-scope="{ row, index }"
        slot="name"
      >
        <Input
          type="text"
          v-model="editName"
          v-if="editIndex === index"
        />
        <span v-else>{{ row.name }}</span>
      </template>

      <template
        slot-scope="{ row, index }"
        slot="gender"
      >
        <Input
          type="text"
          v-model="editgender"
          v-if="editIndex === index"
        />
        <span v-else>{{ row.gender}}</span>
      </template>
      <template
        slot-scope="{ row, index }"
        slot="number"
      >
        <Input
          type="text"
          v-model="editnumber"
          v-if="editIndex === index"
        />
        <span v-else>{{ row.number }}</span>
      </template>

      <template
        slot-scope="{ row, index }"
        slot="birthday"
      >
        <Input
          type="text"
          v-model="editBirthday"
          v-if="editIndex === index"
        />
        <span v-else>{{ row.birthday }}</span>
      </template>

      <template
        slot-scope="{ row, index }"
        slot="action"
      >
        <div v-if="editIndex === index">
          <Button @click="handleSave(index)">保存</Button>
          <Button @click="editIndex = -1">取消</Button>
        </div>
        <div v-else>
          <Button @click="handleEdit(row, index)">修改</Button>
             <Button style="margin-left:10px" type="error">删除</Button>
        </div>
      </template>
    </Table>
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
          slot: "name"
        },
        {
          title: "性别",
          slot: "gender"
        },
        {
          title: "手机号",
          slot: "number"
        },
        {
          title: "生日",
          slot: "birthday"
        },
        {
          title: "操作",
          slot: "action"
        }
      ],
      modal: false,
      data: [],
      editIndex: -1,
      editName: "",
      editgender: "",
      editBirthday: "",
      editnumber: ""
    };
  },
  async created() {
    this.refresh();
  },
  methods: {
    handleEdit(row, index) {
      this.editName = row.name;
      this.editgender = row.gender;
      this.editnumber = row.number;
      this.editBirthday = row.birthday;
      this.editIndex = index;
    },
    async handleSave(index) {
      console.log(this.data[index]);
      this.data[index].name = this.editName;
      this.data[index].gender = this.editgender;
      this.data[index].birthday = this.editBirthday;
      this.data[index].number = this.editnumber;
      this.editIndex = -1;
      let res = await axios.post("/changevip", this.data[index]);
       this.$Message.success("会员信息修改成功");

    },
    getBirthday(birthday) {
      const date = new Date(parseInt(birthday));
      const year = date.getFullYear();
      const month = date.getMonth() + 1;
      const day = date.getDate();
      return `${year}-${month}-${day}`;
    },
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