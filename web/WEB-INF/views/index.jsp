<%--
  Created by IntelliJ IDEA.
  User: 13646
  Date: 2019/7/9
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>首页</h1>
<c:if test="${sessionScope.username == null}">
    <h2><a href="${path}/login">登录</a></h2>
</c:if>
<c:if test="${sessionScope.username != null}">
    <h2>欢迎：${sessionScope.username}<a href="${path}/logout">退出登录</a></h2>
</c:if>

<ul>
    <li><a href="${path}/cart">购物车</a></li>
    <li><a href="${path}/product">商品</a></li>
    <li><a href="${path}/order">订单</a></li>
</ul>
</body>
</html>
