<%--
  Created by IntelliJ IDEA.
  User: zhuqizhu
  Date: 2021/1/13
  Time: 16:11
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
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">
        <form action="<%=basePath%>selectController.do?method=select" method="post">
            <ul class="toolbar">
                <li><label>请输入用户Id</label><input name="userId" type="text" class="dfinput"/></li>
                <li><label></label><input \ name="" type="submit" class="btn" value="查询"></li>
            </ul>
        </form>


        <ul class="toolbar1">
            <li><span><img src="<%=basePath%>static/images/t05.png"/></span>设置</li>
        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>表ID</th>
            <th>用户ID<i class="sort"><img src="<%=basePath%>static/images/px.gif"/></i></th>
            <th>课程Id</th>
            <th>课程名称</th>
            <th>任课教师</th>
            <th>课程时间</th>
            <th>学分</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${curriculumList_db}" var="curriculum">
            <tr>
            <tr>
                <td><input name="" type="checkbox" value=""/></td>
                <td>${curriculum.curriculumId}</td>
                <td>${curriculum.userId}</td>
                <td>${curriculum.courseId}</td>
                <td>${curriculum.curriculum}</td>
                <td>${curriculum.teacher}</td>
                <td>${curriculum.time}</td>
                <td>${curriculum.credit}</td>

            </tr>

        </c:forEach>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">1</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>
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
            <span><img src="images/ticon.png"/></span>
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