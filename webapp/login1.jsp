<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/5
  Time: 15:12
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
    <link href="<%=basePath%>static/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="<%=basePath%>static/js/jquery.js"></script>
    <script src="<%=basePath%>static/js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(static/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>
<form action="<%=basePath%>loginController.do?method=login" method="post">
    <div class="loginbody">

        <span class="systemlogo"></span>
        <div class="loginbox">

            <ul>
                <font color="#dc143c"> ${message}</font>
                <li><input name="username" type="text" class="loginuser" value="admin"
                           onclick="JavaScript:this.value=''"/></li>
                <li><input name="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"/><label><input name="" type="checkbox"
                                                                                            value="" checked="checked"/>记住密码</label><label><a
                        href="#">忘记密码？</a></label></li>
            </ul>

        </div>

    </div>
</form>

</body>
</html>
