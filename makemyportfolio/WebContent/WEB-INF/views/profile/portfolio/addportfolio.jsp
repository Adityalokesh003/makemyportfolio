 
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<div class="profile-main">
	<div class="profile-details">
		<div class="accordion">
			<h3 class="profile-view-heading">Portfolio Details</h3>
			<div class="profile-view-content"> 
				<form>

					<div class="form-row">

						<div class="form-group col-lg-10 ">
							<label for="about_yourself">About Yourself :-</label>
							<textarea class="form-control" id="about_yourself"></textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="strengths">Strengths :-</label>
							<textarea class="form-control" id="strengths"></textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="weaknesses">Weaknesses :-</label>
							<textarea class="form-control" id="weaknesses"></textarea>
						</div>

						<div class="form-group col-lg-10 ">
							<label for="interests">Interests :-</label>
							<textarea class="form-control" id="interests"></textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="achievements">Achievements :-</label>
							<textarea class="form-control" id="achievements"></textarea>
						</div>
						<div class="form-group col-lg-10 ">
							<label for="career_objective">Career Objective :-</label>
							<textarea class="form-control" id="career_objective"></textarea>
						</div>
						<div class="form-group col-lg-10  profile-submit">
							<input type="submit" class="btn btn-block btn-primary"
							value="Add Personal Details">
						</div>


					</div>
				</form>
			</div> 
		</div>
 

	</div>
</div>

<%@include file="../includes/footer.jsp"%>