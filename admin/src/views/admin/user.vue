<template>
  <div>
    <p>
      <button v-show="hasResource('010101')" v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button> &nbsp;
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>

    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>id</th>
        <th>登陆名</th>
        <th>昵称</th>
        <th>密码</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="user in users">
        <td>{{user.id}}</td>
        <td>{{user.loginName}}</td>
        <td>{{user.name}}</td>
        <td>{{user.password}}</td>

        <td>
          <div class="hidden-sm hidden-xs btn-group">
            <button v-show="hasResource('010101')" v-on:click="edit(user)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>
            <button v-show="hasResource('010103')" v-on:click="editPassword(user)" class="btn btn-xs btn-default">
              <i class="ace-icon fa fa-key bigger-120"></i>
            </button>
            <button v-show="hasResource('010102')" v-on:click="del(user.id)" class="btn btn-xs btn-danger">
              <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>
          </div>
        </td>
      </tr>
      </tbody>
    </table>

    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">表单</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
                      <div class="form-group">
                        <label class="col-sm-2 control-label">登陆名</label>
                        <div class="col-sm-10">
                          <input v-model="user.loginName" v-bind:disabled="user.id" class="form-control">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                          <input v-model="user.name" class="form-control">
                        </div>
                      </div>
                      <div v-show="!user.id" class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                          <input v-model="user.password" class="form-control">
                        </div>
                      </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div id="edit-password-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">修改密码</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">新密码</label>
                <div class="col-sm-10">
                  <input v-model="user.password" class="form-control" type="password">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-white btn-default btn-round" data-dismiss="modal">取消</button>
            <button v-on:click="savePassword()" type="button" class="btn btn-white btn-info btn-round">
              <i class="ace-icon fa fa-plus blue"/>
              保存密码
            </button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


  </div>
</template>

<script>
import Pagination from "@/components/pagination";

export default {
  name: "system-user",
  components: {Pagination},
  data: function () {
    return {
      user: {}, //该变量用来绑定form表单的数据
      users: [],
    }
  },
  mounted: function () {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.list(1);
    //this.$parent.activeSidebar("system-user-sidebar")
  },
  methods: {

    /**
     * 查找是否有权限
     */
    hasResource(id) {
      return Tool.hasResource(id);
    },

    //新增
    add() {
      let _this = this;
      _this.user = {};
      $("#form-modal").modal("show");
    },

    //编辑
    edit(user) {
      let _this = this;
      _this.user = $.extend({}, user);
      $("#form-modal").modal("show");
    },

    //列表查询
    list(page) {
      let _this = this;
      _this.$ajax.post('http://127.0.0.1:9000/system/admin/user/list', {
        page: page,
        size: _this.$refs.pagination.size,
      }).then((response) => {
        let resp = response.data;
        _this.users = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total);
      })
    },

    //保存
    save() {
      let _this = this;

      // 保存校验
      if (1 != 1
        || !Validator.require(_this.user.loginName, "登陆名")
        || !Validator.length(_this.user.loginName, "登陆名", 1, 50)
        || !Validator.length(_this.user.name, "昵称", 1, 50)
        || !Validator.require(_this.user.password, "密码")
      ) {
        return;
      }

      _this.user.password = hex_md5(_this.user.password + KEY); //md5加密密码
      _this.$ajax.post('http://127.0.0.1:9000/system/admin/user/save', _this.user).then((response) => {
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
      Confirm.show("删除用户后不可恢复，确认删除？", function () {
        _this.$ajax.delete('http://127.0.0.1:9000/system/admin/user/delete/' + id).then((response)=>{
          let resp = response.data;
          if (resp.success) {
            _this.list(1);
            Toast.success("删除成功！");
          }
        })
      });
    },

    //重置密码
    editPassword(user) {
      let _this = this;
      _this.user = $.extend({}, user);
      _this.user.password = null;
      $("#edit-password-modal").modal("show");
    },

    //保存密码
    savePassword() {
      let _this = this;

      _this.user.password = hex_md5(_this.user.password + KEY); //md5加密密码
      _this.$ajax.post('http://127.0.0.1:9000/system/admin/user/save-password', _this.user).then((response) => {
        let resp = response.data;
        if (resp.success) {
          $("#edit-password-modal").modal("hide");
          _this.list(1);
          Toast.success("保存成功！")
        } else {
          Toast.warning(resp.message)
        }
      })
    },
  }
}
</script>