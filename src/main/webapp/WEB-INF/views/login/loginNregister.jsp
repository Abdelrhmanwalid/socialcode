<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url value="/j_spring_security_check" var="loginUrl"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Social Code</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="social code where all the codes come together">
    <meta name="author" content="Mohamed Kamal">
    <link rel="shortcut icon" href="favicon.ico">
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,300italic,400italic' rel='stylesheet'
          type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <!-- Global CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Theme CSS -->
    <link id="theme-style" rel="stylesheet" href="/assets/css/styles.css">


</head>

<body>
<!-- ******HEADER****** -->
<header class="header row">
    <div class="container">
        <div style="width:400px; margin:0 auto;">
            <h1 class="name" style=" margin:0 auto;">$[SocialCode]</h1>
            <span class="desc">*Alpha version</span>
        </div>
    </div>
    <!--//container-->
</header>
<!--//header-->

<div class="container site-login">
    <div class="row">
        <div id="page-main">
            <div class="col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1">
                <div class="row">

                    <div class="col-md-6">
                        <section id="account-sign-in" class="account-block row">
                            <header><h2>Have an Account?</h2></header>


                            <form class="clearfix" id="form" action="${loginUrl}" method="POST" role="form">

                                <div class="form-group">
                                    <label for="email">Email address</label>
                                    <input name="email" type="email" class="form-control" id="email" placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                                </div>
                                <sec:csrfInput/>
                                <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                    <p  style="color:red;" >Wrong Email/Password.</p>
                                </c:if>
                                <button type="submit" class="btn pull-right">Sign In</button>
                            </form>

                        </section>
                        <!-- /#account-block -->
                    </div>
                    <!-- /.col-md-6 -->
                    <div class="col-md-6">
                        <section id="account-sign-in" class="account-block row">
                            <header><h2>Registration</h2></header>


                            <form:form commandName="user" action="register" method="post" class="clearfix">

                                <div class="form-group">
                                    <label for="email">First name</label>
                                    <form:input path="first_name" type="text" name="firstname" class="username"
                                                placeholder="First name"/>
                                    <form:errors path="first_name" style="color:red;" /></div>
                                <div class="form-group">
                                    <label for="email">last name</label>
                                    <form:input path="last_name" type="text" name="lastname" class="email"
                                                placeholder="Last name"/>
                                    <form:errors path="last_name" style="color:red;" /></div>
                                <div class="form-group">
                                    <label for="email">Email address</label>
                                    <form:input path="email" type="email" name="email" class="email"
                                                placeholder="Email"/>
                                    <form:errors path="email" style="color:red;" /></div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <form:input path="password" type="password" name="password" class="password"
                                                placeholder="Password"/>
                                    <form:errors path="password" style="color:red;" /></div>
                                <button type="submit" class="btn pull-right">Create account</button>
                            </form:form>

                        </section>
                        <!-- /#account-block -->
                    </div>
                    <!-- /.col-md-6 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.col-md-10 -->
        </div>
        <!-- /#page-main -->


    </div>
    <!--//row-->
</div>
<!--//masonry-->

<!-- ******FOOTER****** -->
<footer class="footer">
    <div class="container text-center">
        <small class="copyright" style="color: #ffffff">Developed for you.</small>
    </div>
    <!--//container-->
</footer>
<!--//footer-->

<!-- Javascript -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</body>
</html>

