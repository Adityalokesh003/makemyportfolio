

<%@include file="includes/header.jsp"%>
<link rel="stylesheet"
href="${pageContext.request.contextPath}/public/css/signup.css">
</head>
<body>
<div class="sign-bg">
</div>
	<div id="signup-box">
		<h1>Welcome Back</h1>
		<form action="login" method="post" id="signup-form">

			<div class="input-container">
			<p class='error_message'>${requestScope.error_message }</p>
				<label for="user_name"><b>Username *</b></b></label>
				 <input type="text"
					placeholder="Enter Username" name="user_name" required autocomplete="off">
					 <label for="psw"><b>Password *</b></label> 
					 <input type="password" placeholder="Enter Password" name="password" required autocomplete="off"> 
					 <label> 
					 <input type="checkbox" checked="checked" name="remember">
					Remember me
					</label>
				<input type="submit" class="singup-submit" value="Log In">

			</div>
		<div class="input-container"> 
			
			<span class="psw"><a href="#">Forgot password?</a></span>
			<button   onClick="window.history.back()" class="cancelbtn">Cancel</button>
		</div>

	</form>
		

	</div>
 

<%@include file="includes/footer.jsp"%> 
