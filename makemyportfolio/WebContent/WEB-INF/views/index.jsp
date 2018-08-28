
<%@include file="includes/header.jsp"%>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<%@include file="includes/navbar.jsp"%>
<div class="container homepage">
	${requestScope.message } ${applicationScope.lomsg }
	<%
	application.removeAttribute("lomsg"); 
	%>
	
	
	
	<div class="post-section">
		<div class="post-header">
			<img class="author-pic" src="https://avatars0.githubusercontent.com/u/36074681?s=400&u=1368af0b7c289937f2e457f0aa6aa3c8615099f7&col-sm-8v=4" class="post-author-pic" alt="">
			<div class="post-author">
				<p><a href="">Aditya Surabattula</a></p>
				<span>Student at NIT Raipur</span>
			</div>
			<a class="post-menu" href=""><i class="fas fa-ellipsis-v"></i></a>
		</div>
		<hr>
		<div class="post-content">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde tempora vero, sapiente iure obcaecati ex.</p>
			<img src="https://iso.500px.com/wp-content/uploads/2016/04/stock-photo-150595123.jpg" alt="">
		</div>
		<hr>
		<div class="post-footer">
			<a href=""><i class="far fa-thumbs-up"></i> like</a>
			<a href=""><i class="far fa-comment-alt"></i> comment</a>
		</div>
		
	</div>
	
	<div class="post-section">
		<div class="post-header">
			<img class="author-pic" src="https://avatars0.githubusercontent.com/u/36074681?s=400&u=1368af0b7c289937f2e457f0aa6aa3c8615099f7&col-sm-8v=4" class="post-author-pic" alt="">
			<div class="post-author">
				<p><a href="">Aditya Surabattula</a></p>
				<span>Student at NIT Raipur</span>
			</div>
			<a class="post-menu" href=""><i class="fas fa-ellipsis-v"></i></a>
		</div>
		<hr>
		<div class="post-content">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde tempora vero, sapiente iure obcaecati ex.</p>
			<img src="https://image.jimcdn.com/app/cms/image/transf/none/path/sa6549607c78f5c11/image/i03fd85155b3097ee/version/1471798944/sibenik-croatia-best-destination-for-nature.jpg" alt="">
		</div>
		<hr>
		<div class="post-footer">
			<a href=""><i class="fas fa-thumbs-up"></i> like</a>
			<a href=""><i class="far fa-comment-alt"></i> comment</a>
		</div>
		
	</div>
	
	<div class="post-section">
		<div class="post-header">
			<img class="author-pic" src="https://avatars0.githubusercontent.com/u/36074681?s=400&u=1368af0b7c289937f2e457f0aa6aa3c8615099f7&col-sm-8v=4" class="post-author-pic" alt="">
			<div class="post-author">
				<p><a href="">Aditya Surabattula</a></p>
				<span>Student at NIT Raipur</span>
			</div>
			<a class="post-menu" href=""><i class="fas fa-ellipsis-v"></i></a>
		</div>
		<hr>
		<div class="post-content">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Unde tempora vero, sapiente iure obcaecati ex.</p>
			<img src="http://www.hdwallpaperspulse.com/wp-content/uploads/2015/11/25/Awesome-best-nature-pictures.jpg" alt="">
		</div>
		<hr>
		<div class="post-footer">
			<a href=""><i class="fas fa-thumbs-up"></i> like</a>
			<a href=""><i class="far fa-comment-alt"></i> comment</a>
		</div>
		
	</div>
	

	
</div>


 

 
<%@include file="includes/footer.jsp"%>
