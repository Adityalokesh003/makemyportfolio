 <%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<!-- main content  -->
<div class="main-container">
  <!--  main  -->
  <div class="main">

    <div class="main-sidebar">
      <div class="sidebar-fixed">
       <ul class="sidebar-list">
         <li>
            <a href="">Your Profile</a>
            <a href="">Your Portifolio</a>
            <a href="">Your Projects</a>
            <a href="">Friends</a>
            <a href="">Achievements</a>
         </li>
       </ul>
     </div>
   </div>
   
   <div class="main-content">
    
   ${requestScope.message }   

     <!--  posts -->

     <div class="container ">
      <div class="row post-container">
        <div class="col-md-10">
          <h2><a href="#">Post title</a></h2>
          
          <img class="img-responsive" src="https://images.pexels.com/photos/34950/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350" alt="">
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe voluptatibus molestiae, obcaecati soluta laboriosam consequuntur libero alias mollitia id quos odit ipsam deserunt laudantium atque hic tempora repellendus assumenda in, repudiandae error nihil! Hic dolorem laboriosam quia accusamus, a molestias?</p>
          <a class="btn btn-primary btn-block" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
          
        </div>
        <div class="col-md-8">
          <h2><a href="#">Post title</a></h2>
          <img class="img-responsive" src="" alt="">
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe voluptatibus molestiae, obcaecati soluta laboriosam consequuntur libero alias mollitia id quos odit ipsam deserunt laudantium atque hic tempora repellendus assumenda in, repudiandae error nihil! Hic dolorem laboriosam quia accusamus, a molestias?</p>
          <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
          
        </div>
        <div class="col-md-8">
          <h2><a href="#">Post title</a></h2>
          <img class="img-responsive" src="" alt="">
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe voluptatibus molestiae, obcaecati soluta laboriosam consequuntur libero alias mollitia id quos odit ipsam deserunt laudantium atque hic tempora repellendus assumenda in, repudiandae error nihil! Hic dolorem laboriosam quia accusamus, a molestias?</p>
          <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
          
        </div>
        <div class="col-md-8">
          <h2><a href="#">Post title</a></h2>
          <img class="img-responsive" src="" alt="">
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe voluptatibus molestiae, obcaecati soluta laboriosam consequuntur libero alias mollitia id quos odit ipsam deserunt laudantium atque hic tempora repellendus assumenda in, repudiandae error nihil! Hic dolorem laboriosam quia accusamus, a molestias?</p>
          <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
          
        </div>
        <div class="col-md-8">
          <h2><a href="#">Post title</a></h2>
          <img class="img-responsive" src="" alt="">
          <hr>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe voluptatibus molestiae, obcaecati soluta laboriosam consequuntur libero alias mollitia id quos odit ipsam deserunt laudantium atque hic tempora repellendus assumenda in, repudiandae error nihil! Hic dolorem laboriosam quia accusamus, a molestias?</p>
          <a class="btn btn-primary" href="#">Read More <span class="glyphicon glyphicon-chevron-right"></span></a>
          
        </div>
      </div>
     </div>
  </div>
  <!--  end of main content -->
</div>
<!-- end of main -->

	 
<%@include file="includes/footer.jsp"%>