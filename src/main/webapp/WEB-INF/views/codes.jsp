<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="application" value="${pageContext.request.contextPath}" var="root"/>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <c:choose>
                <c:when test="${isForkPage}">
                    <h2><a href="${root}/code/${code.id}">${code.title}</a> Forks <a href="<c:url value="${root}/code/${code.id}/fork" />" class="btn btn-primary">Add New</a></h2>
                    <h6>Language: ${code.language}</h6>
                </c:when>
                <c:otherwise>
                    <h2>Your codes <a href="<c:url value="/newCode" />" class="btn btn-primary">Add New</a></h2>
                    <blockquote>
                        <p>Good code is its own best documentation. As you're about to add a comment, ask
                            yourself, &lsquo;How can I improve the code so that this comment isn't needed?</p>
                    </blockquote>
                </c:otherwise>
            </c:choose>

            <br/>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Title</th>
                    <c:choose>
                        <c:when test="${isForkPage}">
                            <th>Coder</th>
                        </c:when>
                        <c:otherwise>
                            <th>Programming language</th>
                        </c:otherwise>
                    </c:choose>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${forks}" var="code">
                    <tr>
                        <td><a href="${root}/code/${code.id}">${code.title}</a></td>
                        <c:choose>
                            <c:when test="${isForkPage}">
                                <td>${code.user.first_name} ${code.user.last_name}</td>
                            </c:when>
                            <c:otherwise>
                                <th>${code.language}</th>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>