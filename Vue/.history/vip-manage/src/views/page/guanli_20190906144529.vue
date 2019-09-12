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
          v-model="editsex"
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
          <Button @click="handleEdit(row, index)">操作</Button>
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
            title: '操作',
            slot: 'action'
          }
      ],
      modal: false,
      data: [],
      editIndex: -1,
      editName: "",
      editsex: "",
      editBirthday: "",
      editnumber: ""
    };
  },
  async created() {
    this.refresh();
  },
  methods: {
       handleEdit (row, index) {
        this.editName = row.name;
        this.editAge = row.age;
        this.editAddress = row.address;
        this.editBirthday = row.birthday;
        this.editIndex = index;
      },
      handleSave (index) {
        this.data[index].name = this.editName;
        this.data[index].age = this.editAge;
        this.data[index].birthday = this.editBirthday;
        this.data[index].address = this.editAddress;
        this.editIndex = -1;
      },
      getBirthday (birthday) {
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