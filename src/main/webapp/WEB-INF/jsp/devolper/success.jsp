<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/11/7
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../../static/image/eleico.png" rel="icon">
  <title>基本信息-大象开放平台</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../../static/devolper/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../static/devolper/css/icomoon-social.css">
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="../../static/devolper/css/leaflet.css"/>
  <!--[if lte IE 8]>
  <link rel="stylesheet" href="../../static/devolper/css/leaflet.ie.css"/>
  <![endif]-->
  <link rel="stylesheet" href="../../static/devolper/css/main.css">

  <script src="../../static/devolper/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
<%--头部包含文件--%>
<jsp:include  page="include/top.jsp"  flush="true"/>
<div class="section">
  <div class="container">
    首页&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;开发者信息&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;应用信息
  </div>
</div>

<div class="section section-white" style="height: 400px;vertical-align: middle;text-align: center">
  <div class="container">
    申请成功！您的AppKey为：${AppKey},Secret为 ${Secret}
  </div>
</div>

<!-- Our Clients -->
<div class="section">
  <div class="container">
    <h2>客户案例</h2>

    <div class="clients-logo-wrapper text-center row">
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/canon.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/cisco.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/dell.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/ea.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/ebay.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/facebook.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/google.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/hp.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/microsoft.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/mysql.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/sony.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img
              src="../../static/devolper/img/logos/yahoo.png" alt="Client Name"></a></div>
    </div>
  </div>
</div>
<!-- End Our Clients -->

<!-- Footer -->
<jsp:include  page="include/bottom.jsp"  flush="true"/>

<!-- Javascripts -->
<script src="../../static/devolper/js/jquery-1.9.1.min.js"></script>
<script src="../../static/devolper/js/bootstrap.min.js"></script>

</body>
</html>
