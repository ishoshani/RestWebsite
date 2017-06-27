function hamburger(){
	if (document.getElementById("mySideNav").style.width == "0px") {
		openNav();
	}
	else{
		closeNav();
	}
}

function openNav(){
	document.getElementById("mySideNav").style.width = "250px";
	document.getElementById("main").style.marginLeft = "250px";
}
function closeNav(){
	document.getElementById("mySideNav").style.width = "0px";
	document.getElementById("main").style.marginLeft = "0px";
}
