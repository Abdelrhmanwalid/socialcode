<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>



<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" >
  File to upload: <input type="file" name="file"><br />
  <input type="submit" value="Upload"> Press here to upload the file!
  <sec:csrfInput/>
</form>
