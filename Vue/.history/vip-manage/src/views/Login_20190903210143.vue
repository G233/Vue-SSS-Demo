<template>
  <div>
aa
    <Row> 
      <Col span="12">
      欢迎使用本会员管理系统aaa
      </Col>
      <Col span="12">
      <Card class="card">

      </Card>
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
  width: 300px;
  height: 200;
  margin: auto;
}
</style>