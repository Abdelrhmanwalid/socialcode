<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set scope="application" value="${pageContext.request.contextPath}"
       var="root"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h3>We Encounter Some Problems, Search didn't Work After Deploying</h3>
            <%--<div class="home-data feeds col-md-10">--%>
                <%--<c:if test="${fn:length(tutorials) == 0}">--%>
                    <%--<div class="row col-md-12">--%>
                        <%--<h1>No result</h1>--%>
                    <%--</div>--%>
                <%--</c:if>--%>
                <%--<c:forEach items="${tutorials}" var="tutorial">--%>
                    <%--<div class="feed row">--%>
                        <%--<div class="user-pic col-md-2">--%>
                            <%--<img src="/vimg/${tutorial.post.user.profilePicture.id}" alt="..." class="img-circle">--%>
                        <%--</div>--%>
                        <%--<div class="col-md-10">--%>
                            <%--<div class="row user-name">--%>
                                <%--<a href="${root}/user/${tutorial.post.user.id}">${tutorial.post.user.first_name} ${tutorial.post.user.last_name}</a>--%>
                            <%--</div>--%>
                            <%--<div class="row">--%>
                                <%--<div class="col-md-12">--%>
                                    <%--<hr>--%>
                                    <%--<a>--%>
                                        <%--<h4>${tutorial.title}</h4>--%>
                                    <%--</a>--%>

                                    <%--<p>--%>
                                            <%--${fn:substring(tutorial.text,0,500)}...<a--%>
                                            <%--href="${root}/tutorial/${tutorial.id}">Continue</a>--%>
                                    <%--</p>--%>
                                    <%--<hr>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="row">--%>
                                <%--<a href="${root}/tutorial/${tutorial.id}/favorite"><i--%>
                                        <%--class="fa fa-heart"></i> Favorite </a> ---%>
                                <%--<a><i class="fa fa-share"></i> Share </a> ---%>
                                <%--<a><i class="fa fa-comment"></i> Comment </a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<hr>--%>
                <%--</c:forEach>--%>
            <%--</div>--%>

        </div>
    </div>
</div>