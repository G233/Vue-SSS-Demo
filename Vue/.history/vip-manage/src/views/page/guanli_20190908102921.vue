<template>
  <div>
    <Modal
      v-model="modal"
      footer-hide
    >

      <Form v-on:OK="modal= false,refresh()">
      </Form>
    </Modal>
    <Modal
      v-model="modal3"
      footer-hide
    >
      <Form2 v-on:OK="modal3= false,refresh()"></Form2>
    </Modal>
    <Modal
      footer-hide
      v-model="modal2"
      title="警告"
      :loading="loading"
      @on-ok="deletevip"
    >
      <p>此操作无法撤销，确认删除会员信息吗</p>
    </Modal>
    <Table
      border
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
        slot="integral"
      >
        <span>{{ row.integral}}</span>
      </template>
      <template
        slot-scope="{ row, index }"
        slot="balance"
      >
        <span>{{ row.balance}}</span>
      </template>

      <template
        slot-scope="{ row, index }"
        slot="ljintegral"
      >
        <span>{{ row.ljintegral}}</span>
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
          <Button
            style="margin-left:10px"
            @click=" handdelete(row,index)"
            type="error"
          >删除</Button>
        </div>
      </template>
    </Table>

    <Button
      style="margin-top:50px"
      type="primary"
      @click="modal= true"
    >添加会员</Button>
    <Button
      style="margin-top:50px; margin-left:50px"
      type="primary"
      @click="modal3= true"
    >充值</Button>

  </div>
</template>

<script>
import Form from "../../components/form";
import Form2 from "../../components/form2";
export default {
  components: {
    Form,
    Form2
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
          title: "余额",
          slot: "balance"
        },
        {
          title: "积分",
          slot: "integral"
        },
        {
          title: "累计积分",
          slot: "ljintegral"
        },
        {
          title: "操作",
          slot: "action"
        }
      ],
      modal3:false,
      modal2: false,
      loading: true,
      modal: false,
      deletevipid: "",
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
    handdelete(row, index) {
      this.modal2 = true;
      this.deletevipid = this.data[index].id;
    },
    async deletevip() {
      let res = await axios.post("/deletevip", { VipId: this.deletevipid });
      this.modal2 = false;
      this.refresh();
      this.$Message.success("会员信息删除成功");
    },
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