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
                    <h5>学生信息</h5>
                </div>
                <div class="ibox-content">
                    <input type="hidden" id="closeOrnot" name="closeOrnot" value="${closeOrnot}"/>
                    <form  action="/student/addStudent" method="post" class="form form-horizontal" id="form-news" enctype="multipart/form-data">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">姓名：</label>
                            <div class="col-sm-8">
                                <input id="name" name="name" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">身份证号：</label>
                            <div class="col-sm-8">
                                <input id="sertId" name="sertId" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别：</label>
                            <div class="col-sm-8">
                                <input type="radio" name="sex" id="male" value="1" >男<input type="radio" name="sex" id="famale" value="2" >女
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">生日：</label>
                            <div class="col-sm-8">
                                <input type="text" name="birthDay" class="form-control"
                                       onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                       id="birthDay" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码：</label>
                            <div class="col-sm-8">
                                <input type="password" name="passWord" class="form-control" id="passWord" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">校验密码：</label>
                            <div class="col-sm-8">
                                <input type="text" name="validatePwd" class="form-control" id="validatePwd" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">头像：</label>
                            <div class="col-sm-8">
                                <input type="file" id="imgUrl" name="imgUrlFile" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">父母手机：</label>
                            <div class="col-sm-8">
                                <input id="parentMobile" name="parentMobile" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱：</label>
                            <div class="col-sm-8">
                                <input id="email" name="email" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                                <button class="btn btn-primary" type="button" onClick="layer_close();">取消</button>
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
<script src="../../static/My97DatePicker/WdatePicker.js"></script>
<script src="../../static/js/public.js"></script>
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
    });

    function pageOnload(){
        var closeOrNot =$("#closeOrnot").val();
        if(closeOrNot == 1){
            layer.msg("操作成功");
            layer_close();
        }
    }
</script>
</body>
</html>
