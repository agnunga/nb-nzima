<jsp:include page="assets/header.jsp"/> 
<form class="well form-horizontal" action="../u/add_section" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Add Section</legend>
        <% String error = (String) (request.getAttribute("message") != null ? request.getAttribute("message") : "");%>
        <h5 style="text-align: center; color: red;"><%=error%></h5>
        <div class="form-group">
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <label class="col-md-4 control-label">Choose Hotel: </label>
                    <select name="hotel"  class="form-control">
                        <option value="1">Name</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Name </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="name" placeholder="" class="form-control" type="text" readonly="" hidden="">
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">Amount </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="amount" placeholder="" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-warning">
                    Add <span class=""></span>
                </button>
            </div>
        </div>

    </fieldset>
</form>
<jsp:include page="assets/footer.jsp"/>