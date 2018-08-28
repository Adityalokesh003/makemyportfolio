
<%@page import="makemyportfolio.bo.User"%>
</head>
<body>
	 
	<nav
		class="navbar navbar-expand-lg fixed-top navbar-dark navigation-bg" id="navbar">
		

		<a class="navbar-brand" href="/makemyportfolio">MakeMyPortfolio</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class=" navbar-nav  navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/makemyportfolio/home">Home<span
						class="sr-only">(current)</span></a></li>
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
					User user = (User) session.getAttribute("user");
					if (user != null) {
						
						 
						 
				%>
				<li class="nav-item"><a class="nav-link" href="#"><span
						style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
							  Profile
							</span></a></li>
				
				<div id="mySidenav" class="sidenav">
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a> 
					<p class="username">${sessionScope.user.user_name }</p>>
					<a href="/makemyportfolio/profile">View Profile</a> 
				    <a href="/makemyportfolio/logout">Log Out</a>
				</div>
				<%
					} else {
				%>
				<li class="nav-item"><a class="nav-link" href="/makemyportfolio/signup">Sign
						Up</a></li>
				<li class="nav-item"><a class="nav-link" href="/makemyportfolio/login">Log
						In</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</nav>
	<!-- end of navbar -->