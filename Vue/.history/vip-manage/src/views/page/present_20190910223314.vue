<template>
  <div>
    <div class="giftcard">
      <Row>
        <img
          width="100"
          height="100"
          :src="data[0].photo"
        >
      </Row>
      <Row>
        <p>{{data[0].g_name}}</p>

      </Row>
      <Row>
        <p> 所需积分：{{data[0].g_integral}}</p>

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
p{
    font-weight: 800
}
.giftcard{
    transition: all 0.5s
}
.giftcard:hover{
   transform:scale(10.0);
     box-shadow: 0 1px 6px rgba(0, 0, 0, .2);
    border-color: #eee;
    transition: all .2s ease-in-out;

}
</style>