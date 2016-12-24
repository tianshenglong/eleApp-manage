<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/8
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <link href="../../static/hplus/css/bootstrap.min.css-v=3.3.5.css" rel="stylesheet">
  <link href="../../static/hplus/css/font-awesome.min.css-v=4.4.0.css" rel="stylesheet">
  <link href="../../static/hplus/css/animate.min.css" rel="stylesheet">
  <link href="../../static/hplus/css/style.min.css-v=4.0.0.css" rel="stylesheet">
  <link href="../../static/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
  <link href="../../static/css/style.css" rel="stylesheet">

</head>
<body class="gray-bg">
<nav class="breadcrumb"><i class="fa fa-home"></i>
  首页 &gt; app管理 &gt; app列表
  <a class="btn btn-primary"
     style="margin-top:3px;float: right!important;margin-right:20px;padding-top: 5px"
     href="javascript:location.replace(location.href);" title="刷新">
    <i class="fa fa-refresh fa-2"></i> </a></nav>
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
      <div class="ibox float-e-margins">
        <div class="ibox-title">
          <div class="form-inline">
            <div class="form-group">
              <select class="form-control" name="apptype" id="apptype">
                <option value="1">应用名称</option>
              </select>
              <input type="text" name="keywords" id="keywords" class="form-control">
            </div>
            <button name="search" id="search" class="btn btn-success"><i
                    class="fa fa-search"></i>
              搜索
            </button>
          </div>
          <br/>

          <div class="form-inline">
            <a class="btn btn-primary" onclick="addApp('添加应用','/app/toAppAdd')" href="javascript:void(0);"><i class="fa fa-plus"></i> 添加应用</a>
            <a href="javascript:void(0);" onclick="setPerfact()" class="btn btn-primary"><i class="fa fa-trash-o"></i> 设置精品应用</a>
            <a href="javascript:void(0);" onclick="upploadImgs('上传应用图片','/app/toUploadImgs')"  class="btn btn-primary"><i class="fa fa-trash-o"></i>上传应用展示图片</a>
            <a href="javascript:void(0);" onclick="upploadCaseImgs('上传使用案例','/app/toUploadCaseImgs')"  class="btn btn-primary"><i class="fa fa-trash-o"></i>添加应用使用案例</a>
            <a href="javascript:void(0);" onclick="delApp()" class="btn btn-primary"><i class="fa fa-trash-o"></i> 批量删除</a>
          </div>
        </div>
        <div class="ibox-content">
          <table id="oTable" class="table table-striped table-bordered table-hover dataTables-example">
            <thead>
            <tr>
              <th width="25">
                <input type="checkbox">
              </th>
              <th>应用编号</th>
              <th>应用名称</th>
              <th>应用类型</th>
              <th>公司编号</th>
              <th>是否付费</th>
              <th>价格</th>
              <th>状态</th>
              <th>创建时间</th>
              <th>操作</th>
            </tr>
            </thead>
          </table>

        </div>
      </div>
    </div>
  </div>
</div>

<div class="boxshow">
  <div class="box2">
    <div class="login5"></div>
    <div class="login51">
      <div id="demo" class="demo"></div>
    </div>
  </div>
</div>

<script src="../../static/js/jquery-2.1.4.min.js"></script>
<script src="../../static/layer/layer.js"></script>
<script src="../../static/datatables/js/jquery.dataTables.js"></script>
<script src="../../static/datatables/js/dataTables.bootstrap.js"></script>
<script src="../../static/js/public.js"></script>


<script type="text/javascript">
  var oTable;
  $(document).ready(function () {
    oTable = $('#oTable').dataTable({
      'bServerSide': true,
      "bAutoWidth": false,
      "processing": true,
      "serverSide": true,
      "sScrollX": true,
      "ordering": false,
      "searching": false,

      "dom": 't<"bottom"iflpr<"clear">>',
      "ajax": {
        "url": "/app/getAppList",
        "data": function (d) {
          d.apptype = $("#apptype  option:selected").val();  //请求参数
          d.keywords = $('#keywords').val();  //请求参数
        }
      },
      "columnDefs": [{
        "render": function (data, type, row) {
          return "<td><input type='checkbox' value='" + row[0] + "' name='checkList'></td>"
        },
        "targets": 0,
      },{
        "render": function (data, type, row) {
          if (row[7] == '已审核') {
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit(0,"+row[0]+")'>已审核</button>"
          } else if (row[7] == '未审核') {
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit(1,"+row[0]+")'>审核</button>"
          }
        },
        "targets": 9,
      }],
      "language": {
        "url": "../static/datatables/i18n/Chinese.json"
      }
    });

    $('#search').click(function () {
      oTable.fnDraw();
    });
  });

  function setPerfact(){
    var str = '';
    $("input[name='checkList']:checked").each(function(i, o) {
      str += $(this).val();
      str += ",";
    });
    if (str.length > 0) {
      layer.confirm(
              '确认要将所选应用设置为精品吗？',
              {
                btn: ['确定', '取消'],
                shade: false
              },
              function () {
                $.ajax({
                  dataType : 'json',
                  type : 'POST',
                  cache : false,
                  url : '/app/setPerfact',
                  data : {
                    appIds : str
                  },
                  async : false,
                  success : function(data) {
                    if (data == true) {
                      layer.msg('操作成功', {
                        icon: 6,
                        time: 1000
                      });
                    } else {
                      layer.msg('操作失败', {
                        icon: 5,
                        time: 1000
                      });
                    }
                    oTable.fnDraw();
                  },
                  error : function(data) {
                    layer.alert('批量删除失败!', {
                      icon : 5
                    });
                  },
                });
              }, function () {
                layer.msg('已取消操作', {
                  icon: 5,
                  time: 1000
                });
              });
    }else{
      layer.msg('至少选择一条记录操作!', {
        icon : 6,
        time : 2000
      });
    }
  }

  /*应用-添加*/
  function addApp(title, url) {
    var index = layer.open({
      type: 2,
      title: title,
      content: url,
      end: function (layero, index) {
        oTable.fnDraw();
      }
    });
    layer.full(index);
  }

  /*应用-添加*/
  function upploadImgs(title, url) {
    var str = '';
    $("input[name='checkList']:checked").each(function (i, o) {
      str += $(this).val();
      str += ",";
    });
    var idArr = str.split(",");
    if (idArr.length ==2) {
      var index = layer.open({
        type: 2,
        title: title,
        content: url+"?appId="+idArr[0],
        end: function (layero, index) {
          oTable.fnDraw();
        }
      });
      layer.full(index);
    }else if(idArr.length ==1){
      layer.msg('至少选择一条记录操作!', {
        icon: 6,
        time: 2000
      });
    } else if(idArr.length >2){
      layer.msg('只能上传一个应用的图片信息，请重新选择!', {
        icon : 5,
        time : 2000
      });
    }
  }

  /*应用-添加*/
  function upploadCaseImgs(title, url) {
    var str = '';
    $("input[name='checkList']:checked").each(function (i, o) {
      str += $(this).val();
      str += ",";
    });
    var idArr = str.split(",");
    if (idArr.length ==2) {
      var index = layer.open({
        type: 2,
        title: title,
        content: url+"?appId="+idArr[0],
        end: function (layero, index) {
          oTable.fnDraw();
        }
      });
      layer.full(index);
    }else if(idArr.length ==1){
      layer.msg('至少选择一条记录操作!', {
        icon: 6,
        time: 2000
      });
    } else if(idArr.length >2){
      layer.msg('只能上传一个应用的图片信息，请重新选择!', {
        icon : 5,
        time : 2000
      });
    }
  }

  function changeAudit(type,id){
    layer.confirm(
            '确认要变更app的审核状态吗？',
            {
              btn: ['确定', '取消'],
              shade: false
            },
            function () {
              $.ajax({
                dataType : 'json',
                type : 'POST',
                cache : false,
                url : '/app/updateAppStatus',
                data : {
                  id : id,
                  status:type
                },
                async : false,
                success : function(data) {
                  if (data == true) {
                    layer.msg('操作成功', {
                      icon: 6,
                      time: 1000
                    });
                  } else {
                    layer.msg('操作失败', {
                      icon: 5,
                      time: 1000
                    });
                  }
                  oTable.fnDraw();
                },
                error : function(data) {
                  layer.alert('批量删除失败!', {
                    icon : 5
                  });
                },
              });
            }, function () {
              layer.msg('已取消操作', {
                icon: 5,
                time: 1000
              });
            });
  }


  function delApp() {
    var str = '';
    $("input[name='checkList']:checked").each(function(i, o) {
      str += $(this).val();
      str += ",";
    });
    if (str.length > 0) {
      layer.confirm('确认要删除所选的app吗？', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
      }, function(){
        var IDS = str.substr(0, str.length - 1);
        alert(IDS);
        layer.msg('操作成功!', {
          icon : 6,
          time : 2000
        });
        oTable.fnDraw();
      }, function(){
        layer.msg('已取消操作', {
          icon: 5,
          time: 1000
        });
      });
    }else{
      layer.msg('至少选择一条记录操作!', {
        icon : 6,
        time : 2000
      });
    }
  }


  function uploadAppImgs(){
    $('.box2').fadeIn("slow");
  }

</script>
</body>
</html>
