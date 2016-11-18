<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/11/7
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="../../static/image/eleico.png" rel="icon">
  <title>大象开放平台-首页</title>
  <link rel="stylesheet" href="../../static/devolper/css/bootstrap.min.css">
  <link rel="stylesheet" href="../../static/devolper/css/icomoon-social.css">
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="../../static/devolper/css/leaflet.css" />
  <!--[if lte IE 8]>
  <link rel="stylesheet" href="../../static/devolper/css/leaflet.ie.css" />
  <![endif]-->
  <link rel="stylesheet" href="../../static/devolper/css/main.css">

  <script src="../../static/devolper/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
<%--头部包含文件--%>
<jsp:include  page="include/top.jsp"  flush="true"/>

<!-- Homepage Slider -->
<div class="homepage-slider">
  <div id="sequence">
    <ul class="sequence-canvas">
      <!-- Slide 1 -->
      <li class="bg4">
        <!-- Slide Title -->
        <h2 class="title">移动应用</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">大象开放平台为移动应用提供了便捷的合作模式，满足了多元化移动终端用户随时随地快速登录、分享信息的需求，助力实现移动Apps、
          健康设备、智能家居，车载等多类型终端的社会化接入。<a href="/devolper/join" target="_blank" class="btn btn-orange">立即接入</a></h3>

        <!-- Slide Image -->
        <img class="slide-img" src="../../static/devolper/img/homepage-slider/slide1.png" alt="Slide 1" />
      </li>
      <!-- End Slide 1 -->
      <!-- Slide 2 -->
      <li class="bg3">
        <!-- Slide Title -->
        <h2 class="title">web接入</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">大象开放平台封装了可直接部署在任意网站上的微博登录按钮、关注按钮、分享按钮等组件，为开发者降低新用户注册门槛的同时，实现了社交关系的零成本引入和优质内容的快速传播。</h3>
        <!-- Slide Image -->
        <img class="slide-img" src="../../static/devolper/img/homepage-slider/slide2.png" alt="Slide 2" />
      </li>
      <!-- End Slide 2 -->
      <!-- Slide 3 -->
      <li class="bg1">
        <!-- Slide Title -->
        <h2 class="title">数据中心</h2>
        <!-- Slide Text -->
        <h3 class="subtitle">基于微博商业数据接口，提供微博帐号在微博营销的效果分析数据。包括粉丝分析、微博/评论内容分析、粉丝互动分析、相关行业帐号分析。</h3>
        <!-- Slide Image -->
        <img class="slide-img" src="../../static/devolper/img/homepage-slider/slide3.png" alt="Slide 3" />
      </li>
      <!-- End Slide 3 -->
    </ul>
    <div class="sequence-pagination-wrapper">
      <ul class="sequence-pagination">
        <li>1</li>
        <li>2</li>
        <li>3</li>
      </ul>
    </div>
  </div>
</div>
<!-- End Homepage Slider -->

<!-- Press Coverage -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-wired">
          <a href="#">大象开放平台为移动应用提供了便捷的合作模式，满足了多元化移动终端用户随时随地快速登录、分享信息的需求，助力实现移动Apps、健康设备、智能家居，车载等多类型终端的社会化接入。</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-mashable">
          <a href="#">大象开放平台封装了可直接部署在任意网站上的微博登录按钮、关注按钮、分享按钮等组件，为开发者降低新用户注册门槛的同时，实现了社交关系的零成本引入和优质内容的快速传播。</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-techcrunch">
          <a href="#">基于微博商业数据接口，提供微博帐号在微博营销的效果分析数据。包括粉丝分析、微博/评论内容分析、粉丝互动分析、相关行业帐号分析。</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Services -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="../../static/devolper/img/service-icon/diamond.png" alt="Service 1">
          <h3>移动应用</h3>
          <p>Mobile Application</p>
          <a href="/devolper/join" target="_blank" class="btn">立即接入</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="../../static/devolper/img/service-icon/ruler.png" alt="Service 2">
          <h3>web接入</h3>
          <p>Web Connect</p>
          <a href="#" class="btn">立即接入</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="../../static/devolper/img/service-icon/box.png" alt="Service 3">
          <h3>数据接入</h3>
          <p>DATE CENTER</p>
          <a href="#" class="btn">立即接入</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Services -->

<!-- Call to Action Bar -->
<div class="section section-white">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="calltoaction-wrapper">
          <h3>大象sdk下载!</h3> <a href="../../static/sdk/esdk.zip" class="btn btn-orange">立即下载</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Call to Action Bar -->

<!-- Pricing Table 暂时注释 begin -->
<%--<div class="section">
  <div class="container">
    <h2>Pricing</h2>
    <div class="row">
      <!-- Pricing Plans Wrapper -->
      <div class="pricing-wrapper col-md-12">
        <!-- Pricing Plan -->
        <div class="pricing-plan">
          <!-- Pricing Plan Ribbon -->
          <div class="ribbon-wrapper">
            <div class="price-ribbon ribbon-red">Popular</div>
          </div>
          <h2 class="pricing-plan-title">Starter</h2>
          <p class="pricing-plan-price">FREE</p>
          <!-- Pricing Plan Features -->
          <ul class="pricing-plan-features">
            <li><strong>1</strong> user</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>2GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <!-- End Pricing Plan -->
        <div class="pricing-plan">
          <h2 class="pricing-plan-title">Advanced</h2>
          <p class="pricing-plan-price">$49<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>10</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>20GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <!-- Promoted Pricing Plan -->
        <div class="pricing-plan pricing-plan-promote">
          <h2 class="pricing-plan-title">Premium</h2>
          <p class="pricing-plan-price">$99<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>Unlimited</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>100GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
        <div class="pricing-plan">
          <!-- Pricing Plan Ribbon -->
          <div class="ribbon-wrapper">
            <div class="price-ribbon ribbon-green">New</div>
          </div>
          <h2 class="pricing-plan-title">Mega</h2>
          <p class="pricing-plan-price">$199<span>/mo</span></p>
          <ul class="pricing-plan-features">
            <li><strong>Unlimited</strong> users</li>
            <li><strong>Unlimited</strong> projects</li>
            <li><strong>100GB</strong> storage</li>
          </ul>
          <a href="index.html" class="btn">Order Now</a>
        </div>
      </div>
      <!-- End Pricing Plans Wrapper -->
    </div>
  </div>
</div>--%>

<!-- End Pricing Table 暂时注释 end -->

<!-- Our Clients -->
<div class="section">
  <div class="container">
    <h2>客户案例</h2>
    <div class="clients-logo-wrapper text-center row">
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/canon.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/cisco.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/dell.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/ea.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/ebay.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/facebook.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/google.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/hp.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/microsoft.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/mysql.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/sony.png" alt="Client Name"></a></div>
      <div class="col-lg-1 col-md-1 col-sm-3 col-xs-6"><a href="#"><img src="../../static/devolper/img/logos/yahoo.png" alt="Client Name"></a></div>
    </div>
  </div>
</div>
<!-- End Our Clients -->

<!-- Footer -->
<jsp:include  page="include/bottom.jsp"  flush="true"/>

<!-- Javascripts -->
<script src="../../static/devolper/js/jquery-1.9.1.min.js"></script>
<script src="../../static/devolper/js/bootstrap.min.js"></script>
<script src="../../static/devolper/js/leaflet.js"></script>
<script src="../../static/devolper/js/jquery.fitvids.js"></script>
<script src="../../static/devolper/js/jquery.sequence-min.js"></script>
<script src="../../static/devolper/js/jquery.bxslider.js"></script>
<script src="../../static/devolper/js/main-menu.js"></script>
<script src="../../static/devolper/js/template.js"></script>

</body>
</html>
