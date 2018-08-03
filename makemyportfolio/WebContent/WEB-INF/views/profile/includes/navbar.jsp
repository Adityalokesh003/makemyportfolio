<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="../../includes/header.jsp"%>
 <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
 <link rel="stylesheet"
	href="${pageContext.request.contextPath}/public/css/profile.css">
<%@include file="../../includes/navbar.jsp"%>   
 <div class="profile-sidenav">
  <button class="dropdown-btn">Profile 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="#">View Profile</a>
    <a href="#">Edit Profile</a>
  </div>
  <button class="dropdown-btn">Portfolio 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
  
    <a href="#">View Portfolio</a>
    <a href="#">Edit Portfolio</a>
  </div>
  <button class="dropdown-btn">Projects 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="#">View Project</a>
    <a href="#">Add Project</a>
  </div>
  <a href="#contact" class="profile-sidebar-link">Friends</a>
</div>