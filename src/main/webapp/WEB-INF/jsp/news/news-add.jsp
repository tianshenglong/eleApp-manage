<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/8
  Time: 21:49
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

    <script src="../../static/js/jquery-1.8.3.min.js"></script>
    <script src="../../static/ueditor/ueditor.config.js"></script>
    <script src="../../static/ueditor/ueditor.all.min.js"></script>
    <script src="../../static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="../../static/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<nav class="breadcrumb"><i class="fa fa-home"></i>
    首页 &gt; 资讯管理 &gt; 添加资讯
    <a class="btn btn-primary"
       style="margin-top:3px;float: right!important;margin-right:20px;padding-top: 5px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="fa fa-refresh fa-2"></i> </a></nav>
<div class="wrapper wrapper-content animated fadeInRight container">
    <form action="/news/addNews" method="post" class="form form-horizontal" id="form-company" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-4">
                <label for="name" class="control-label" style="color:red;">资讯名称：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="name" name="name" maxlength="50"
                       required="required"
                       placeholder="限制50字以内，中文、英文、数字和标点符号均算一个字；">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="publishDate" class="control-label" style="color:red;">发布时间：</label>
            </div>
            <div class="col-md-8">
                <input type="text" name="publishDate" class="form-control"
                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       id="publishDate" >
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="author" class="control-label" style="color:red;">作者：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="author" name="author" maxlength="50"
                       required="required">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="newsTypeId" class="control-label" style="color:red;">资讯类别：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="newsTypeId" name="newsTypeId" maxlength="50"
                       required="required">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="keywords" class="control-label">关键字：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="keywords" name="keywords" maxlength="100"
                       placeholder="限制100字以内，中文、英文、数字和标点符号均算一个字；">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="description" class="control-label">描述：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="description" name="description" >
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="imgUrl" class="control-label">图片：</label>
            </div>
            <div class="col-md-8">
                <span style="display:none">
                    <input id="lefile" type="file" style="display:none" multiple
                           class="input-file" >
                </span>
                <div class="input-append form-inline">
                    <input id="imgUrl" class="input-large form-control" type="text" name="imgUrl"
                           style="height:30px;">
                    <a class="btn btn-primary radius" onclick="$('input[id=lefile]').click();">浏览文件</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="weight" class="control-label">权重：</label>
            </div>
            <div class="col-md-8">
                <input type="text" class="form-control" id="weight" name="weight" />
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <label for="weight" class="control-label">资讯内容：</label>
            </div>
            <div class="col-md-8">
                <script id="editor" type="text/plain"
                        style="width: 100%; height: 400px;"></script>
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
<script>

    $(document).ready(function () {
        /*文件上传预览*/
        $('input[id=lefile]').change(function () {
            var objUrl = getObjectURL(this.files[0]);
            if (objUrl) {
                $("#img0").attr("src", objUrl);
            }
            $('#photoCover').val($(this).val());
        });
    });
    var ue = UE.getEditor('editor');
</script>
</body>
</html>
