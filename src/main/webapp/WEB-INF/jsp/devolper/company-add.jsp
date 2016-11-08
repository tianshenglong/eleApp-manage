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
    <title></title>
</head>
<body>
<form action="/devolper/joinUp" method="post">
    开发者名称：<input type="text" name="compName" id="compName"/><br/>
    所在地区： <select name="province" id="province">
    <option value="1">北京</option>
    <option value="2">上海</option>
</select><select name="city" id="city">
    <option value="2">北京</option>
    <option value="3">上海</option>
</select><br/>
    详细地址： <input type="text" name="address" id="address"/><br/>
    邮编： <input type="text" name="postCode" id="postCode"/><br/>
    企业邮箱： <input type="text" name="compEmail" id="compEmail"/><br/>
    企业电话： <input type="text" name="compMobile" id="compMobile"/><br/>
    聊天工具： <select name="chatTool" id="chatTool">
    <option value="1">qq</option>
    <option value="2">msn</option>
</select><input type="text" name="chatNum" id="chatNum"/><br/>
    网站： <input type="text" name="webSite" id="webSite"/><br/>
    紧急联系人姓名： <input type="text" name="urgentMan" id="urgentMan"/><br/>
    紧急联系人电话： <input type="text" name="urgentMobile" id="urgentMobile"/><br/>

    <button type="submit">提交</button>
    <button type="reset">重制</button>

</form>
</body>
</html>
