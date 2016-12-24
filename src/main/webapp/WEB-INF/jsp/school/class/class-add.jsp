<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/19
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
          <h5>班级信息</h5>
        </div>
        <div class="ibox-content">
          <input type="hidden" id="closeOrnot" name="closeOrnot" value="${closeOrnot}"/>
          <form  action="/graClass/addClass" method="post" class="form form-horizontal" id="form-user">
            <div class="form-group">
              <label class="col-sm-3 control-label">班级名称：</label>
              <div class="col-sm-8">
                <input id="name" name="name" class="form-control" type="text">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">所属学校：</label>
              <div class="col-sm-8">
                <select id="schoolId" name="schoolId" class="form-control">
                  <option value="">请选择</option>
                  <c:forEach var="sc" items="${allSchool}">
                    <option value="${sc.id}">${sc.name}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">所属年级：</label>
              <div class="col-sm-8">
                <select id="gradeId" name="gradeId" class="form-control">
                </select>
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
<script src="../../static/js/public.js"></script>
<script src="../../static/js/jquery.chained.remote.min.js"></script>
<script>

  $(document).ready(function () {
    $("#gradeId").remoteChained({
      parents: "#schoolId",
      url: "/public/getGradeList",
      loading: "loading...",
      clear: true
    });
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