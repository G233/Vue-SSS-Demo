<template>
    <div>
           <Modal
        v-model="modal1"
        @on-ok="ok"
        @on-cancel="cancel">
       <Form ref="formInline" :model="formInline" :rules="ruleInline">
        <FormItem prop="name">
          <Input type="text" v-model="formInline.name" placeholder="书名"></Input>
        </FormItem>
        <FormItem prop="author">
          <Input type="text" v-model="formInline.author" placeholder="作者"></Input>
        </FormItem>
        <FormItem prop="price">
          <Input type="text" v-model="formInline.price" placeholder="书籍价格"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="addbook">添加</Button>
        </FormItem>
      </Form>
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