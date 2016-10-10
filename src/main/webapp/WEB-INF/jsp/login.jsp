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
  <title>大象应用后台管理</title>
</head>
<body>
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form  id="logform" class="form form-horizontal" action="/ajaxLogin" method="post">
      <c:if test="${msg!=null and msg!=''}">
      <div class="row cl">
        <label class="form-label col-3"></label>
        <div class="formControls col-8">
            ${msg}
        </div>
      </div>
      </c:if>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="j_username" name="j_username"  type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="j_password" name="j_password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <label for="auto">
            <input type="checkbox" name="auto" id="auto">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-8 col-offset-3">
          <div id="div_geetest_lib"></div>
          <div id="div_id_float"></div>
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <button  type="submit" class="btn btn-success radius size-L"> &nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;</button>
          <button  type="reset" class="btn btn-default radius size-L" >&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;</button>
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright © 2012-2016</div>
</body>
</html>
