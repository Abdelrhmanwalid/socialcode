<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form:form commandName="user">
    email: <form:input path="email"/>
    password <form:input path="password" type="password"/>
    <input type="submit" value="Register">
</form:form>
</body>
</html>
