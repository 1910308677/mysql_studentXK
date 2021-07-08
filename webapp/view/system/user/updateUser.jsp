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
        <li><a href="#">用户列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="<%=basePath%>userController.do?method=update" method="post">
        <input type="hidden" name="userIdSTR" value="${user_db.userId}">
        <ul class="forminfo">修改
            <li><label>姓名</label><input name="name" type="text" class="dfinput"  value="${user_db.name}"/><i>标题不能超过30个字符</i></li>
            <li><label>性别</label><input name="sex" type="text" class="dfinput"  value="${user_db.sex}"/><i>标题不能超过30个字符</i></li>
            <li><label>年龄</label><input name="age" type="text" class="dfinput"  value="${user_db.age}"/><i>年龄不能超过30个字符</i></li>
            <li><label>地址</label><input name="adress" type="text" class="dfinput"  value="${user_db.adress}"/><i>地址不能超过30个字符</i></li>
            <li><label>电话</label><input name="tel" type="text" class="dfinput"  value="${user_db.tel}"/><i>电话不能超过30个字符</i></li>
            <li><label>QQ</label><input name="QQ" type="text" class="dfinput"  value="${user_db.QQ}"/><i>QQ不能超过30个字符</i></li>
            <li><label>微信</label><input name="wechat" type="text" class="dfinput"  value="${user_db.wechat}"/><i>微信不能超过30个字符</i></li>
            <li><label>邮箱</label><input name="email" type="text" class="dfinput"  value="${user_db.email}"/><i>邮箱不能超过30个字符</i></li>
            <li><label>用户名</label><input name="username" type="text" class="dfinput"  value="${user_db.username}"/><i>用户名不能超过30个字符</i></li>
            <li><label>密码</label><input name="password" type="text" class="dfinput"  value="${user_db.password}"/><i>密码不能超过30个字符</i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改"/></li>
        </ul>
    </form>

</div>
</body>
</html>
