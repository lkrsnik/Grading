
$(document).ready(function(){
	$(".error").hide();
	document.getElementById("btn2").addEventListener("click",profesorsValidation,false);
	document.getElementById("btn3").addEventListener("click",mateValidation,false);
})


function profesorsValidation(){
	var valid=true;
	if(!normalValidation("proff","#errorGradeStudents"))
		valid=false;
}

function normalValidation(name,element){
	var valid=true;
	var theValue=document.getElementById("proff").value;
	var patt=/^[0-9]{1,2}$/;
	var res=theValue.match(patt);
	if(res!=null){
		$(element).hide();
		return true;
	} else {
		$(element).show();
		return false;
	}
}

function mateValidation(){
	return datalistValidation("vpisanoIme","imena","#errorGradeInside");
}