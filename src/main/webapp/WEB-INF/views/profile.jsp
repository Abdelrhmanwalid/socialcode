<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set scope="application" value="${pageContext.request.contextPath}"
       var="root"/>
<div class="container">
    <div class="profile-header">
        <div class="top-section">
            <img class="img-circle" src="img/pp.jpg" alt="Profile Picture"/>
        </div>
        <div class="user-info">
            <div class="row title">
                <div class="user-name">
                    <a href="profile">${user.first_name} ${user.last_name}</a>
                </div>
                <c:if test="${not isCurrent}">
                    <c:choose>
                        <c:when test="${user.followers.contains(currentUser)}">
                            <a href="${root}/user/${user.id}/unfollow" class="follow btn btn-success"
                               onMouseout="this.textContent='Following';this.classList.remove('btn-warning') ;"
                               onMouseover="this.textContent='Unfollow';this.classList.add('btn-warning') ;">Following</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${root}/user/${user.id}/follow" class="follow btn btn-default">Follow</a>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
            <div class="user-about">
                Bio goes here ....
            </div>
        </div>
        <div class="menu row">
            <div class="menu-item col-md-4">
                <small class="menu-label row">
                    Codes
                </small>
                ${fn:length(codes)}
            </div>
            <div class="menu-item col-md-4">
                <small class="menu-label row">
                    Tutorials
                </small>
                ${fn:length(tutorials)}
            </div>
            <div class="menu-item col-md-4">
                <small class="menu-label row">
                    Followers
                </small>
                ${fn:length(user.followers)}
            </div>
        </div>
    </div>
    <hr>
    <div class="profile-container">
        <c:forEach items="${postsList}" var="post">
            <c:if test="${post.type=='tutorial'}">
                <c:set value="${PostsWithData[post]}"
                       var="tutorial"/>
                <div class="post row">
                    <div class="post-header row">
                        <div class="user-pic col-md-1">
                            <img src="img/pp.jpg" alt="..." class="img-circle">
                        </div>
                        <div class="user-info col-md-3">
                            <div class="user-name">
                                <a href="${root}/user/${post.user.id}">
                                    ${post.user.first_name} ${post.user.last_name}
                                </a>
                            </div>
                            <div class="post-time">
                                <c:set var="time" value="${tutorial.created_at}"/>
                                <fmt:formatDate type="both"
                                                value="${time}"/>
                            </div>
                        </div>
                    </div>
                    <div class="post-container row">
                        <div class="col-md-12">
                            <a class="post-title" href="${root}/tutorial/${tutorial.id}">
                                <h4>${tutorial.title}</h4>
                            </a>

                            <p>
                                    ${fn:substring(tutorial.text,0,500)}
                            </p>
                        </div>

                    </div>
                    <div class="post-footer">
                        <div class="row">
                            <a onclick='swal({title: "Favorited!",  text: "You favorited this tutorial!",  timer: 5000, type: "success" });'><i
                                    class="fa fa-heart"></i> Favorite </a> -
                            <a><i class="fa fa-share"></i> Share </a> -
                            <a><i class="fa fa-comment"></i> Comment </a>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${post.type=='code'}">
                <c:set value="${PostsWithData[post]}"
                       var="code"/>
                <div class="post row">
                    <div class="post-header row">
                        <div class="user-pic col-md-1">
                            <img src="img/pp.jpg" alt="..." class="img-circle">
                        </div>
                        <div class="user-info col-md-3">

                            <div class="user-name">
                                <a href="${root}/user/${post.user.id}">
                                    ${post.user.first_name} ${post.user.last_name}
                            </a>
                            </div>
                            <div class="post-time">
                                <c:set var="time" value="${tutorial.created_at}"/>
                                <fmt:formatDate type="both"
                                                value="${time}"/>
                            </div>
                        </div>
                    </div>
                    <div class="post-container row">
                        <div class="col-md-12">
                            <a class="post-title" href="${root}/code/${code.id}">
                                <h4>${code.title}</h4>
                            </a>

                            <div class="code-preview">
                                <pre><code class="${code.language}">${fn:escapeXml(code.code)}</code></pre>
                            </div>
                        </div>

                    </div>
                    <div class="post-footer">
                        <div class="row">
                            <a onclick='swal({title: "Favorited!",  text: "You favorited this tutorial!",  timer: 5000, type: "success" });'><i
                                    class="fa fa-heart"></i> Favorite </a> -
                            <a><i class="fa fa-share"></i> Share </a> -
                            <a><i class="fa fa-comment"></i> Comment </a>
                        </div>
                    </div>
                </div>
            </c:if>
            <hr>

        </c:forEach>


    </div>
</div>

http://localhost:8888/socialcode/user/1/follow
for i in $( ls ); do echo item: $i done