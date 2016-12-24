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
                    <h5>请填写应用基本信息</h5>
                </div>
                <div class="ibox-content">
                    <input type="hidden" id="closeOrnot" name="closeOrnot" value="${closeOrnot}"/>
                    <form class="form-horizontal m-t" action="/app/addApp" method="post" class="form form-horizontal" id="form-app">
                        <input type="hidden" id="companyCode" name="companyCode"  />
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用编号：</label>
                            <div class="col-sm-8">
                                <input id="appCode" name="appCode" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用名称：</label>
                            <div class="col-sm-8">
                                <input id="appName" name="appName" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用说明：</label>
                            <div class="col-sm-8">
                                <textarea name="appExplain" id="appExplain" cols="" rows="" class="form-control" maxlength="300"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用类型：</label>
                            <div class="col-sm-8">
                                <select id="appTypeId" name="appTypeId" class="form-control">
                                    <c:forEach var="cc" items="${allTypes}">
                                        <option value="${cc.id}">${cc.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">选择单位：</label>
                            <div class="col-sm-8">
                                <input id="companyName" name="companyName" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用所在地址：</label>
                            <div class="col-sm-8">
                                <input type="text" name="AppAddress" id="AppAddress" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">应用大小：</label>
                            <div class="col-sm-8">
                                <input id="appSize" name="appSize" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group draggable">
                            <label class="col-sm-3 control-label">小图：</label>
                            <div class="col-sm-8">
                                <input type="file" name="imgSmallFile" id="imgSmallFile" class="form-control">
                            </div>
                        </div>
                        <div class="form-group draggable">
                            <label class="col-sm-3 control-label">大图：</label>
                            <div class="col-sm-8">
                                <input type="file" name="imgBigFile" id="imgBigFile" class="form-control">
                            </div>
                        </div>
                        <div class="form-group draggable">
                            <label class="col-sm-3 control-label">是否付费：</label>
                            <div class="col-sm-8">
                                <input type="radio" id="radio-1" name="isFree" value="1" >
                                <label for="radio-1">是</label>
                                <input type="radio" id="radio-2" name="isFree" value="0" >
                                <label for="radio-2">否</label>
                            </div>
                        </div>
                        <div class="form-group draggable">
                            <label class="col-sm-3 control-label">价格：</label>
                            <div class="col-sm-8">
                                <input id="price" name="price" class="form-control" type="text" >
                            </div>
                        </div>
                        <div class="form-group draggable">
                            <label class="col-sm-3 control-label">上传说明：</label>
                            <div class="col-sm-8">
                                <textarea name="uploadExplain" id="uploadExplain" cols="" rows="" class="form-control" maxlength="300"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
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

<script>

    $(function () {
        $("#companyName").focus(function () {
            layer.open({
                type: 2,
                title: '选择单位',
                shadeClose: false,
                shade: 0.8,
                area: ['70%', '90%'],
                content: '/comp/toChoiceCompList'
            });
            $("#companyName").blur();
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
