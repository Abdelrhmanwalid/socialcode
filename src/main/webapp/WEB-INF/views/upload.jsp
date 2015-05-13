<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" >
  File to upload: <input type="file" accept="image/*" name="file"><br />
  <form:errors path="file" />
  <input type="submit" value="Upload"> Press here to upload the file!
  <sec:csrfInput/>
</form>
