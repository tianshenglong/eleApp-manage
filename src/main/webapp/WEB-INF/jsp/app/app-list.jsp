<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/8
  Time: 18:55
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
        <div class="ibox-title">
          <div class="form-inline">
            <div class="form-group">
              <select class="form-control" name="selectId" id="selectId">
                <option value="1">名称</option>
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
            <a class="btn btn-primary" onclick="addApp('添加管理员','/app/toAppAdd')" href="javascript:void(0);"><i class="fa fa-plus"></i> 添加app</a>
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
              <th>名称</th>
              <th>所属单位</th>
              <th>审核状态</th>
              <th>审核通过日期</th>
              <th>审核人</th>
              <th>添加时间</th>
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
        "url": "/app/getAppList",
        "data": function (d) {
          d.userName = $('#userName').val();  //请求参数
        }
      },
      "columnDefs": [{
        "render": function (data, type, row) {
          var buttons = '';
          buttons += "<input type='checkbox' value='" + row.id + "' name='checkList'>";
          return buttons;
        },
        "targets": 0,
      },{
        "render": function (data, type, row) {
          if (row[3] == '1') {
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit()'>已审核</button>"
          } else if (row[3] == '0') {
            return "<button type='button' class='btn btn-primary btn-xs' onclick='changeAudit()'>审核</button>"
          }
        },
        "targets": 7,
      }],
      "language": {
        "url": "../static/datatables/i18n/Chinese.json"
      }
    });

    $('#search').click(function () {
      oTable.fnDraw();
    });
  });

  /*单位-添加*/
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

  function changeAudit(){
    layer.confirm(
            '确认要变更app的审核状态吗？',
            {
              btn: ['确定', '取消'],
              shade: false
            },
            function () {
              layer.msg('操作成功', {
                icon: 6,
                time: 1000
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
      layer.confirm('确认要删除所选的培训班吗？', {
        btn : [ '确定', '取消' ],
        shade : false
      }, function() {
        var IDS = str.substr(0, str.length - 1);
        layer.msg('操作成功!', {
          icon : 6,
          time : 2000
        }, function () {
          layer.msg('已取消操作', {
            icon: 5,
            time: 1000
          });
        });
      });
    } else {
      layer.msg('至少选择一条记录操作!', {
        icon : 6,
        time : 2000
      });
    }
    oTable.fnDraw();
  }

</script>
</body>
</html>
