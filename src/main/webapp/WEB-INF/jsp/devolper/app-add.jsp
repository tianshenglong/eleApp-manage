<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/11/8
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/devolper/addApp" method="post" enctype="multipart/form-data">
    <input type="hidden" name="CompanyCode" value="1" /> <%--${compId}--%>
    应用名称：<input type="text" name="AppName" id="AppName"/><br/>
    应用说明： <input type="text" name="AppExplain" id="AppExplain"/><br/>
    应用类型： <input type="radio" name="AppType" value="1"/>移动客户端<input type="radio" name="AppType" value="2"/>桌面客户端<input type="radio" name="AppType" value="3" />网站应用<br/>
    应用地址： <input type="text" name="AppAddress" id="AppAddress"/><br/>
    应用大小： <input type="text" name="AppSize" id="AppSize" /><br/>
    小图： <input type="file" name="smallImg" /><br/>
    大图： <input type="file" name="bigImg" /><br/>
    是否付费： <input type="radio" name="IsFree" value="1"/>是<input type="radio" name="IsFree" value="0"/>否<br/>
    价格： <input type="text" name="Price" id="Price"/><br/>
    <input type="checkbox" checked />我已阅读并接受大象开放平台开发者协议

    <button type="submit">创建应用</button>
    <button type="reset">重制</button>
</form>
</body>
</html>
