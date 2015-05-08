<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form commandName="code" class="form-horizontal">
                <div class="form-group">
            <label class="col-sm-3 control-label">Title</label>
            <div class="col-sm-9">
                <form:input path="title" type="text" name="title" class="form-control" placeholder="Title" />
                <p class="help-block" style="color:#ff0000;"><form:errors path="title" /></p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Programming language</label>
            <div class="col-sm-9">
                <form:select name="lang" class="form-control" items="${languages}" path="language" />
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Code</label>
            <div class="col-sm-9">
                <form:textarea path="code" class="form-control" rows="20"/>
                <p class="help-block" style="color:#ff0000;"><form:errors path="code" /></p>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <div class="checkbox">
                    <label>
                        <form:checkbox path="onProfile" /> Share in my profile
                    </label>
                </div>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <div class="checkbox">
                    <label>
                        <form:checkbox path="runnable"  /> Run the code
                    </label>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">Input</label>
            <div class="col-sm-9">
                <form:textarea path="input" class="form-control" rows="5"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default">Add</button>
            </div>
        </div>
        </form:form>
    </div>
</div>
</div>