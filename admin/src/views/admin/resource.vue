<template>
  <div>
    <p>
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <div class="row">
      <div class="col-md-6">
        <textarea id="resource textarea" class="form-control" v-model="resourceStr" name="resource" rows="10"/>

        <br>
        <button id="save-btn" type="button" class="btn btn-primary" v-on:click="save()">
          保存
        </button>
      </div>
      <div class="col-md-6">
        <ul id="tree" class="ztree"></ul>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "system-resource",
  data: function () {
    return {
      resource: {}, //该变量用来绑定form表单的数据
      resources: [],
      resourceStr:"",
      tree:{},
    }
  },
  mounted: function () {
    let _this = this;
    _this.list();
    //this.$parent.activeSidebar("system-resource-sidebar")
  },
  methods: {
    //列表查询
    list() {
      let _this = this;
      _this.$ajax.get('http://127.0.0.1:9000/system/admin/resource/load-tree').then((res) => {
        let response = res.data;
        _this.resources = response.content;
        //初始化树
        _this.initTree();
      })
    },

    //保存
    save() {
      let _this = this;

      // 保存校验
      if(Tool.isEmpty(_this.resourceStr)) {
        Toast.warning("资源不能为空！");
        return;
      }

      let json = JSON.parse(_this.resourceStr);

      _this.$ajax.post('http://127.0.0.1:9000/system/admin/resource/save', json).then((response) => {
        let resp = response.data;
        if (resp.success) {
          $("#form-modal").modal("hide");
          _this.list(1);
          Toast.success("保存成功！")
        } else {
          Toast.warning(resp.message)
        }
      })
    },

    //删除
    del(id) {
      let _this = this;
      Confirm.show("删除资源后不可恢复，确认删除？", function () {
        _this.$ajax.delete('http://127.0.0.1:9000/system/admin/resource/delete/' + id).then((response) => {
          let resp = response.data;
          if (resp.success) {
            _this.list(1);
            Toast.success("删除成功！");
          }
        })
      });
    },

    //初始化资源树
    initTree() {
      let _this = this;
      let setting = {
        data:{
          simpleData:{
            idKey:"id",
            pIdKey:"parent",
            rootPId:"",
          }
        }
      };

      _this.zTree = $.fn.zTree.init($("#tree"),setting,_this.resources);
      _this.zTree.expandAll();
    },
  }
}
</script>