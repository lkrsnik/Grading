//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
var slovene=true;
$(document).ready(function(){
	$(".error").hide();
	document.getElementById("oddaja").addEventListener("click",publishAssignmentValidators,false);
	//setFontChange();
	document.getElementById("list").addEventListener("mouseover",mouseOverList,false);
	document.getElementById("list").addEventListener("mouseout",mouseOutList,false);
	//document.getElementById("uol").addEventListener("mouseover",mouseOutList,false);
	document.getElementById("prevod").addEventListener("click",changeLanguage,false);
})

function changeLanguage(){
	var doc=loadXMLDoc('prevodi.xml');
	//alert(doc.getElementsByTagName("en")[0].childNodes[0].nodeValue);
	if(slovene){
		accuallyChangeLanguage(doc,"en");
		slovene=false;
	}else{
		accuallyChangeLanguage(doc,"sl");
		slovene=true;
	}
}

function accuallyChangeLanguage(doc,language){
	//alert(doc.getElementsByTagName(language).length);
	for(var i=0;i<doc.getElementsByTagName(language).length;i++){
		if(i<12)
			document.getElementById(i+1).innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i<17)
			document.getElementById("alin"+(i-11)).innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i<21)
			document.getElementById(i).value=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==21)
			document.getElementById("oddaja").value=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==22)
			document.getElementById("errorTitle").innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==23)
			document.getElementById("errorOtherParticipants").innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==24)
			document.getElementById("errorProject").innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==25)
			document.getElementById("errorCode").innerHTML=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
		else if(i==26)
			document.getElementById("prevod").value=doc.getElementsByTagName(language)[i].childNodes[0].nodeValue;
			
	}
}

function publishAssignmentValidators(){
	var valid=true;
	if(!notEmptyValidation("naslov","#errorTitle"))
		valid=false;
	if(!notEmptyValidation("rest1","#errorOtherParticipants"))
		valid=false;
	if(!notEmptyValidation("rest2","#errorOtherParticipants"))
		valid=false;
	if(!notEmptyValidation("sourceProject","#errorProject"))
		valid=false;
	if(!notEmptyValidation("sourceCode","#errorCode"))
		valid=false;
	if(valid){
	}
}

function mouseOverList(){
	for(var i=1;i<6;i++){
		document.getElementById("alin"+i).addEventListener("mouseover",insideList,false);
	}
}

function insideList(event){
	for(var i=1;i<6;i++){
		if(event.target.id == "alin"+i){
			$("#alin"+i).css("font-size", "16px");
			$("#alin"+i).css("font-weight", "bold");
		}else{
			$("#alin"+i).css("font-size", "11px");
			$("#alin"+i).css("font-weight", "normal");
		}
	}
}

function mouseOutList(){
	//alert("here");
	for(var i=1;i<6;i++){
		$("#alin"+i).css("font-size", "11px");
		$("#alin"+i).css("font-weight", "normal");
		this.removeEventListener("mouseover",arguments.callee,false);
	}
}