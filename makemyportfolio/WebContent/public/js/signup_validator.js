  
function validatePassword(){
	var password = $("#signup-form input[name='password']");
	var pword=password.val();console.log(pword);
	var pword_length= pword.length;

	if(pword_length < 5 || pword_length > 20){
		$(".error_message").text("password length should be 5 to 19 characters");
		$("#signup-form input[name='password']").focus();
		$("#signup-form input[name='password']").css("1px solid red") ;
		return false;
	}
	if(pword.search(/^[\S]+$/) < 0){
		$(".error_message").text("No spaces allowed");
		$("#signup-form input[name='password']").focus();
		$("#signup-form input[name='password']").css("1px solid red") ;
		return false;
	}
	if(pword.search(/[A-Z]/) < 0){
		$(".error_message").text("Password must contain a capital letter");
		$("#signup-form input[name='password']").focus();
		$("#signup-form input[name='password']").css("1px solid red") ;
		return false;
	}
	if(pword.search(/[!@#$%^&*_]/) < 0){
		$(".error_message").text("Password must contain a Special Character i.e, any one of  '!' '@' '#' '$' '%' '^' '&' '*' '_' ");
		$("#signup-form input[name='password']").focus();
		$("#signup-form input[name='password']").css("1px solid red") ;
		return false;
	}
	return true;
}


function validateUsername() {
	var user_name=$("#signup-form input[name='user_name']");
	var uname    =user_name.val();
	console.log(uname);
	var uname_length= uname.length;
	if(uname_length < 6 || uname_length > 20){
		$(".error_message").text("username length should be 6 to 20 characters");
		$("#signup-form input[name='user_name']").focus();
		$("#signup-form input[name='user_name']").css("1px solid red") ;
		 
		return false ;
	}

	//var letters = /^[A-Za-z][A-Za-z0-9@_]+$/;
	if(!(uname.match(/^[a-zA-Z].+$/))){
		$(".error_message").text("1st character should be a alphabet"); 
		$("#signup-form input[name='user_name']").focus();
		$("#signup-form input[name='user_name']").css("1px solid red") ;
		return false ;
	}
	if(uname.search(/^[\S]+$/) < 0){
		$(".error_message").text("No spaces allowed");
		$("#signup-form input[name='user_name']").focus();
		$("#signup-form input[name='user_name']").css("1px solid red") ;
		return false;
	}
	if(!(uname.match(/^[a-zA-Z][a-zA-Z0-9@_]+$/))){
		$(".error_message").text("special characters otherthan '@' and '_' are not allowed"); 
		$("#signup-form input[name='user_name']").focus();
		$("#signup-form input[name='user_name']").css("1px solid red") ;
		return false ;
	}
	return true;


}

  
function validator() {
	console.log("yes");
	if(validateUsername() && validatePassword() ){
		return true;
	}else{
		return false;
	}

}
	 