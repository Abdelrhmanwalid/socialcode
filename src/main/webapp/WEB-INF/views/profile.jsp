<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

        <div class="post row">
            <div class="post-header row">
                <div class="user-pic col-md-1">
                    <img src="img/pp.jpg" alt="..." class="img-circle">
                </div>
                <div class="user-info col-md-3">
                    <div class="user-name"><a href="">
                        Mohamed Kamal</a></div>
                    <div class="post-time">15 mins ago.</div>
                </div>
            </div>
            <div class="post-container row">
                <div class="col-md-12">
                    <a class="post-title">
                        <h4>How to setup Git</h4>
                    </a>

                    <p>
                        We can make thisf n divides a number that is g code run faster by noticing that we only need to
                        check divisibility for values of i that are less or equal to the square root of n (call this m).
                        If n divides a number that is greater than m then the result of that division will be some
                        number less than m and thus n will also divide a number less or equal to....<a>Continue</a>
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

        <hr>

        <div class="post row">
            <div class="post-header row">
                <div class="user-pic col-md-1">
                    <img src="img/pp.jpg" alt="..." class="img-circle">
                </div>
                <div class="user-info col-md-3">

                    <div class="user-name"><a href="">
                        Mohamed Kamal</a></div>
                    <div class="post-time">15 mins ago.</div>
                </div>
            </div>
            <div class="post-container row">
                <div class="col-md-12">
                    <a class="post-title">
                        <h4>Bash code for fun</h4>
                    </a>

                    <div class="code-preview">
                            <pre><code class="bash">#!/bin/bash

                                ###### BEGIN CONFIG
                                ACCEPTED_HOSTS=&quot;/root/.hag_accepted.conf&quot;
                                BE_VERBOSE=false
                                ###### END CONFIG

                                if [ &quot;$UID&quot; -ne 0 ]
                                then
                                echo &quot;Superuser rights is required&quot;
                                echo &#39;Printing the # sign&#39;
                                exit 2
                            </code></pre>
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
        <hr>


    </div>
</div>