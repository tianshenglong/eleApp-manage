<%--
  Created by IntelliJ IDEA.
  User: 胜龙
  Date: 2016/10/20
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="../../static/ztreeV3/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row" style="overflow:auto; height: 300px">
            <div id="roleResourcesTree" class="ztree"></div>
        </div>
        <div class="hr-line-dashed"></div>
        <button class="btn btn-default" onClick="saveRoleResources();" type="submit">确定</button>
        <button onClick="layer_close();" class="btn btn-primary" type="button">返回</button>


    </div>
</div>

<script src="../../static/js/jquery-1.8.3.min.js"></script>
<script src="../../static/layer/layer.js"></script>
<script src="../../static/datatables/js/jquery.dataTables.js"></script>
<script src="../../static/datatables/js/dataTables.bootstrap.js"></script>
<script src="../../static/js/public.js"></script>
<script src="../../static/ztreeV3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">

    var setting = {
        async: {
            enable: true,
            url: "/role/getRoleResources",
            autoParam: ["id", "name=n", "level=lv", "type"],
            otherParam: {"roleId": getQueryString("roleId")},
            dataFilter: filter
        },
        check: {
            enable: true,
            chkStyle: "checkbox",
            chkboxType: {"Y": "p", "N": "s"}
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    /*根据name获取URL参数*/
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }


    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i = 0, l = childNodes.length; i < l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }

    $(document).ready(function () {
        $.fn.zTree.init($("#roleResourcesTree"), setting);
    });


    /*根据name获取URL参数*/
    function saveRoleResources() {
        var treeObj=$.fn.zTree.getZTreeObj("roleResourcesTree");
        var checkedObj = treeObj.getCheckedNodes(true);
        if(checkedObj.length>0){
            var level1 = [];
            var level2 = [];
            var level3 = [];
            for (var i=0;i<checkedObj.length;i++)
            {
                if(checkedObj[i].level == 0){
                    level1.push(checkedObj[i].id);
                }else if(checkedObj[i].level == 1){
                    level2.push(checkedObj[i].id);
                }else if(checkedObj[i].level == 2){
                    var button = {};
                    button.id=checkedObj[i].id;
                    button.name=checkedObj[i].name;
                    level3.push(button);
                }
            }

            $.ajax({
                dataType: 'json',
                type: 'POST',
                cache: false,
                url: '/role/editRole',
                data: {
                    roleId: getQueryString("roleId"),
                    level1: JSON.stringify(level1),
                    level2: JSON.stringify(level2),
                    level3: JSON.stringify(level3),
                },
                async: false,
                success: function (data) {
                    layer.msg('保存成功');
//                    layer.close(index);
                },
                error: function (data) {
                    layer.close(index);
                    layer.msg('操作失败');
                },
            });
        }else{
            layer.msg('权限设置不能为空!');
        }
    }


</script>
</body>
</html>
