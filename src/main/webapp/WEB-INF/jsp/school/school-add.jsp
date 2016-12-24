<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/8
  Time: 22:22
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
<body class="gray-bg" onload="pageOnload()">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>请填写学校基本信息</h5>
                </div>
                <div class="ibox-content">
                    <input type="hidden" id="closeOrnot" name="closeOrnot" value="${closeOrnot}"/>
                    <form class="form-horizontal m-t" action="/school/addSchool" method="post" class="form form-horizontal" id="form-app">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校名称：</label>
                            <div class="col-sm-8">
                                <input id="name" name="name" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">归属地：</label>
                            <div class="col-sm-9">
                                <div class="form-inline">
                                    <select id="province" name="province" class="form-control">
                                        <option value="10">请选择</option>
                                        <c:forEach var="province" items="${listProvince}">
                                            <option value="${province.id}">${province.name}</option>
                                        </c:forEach>
                                    </select>
                                    <!-- 市 -->
                                    <select name="city" id="city" class="form-control">
                                    </select>
                                    <!-- 县 -->
                                    <select id="county" name="county" class="form-control">
                                    </select>
                                    <!-- 乡 -->
                                    <select name="rural" id="rural" class="form-control">
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校地址：</label>
                            <div class="col-sm-8">
                                <input id="address" name="address" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">紧急联系人：</label>
                            <div class="col-sm-8">
                                <input type="text" name="contactPerson" id="contactPerson" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">紧急联系人电话：</label>
                            <div class="col-sm-8">
                                <input id="contactMobile" name="contactMobile" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">保存</button>
                                <button class="btn btn-primary" type="button" onClick="layer_close();">关闭</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../static/js/jquery-1.11.3.min.js"></script>
<script src="../../static/layer/layer.js"></script>
<script src="../../static/js/public.js"></script>
<script src="../../static/js/jquery.chained.remote.min.js"></script>

<script>

    $(function() {
        $("#city").remoteChained({
            parents: "#province",
            url: "/public/getCityList",
            loading: "loading...",
            clear: true
        });
        $("#county").remoteChained({
            parents: "#city",
            url: "/public/getCountyList",
            loading: "loading...",
            clear: true
        });
        $("#rural").remoteChained({
            parents: "#county",
            url: "/public/getRuralList",
            loading: "loading...",
            clear: true
        });
    });
    function pageOnload(){
        var closeOrNot =$("#closeOrnot").val();
        if(closeOrNot == 1){
            layer_close();
        }
    }
</script>

</body>
</html>
