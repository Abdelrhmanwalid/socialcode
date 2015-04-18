<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Abdelrhman
  Date: 18/4/2015
  Time: 5:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Or Register</title>
</head>
<body>
<c:url value="/j_spring_security_check" var="loginUrl" />
<h2>Login</h2>
<form id="form" action="${loginUrl}" method="POST">

  <c:if test="${not empty param.err}">
    <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
  </c:if>
  <c:if test="${not empty param.out}">
    <div>You've logged out successfully.</div>
  </c:if>
  <c:if test="${not empty param.time}">
    <div>You've been logged out due to inactivity.</div>
  </c:if>

  Username:<br>
  <input type="text" name="email" value=""/><br><br>
  Password:<br>
  <input type="password" name="password" value=""/>

  <input value="Login" name="submit" type="submit"/>
  <sec:csrfInput/>

</form>
<h3>Or Register </h3>
<form:form commandName="user" action="register" method="post">
  email: <form:input path="email"/>
  password <form:input path="password" type="password"/>
  <input type="submit" value="Register">
</form:form>
</body>
</html>
