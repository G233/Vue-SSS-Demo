<template>
<Row>
      <Input style="width:300px" v-model="number" placeholder="请输入查询手机号"></Input>
    <Button @click="gete" style="margin-left:50px" type="primary">查询</Button></div>
</Row>
 
</template>

<script>
    export default {
        name: '',
        data() {
            return {
                number:''
                
            }
        },
        methods: {
            async gete(){
                let res= await axios.post('/getexchange',{})
            }
        },
    }
</script>

<style lang="" scoped>
    
</style>