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
</head>
<body>
<nav class="breadcrumb"><i class="fa fa-home"></i>
    首页 &gt; app管理 &gt; 添加app
    <a class="btn btn-primary"
       style="margin-top:3px;float: right!important;margin-right:20px;padding-top: 5px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="fa fa-refresh fa-2"></i> </a></nav>
<div class="wrapper wrapper-content animated fadeInRight container">
    <form action="/app/addApp" method="post" class="form form-horizontal" id="form-company">
        <div class="row">
            <div class="col-md-4">
                <label for="name" class="control-label" style="color:red;">app名称：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="name" name="name" maxlength="50"
                       required="required"
                       placeholder="限制50字以内，中文、英文、数字和标点符号均算一个字；">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="companyCode" class="control-label" style="color:red;">所属单位：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="companyCode" name="companyCode" maxlength="50"
                       required="required">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="description" class="control-label" style="color:red;">描述：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="description" name="description" maxlength="50"
                       required="required">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="imgUrl" class="control-label" style="color:red;">缩略图：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="imgUrl" name="imgUrl" maxlength="50"
                       required="required">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="appUrl" class="control-label">app：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="appUrl" name="appUrl" maxlength="100"
                       placeholder="限制100字以内，中文、英文、数字和标点符号均算一个字；">
            </div>
        </div>
        <div class="form-inline" style="text-align: center;margin-top: 20px">
            <button class="btn btn-secondary radius" type="submit" id="subDraft">
                <i class="fa fa-plus"></i>保存
            </button>
            <button class="btn btn-secondary radius" type="button" onClick="layer_close();">
                <i class="fa fa-close"></i>关闭
            </button>
        </div>
    </form>
</div>
</body>
</html>
