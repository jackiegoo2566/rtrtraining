document.onreadystatechange = function(){
	if(document.readyState ==="complete"){
		closeLoadingBar();
	}
}

function login(){
	openLoadingBar();
	var username = document.getElementById('iduser').value;
	var password = document.getElementById('password').value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			closeLoadingBar();
		}
	}
	xhttp.open("POST", "login/authenticate?username="+username+"&password="+password, true);
	xhttp.send();
}
function openLoadingBar(){
	document.getElementById('dualring').style="display:block";
}
function closeLoadingBar(){
	document.getElementById('dualring').style="display:none";
}

