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
})



function publishAssignmentValidators(){
	var valid=true;
	if(!notEmptyValidation("naslov","#errorTitle"))
		valid=false;
	if(!notEmptyValidation("mate1","#errorOtherParticipants"))
		valid=false;
	if(!notEmptyValidation("mate2","#errorOtherParticipants"))
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
;
