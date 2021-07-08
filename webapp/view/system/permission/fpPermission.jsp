<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/5
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <link href="<%=basePath%>static/css/style.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>static/js/jquery.js"></script>
    <%--    <script src="<%=basePath%>static/js/pintuer.js"></script>--%>
    <script>
        $(function() {
            var array = new Array();
            <c:forEach items="${ids}" var="item" >
            array.push("${item}"); //对象，加引号
            </c:forEach>
            for (var i = 0; i < array.length; i++) {
                $("#" + array[i]).attr("checked", "checked");
            }
        })
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>分配用户：${role_db.name}&nbsp;&nbsp;&nbsp;&nbsp;<font color="#b22222">${message}</font></span></div>
    <form action="<%=basePath%>permissionController.do?method=fpPermission" method="post">
        <input type="hidden" name="roleIdSTR" value="${role_db.roleId}">
        <ul class="forminfo">


            权限列表:<br>
            <c:forEach items="${permissionList_db}" var="permission">
                <input name="permissionIdSTRs" type="checkbox" id="${permission.permissionId}" VALUE="${permission.permissionId}"/>${permission.name}<br>
            </c:forEach>
            <p>
                &nbsp;
            <p>
                &nbsp;
            <p>



            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="分配权限"/></li>
        </ul>
    </form>

</div>
</body>
</html>
