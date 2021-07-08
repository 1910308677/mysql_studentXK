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
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>课程信息</span></div>
    <form action="<%=basePath%>courseController.do?method=update" method="post">
        <input type="hidden" name="courseIdSTR" value="${course_db.courseId}">
        <ul class="forminfo">修改
            <li><label>课程名</label><input name="curriculum" type="text" class="dfinput"  value="${course_db.curriculum}"/><i>标题不能超过30个字符</i></li>
            <li><label>任课老师</label><input name="teacher" type="text" class="dfinput"  value="${course_db.teacher}"/><i>标题不能超过30个字符</i></li>
            <li><label>上课时间</label><input name="time" type="text" class="dfinput"  value="${course_db.time}"/><i>标题不能超过30个字符</i></li>
            <li><label>学分</label><input name="credit" type="text" class="dfinput"  value="${course_db.credit}"/><i>标题不能超过30个字符</i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改"/></li>
        </ul>
    </form>

</div>
</body>
</html>
