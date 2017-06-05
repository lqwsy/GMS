
function JumpToQueryResult(){
	window.open('QueryResult.jsp');
}

function displayContent() {
	var myId = document.getElementById("myAlert");
	if(myId.style.display == "none"){
	document.getElementById("myAlert").style.display = "block"; //当div是隐藏的时候，点击后会显示
	}
	else { 
	  document.getElementById("myAlert").style.display = "none";//当div是显示的时候，点击后会隐藏
	  }
	}

$(document).ready(function(){
	  $("#hide").click(function(){
	  $("#hide2").hide();
	  });
	});

$(document).ready(function(){
	  $("#hide3").click(function(){
	  $("#hide4").hide();
	  });
	});

$(document).ready(function(){
	  $("#hide5").click(function(){
	  $("#hide6").hide();
	  });
	});

$(document).ready(function(){
	  $("#hide7").click(function(){
	  $("#hide2").hide();
	  });
	});
$(document).ready(function(){
	  $("#hide8").click(function(){
	  $("#hide9").hide();
	  });
	});
function JumpToUserQueryResult(){
	window.open('QueryUserResult.jsp');
}