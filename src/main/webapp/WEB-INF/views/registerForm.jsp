<%--
  Created by IntelliJ IDEA.
  User: scarlett
  Date: 2018/10/15
  Time: 下午10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
<h1>Register</h1>
<!-- action属性不设置，表单会提交到它展现时相同的路径上：/spitter/register-->
<form method="post" action="/spitter/register" enctype="multipart/form-data">
First Name:<input type="text" name="firstName" /><br/>
Last Name:<input type="text" name="lastName" /><br/>
Username:<input type="text" name="username" /><br/>
Password:<input type="password" name="password" /><br/>
    <label>Profile Picture</label>
    <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif"/><br/>
    <input type="submit" value="Register" />

</form>
</body>
</html>
