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
        首页&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;开发者信息
    </div>
</div>

<div class="section section-white">
    <div class="container">
        <form action="/devolper/joinUp" method="post">
            <div class="row" style="line-height: 50px;">
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="compName">开发者名称：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="compName"
                                                                                     id="compName"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label>所在地区：</label></div>
                    <div class="col-md-3" style="float:left;text-align: left">
                        <select name="province" class="form-control" id="province" style="width: 80%">
                            <option value="1">北京</option>
                            <option value="2">上海</option>
                        </select></div>
                    <div class="col-md-3" style="float:left;text-align: left">
                        <select name="city" class="form-control" id="city" style="width: 80%">
                            <option value="1">北京</option>
                            <option value="2">上海</option>
                        </select></div>
                    <div class="col-md-2"></div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="address">详细地址：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="address"
                                                                                     id="address" class="form-control"/>
                    </div>
                    <div class="col-md-2"></div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="postCode">邮编：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="postCode"
                                                                                     id="postCode"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="compEmail">企业邮箱：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="compEmail"
                                                                                     id="compEmail"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="compMobile">企业电话：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="compMobile"
                                                                                     id="compMobile"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="chatTool">聊天工具：</label></div>
                    <div class="col-md-2" style="float:left;text-align: left">
                        <select name="chatTool" class="form-control" id="chatTool" style="width: 80%">
                            <option value="1">北京</option>
                            <option value="2">上海</option>
                        </select>
                    </div>
                    <div class="col-md-4" style="float:left;text-align: left">
                        <input type="text" name="chatNum" id="chatNum" class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>


                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="webSite">网站：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="webSite" id="webSite"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="urgentMan">紧急联系人姓名：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="urgentMan" id="urgentMan"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="urgentMobile">紧急联系人电话：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left"><input type="text" name="urgentMobile" id="urgentMobile"
                                                                                     class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>

                <div class="col-md-12">
                    <div class="col-md-4"></div>
                    <div class="col-md-6"><button type="submit" class="btn btn-success">提交</button>&nbsp;&nbsp;<button type="reset" class="btn btn-success">重置</button></div>
                    <div class="col-md-2"></div>

                </div>
            </div>
        </form>
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
<script src="../../static/devolper/js/leaflet.js"></script>
<script src="../../static/devolper/js/jquery.fitvids.js"></script>
<script src="../../static/devolper/js/jquery.sequence-min.js"></script>
<script src="../../static/devolper/js/jquery.bxslider.js"></script>
<script src="../../static/devolper/js/main-menu.js"></script>
<script src="../../static/devolper/js/template.js"></script>

</body>
</html>
