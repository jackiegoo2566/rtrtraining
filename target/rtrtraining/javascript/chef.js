document.onreadystatechange = function() {
	if(document.readyState === "complete"){
		loadData();		
	}
}
function loadData(){
	/*openLoadingBar();*/
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			loadOrderData(JSON.parse(this.response));
			/*closeLoadingBar();*/
		}
	}
	xhttp.open("GET", "chef/getOrderItem", true);
	xhttp.send();
}
function loadOrderData(data){
	for(var i=0; i<data.length; i++){
		var tableUI = document.getElementById("order-list-table");
		var tr = document.createElement('tr');
		tableUI.appendChild(tr);
		
		var td1 = document.createElement('td'); 
		td1.innerHTML = data[i].item.name;
		var td2 = document.createElement('td');
		td2.innerHTML = data[i].time;
		
		var td3 = document.createElement('td');
		var stt3 = document.createElement('input');
		stt3.id = 'stt1' + data[i].orderId + data[i].itemId;
		stt3.setAttribute('type','radio');
		stt3.setAttribute('name',data[i].orderId + data[i].itemId);
		
		var td4 = document.createElement('td');
		var stt4 = document.createElement('input');
		stt4.id = 'stt2' + data[i].orderId + data[i].itemId;
		stt4.setAttribute('type','radio');
		stt4.setAttribute('name',data[i].orderId + data[i].itemId);	
		
		var td5 = document.createElement('td');
		var stt5 = document.createElement('input');
		stt5.id = 'stt3' + data[i].orderId + data[i].itemId;
		stt5.setAttribute('type','radio');
		stt5.setAttribute('name',data[i].orderId + data[i].itemId);	
		
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);

		if(data[i].statusId=="hs"){
			document.getElementById("stt1" + data[i].orderId + data[i].itemId).checked = true;
		} else {
			document.getElementById("stt2" + data[i].orderId + data[i].itemId).checked = true;			
		}
	}	
}

function refresh(){
	loadData();	
}


/*
function openLoadingBar(){
	document.getElementById('dualring').style="display:block";
}
function closeLoadingBar(){
	document.getElementById('dualring').style="display:none";
}*/