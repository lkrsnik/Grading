function notEmptyValidation(name,element){
	var theValue=document.getElementsByName(name)[0].value;
	if(theValue!=""){
		$(element).hide();
		return true;
	} else {
		$(element).show();
		return false;
	}
}

function datalistValidation(idInputa,idDataseta,imeErrorja){
	var value=document.getElementById(idInputa).value;
	var opcije=document.getElementById(idDataseta).options;
	for(var i=0;i<$("#"+idDataseta).length;i++){
		if(opcije[i].value==value && value != ""){
			$(imeErrorja).hide();
			return true;
		}
	}
	$(imeErrorja).show();
	//document.getElementById("errorGradeInside").show();
	return false;
	
}