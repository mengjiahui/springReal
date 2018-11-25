<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2018/10/20
  Time: 下午7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.username}"/><br/>
<c:out value="${spitter.firstName}"/><br/>
<c:out value="${spitter.lastName}"/><br/>
</body>
</html>
