<jsp:include page="assets/header.jsp"/>    
<form class="well form-horizontal" action="upload_file3" method="post" enctype="multipart/form-data" id="contact_form" style="max-width: 700px; margin: 50px auto auto auto;">
    <fieldset>
        <legend style="text-align: center;">Upload Room Picture</legend> 
        <div class="form-group">
            <label class="col-md-4 control-label">Picture : </label> 
            <div class="input-group">
                <input name="file" placeholder="" class="" type="file" required>
            </div> 
        </div> 
        <input name="destination" value="/home/agunga/Pictures/hotelReservation" class="form-control" type="text" required>
        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <input type="submit" class="btn btn-warning" value="Upload Image" >
            </div>
        </div>
    </fieldset>
</form>
<jsp:include page="assets/footer.jsp"/>