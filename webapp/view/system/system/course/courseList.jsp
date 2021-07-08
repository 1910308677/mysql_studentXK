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
    <script type="text/javascript" src="<%=basePath%>static/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">课程表</a></li>
        <li><a href="#">课程内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li class="click"><span><img src="<%=basePath%>static/images/t01.png"/></span><a
                    href="<%=basePath%>view/system/course/addCourse.jsp">添加</a></li>
            <li class="click"><span><img src="<%=basePath%>static/images/t02.png"/></span><a
                    href="<%=basePath%>view/system/course/updateCourse.jsp">修改</a></li>
            <li><span><img src="<%=basePath%>static/images/t03.png"/></span>删除</li>
            <li><span><img src="<%=basePath%>static/images/t04.png"/></span>统计</li>
        </ul>


        <ul class="toolbar1">
            <li><span><img src="<%=basePath%>static/images/t05.png"/></span>设置</li>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>课程号<i class="sort"><img src="<%=basePath%>static/images/px.gif"/></i></th>
            <th>课程名</th>
            <th>任课老师</th>
            <th>上课时间</th>
            <th>学分</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courseList_db}" var="course">
            <tr>
            <tr>
                <td><input name="" type="checkbox" value=""/></td>
                <td>${course.courseId}</td>
                <td>${course.curriculum}</td>
                <td>${course.teacher}</td>
                <td>${course.time}</td>
                <td>${course.credit}</td>
                <td>
                    <a href="<%=basePath%>courseController.do?method=delete&courseIdSTR=${course.courseId}">删除</a>&nbsp;&nbsp;
                    <a href="<%=basePath%>courseController.do?method=updateUI&courseIdSTR=${course.courseId}">修改</a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">12</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="<%=basePath%>static/images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>