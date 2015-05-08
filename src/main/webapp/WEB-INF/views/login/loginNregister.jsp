<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/j_spring_security_check" var="loginUrl" />




<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300italic,300' rel='stylesheet' type='text/css'>
        <style type="text/css">
        
body {
    background-color: #343434;
    background-image:url("octicons-bg.png");
    background-size:cover;
    font-family: 'Open Sans Condensed', sans-serif;
    color: #fff;
}
a{
    text-decoration:none;
}
.login-title {
    height: 50px;
    padding: 10px 10px;
    line-height: 20px;
    margin-left: 30px;
    margin-top: 10px;
}
    .title {
        text-align: center;
        letter-spacing: 0.03em;
        font-weight: 700;
        color: #e6e6e6;
        font-size: 40px;
        margin-bottom: 0px;
    }

.page-container {
    margin:30px;
}

h1 {
    font-size: 30px;
    font-weight: 700;
    text-shadow: 0 1px 4px rgba(0,0,0,.2);
}
h1.login{
    margin: 15px auto 0 900px;
    color:#e6e6e6;
}
.login-form{
    position: relative;
    width: 550px;
    margin: -90px auto 0 700px;
}
.login-form> input {
    width: 120px;
    height: 30px;
    margin-top: 25px;
    padding: 0 15px;
    background: #2d2d2d; /* browsers that don't support rgba */
    background: rgba(45,45,45,.15);
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #ffffff; /* browsers that don't support rgba */
    border: 1px solid rgba(255,255,255,.15);
    -moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    -webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}
.login-form>button{

    cursor: pointer;
    width: 90px;
    height: 30px;
    margin-top:25px;
    padding: 0;
    background: #ef4300;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #ff730e;
    -moz-box-shadow:
    0 15px 30px 0 rgba(255,255,255,.25) inset,
    0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
    0 15px 30px 0 rgba(255,255,255,.25) inset,
    0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
    0 15px 30px 0 rgba(255,255,255,.25) inset,
    0 2px 7px 0 rgba(0,0,0,.2);
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    font-weight: 700;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}
.login-h>a{
    margin-left:15px;
    font-size:10px;
}
hr{opacity:0.5;
}
.regstration-form{
    border: 2px solid #ffffff;
    border-radius: 10%;
    position:relative;
    width: 305px;
    padding: 20px;
    margin-top:100px;
    margin-left:100px;
    text-align: center;
}
input {
    width: 270px;
    height: 42px;
    margin-top: 25px;
    padding: 0 15px;
    background: #2d2d2d; /* browsers that don't support rgba */
    background: rgba(45,45,45,.15);
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #3d3d3d; /* browsers that don't support rgba */
    border: 1px solid rgba(255,255,255,.15);
    -moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    -webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

input:-moz-placeholder { color: #8b8b8b;
opacity:0.5;}
input:-ms-input-placeholder { color: #8b8b8b;
    opacity:0.5;}
input::-webkit-input-placeholder { color: #8b8b8b;
    opacity:0.5;}

input:focus {
    outline: none;
    -moz-box-shadow:
        0 2px 3px 0 rgba(0,0,0,.1) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 2px 3px 0 rgba(0,0,0,.1) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
        0 2px 3px 0 rgba(0,0,0,.1) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
}

button {
    cursor: pointer;
    width: 300px;
    height: 44px;
    margin-top:25px;
    padding: 0;
    background: #ef4300;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #ff730e;
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
        0 15px 30px 0 rgba(255,255,255,.25) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    font-weight: 700;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

button:hover {
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
}

button:active {
    -moz-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
        0 15px 30px 0 rgba(255,255,255,.15) inset,
        0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:        
        0 5px 8px 0 rgba(0,0,0,.1) inset,
        0 1px 4px 0 rgba(0,0,0,.1);

    border: 0px solid #ef4300;
}


        
        </style>
    </head>
    <body>
        <div class="nav-bar">
            <div class="login-title">
                <a class="login-title title" href="home.html">$[Social Code]</a>
            </div>
            <!---------- Login Form Start--------->
            <div class="login-h">
                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                </c:if>
                    <form class="login-form" id="form" action="${loginUrl}" method="POST">

                        <input type="text" name="email" class="email" placeholder="Email">
                        <input type="password" name="password" class="password" placeholder="Password">
                        <button type="submit" >Sign in</button>
                          <sec:csrfInput/>
                        
                    </form>
            </div>
            <hr>
        </div>
        <!----------Regstration Form Start--------->
        <div class="page-container">
            <div class="regstration-h">
                <div class="regstration-form">
                <form:form commandName="user" action="register" method="post">
                    <form:input path="first_name" type="text" name="firstname" class="username" placeholder="First name"/>
                    <form:errors path="first_name" />
                    <form:input path="last_name" type="text" name="lastname" class="email" placeholder="Last name"/>
                    <form:errors path="last_name" />
                    <form:input path="email" type="email" name="email" class="email" placeholder="Email"/>
                    <form:errors path="email" />
                    <form:input path="password" type="password" name="password" class="password" placeholder="Password"/>
                    <form:errors path="password" />
                    <button type="submit" value="Register">Regstration</button>
                </form:form>

                </div>
            </div>

        </div>
        <br>
        <br>
    <hr>
    </body>
</html>

