<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/4
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    首页 &gt; 权限管理 &gt; 管理员维护
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
                            <select class="form-control" name="usertype" id="usertype">
                                <option value="1">用户名</option>
                                <option value="2">昵称</option>
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
                        <a class="btn btn-primary" onclick="addUser('添加管理员','/user/toAppUser')"
                           href="javascript:void(0);"><i class="fa fa-plus"></i> 添加管理员</a>
                        <a href="javascript:void(0);" onclick="role_del()" class="btn btn-primary"><i
                                class="fa fa-trash-o"></i> 批量删除</a>
                    </div>
                </div>
                <div class="ibox-content">
                    <table id="oTable" class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th width="25">
                                <input type="checkbox">
                            </th>
                            <th>用户Code</th>
                            <th>用户名称</th>
                            <th>手机号码</th>
                            <th>用户类型</th>
                            <th>用户昵称</th>
                            <th>积分</th>
                            <th>邮箱</th>
                            <th>状态</th>
                            <th>添加时间</th>
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
                "url": "/user/getUserList",
                "data": function (d) {
                    d.usertype = $("#usertype  option:selected").val();  //请求参数
                    d.keywords = $('#keywords').val();  //请求参数
                }
            },
            "columnDefs": [{
                "render": function (data, type, row) {
                    var buttons = '';
                    buttons += "<input type='checkbox' value='" + row.id + "' name='checkList'>";
                    return buttons;
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
            $("#selectName").val("");
            $("#roleId").val("");
            $("#selectId").val(1);
            oTable.fnDraw();
        });
    });

    /*资讯-添加*/
    function addUser(title, url) {
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

</script>
</body>
</html>
