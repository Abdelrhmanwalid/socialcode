<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set scope="application" value="${pageContext.request.contextPath}"
       var="root"/>
<div class="container">
    <div class="profile-header">
        <div class="top-section">
            <img class="img-circle" src="/vimg/${user.profilePicture.id}" alt="Profile Picture"/>
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
                ${user.biography}
            </div>
        </div>
        <div class="menu row">
            <div class="menu-item col-md-3">
                <small class="menu-label row">
                    Codes
                </small>
                ${fn:length(codes)}
            </div>
            <div class="menu-item col-md-3">
                <small class="menu-label row">
                    Tutorials
                </small>
                ${fn:length(tutorials)}
            </div>
            <div class="menu-item col-md-3">
                <small class="menu-label row">
                    Followers
                </small>
                <a class="" data-toggle="modal" data-target="#followerModel">
                    ${fn:length(user.followers)}
                </a>
            </div>
            <div class="menu-item col-md-3">
                <small class="menu-label row">
                    Favorited
                </small>
                <a class="" data-toggle="modal" data-target="#favModel">
                    34
                </a>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="followerModel" tabindex="-1" role="dialog" aria-labelledby="followerModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="followerModalLabel">Followers</h4>
                    </div>
                    <div class="modal-body">


                        <div class="row">
                            <div class="col-md-1">
                                <a href="#">
                                    <img src="img/pp.jpg" style="height: 40px;width: 40px;" alt="..."
                                         class="img-circle">
                                </a>
                            </div>
                            <div class="col-md-8">
                                <h4 class="">Media heading</h4>
                            </div>
                        </div>
                        <hr/>
                        <div class="row">
                            <div class="col-md-1">
                                <a href="#">
                                    <img src="img/pp.jpg" style="height: 40px;width: 40px;" alt="..."
                                         class="img-circle">

                                </a>
                            </div>
                            <div class="col-md-8">
                                <h4 class="">Media heading</h4>
                            </div>
                        </div>
                        <hr/>
                        <div class="row">
                            <div class="col-md-1">
                                <a href="#">
                                    <img src="img/pp.jpg" style="height: 40px;width: 40px;" alt="..."
                                         class="img-circle">

                                </a>
                            </div>
                            <div class="col-md-8">
                                <h4 class="">Media heading</h4>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Save changes</button>
                    </div> -->
                </div>
            </div>
        </div>

        <div class="modal fade" id="favModel" tabindex="-1" role="dialog" aria-labelledby="favModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="favModalLabel">Favorited Posts</h4>
                    </div>
                    <div class="modal-body" style="margin:10px;">

                        <div class="row">
                            <div class="col-md-12">
                                <h4><a href="">How to setup get ?</a></h4>
                            </div>
                            <div class="cont col-md-12"> We can make thisf n divides a number that is g code run faster
                                by noticing that we only need to check divisibility for values of i that are less or
                                equal to the square root of n (call this m). If n divides a number that is greater than
                                m then the result of that division will be some number less than m and thus n will also
                                divide a number less or equal to....Continue
                            </div>
                        </div>

                        <hr/>
                        <div class="row">
                            <div class="col-md-12">
                                <h4><a href="">How to setup get ?</a></h4>
                            </div>
                            <div class="cont col-md-12"> We can make thisf n divides a number that is g code run faster
                                by noticing that we only need to check divisibility for values of i that are less or
                                equal to the square root of n (call this m). If n divides a number that is greater than
                                m then the result of that division will be some number less than m and thus n will also
                                divide a number less or equal to....Continue
                            </div>
                        </div>

                    </div>
                    <!-- <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Save changes</button>
                    </div> -->
                </div>
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
                            <img src="/vimg/${user.profilePicture.id}" alt="" class="img-circle">
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
                            <c:choose>
                                <c:when test="${post.favoritedBy.contains(currentUser)}">
                                    <a href="${root}/post/${post.id}/favorite"><i
                                            class="fa fa-heart-o"></i> UnFavorite </a> -
                                </c:when>
                                <c:otherwise>
                                    <a href="${root}/post/${post.id}/favorite"><i
                                            class="fa fa-heart"></i> Favorite </a> -
                                </c:otherwise>
                            </c:choose>
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
                            <img src="/vimg/${user.profilePicture.id}" alt="..." class="img-circle">
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
                            <c:choose>
                                <c:when test="${post.favoritedBy.contains(currentUser)}">
                                    <a href="${root}/post/${post.id}/favorite"><i
                                            class="fa fa-heart-o"></i> UnFavorite </a> -
                                </c:when>
                                <c:otherwise>
                                    <a href="${root}/post/${post.id}/favorite"><i
                                            class="fa fa-heart"></i> Favorite </a> -
                                </c:otherwise>
                            </c:choose>
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
