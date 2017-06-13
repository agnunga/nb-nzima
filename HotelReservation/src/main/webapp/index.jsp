<jsp:include page="assets/header.jsp"/> 
<form class="well form-horizontal" action="start" method="post"
      id="contact_form" style="max-width: 700px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Welcome, Login</legend>
        <% String message = (String) (request.getAttribute("message") != null ? request.getAttribute("message") : "");%>
        <h5 style="text-align: center; color: red;"><%=message%></h5>
        <div class="form-group">
            <label class="col-md-4 control-label">Username: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="username" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Password: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group"> 
                    <input name="password" placeholder="" class="form-control" type="password" required>
                </div>
            </div>
        </div>
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning">
                    Sign In <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
<jsp:include page="assets/footer.jsp"/>