<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="application" value="${pageContext.request.contextPath}" var="root"/>
<div class="container">
    <script type="text/javascript">
        function resizeIframe(obj) {
            obj.style.height = obj.contentWindow.document.body.scrollHeight
            + 'px';
        }
    </script>
    <div class="row tut-head"
         style="padding: 20px; background-color: #EF7126; margin-top: -130px; padding-top: 130px; padding-bottom: 80px;  background: url('${root}/assets/img/octicons-bg.png') repeat scroll 0% 0% #EF7126; font-family: 'Open Sans', sans-serif;">
        <h1
                style="color: white; font-size: 50px; text-align: center; min-height: 100px; display: flex; justify-content: center; flex-direction: column;"
                class="tut-title">${tutorial.title}</h1>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2 tutorial tut-container"
             style=" margin-top: 50px; ">
            ${tutorial.text}

            <div class="row" style="margin-top: 50px;">
                <hr>
                <c:forEach items="${tags}" var="tag">
                    <a type="button" href="${root}/search?q=${tag.tag}" class="btn btn-info btn-sm">${tag.tag}</a>
                </c:forEach>
            </div>
        </div>
    </div>
    <section class="tut-user-info">
        <div class="row"
             style="background-color: #F9F9F9; padding: 30px; margin-top: 30px">
            <div class="col-md-8 col-md-offset-2">
                <div class="row">
                    <div class="col-md-4" style="text-align: center;">
                        <img class="img-circle" src="/vimg/${tutorial.post.user.profilePicture.id}"
                             style="height: 150px; width: 150px;"/>
                    </div>
                    <div class="col-md-8">
                        <h3>
                            <a href="${root}/user/${user.id}">${user.first_name} ${user.last_name}</a>
                        </h3>

                        <p>${user.biography}</p>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <section></section>
</div>