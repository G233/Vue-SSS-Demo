<template>
  <div>
    <div>
      <Row>
        <div class="giftimg"><img :src="data[0].photo"></div>
      </Row>
      <Row>
        {{data[0].g_name}}
      </Row>
      <Row>

      </Row>
    </div>

  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
      data: [
        {
          g_integral: 3000,
          g_name: "儿童帽子",
          photo:
            "https://img14.360buyimg.com/n7/jfs/t1/19360/2/10627/178147/5c89b4b6E93eaa933/67c0fc5601c2581c.jpg"
        }
      ]
    };
  }
};
</script>

<style  scoped>
.giftimg {
  width: 300px;
  height: 450px;
  background-color:aqua
}
</style>