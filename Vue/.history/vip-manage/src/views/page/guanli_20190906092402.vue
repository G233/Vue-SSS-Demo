<template>
  <div>
    <Modal
      v-model="modal1"
      @on-ok="ok"
      @on-cancel="cancel"
    >
      <Form
        style="margin-top:50px"
        ref="formInline"
        :model="formInline"
        :rules="ruleInline"
        :label-width="60"
      >
        <FormItem
          label="姓名"
          prop="name"
        >
          <Input
            type="text"
            v-model="formInline.name"
            placeholder="请输入姓名"
          ></Input>
        </FormItem>
        <FormItem
          label="手机号"
          prop="number"
        >
          <Input
            type="number"
            v-model="formInline.number"
            placeholder="手机号"
          ></Input>
        </FormItem>
        <FormItem label="性别">
          <i-switch
            v-model="formInline.gender"
            size="large"
            true-value=1
            false-value=0
          >
            <span slot="open">男</span>
            <span slot="close">女</span>
          </i-switch>
        </FormItem>
        <FormItem label="生日">
          <DatePicker
         
          @on-change="formInline.birthday=$event"
          format="yyyy-MM-dd"
            type="date"
            placeholder="选择日期"
            style="width: 200px"
          ></DatePicker>
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
        number: "",
        gender: 0,
        birthday: ""
      },
      ruleInline: {
        name: [
          {
            required: true,
            message: "请输入姓名",
            trigger: "blur"
          }
        ],
        number: [
          {
            required: true,
            message: "请输入手机号",
            trigger: "blur"
          }
        ]
      }
    };
  },
 async created() {
    let res= await axios.post('getallvip',{name:'a'})
    console.log(res.data)
},
  methods: {
    async ok() {
        let res= await axios.post('/addvip',this.formInline)
        console.log(res.data)
        

      this.$Message.success("会员添加成功");
      console.log( this.formInline)
    },
    cancel() {
      this.$Message.info("Clicked cancel");
    }
  }
};
</script>

<style lang="" scoped>
</style>