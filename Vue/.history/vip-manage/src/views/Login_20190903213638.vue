<template>
  <div>

    <Row type="flex" justify="center" align="middle">
      <Col span="12">
    <div class="wlctxt">欢迎使用会员管理系统</div>
    <div>power by lg</div>
    
      </Col>
      <Col span="12">
      <div class="card">

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
.wlctxt{
    
    font-weight: bold;
   
    font-size: 40px;

    text-align: center
}
</style>