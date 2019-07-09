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
<form action="${path}/doLogin" method="post">
    <input type="hidden" name="uri" value="${param.uri}">
    <input name="username" type="text" placeholder="请输入用户名">
    <br>
    <input name="password" type="password" placeholder="请输入密码">
    <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
