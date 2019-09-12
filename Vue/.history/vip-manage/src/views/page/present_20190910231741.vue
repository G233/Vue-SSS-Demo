<template>
  <div>
    <div class="gifts">
      <div
        :class="giftcard(index)"
        @click="chose(index)"
        v-for="(item, index) in data"
        :key="index"
      >
        <Row>
          <img
            width="100"
            height="100"
            :src="item.photo"
          >
        </Row>

        <Row>
          <p>{{item.g_name}}</p>
        </Row>
        <Row>
          <p> 所需积分：{{item.g_integral}}</p>

        </Row>
      </div>
    </div>
    <Button @click="" :disabled="!haschose" style="margin-top:100px" type="primary" size="large">兑换</Button>

  </div>
</template>

<script>
export default {
  computed: {},
  name: "",
  data() {
    return {
      choseindex:false,
      haschose:false,
      data: [
      ]
    };
  },
  async created() {
    let res = await axios.post("/getallgift", {});
    this.data = res.data;
  },
  methods: {
    giftcard(index) {
      if (this.choseindex === index) {
        return "giftcard chose";
      } else {
        return "giftcard ";
      }
    },
    async chose(index) {
        if( this.choseindex === index){
            this.choseindex=false
            this.haschose=false
        }
        else{
             this.choseindex = index;
             this.haschose=true;
        }
     
    }
  }
};
</script>

<style  scoped>
p {
  font-weight: 800;
}
.giftcard {
  transition: all 0.5s;
  width: 150px;
  height: 200px;
  margin-inline-start: 100px;
  margin-top: 20px;
  padding: 20px;
}
.chose {
  transform: scale(1.05);
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.2);
  border-color: #eee;
  transition: all 0.2s ease-in-out;
}
.giftcard:hover {
  transform: scale(1.05);
  box-shadow: 0 1px 6px rgba(0, 0, 0, 0.2);
  border-color: #eee;
  transition: all 0.2s ease-in-out;

  cursor: pointer;
}
.gifts {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
}
</style>