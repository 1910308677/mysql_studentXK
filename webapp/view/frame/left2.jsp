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
            //导航切换
            $(".menuson li").click(function(){
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if($ul.is(':visible')){
                    $(this).next('ul').slideUp();
                }else{
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="<%=basePath%>static/images/leftico01.png" /></span>系统管理
        </div>
        <ul class="menuson">
            <li class="active"><cite></cite><a href="<%=basePath%>userController.do?method=list" target="rightFrame">用户管理</a><i></i></li>
            <li><cite></cite><a href="<%=basePath%>roleController.do?method=list" target="rightFrame">角色管理</a><i></i></li>
            <li><cite></cite><a href="<%=basePath%>permissionController.do?method=list" target="rightFrame">权限管理</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="<%=basePath%>static/images/leftico01.png" /></span>邮件管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="#" target="rightFrame">写邮件</a><i></i></li>
            <li><cite></cite><a href="#" target="rightFrame">收件箱</a><i></i></li>
            <li><cite></cite><a href="#" target="rightFrame">发件箱</a><i></i></li>
            <li><cite></cite><a href="#" target="rightFrame">草稿箱</a><i></i></li>
            <li><cite></cite><a href="#" target="rightFrame">垃圾箱</a><i></i></li>
        </ul>
    </dd>
</dl>
</body>
</html>
