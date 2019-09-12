<template>
  <div>
    <div>
      <Row>
        <img
          width="100"
          height="100"
          :src="data[0].photo"
        >
      </Row>
      <Row>
        <div class="p">{{data[0].g_name}}</div>

      </Row>
      <Row>
        <div class="p"> 所需积分：{{data[0].g_integral}}</div>

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
.p{
    font-weight:600;
    background-color: aquamarine
}
</style>