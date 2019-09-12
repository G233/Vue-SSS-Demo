<template>
    <div>
           <Modal
        v-model="modal1"
        @on-ok="ok"
        @on-cancel="cancel">
        <p>Content of dialog</p>
        <p>Content of dialog</p>
        <p>Content of dialog</p>
    </Modal>
         <Button type="primary"  @click="modal1 = true">添加会员</Button>
    </div>
</template>

<script>
    export default {
        data () {
            return {
              modal1: false
            }            
        },
        methods: {
           ok () {
                this.$Message.info('Clicked ok');
            },
            cancel () {
                this.$Message.info('Clicked cancel');
            }
        }
    }
</script>

<style lang="" scoped>
    
</style>