//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
$(document).ready(function(){
	$(".error").hide();
	//document.getElementById("dodajUporabnika").addEventListener("submit",function() { return false;},false);
	document.getElementById("potrdi").addEventListener("click",registerValidations,false);
        document.getElementById("roleInputRadio:student")[0].checked;
})

function registerValidations(e){
	var valid=true;
	if(!passValidation())
		valid=false;
	if(!nameValidation("ime","#errorName"))
		valid=false;
	if(!nameValidation("priimek","#errorSurname"))
		valid=false;
	//if(valid && document.getElementById("dodajUporabnika").checkValidity()){
	if(!valid){
		e.preventDefault();
	}
}
function nameValidation(name,element){
	
	var theValue=document.getElementsByName(name)[0].value;
	var patt=/^[A-Z][a-z]+$/;
	var res=theValue.match(patt);
	if(res!=null){
		$(element).hide();
		return true;
	} else {
		$(element).show();
		return false;
	}
}

function passValidation() {
	//alert("tralala");
	var pas1=document.getElementById("pas1").value;
	var pas2=document.getElementById("pas2").value;
	if(pas1==pas2 && pas1!=""){
		$("#errorPass").hide();
		return true;
	}else{
		$("#errorPass").show();
		return false;
	}
}

//document.addEventListener("load")	