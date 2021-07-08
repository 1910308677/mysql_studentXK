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
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">角色列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>分配用户：${user_db.name}&nbsp;&nbsp;&nbsp;&nbsp;<font color="#b22222">${message}</font></span></div>
    <form action="<%=basePath%>roleController.do?method=fpRole" method="post">
        <input type="hidden" name="userIdSTR" value="${user_db.userId}">
    <ul class="forminfo">


        角色列表:

        <c:forEach items="${roleList_db}" var="role">
            <input name="roleIdSTR" type="radio" id="roleIdSTR" VALUE="${role.roleId}"
                   <c:if test="${role.roleId==XZRole.roleId}">checked="checked"</c:if>
            />${role.name}
        </c:forEach>



        <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

        <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="分配角色"/></li>
    </ul>
    </form>

</div>
</body>
</html>
