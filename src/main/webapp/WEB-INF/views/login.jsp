<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring Security Form Login Tutorial</title>
    </head>
     
    <body>
        <H1>Login</H1>
        <form id="form" action="<c:url value='/login.jsp'/>" method="POST">
         
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
            <input type="email" name="email" value=""/><br><br>
            Password:<br>
            <input type="password" name="password" value=""/>
             
            <input value="Login" name="submit" type="submit"/>
        </form>
    </body>
</html>