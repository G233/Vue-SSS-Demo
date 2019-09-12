<template>
    
</template>

<script>
    export default {
        async created() {
            let res = await axios.post('/getbvip')
            console.log(res.data)
            
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