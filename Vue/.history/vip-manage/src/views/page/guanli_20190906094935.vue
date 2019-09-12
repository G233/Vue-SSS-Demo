<template>
  <div>
   
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