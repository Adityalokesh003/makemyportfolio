   
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<div class="profile-main">
	<div class="profile-details">
		<div class="accordion">
			<h3 class="profile-view-heading">Project Details</h3>
			<div class="profile-view-content"> 
				<form>

					<div class="form-row">

						<div class="form-group col-lg-10 ">
							<label for="project_title">Project Title :-</label>
							 <input type="text"
							class="form-control" id="project_title" value="MAke My Portfolio">
						</div>
						<div class="form-group col-lg-10 ">
							<label for="technologies_used">Technologies Used :-</label>
							<textarea class="form-control" id="technologies_used">sgsg gsfg</textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="project_description">Project Description :-</label>
							<textarea class="form-control" id="project_description">sgs sgsg sgsg</textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="project_picture">Project Picture :-</label>
							<input type="file" class="form-control">
						</div>

						<div class="form-group col-lg-10 ">
							<label for="project_duration">Project Duration :-</label>
							<input type="text"
							class="form-control" id="project_duration" value="1 month">
						</div>
						 
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Add Project">
						</div>


					</div>
				</form>
			</div> 
		</div>
 

	</div>
</div>

<%@include file="../includes/footer.jsp"%>