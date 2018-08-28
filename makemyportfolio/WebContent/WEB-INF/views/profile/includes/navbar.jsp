 <%@include file="../../includes/header.jsp"%>
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
 <link rel="stylesheet"
	href="${pageContext.request.contextPath}/public/css/profile.css">
<%@include file="../../includes/navbar.jsp"%>   
 <div class="profile-sidenav">
  <button class="dropdown-btn">Profile 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/makemyportfolio/profile">View</a>
    <a href="/makemyportfolio/profile/new">Create/Add</a>
    <a href="/makemyportfolio/profile/edit">Edit</a>
  </div>
  <button class="dropdown-btn">Portfolio 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
  
    <a href="/makemyportfolio/portfolio">View</a>
    <a href="/makemyportfolio/portfolio/new">Create/Add</a>
    <a href="/makemyportfolio/portfolio/edit">Edit</a>
  </div>
  <button class="dropdown-btn">Projects 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="/makemyportfolio/profile/project">View</a>
    <a href="/makemyportfolio/profile/project/new">Add</a>
    <a href="/makemyportfolio/profile/project/edit">Edit</a>
  </div>
  <a href="#contact" class="profile-sidebar-link">Friends</a>
   
</div>