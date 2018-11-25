<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2018/10/20
  Time: 下午9:25
  To change this template use File | Settings | File Templates.
--%>
<!-- Spring提供的JSP标签库，用于渲染HTML表单标签-->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--span.error{--%>
    <%--color:red}--%>
    div.errors{
    color:red}
</head>
<body>
<!-- commandName="spitter"和模型中的spitter一一对应，<sf:>所渲染的标签中，会存在value -->
<sf:form method="post" commandName="spitter">
    <%--<sf:errors path="*" element="div" cssClass="errors" />--%>
    First Name:<sf:input path="firstName"/>
    <%--<sf:errors path="firstName" cssClass="error"/> <br/><!-- firstName有错误的话，显示错误信息-->--%>
    Last Name:<sf:input path="lastName"/><br/>
    Email:<sf:input path="email"/><br/>
    Username:<sf:input path="username"/><br/>
    Password:<sf:password path="password"/><br/>
    <input type="submit" value="Register">
</sf:form>
</body>
</html>
