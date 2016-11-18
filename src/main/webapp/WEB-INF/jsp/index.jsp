<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/1
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <title>大象应用管理后台</title>

  <meta name="keywords" content="大象应用管理后台">
  <meta name="description" content="大象应用管理后台">

  <!--[if lt IE 8]>
  <meta http-equiv="refresh" content="0;ie.html" />
  <![endif]-->

  <link rel="shortcut icon" href="favicon.ico" >
  <link href="../../static/hplus/css/bootstrap.min.css-v=3.3.5.css" rel="stylesheet">
  <link href="../../static/hplus/css/font-awesome.min.css-v=4.4.0.css" rel="stylesheet">
  <link href="../../static/hplus/css/animate.min.css" rel="stylesheet">
  <link href="../../static/hplus/css/style.min.css-v=4.0.0.css" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <span><img alt="image" class="img-circle" src="../../static/hplus/img/profile_small.jpg" /></span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${userName}</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
            </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
              </li>
              <li><a class="J_menuItem" href="profile.html">个人资料</a>
              </li>
              <li><a class="J_menuItem" href="contacts.html">联系我们</a>
              </li>
              <li><a class="J_menuItem" href="mailbox.html">信箱</a>
              </li>
              <li class="divider"></li>
              <li><a href="login.html">安全退出</a>
              </li>
            </ul>
          </div>
          <div class="logo-element">H+
          </div>
        </li>
        <c:forEach var="topMenu" items="${sessionScope.userAccess.userRole.roleTopMenuList}" >
          <li>
            <a href="/">
              <i class="${topMenu.logo}"></i>
              <span class="nav-label">${topMenu.menuName}</span>
              <span class="fa arrow"></span>
            </a>
            <ul class="nav nav-second-level">
              <c:forEach var="subMenu" items="${topMenu.roleSubMenuList}">
                <li>
                  <a class="J_menuItem" href="${subMenu.url}" data-index="0">${subMenu.menuName}</a>
                </li>
              </c:forEach>
            </ul>
          </li>
        </c:forEach>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->
  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
        </div>
      </nav>
    </div>
    <div class="row content-tabs">
      <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
      </button>
      <nav class="page-tabs J_menuTabs">
        <div class="page-tabs-content">
          <a href="/user/toUserList" class="active J_menuTab" data-id="index_v1.html">首页</a>
        </div>
      </nav>
      <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
      </button>
      <div class="btn-group roll-nav roll-right">
        <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

        </button>
        <ul role="menu" class="dropdown-menu dropdown-menu-right">
          <li class="J_tabShowActive"><a>定位当前选项卡</a>
          </li>
          <li class="divider"></li>
          <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
          </li>
          <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
          </li>
        </ul>
      </div>
      <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
    </div>
    <div class="row J_mainContent" id="content-main">
      <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="../static/html/welcome.html" frameborder="0" data-id="index_v1.html" seamless></iframe>
    </div>
  </div>
  <!--右侧部分结束-->
</div>
<script src="../../static/hplus/js/jquery.min.js-v=2.1.4.js" ></script>
<script src="../../static/hplus/js/bootstrap.min.js-v=3.3.5.js" ></script>
<script src="../../static/hplus/js/plugins/metisMenu/jquery.metisMenu.js" ></script>
<script src="../../static/hplus/js/plugins/slimscroll/jquery.slimscroll.min.js" ></script>
<script src="../../static/hplus/js/plugins/layer/layer.min.js"></script>
<script src="../../static/hplus/js/hplus.min.js-v=4.0.0.js"></script>
<script src="../../static/hplus/js/contabs.min.js" type="text/javascript"></script>
<script src="../../static/hplus/js/plugins/pace/pace.min.js"></script>
</body>

</html>