<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/11/2
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
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
        <%--<div class="ibox-title">
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
            <a href="javascript:void(0);" onclick="delApp()" class="btn btn-primary"><i class="fa fa-trash-o"></i> 批量删除</a>
          </div>
        </div>--%>
        <div class="ibox-content">
          <table id="oTable" class="table table-striped table-bordered table-hover dataTables-example">
            <thead>
            <tr>
              <th width="25">
                <input type="checkbox">
              </th>
              <th>应用id</th>
              <th>证书</th>
              <th>用户id</th>
              <th>用户openid</th>
              <th>证书生成时间</th>
              <th>最后刷新时间</th>
              <th>有效期</th>
              <th>状态</th>
              <th>操作</th>
            </tr>
            </thead>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="../../static/js/jquery-1.8.3.min.js"></script>
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
        "url": "/oauth/getOauthList"
      },
      "columnDefs": [{
        "render": function (data, type, row) {
          return "<input type='checkbox' value='" + row[0] + "' name='checkList'>";
        },
        "targets": 0,
      },{
        "render": function (data, type, row) {
          console.log(row);
          if (row[8] == '禁用') {
            console.log(row[8]);
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit(1,"+row[0]+")'>生效</button>";
          } else if (row[8] == '生效') {
            console.log(row[8]+1);
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit(0,"+row[0]+")'>禁用</button>";
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

  function changeAudit(type,id){
    layer.confirm(
            '确认要变更Oauth的状态吗？',
            {
              btn: ['确定', '取消'],
              shade: false
            },
            function () {
              $.ajax({
                dataType : 'json',
                type : 'POST',
                cache : false,
                url : '/oauth/updateOauthStatus',
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
                  layer.alert('程序异常，请联系管理员!', {
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
</script>
</body>
</html>

