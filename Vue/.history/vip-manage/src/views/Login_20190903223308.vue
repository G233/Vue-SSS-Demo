<template>
  <div>

    <Row
      type="flex"
      justify="center"
      align="middle"
    >
      <Col span="12">
      <div class="wlctxt">欢迎使用会员管理系统</div>
      <div class="text2">power by lg</div>
      </Col>
      <Col span="12">
      <div class="card">
        <Row
          type="flex"
          justify="center"
          align="middle"
          style="height:450px"
          
        >
          <Col  span="24">
          
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
              v-model="value"
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
              v-model="value"
              placeholder="请输入密码"
              style="width: 300px"
            />
            </Col>
          </Row>
          <Row>
            i
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
    return {};
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
  margin-top: 100px;
}
.wlctxt {
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
.tishi{
     font-weight: bold;
  color: 	#464c5b;
 
  font-size: 15px;
}
</style>