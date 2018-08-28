<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<div class="profile-main">


	<div class="profile-details">

		<div class="profile-heading col-lg-9">
			Profile Details
			<hr>
		</div>
		<div class="accordion">
			<h3 class="profile-view-heading">Educational Details</h3>
			<div class="profile-view-content">
			<form>
				<div class="profile-picture ">
					<div class="picture-box ">
						<img
						src="https://avatars0.githubusercontent.com/u/36074681?s=400&u=1368af0b7c289937f2e457f0aa6aa3c8615099f7&col-sm-8v=4"
						class="img-responsive">
						 
							<div class="button-wrapper">
								 <input type="file"
								name="">
							</div>
						 
					</div>
				</div>
				
					<div class="form-row">
						<div class="form-group col-lg-10  ">
							<label for="full_name">Full Name :-</label> <input type="text"
							class="form-control" id="full_name" value="Aditya Surabattula">
						</div>
						<div class="form-group col-lg-10 ">
							<label for="about_you">About You :-</label>
							<textarea class="form-control" id="about_you">About Me will be here
							</textarea>
						</div>
						<div class="form-group col-lg-10  ">
							<label for="hometown">Hometown :-</label> <input type="text"
							class="form-control" id="hometown" value="Vizag">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="current_city">Current City :-</label> <input
							type="text" class="form-control" id="current_city"
							value="Raipur">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="email_id">Email Id :-</label> <input type="email"
							class="form-control" id="email_id"
							value="adityalokesh003@gmail.com">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="phone_no">Phone number :-</label> <input type="text"
							class="form-control" id="phone_no" value="+91 7987592885">
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Update Profile Details">
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="accordion">
			<h3 class="profile-view-heading">Educational Details</h3>
			<div class="profile-view-content">
				<form>
					<div class="form-row">
						<div class="form-group col-lg-10  ">
							<label for="degree_type">Degree Type :-</label> <input
							type="text" class="form-control" id="degree_type" value="B.Tech">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="institution_name">Institution Name :-</label> <input
							type="text" class="form-control" id="institution_name"
							value="Vizag">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="year_of_pass">Year Of Pass :-</label> <input
							type="text" class="form-control" id="year_of_pass" value="2019">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="percentage">Percentage :-</label> <input type="text"
							class="form-control" id="percentage" value="2019">
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Update Educational Details">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="accordion">
			<h3 class="profile-view-heading">Technical Details Details</h3>
			<div class="profile-view-content">
				<form>
					<div class="form-row">
						<div class="form-group col-lg-10  ">
							<label for="programming_languages">Programming Languages :-</label> 
							<textarea class="form-control" id="programming_languages">About Me will be here</textarea>
						</div>
						<div class="form-group col-lg-10  ">
							<label for="web_technologies">Web Technologies :-</label> 
							<textarea class="form-control" id="web_technologies">About Me will be here</textarea>
						</div>
						<div class="form-group col-lg-10  ">
							<label for="os_known">Operating Systems known :-</label> 
							<textarea class="form-control" id="os_known">About Me will be here</textarea>
						</div>
						<div class="form-group col-lg-10  ">
							<label for="databases_known">Databases known :-</label> 
							<textarea class="form-control" id="databases_known">About Me will be here</textarea>
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Update Technical Details">
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div class="accordion">
			<h3 class="profile-view-heading">Development Categories</h3>
			<div class="profile-view-content">
				<form action="/makemyportfolio/profie/edit" method="post">  
					<div class="form-row">
						<div class="form-group col-lg-10  ">
							<label for="category_title">Category Title :-</label> <input
							type="text" class="form-control" id="category_title" name="category_title" value="B.Tech">
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary" name="dev_cat_update"
							value="Update Development Categories">
						</div>
					</div>
				</form>
			</div>
		</div>
		
		<div class="accordion">
			<h3 class="profile-view-heading">Extra-curricular Activities</h3>
			<div class="profile-view-content">
				<form>
					<div class="form-row">
						<div class="form-group col-lg-10  ">
							<label for="activity_title">Activity Title :-</label> <input
							type="text" class="form-control" id="activity_title" value="B.Tech">
						</div>
						<div class="form-group col-lg-10  ">
							<label for="activity_description">Description :-</label> 
							<textarea class="form-control" id="activity_description">About Me will be here</textarea>
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Update Extra-curricular Activities">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="includes/footer.jsp"%> 