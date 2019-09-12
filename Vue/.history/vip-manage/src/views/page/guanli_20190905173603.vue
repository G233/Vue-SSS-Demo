<template>
    <div>
         <Button @click="handleRender">添加会员</Button>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                value: ''
            }            
        },
        methods: {
            handleRender () {
                this.$Modal.confirm({
                    render: (h) => {
                        return h('Input', {
                            props: {
                                value: this.value,
                                autofocus: true,
                                placeholder: 'Please enter your name...'
                            },
                            on: {
                                input: (val) => {
                                    this.value = val;
                                }
                            }
                        })
                    }
                })
            }
        }
    }
</script>

<style lang="" scoped>
    
</style>