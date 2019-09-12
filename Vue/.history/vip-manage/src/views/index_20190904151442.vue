
<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">
      <Sider
        collapsible
        :collapsed-width="78"
        v-model="isCollapsed"
      >
        <Menu
          active-name="1-1"
          theme="dark"
          width="auto"
          :class="menuitemClasses"
          @on-select='topage'
        >
          <MenuItem   name="1-1">

          <span >会员管理</span>
          </MenuItem>
          <MenuItem  name="1-2">

          <span>消费记录</span>
          </MenuItem>
          <MenuItem name="1-3">

          <span>促销活动</span>
          </MenuItem>
          <MenuItem name="1-4">

          <span>积分流水</span>
          </MenuItem>
            <MenuItem name="1-5">

          <span>积分商城</span>
          </MenuItem>
            <MenuItem name="1-6">

          <span>生日会员</span>
          </MenuItem>
          
        </Menu>
      </Sider>
      <Layout>
        <Header
          class="title"
          :style="{background: '#fff', boxShadow: '0 2px 3px 2px rgba(0,0,0,.1)'}"
        >
          会员管理系统
        </Header>
        <Content :style="{padding: '50px 16px 16px'}">

          <Card>
            <div style="height: 600px">
                <router-view></router-view>
            </div>
          </Card>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>
<script>
export default {
    methods: {
        topage(name){
            console.log(name)
           this.$router.push({name:name}) 
        }
    },
  data() {
    return {
      isCollapsed: false
    };
  },
  computed: {
    menuitemClasses: function() {
      return ["menu-item", this.isCollapsed ? "collapsed-menu" : ""];
    }
  }
};
</script>
<style scoped>
.layout-con {
  height: 100%;
  width: 100%;
}
.menu-item span {
  display: inline-block;
  overflow: hidden;
  width: 69px;
  text-overflow: ellipsis;
  white-space: nowrap;
  vertical-align: bottom;
  transition: width 0.2s ease 0.2s;
}
.menu-item i {
  transform: translateX(0px);
  transition: font-size 0.2s ease, transform 0.2s ease;
  vertical-align: middle;
  font-size: 16px;
}
.collapsed-menu span {
  width: 0px;
  transition: width 0.2s ease;
}
.collapsed-menu i {
  transform: translateX(5px);
  transition: font-size 0.2s ease 0.2s, transform 0.2s ease 0.2s;
  vertical-align: middle;
  font-size: 22px;
}
.title {
  font-weight: 16px;

  font-size: 30px;

  text-align: center;
  color: #959ca5
}
</style>