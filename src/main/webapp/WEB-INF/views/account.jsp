<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3 style="padding:10px;">Update Account Information</h3>

            <form:form commandName="user" class="form-horizontal">
                <form:hidden path="id" />
                <div class="form-group">
                    <label class="col-sm-3 control-label">First Name</label>

                    <div class="col-sm-9">
                        <form:input type="text" name="fname" class="form-control" placeholder="first name" path="first_name" />
                        <form:errors path="first_name" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Last Name</label>

                    <div class="col-sm-9">
                        <form:input type="text" name="lname" class="form-control" placeholder="last name" path="last_name" />
                        <form:errors path="last_name" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">Profile Picture</label>

                    <div class="col-sm-9">
                        <input type="submit" value="Upload"> Press here to upload the file!
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">Biography</label>

                    <div class="col-sm-9">
                        <form:textarea class="form-control" rows="5" path="biography" />
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form:form>
            <hr>
            <h3 style="padding:10px;">Update Password</h3>

            <form:form commandName="user" action="/account/password"  class="form-horizontal">
                <form:errors path="password" />
                <form:hidden path="id" />
                <div class="form-group">
                    <label class="col-sm-3 control-label">Old Password</label>

                    <div class="col-sm-9">
                        <input type="password" name="oldpassword" class="form-control" placeholder="old password">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">New Password</label>

                    <div class="col-sm-9">
                        <form:password path="password" name="newpassword" class="form-control" placeholder="new password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</div>