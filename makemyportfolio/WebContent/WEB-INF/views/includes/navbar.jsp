
<%@page import="makemyportfolio.bo.User"%>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg fixed-top navbar-dark navigation-bg">

		<a class="navbar-brand" href="/makemyportifolio">MakeMyPortifolio</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class=" navbar-nav  navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="includes/index.jsp">Home<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="#">Projects</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Connect</a></li>

			</ul>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
			<%
			User user =  (User)session.getAttribute("user");
			if(user!=null){%>
				<li class="nav-item"><a class="nav-link" href="#">${ sessionScope.user.name}</a></li>
				<li class="nav-item"><a class="nav-link" href="logout">Log Out</a></li>
				<%}else{ %>
				<li class="nav-item"><a class="nav-link" href="signup">Sign Up</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Log In</a></li>
				<%} %>
			</ul>
		</div>
	</nav>
	<!-- end of navbar -->