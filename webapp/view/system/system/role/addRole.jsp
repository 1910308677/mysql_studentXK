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
    <link href="<%=basePath%>static/css/style.css" rel="stylesheet" type="text/css"/>
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

    <div class="formtitle"><span>基本信息</span></div>
    <form action="<%=basePath%>roleController.do?method=add" method="post">
        <input type="hidden" name="roleIdSTR" value="${role_db.userId}">
        <ul class="forminfo">增加
            <li><label>名称</label><input name="name" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
            <li><label>状态</label><input name="state" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="增加"/></li>
        </ul>
    </form>
</div>
</body>
</html>
