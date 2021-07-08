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
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <link href="<%=basePath%>static/css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="<%=basePath%>static/js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>


</head>

<body style="background:url(<%=basePath%>static/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="<%=basePath%>static/main.html" target="_parent"><img src="<%=basePath%>static/images/logo.png" title="系统首页" /></a>
</div>

<ul class="nav">
    <li><a href="<%=basePath%>static/default.html" target="rightFrame" class="selected"><img src="<%=basePath%>static/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="<%=basePath%>static/imgtable.html" target="rightFrame"><img src="<%=basePath%>static/images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
    <li><a href="<%=basePath%>static/imglist.html"  target="rightFrame"><img src="<%=basePath%>static/images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
    <li><a href="<%=basePath%>static/tools.html"  target="rightFrame"><img src="<%=basePath%>static/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
    <li><a href="<%=basePath%>static/computer.html" target="rightFrame"><img src="<%=basePath%>static/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
    <li><a href="<%=basePath%>static/tab.html"  target="rightFrame"><img src="<%=basePath%>static/images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
</ul>

<div class="topright">
    <ul>
        <li><span><img src="<%=basePath%>static/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
        <li><a href="<%=basePath%>login.jsp" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span><font color="#f0ffff"> ${USER.name}</font></span>
        <i>消息</i>
        <b>0</b>
    </div>

</div>
</body>
</html>
