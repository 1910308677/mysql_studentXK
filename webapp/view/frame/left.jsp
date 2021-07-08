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
    <script language="JavaScript" src="<%=basePath%>static/js/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>通讯录</div>

<dl class="leftmenu">


    <c:forEach items="${firstLvMenuList }" var="firstLvMenu">
        <c:if test="${firstLvMenu.pId==1}">
            <dd><div class="title"><span><img src="<%=basePath%>static/images/leftico03.png" /></span>${firstLvMenu.name  }</div>
                <ul class="menuson">
                    <c:forEach items="${menuLvMap }" var="menuLvMap">
                        <c:if test="${firstLvMenu.permissionId == menuLvMap.key}">
                            <c:forEach items="${menuLvMap.value }" var="scdLvMenu">
                                <li><cite></cite><a href="<%=basePath%>${scdLvMenu.url }"  target="rightFrame">${scdLvMenu.name }</a><i></i></li>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </ul>
            </dd>
        </c:if>
    </c:forEach>

</dl>
</body>
</html>
