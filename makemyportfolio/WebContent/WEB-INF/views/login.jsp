
<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>


<div id="signup-box" class="container">
	<h1>Welcome Back!</h1>
	<form action="login" method="post" id="signup">
	<p class="error_message">${requestScope.error_message }</p>
		<div class="form-group">
			<label for="user_name">User name *</label>
			<input type="text" name="user_name" class="form-control" id="user_name" required autocomplete="off">
		</div>
		<div class="form-group">
			<label for="password">Password *</label>
			<input type="text" name="password" class="form-control" id="password" required autocomplete="off">
		</div>
		<br>
		<div class="form-group">
			<button class="btn btn-primary btn-lg btn-block" id="signup-submit">Log In</button>
		</div>
	</form>
</div>
 
<%@include file="includes/footer.jsp"%>