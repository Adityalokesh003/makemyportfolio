<%@include file="includes/navbar.jsp"%>
<div class="profile-heading col-lg-9">
	 	Profile Details<hr>
	 </div>
<div class="profile-main">
	
	<div class="profile-details">
	 <form>
	 	
	 	<div class="form-row">
	 	
	 	<div class="form-group col-lg-10  ">
	 		<label for="full_name">Full Name :-</label>
	 		<input type="text" class="form-control" id="full_name" value="Aditya Surabattula" readonly="readonly">
	 	</div>
	 	<div class="form-group col-lg-10 ">
	 		<label for="about_you">About You :-</label>
	 		<textarea class="form-control" id="about_you" readonly="readonly">About Me will be here
	 		</textarea>
	 	</div>
	 	<div class="form-group col-lg-10  ">
	 		<label for="hometown">Hometown :-</label>
	 		<input type="text" class="form-control" id="hometown" value="Vizag" readonly="readonly">
	 	</div>
	</div>
	 </form>
			</div>
	<div class="profile-picture ">
		<div class="picture-box ">
			<img src="https://avatars0.githubusercontent.com/u/36074681?s=400&u=1368af0b7c289937f2e457f0aa6aa3c8615099f7&col-sm-8v=4" class="img-responsive">
			<form>
				<div class="button-wrapper">
					<button class="btn button">Upload a picture</button>
					<input type="file" name="">
				</div>
			</form>
			
		</div>
		
	</div>
	
</div>
<%@include file="../includes/footer.jsp"%>
