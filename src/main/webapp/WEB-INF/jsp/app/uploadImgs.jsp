<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/12/23
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>上传应用图片</title>
  <!-- 引用控制层插件样式 -->
  <link rel="stylesheet" href="../static/zyupload/control/css/zyUpload.css" type="text/css">
  <script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
  <!-- 引用核心层插件 -->
  <script src="../static/zyupload/core/zyFile.js"></script>
  <!-- 引用控制层插件 -->
  <script src="../static/zyupload/control/js/zyUpload.js"></script>
  <!-- 引用初始化JS -->
  <script src="../static/zyupload/core/appimages.js"></script>
  <script src="../../static/js/public.js"></script>

  <script type="text/javascript">
    //我这里使用的是springmvc
    var pathurl="/app/uploadAppImgs?appId=${appId}";
  </script>
</head>
<body>
<button onClick="layer_close();">关闭页面</button>
<div id="demo" class="demo"></div>
</body>
</html>