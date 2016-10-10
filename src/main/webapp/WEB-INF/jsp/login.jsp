<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/3
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta name="renderer" content="webkit|ie-comp|ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport"
        content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>

  <link href="../../static/hplus/css/bootstrap.min.css-v=3.3.5.css" rel="stylesheet">
  <link href="../../static/hplus/css/font-awesome.min.css-v=4.4.0.css" rel="stylesheet">
  <link href="../../static/hplus/css/animate.min.css" rel="stylesheet">
  <link href="../../static/hplus/css/style.min.css-v=4.0.0.css" rel="stylesheet">
  <link href="../../static/datatables/css/dataTables.bootstrap.css" rel="stylesheet">
  <link href="../../static/hplus/css/login.min.css" rel="stylesheet">

  <title>大象应用后台管理</title>
  <script>
    if(window.top!==window.self){window.top.location=window.location};
  </script>
</head>
<body class="signin">
<div class="signinpanel">
  <div class="row">
    <div class="col-sm-7">
      <div class="signin-info">
        <div class="logopanel m-b">
          <h1>欢迎使用 <strong>大象应用管理后台</strong></h1>
        </div>
        <div class="m-b"></div>
        <h4>欢迎使用 <strong>大象应用管理后台</strong></h4>
        <ul class="m-b">
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
        </ul>
      </div>
    </div>
    <div class="col-sm-5">
      <form id="logform" class="form form-horizontal" action="/ajaxLogin" method="post">
        <h4 class="no-margins">登录：</h4>
        <p class="m-t-md">登录到大象应用管理后台</p>
        <input type="text" class="form-control uname" id="j_username" name="j_username"  placeholder="用户名" />
        <input type="password" class="form-control pword m-b" id="j_password" name="j_password" placeholder="密码" />
        <button class="btn btn-success btn-block" type="submit">登录</button>
      </form>
    </div>
  </div>
  <div class="signup-footer">
    <div class="pull-left">
      &copy; 2015 All Rights Reserved.
    </div>
  </div>
</div>
</body>
</html>
