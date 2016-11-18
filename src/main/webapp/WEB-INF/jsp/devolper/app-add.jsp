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

<div class="section section-white">
    <div class="container">
        <form action="/devolper/addApp" method="post" enctype="multipart/form-data">
            <input type="hidden" name="CompanyCode" value="${compId}" />
            <div class="row" style="line-height: 50px;">
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="AppName">应用名称：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="text" name="AppName" id="AppName"class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="AppExplain">应用说明：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <textarea rows="" cols="" class="form-control"  name="AppExplain" id="AppExplain"></textarea>
                    </div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label>应用类型：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="radio" name="AppType" value="1"/>移动客户端&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="AppType" value="2"/>桌面客户端&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="AppType" value="3" />网站应用</div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="AppAddress">应用地址：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="text" name="AppAddress" id="AppAddress" class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="AppSize">应用大小：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="text" name="AppSize" id="AppSize" class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="smallImg">小图：</label></div>
                    <div class="col-md-4" style="float:left;text-align: left">
                        <input type="file" name="smallImg" id="smallImg" multiple style="display:none" class="input-file" />
                        <div class="input-append form-inline">
                            <input id="smallImgCover"  class="input-large form-control" type="text"
                                   style="height:30px;">
                            <a class="btn btn-primary radius" onclick="$('input[id=smallImg]').click();">浏览文件</a>
                        </div>
                    </div>
                    <div class="col-md-4"><img src="" id="smallImgView" style="width: 100px;height: 100px;border: 0;"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="bigImg">大图：</label></div>
                    <div class="col-md-4" style="float:left;text-align: left">
                        <input type="file" name="bigImg" id="bigImg" multiple style="display:none" class="input-file" />
                        <div class="input-append form-inline">
                            <input id="bigImgCover" class="input-large form-control" type="text"
                                   style="height:30px;">
                            <a class="btn btn-primary radius" onclick="$('input[id=bigImg]').click();">浏览文件</a>
                        </div>
                    </div>
                    <div class="col-md-4"><img src="" id="bigImgView" style="width: 100px;height: 100px;border: 0;"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label>是否付费：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="radio" name="IsFree" value="1"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="IsFree" value="0"/>否</div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-2"><label for="Price">价格：</label></div>
                    <div class="col-md-6" style="float:left;text-align: left">
                        <input type="text" name="Price" id="Price" class="form-control"/></div>
                    <div class="col-md-2"></div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-2"></div>
                    <div class="col-md-6"><input type="checkbox" checked />我已阅读并接受大象开放平台开发者协议</div>
                    <div class="col-md-4"></div>
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

<script>
    $(document).ready(function () {
        /*文件上传预览*/
        $('input[id=bigImg]').change(function () {
            var objUrl = getObjectURL(this.files[0]);
            if (objUrl) {
                $("#bigImgView").attr("src", objUrl);
            }
            $('#bigImgCover').val($(this).val());
        });
        $('input[id=smallImg]').change(function () {
            var objUrl = getObjectURL(this.files[0]);
            if (objUrl) {
                $("#smallImgView").attr("src", objUrl);
            }
            $('#smallImgCover').val($(this).val());
        });
    });

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
</script>

</body>
</html>
