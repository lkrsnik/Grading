
$(document).ready(function(){
	//$("#ocenjevanje").hide();
	$(".error").hide();
	drawXMLTable();
	document.getElementById("selektor").addEventListener("click",chooseProject,false);
	document.getElementById("btn2").addEventListener("click",profesorsValidation,false);
	document.getElementById("btn3").addEventListener("click",mateValidation,false);
})

function drawXMLTable(){
	var doc=loadXMLDoc('studenti.xml');
	var table = document.createElement('table');
	for (var i = 0; i < doc.getElementsByTagName("ime").length; i++){
		var tr = document.createElement('tr');   

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');

		var bes1=doc.getElementsByTagName("ime")[i].childNodes[0].nodeValue+" "+doc.getElementsByTagName("priimek")[i].childNodes[0].nodeValue;
		var bes2=doc.getElementsByTagName("student")[i].getAttribute("vpisna");
		var bes3=doc.getElementsByTagName("projekt")[i].childNodes[0].nodeValue;//doc.getElementsByTagName("projekt")[i].childNodes[0].nodeValue
		var text1 = document.createTextNode(bes1);
		var text2 = document.createTextNode(bes2);
		var text3 = document.createTextNode(bes3);
		
		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);

		table.appendChild(tr);
	}
	document.getElementById("tabelaSeznama").appendChild(table);
	
}

function chooseProject(){
	
	var value=document.getElementById("selektor").options[document.getElementById("selektor").selectedIndex].value;
	document.getElementById("naslovSklopa").innerHTML="Ocenjevanje projekta z naslovom \"" + value + "\" in soustvarjalcev vašega projekta:";
	if(document.getElementById("selektor").selectedIndex!=-1){
		$("#ocenjevanje").hide();
		$("#ocenjevanje").slideDown("slow");
	}
}

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