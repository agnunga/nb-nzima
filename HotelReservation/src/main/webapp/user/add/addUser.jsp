<jsp:include page="assets/header.jsp"/> 
<form class="well form-horizontal" action="../u/add_user" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Add Hotel</legend>
        <% String error = (String) (request.getAttribute("message") != null ? request.getAttribute("message") : "");%>
        <h5 style="text-align: center; color: red;"><%=error%></h5>
        <div class="form-group">
            <label class="col-md-4 control-label">Name: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="name" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
       <div class="form-group">
            <label class="col-md-4 control-label">ID/Passport No.: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="natid" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Email: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="email" placeholder="" class="form-control" type="email" required>
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
                    Register <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
<jsp:include page="assets/footer.jsp"/>