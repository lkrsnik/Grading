//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
$(document).ready(function(){
	$(".error").hide();
    $("#errorMsg").show();
	//document.getElementById("forma").addEventListener("submit",function() { return false;},true); //e.prevent default
	document.getElementById("prijava").addEventListener("click",signValidations,false);
})

function signValidations(e){
	var valid=true;
	if(!notEmptyValidation("username","#errorUser"))
		valid=false;
	if(!notEmptyValidation("password","#errorPass"))
		valid=false;
	if(!valid){
		e.preventDefault();
	}
}

;
