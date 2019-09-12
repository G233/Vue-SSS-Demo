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
        prop="number"
      >
        <Input
          type="number"
          v-model="formInline.number"
          placeholder="请输入充值的手机号"
        ></Input>
      </FormItem>
      <FormItem
        label="充值金额"
        prop="money"
      >
        <Input
          type="number"
          v-model="formInline.money"
          placeholder="请输入整数充值金额"
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
  data() {
    const validatePhone = async (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入充值手机号"));
      } else {
        let res = await axios.post("/checkphone", { number: value });
        console.log(res.data);
        if (res.data !== 200) {
          callback(new Error("请输入正确的手机号"));
        }
        callback();
      }
    };
    return {
      formInline: {
        money: "",
        number: ""
      },
      ruleInline: {
        money: [
          {
            required: true,
            message: "请输入充值金额",
            trigger: "blur"
          }
        ],
        number: [
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
    async submite(name) {
      this.$refs[name].validate(async valid => {
        if (valid) {
          let res = await axios.post("/addvip", this.formInline);

          this.$emit("OK");
          this.$Message.success("充值成功");
        } else {
          this.$Message.error("请填写充值信息");
        }
      });
    }
  }
};
</script>

<style scoped>
</style>