//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
$(document).ready(function(){
	$(".error").hide();
	document.getElementById("nastaviKriterij").addEventListener("click",setValidators,false);
	document.getElementById("proNum").addEventListener("change",syncProNum,false);
	document.getElementById("asiNum").addEventListener("change",syncAsiNum,false);
	document.getElementById("stuNum").addEventListener("change",syncStuNum,false);
	document.getElementById("proSlider").addEventListener("change",syncProSlider,false);
	document.getElementById("asiSlider").addEventListener("change",syncAsiSlider,false);
	document.getElementById("stuSlider").addEventListener("change",syncStuSlider,false);
})



function setValidators(e){
	var valid=true;
	if(!notEmptyValidation("instructions","#errorInstructions"))
		valid=false;
	if(!notANumber("prof","#errorNotANumber"))
		valid=false;
	else if(!notANumber("asist","#errorNotANumber"))
		valid=false;
	else if(!notANumber("stud","#errorNotANumber"))
		valid=false;
	else if(!correctValueOnSliders())
		valid=false;
	if(!valid){
		e.preventDefault();
	}
}

function correctValueOnSliders(){
	var value=parseInt(document.getElementById("proNum").value)+parseInt(document.getElementById("asiNum").value)+parseInt(document.getElementById("stuNum").value);
	if(value == "100"){
		$("#errorSlider").hide();
		return true;
	}
	$("#errorSlider").show();
	return false;
}

function notANumber(name,element){
	var theValue=document.getElementsByName(name)[0].value;
	var patt=/^[0-9]+$/;
	var res=theValue.match(patt);
	if(res!=null){
		$(element).hide();
		return true;
	} else {
		$(element).show();
		return false;
	}
}

function syncProSlider() {
	document.getElementById("proNum").value=document.getElementById("proSlider").value;
}
function syncAsiSlider() {
	document.getElementById("asiNum").value=document.getElementById("asiSlider").value;
}
function syncStuSlider() {
	document.getElementById("stuNum").value=document.getElementById("stuSlider").value;
}

function syncProNum() {
	document.getElementById("proSlider").value=document.getElementById("proNum").value;
}
function syncAsiNum() {
	document.getElementById("asiSlider").value=document.getElementById("asiNum").value;
}
function syncStuNum() {
	document.getElementById("stuSlider").value=document.getElementById("stuNum").value;
}
;
