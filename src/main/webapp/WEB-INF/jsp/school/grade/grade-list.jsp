<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/19
  Time: 0:02
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
  首页 &gt; 学校管理 &gt; 年级管理
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
              年级名称
              <input type="text" name="gradeName" id="gradeName" class="form-control">
            </div>
            <button name="search" id="search" class="btn btn-success"><i
                    class="fa fa-search"></i>
              搜索
            </button>
          </div>
          <br/>

          <div class="form-inline">
            <a class="btn btn-primary" onclick="addRole('添加年级','/role/toRoleAdd')"
               href="javascript:void(0);"><i class="fa fa-plus"></i> 添加年级</a>
          </div>
        </div>
        <div class="ibox-content">
          <table id="oTable" class="table table-striped table-bordered table-hover dataTables-example">
            <thead>
            <tr>
              <th width="25">
                <input type="checkbox">
              </th>
              <th>年级名称</th>
              <th>所属学校</th>
              <th>创建时间</th>
              <th>修改时间</th>
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
        "url": "/graClass/getGradeList",
        "data": function (d) {
          d.gradeName = $('#gradeName').val();
        }
      },
      "columnDefs": [{
        "render": function (data, type, row) {
          return "<td><input type='checkbox' value='" + row[0] + "' name='checkList'></td>"
        },
        "targets": 0,
      }],
      "language": {
        "url": "../static/datatables/i18n/Chinese.json"
      }
    });

    $('#search').click(function () {
      oTable.fnDraw();
    });

    $('#reload').click(function () {
      oTable.fnDraw();
    });
  });

  /*资讯-添加*/
  function addRole(title, url) {
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

  /*角色-资源管理*/
  function role_resource(title, url, id) {
    if (id == '1') {
      layer.msg("管理员不可修改权限");
      return;
    }
    layer.open({
      type: 2,
      skin: 'layui-layer-rim', //加上边框
      area: ['420px', '470px'], //宽高
      title: title,
      content: url
    });
  }

</script>
</body>
</html>