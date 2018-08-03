function openNav() {
	document.getElementById("mySidenav").style.width = "250px";
}
function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
}
//sidenavbar
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;
for (i = 0; i < dropdown.length; i++) {
	dropdown[i].addEventListener("click", function() {
		this.classList.toggle("profile-active");
		var dropdownContent = this.nextElementSibling;
		if (dropdownContent.style.display === "block") {
			dropdownContent.style.display = "none";
		} else {
			dropdownContent.style.display = "block";
		}
	});
}

 
//var prevScrollpos = window.pageYOffset;
//window.onscroll = function() {
//var currentScrollPos = window.pageYOffset;
//if (prevScrollpos > currentScrollPos) {
//document.getElementById("navbar").style.top = "0";

//} else {
//document.getElementById("navbar").style.top = "-90px";
//}
//prevScrollpos = currentScrollPos;
//} 