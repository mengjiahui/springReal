<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2018/10/15
  Time: 下午6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="spittle.id"/>">
            <div class="spittleMessage">
                <c:out value="${spittle.message}"/>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                <span class="spittleLocation">
                    {<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/>}
                </span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
