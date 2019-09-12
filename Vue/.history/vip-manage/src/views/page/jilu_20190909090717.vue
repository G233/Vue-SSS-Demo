<template>
<Row>
       <div><Input style="width:300px" v-model="number" placeholder="请输入查询手机号"></Input>
    <Button type="primary">查询</Button></div>
</Row>
 
</template>

<script>
    export default {
        name: '',
        data() {
            return {
                number:''
                
            }
        }
    }
</script>

<style lang="" scoped>
    
</style>