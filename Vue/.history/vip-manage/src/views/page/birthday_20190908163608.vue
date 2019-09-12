<template>
    
</template>

<script>
    export default {
        async created() {
            try{
   let res = await axios.post('/getbvip',{})
   console.log(res.data)
            }
         
         catch(e){
             console.log(e)
         }
            
        },
        name: '',
        data() {
            return {
                
            }
        }
    }
</script>

<style  scoped>
    
</style>