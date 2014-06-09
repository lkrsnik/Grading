//pas1=document.getElementById("pas1").innerHTML;
//uporabnik=document.getElementById("uporabnik").value;
$(document).ready(function(){
	$(".error").hide();
        
	kreirajTabelo();
        
	//document.getElementById("nastaviKriterij").addEventListener("click",setValidators,false);
	
        document.getElementById("proNum").addEventListener("change",syncProNum,false);
	document.getElementById("asiNum").addEventListener("change",syncAsiNum,false);
	document.getElementById("stuNum").addEventListener("change",syncStuNum,false);
	document.getElementById("proSlider").addEventListener("change",syncProSlider,false);
	document.getElementById("asiSlider").addEventListener("change",syncAsiSlider,false);
	document.getElementById("stuSlider").addEventListener("change",syncStuSlider,false);
})

function kreirajTabelo(){
	var table = document.createElement('table');
	//header
	var thead =document.createElement('thead');
	
	var tr = document.createElement('tr');   

	var th1 = document.createElement('th');
	var th2 = document.createElement('th');

	var text1 = document.createTextNode('Ocenjevalec');
	var text2 = document.createTextNode('Delež ocene');
	th1.appendChild(text1);
	th2.appendChild(text2);
	tr.appendChild(th1);
	tr.appendChild(th2);

	thead.appendChild(tr);
	
	table.appendChild(thead);
	
	//body
	var tbody=document.createElement('tbody');
	
	addRow(tbody,'Profesor','0');
	addRow(tbody,'Asistenti','0');
	addRow(tbody,'Študentje','0');
	
	table.appendChild(tbody);
	
	//footer
	var tfoot =document.createElement('tfoot');
	
	var tr = document.createElement('tr');   

	var tf1 = document.createElement('td');

	var text1 = document.createTextNode('Ocena sodelavcev znotraj projekta prav tako spada pod Študentje.');

	tf1.appendChild(text1);
	tf1.setAttribute("colspan","2");
	tr.appendChild(tf1);

	tfoot.appendChild(tr);
	
	table.appendChild(tfoot);
	
	document.getElementById("tabela").appendChild(table);
}

function addRow(table,text1,text2){
	var tr = document.createElement('tr');   

	var th1 = document.createElement('td');
	var th2 = document.createElement('td');

	var text1 = document.createTextNode(text1);
	var text2 = document.createTextNode(text2);

	th1.appendChild(text1);
	th2.appendChild(text2);
	tr.appendChild(th1);
	tr.appendChild(th2);

	table.appendChild(tr);
}


function setValidators(e){
	var valid=true;
	if(!notEmptyValidation("ocenjevanje","#errorInstructions"))
		valid=false;
	if(!notANumber("number1","#errorNotANumber"))
		valid=false;
	else if(!notANumber("number2","#errorNotANumber"))
		valid=false;
	else if(!notANumber("number3","#errorNotANumber"))
		valid=false;
	else if(!correctValueOnSliders())
		valid=false;
	if(!valid){
		e.preventDefault();
	} else{
		alert("Oddaja je uspela.");
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
