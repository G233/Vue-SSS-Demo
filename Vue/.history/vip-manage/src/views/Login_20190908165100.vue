<template>
  <div>

    <Row
      type="flex"
      justify="center"
      align="middle"
    >
      <Col span="12">
      <div class="wlctxt">欢迎使用会员管理系统</div>
      <div class="text2">power by QLY</div>
      </Col>
      <Col span="12">
      <div class="card">
        <Row
          type="flex"
          justify="center"
          align="middle"
          style="height:450px"
        >
          <Col span="24">

          <Row
            type="flex"
            justify="center"
            align="middle"
            class="input"
          >
            <Col span="6">
            <div class="tishi">用户名：</div>

            </Col>
            <Col span="16">
            <Input
              v-model="name"
              placeholder="请输入用户名"
              style="width: 300px"
            />
            </Col>
          </Row>

          <Row
            type="flex"
            justify="center"
            align="middle"
            class="input"
          >
            <Col span="6">
            <div class="tishi">密码：</div>

            </Col>
            <Col span="16">
            <Input
            type="password"
              v-model="paw"
              placeholder="请输入密码"
              style="width: 300px"
            />
            </Col>
          </Row>
          <Row>
            <Button
              type="primary"
              class="anniu"
              @click="check"
            >登 录</Button>
          </Row>

          </Col>
        </Row>

      </div>
      </Col>

    </Row>
  </div>
</template>

<script>
export default {
  methods: {
    async check() {
      let data = { name: this.name, paw: this.paw };
      try {
        let res = await axios.post("/login", data);
       
        if(res.data==200){
            this.$Message.success('登陆成功');
            this.$router.push('/VIP')
        }
        else{
             this.$Message.error('用户名或密码错误');
        }
      } catch (e) {
        console.log(e);
      } 
    }
  },
  beforeCreate() {
    document
      .querySelector("body")
      .setAttribute("style", "background-color:#efeff4;");
  },

  beforeDestroy() {
    document.querySelector("body").removeAttribute("style");
  },
  name: "",
  data() {
    return {
      name: "",
      paw: ""
    };
  }
};
</script>

<style  scoped>
.card {
  background-color: white;
  border-radius: 10px;
  box-shadow: 0px 40px 100px 0px rgba(0, 0, 0, 0.1);
  width: 700px;
  height: 450px;
  margin: auto;
  margin-top: 200px;
}
.wlctxt {
  margin-top: 200px;
  font-weight: bold;

  font-size: 40px;

  text-align: center;
}
.text2 {
  font-weight: bold;
  color: #9ea7b4;
  padding: 40px;
  font-size: 15px;
}
.input {
  padding: 30px;
  text-align: center;
}
.tishi {
  font-weight: bold;
  color: #464c5b;

  font-size: 15px;
}
.anniu {
  margin: 50px;
  width: 100px;
  height: 40px;
  color: white;
  font-size: 15px;
}
</style>