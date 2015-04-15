<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="javax.servlet.jsp.PageContext" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring Security Form Login Tutorial</title>
    </head>

    <body>
        <H1>Login (╯°□°)╯︵ ┻━┻</H1>
      
      <form name='f' action='/socialcode/check' method='POST'>
 <table>
    <tr><td>User:</td><td><input type='text' name='email' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
   

  </table>
</form>
          </body>
</html>