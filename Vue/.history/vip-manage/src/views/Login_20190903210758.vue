<template>
  <div>

    <Row>
      <Col span="12">
      欢迎使用本会员管理系统aaa
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
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px;

  width: 500px;
  height: 250px;
  margin: auto;
  margin-top: 100px;
}
</style>