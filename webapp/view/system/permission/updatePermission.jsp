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
        <li><a href="#">权限表单</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="<%=basePath%>permissionController.do?method=update" method="post">
        <input type="hidden" name="permissionIdSTR" value="${permission_db.permissionId}">
        <ul class="forminfo">


            <li><label>父级:</label>
                <select id="pIdSTR" name="pIdSTR">
                    <option>------请选择父级节点------</option>
                    <c:forEach items="${permissionList_db}" var="permission">
<%--                        <c:if test="${permission.permissionId == permission_db.pId }">--%>
                        <c:if test="${permission.permissionId == permission_db_xz.permissionId }">
                            <option value="${permission.permissionId}" selected="selected">${permission.name}</option>
                        </c:if>
                        <c:if test="${permission.permissionId != permission_db.pId }">
                            <option value="${permission.permissionId}">${permission.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <i>请选择父级节点</i>
            </li>


            <li><label>名称</label><input name="name" type="text" class="dfinput" value="${permission_db.name}"/><i>名称不能超过10个字符</i>
            </li>
            <li><label>类型</label><input name="type" type="text" class="dfinput" value="${permission_db.type}"/><i>类型不能超过10个字符</i>
            </li>
            <li><label>url</label><input name="url" type="text" class="dfinput" value="${permission_db.url}"/><i>url不能超过30个字符</i>
            </li>
            <li><label>权限码</label><input name="percode" type="text" class="dfinput"
                                         value="${permission_db.percode}"/><i>权限码不能超过8个字符</i></li>
            <li><label>状态</label><input name="state" type="text" class="dfinput" value="${permission_db.state}"/><i>状态不能超过2个字符</i>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="增加"/></li>
        </ul>
    </form>

</div>
</body>
</html>
