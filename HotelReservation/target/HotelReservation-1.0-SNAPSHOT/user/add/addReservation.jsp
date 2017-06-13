<jsp:include page="assets/header.jsp"/> 
<form class="well form-horizontal" action="../u/add_reservation" method="post"
      id="contact_form" style="max-width: 900px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Reserve Room</legend>
        <% String error = (String) (request.getAttribute("message") != null ? request.getAttribute("message") : "");%>
        <h5 style="text-align: center; color: red;"><%=error%></h5>
        <div class="form-group">
            <label class="col-md-4 control-label">Name </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="name" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
       <div class="form-group">
            <label class="col-md-4 control-label">ID/Passport No: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="natid" placeholder="" class="form-control" type="text" >
                </div>
            </div>
        </div> 
        <div class="form-group">
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <label class="col-md-4 control-label"> Hotel: </label>
                    <select name="hotel"  class="form-control">
                        <option value="1">Name</option>
                    </select>
                    <label class="col-md-4 control-label"> Room: </label>
                    <select name="room"  class="form-control">
                        <option value="1">Name</option>
                    </select>           
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">CheckIn: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="checkin" placeholder="e.g 12/31/2016" class="form-control" type="text" required>
                </div>
            </div>
        </div> 
        <div class="form-group">
            <label class="col-md-4 control-label">CheckOut: </label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <input name="checkout" placeholder="e.g 21/01/2017" class="form-control" type="text" required>
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