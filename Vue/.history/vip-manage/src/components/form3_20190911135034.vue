<template>
  <div>

    <Form
      style="margin-top:50px"
      ref="formInline"
      :model="formInline"
      :rules="ruleInline"
      :label-width="80"
    >

      <FormItem
        label="手机号"
        prop="phone"
      >
        <Input
          type="number"
          v-model="formInline.phone"
          placeholder="请输入兑换的手机号"
        ></Input>
      </FormItem>
      <FormItem
        label="兑换数量"
        prop="number"
      >
        <Input
          type="number"
          v-model="formInline.number"
          placeholder="请输入兑换数量"
        ></Input>
      </FormItem>

      <FormItem>
        <Button
          @click="submite('formInline')"
          type="primary"
        >确定</Button>

      </FormItem>
    </Form>

  </div>
</template>

<script>
export default {
  props: {
    chose: ""
  },
  computed: {
    modal3() {
      return this.$store.state.modal3;
    }
  },
  watch: {
    modal3: function(val) {
      Object.assign(this.$data.formInline, this.$options.data().formInline);
    }
  },

  data() {
    const validatePhone = async (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入兑换手机号"));
      } else {
        let res = await axios.post("/checkphone", { number: value });
        console.log(res.data);
        if (res.data !== 200) {
          callback(new Error("此手机号未注册会员"));
        }
        callback();
      }
    };
    return {
      formInline: {
        phone: "",
        number: ""
      },
      ruleInline: {
        number: [
          {
            required: true,
            message: "请输入兑换数量",
            trigger: "blur"
          }
        ],
        phone: [
          {
            required: true,
            validator: validatePhone,
            trigger: "blur"
          }
        ]
      }
    };
  },

  methods: {
    async submite(data) {
      this.$refs[data].validate(async valid => {
        if (valid) {
          console.log(this.chose);
          let data = {
            phone: this.phone,
            number: this.number,
            gifid: this.$store.state.choseid
          };
          let res = await axios.post("/covertgift", data);
          if(res.data==400){
                this.$Message.error("积分不足");
          }
          else{
 this.$emit("OK");
          this.$Message.success("兑换成功");
          }

         
        } else {
          this.$Message.error("兑换信息有误");
        }
      });
    }
  }
};
</script>

<style scoped>
</style>