<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

<c:redirect url="${pageContext.request.contextPath}/home"/>

	<h3>messages, whatever</h3>
	<a href="newCode">new code</a>
	<a href="upload">upload</a>
	<a href="<c:url value="/logout" />">Logout</a>
       <iframe src="code/embed?url=/socialcode/code/1/" width="100%" height="300px" frameborder="0" style="border: 1px solid #c0c0c0; overflow-x: hidden;"></iframe>

</body>
</html>