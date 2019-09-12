<template>
  <div >
      <div class="gifts">
    <div  :class="choseindex==index:'chose':''" @click="chose(index)" v-for="(item, index) in data" :key="index" >
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

  </div>
</template>

<script>
export default {
  name: "",
  data() {
    return {
        choseindex:'',
      data: [
        {
            
          g_integral: 3000,
          g_name: "儿童帽子",
          photo:
            "https://img14.360buyimg.com/n7/jfs/t1/19360/2/10627/178147/5c89b4b6E93eaa933/67c0fc5601c2581c.jpg"
        }
      ]
    };
  },
  async created() {
      let res= await axios.post('/getallgift',{})
      this.data=res.data
      
  },
  methods: {
      async chose(index){
          this.choseindex=index
          
      }
  },
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
  margin-inline-start :100px;
  padding: 20px
}
.chose{
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
.gifts{
    display:flex;
    flex-direction:row;
      flex-wrap:wrap;
      align-items:center
}
</style>