<template>
    <div>
           <Modal
        v-model="modal1"
        title="Common Modal dialog box title"
        @on-ok="ok"
        @on-cancel="cancel">
        <p>Content of dialog</p>
        <p>Content of dialog</p>
        <p>Content of dialog</p>
    </Modal>
         <Button type="primary" @click="handleRender">添加会员</Button>
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
        return h('div', [
            h('Input', {
                props: {
                    value: '',
                    autofocus: true,
                    placeholder: '请输入...'
                },
                on: {
                    input: (val) => {
                        this.s=val
                    }
                }
            }),
          
        ])
    }
})
            }
        }
    }
</script>

<style lang="" scoped>
    
</style>