
<%@include file="includes/header.jsp"%>
<link rel="stylesheet"
href="${pageContext.request.contextPath}/public/css/signup.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/signup_validator.js"></script>
</head>
<body>
	<div class="sign-bg">
	</div>
	<div id="signup-box">
		<h1>Sign Up for free</h1>
		<form action="signup" method="post" onsubmit="return validator()" id="signup-form">

			<div class="input-container">
				<p class='error_message'>${requestScope.error_message }</p>
				<label for="user_name"><b>Username *</b></b></label>
				<input type="text"
				placeholder="Enter Username" name="user_name" required autocomplete="off">
				<label for="psw"><b>Password *</b></label> 
				<input type="password" placeholder="Enter Password" name="password" required autocomplete="off"> 

				<input type="submit" class="singup-submit" value="Sign Up">

			</div>
			<div class="input-container"> 

				<span class="psw">Already have an account?<a href="login">Login</a></span>
				<button   onClick="window.history.back()" class="btn btn-primary cancelbtn">Cancel</button>
			</div>

		</form>
		

	</div>






	<%@include file="includes/footer.jsp"%>