<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set scope="application" value="${pageContext.request.contextPath}"
       var="root"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="home-data feeds col-md-10">
                <c:if test="${fn:length(postsList) == 0}">
                    <div class="row col-md-12">
                        Looks Like Your Feed Is Empty, Start Following More People to Stay Updated with Their Posts.
                    </div>
                </c:if>
                <c:forEach items="${postsList}" var="post">
                    <c:choose>
                        <c:when test="${post.type=='tutorial'}">
                            <c:set value="${PostsWithData[post]}"
                                   var="tutorial"/>
                            <div class="feed row">
                                <div class="user-pic col-md-2">
                                    <img src="/vimg/${post.user.profilePicture.id}" alt="..." class="img-circle">
                                </div>
                                <div class="col-md-10">
                                    <div class="row user-name">
                                        <a href="${root}/user/${post.user.id}">${post.user.first_name} ${post.user.last_name}</a>
                                        <span>added new tutorial.</span>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <hr>
                                            <a>
                                                <h4>${tutorial.title}</h4>
                                            </a>

                                            <p>
                                                    ${fn:substring(tutorial.text,0,500)}...<a
                                                    href="${root}/tutorial/${tutorial.id}">Continue</a>
                                            </p>
                                            <hr>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <a href="${root}/tutorial/${tutorial.id}/favorite" ><i
                                                class="fa fa-heart"></i> Favorite </a> -
                                        <a><i class="fa fa-share"></i> Share </a> -
                                        <a><i class="fa fa-comment"></i> Comment </a>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </c:when>
                        <c:when test="${post.type=='code'}">
                            <c:set value="${PostsWithData[post]}"
                                   var="code"/>
                            <div class="feed row">
                                <div class="user-pic col-md-2">
                                    <img src="/vimg/${post.user.profilePicture.id}" alt="..." class="img-circle">
                                </div>
                                <div class="col-md-10">
                                    <div class="row user-name">
                                        <a href="${root}/user/${post.user.id}">${post.user.first_name} ${post.user.last_name}</a>
                                        <span>published new code.</span>
                                    </div>
                                    <a class="post-title" href="${root}/code/${code.id}">
                                        <h4>${code.title}</h4>
                                    </a>

                                    <div class="code-preview">
                                        <pre><code class="${code.language}">${fn:escapeXml(code.code)}</code></pre>
                                    </div>
                                    <div class="row">
                                        <a onclick='swal({title: "Favorited!",  text: "You favorited this tutorial!",  timer: 5000, type: "success" });'><i
                                                class="fa fa-heart"></i> Favorite </a> -
                                        <a><i class="fa fa-share"></i> Share </a> -
                                        <a><i class="fa fa-comment"></i> Comment </a>
                                    </div>
                                </div>
                            </div>
                            <hr>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
            <div class="sidebar hide">
                <h4>Suggested Users:</h4>

                <p>
                    We can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n
                    wiWe can make thisf n divides a number that is g code run faster by noticing that we only need to
                    check
                    divisibility for values of i that are less or equal to the square root of n (call this m). If n
                    divides a
                    number that is greater than m then the result of that division will be some number less than m and
                    thus n wi

                </p>
            </div>
        </div>
    </div>
</div>