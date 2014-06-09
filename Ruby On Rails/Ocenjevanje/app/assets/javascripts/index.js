//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
$(document).ready(function(){
	$(".error").hide();
	document.getElementById("slika").addEventListener("mouseover",animirajSliko,false);
})

function animirajSliko(){
	$("#slika").animate({
		height:'266px',
		width:'552px'
    });
	$("#slika").animate({
		height:'183px',
		width:'276px'
    });
}

