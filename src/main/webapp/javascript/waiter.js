document.onreadystatechange=function (){
	if (document.readyState==="complete"){
		loadTableSpace();
		loadItemPopup();
	}
}
			/*	TABLES FIELD	*/
function loadTableSpace(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			loadTable(JSON.parse(this.response));
		}
	}
	xhttp.open("GET", "waiter/getTable", true);
	xhttp.send();
}
/** LOAD ALL TABLE
 * @param data
 * @returns
 */
function loadTable(data){
	for(var i=0; i<data.length; i++){
		var tableData=data[i];
		var cTable=document.getElementById("tables-container"); /* all table */
	/** SINGLE TABLE */
		var singleTable=document.createElement('div'); 	/* TABLE 1-2-3...  */
		singleTable.className='single-table';
		singleTable.id='table' + data[i].idTable;
		/**	TOP OF A TABLE */
		var topTable=document.createElement('div');
		var labelTable=document.createElement('label');
		labelTable.innerHTML="Table " + tableData.idTable;
		var tableStt=document.createElement('div');//status
		tableStt.className='single-table-status';
		tableStt.innerHTML=tableData.tableStatus;
		var bLine=document.createElement('div');//a line beneath label
		bLine.className='single-table-bline';
		topTable.appendChild(labelTable);
		topTable.appendChild(tableStt);
		topTable.appendChild(bLine);
		singleTable.appendChild(topTable);
	
		/**	MID	OF A TABLE  */
		var midTable=document.createElement('div');	/* create choosed items div */
		midTable.className='mid-table-container';
		var choosedItemTable=document.createElement('table');/* create choosed item table */
		choosedItemTable.className='choosed-items-table';
				/* create TR of TH */
		var trhead=document.createElement('tr'); /* head row */
		trhead.className = 'trhead';
					/* create 5 THs */
		var tth1=document.createElement('th');	
		tth1.innerHTML="ID";
		tth1.className='thId';
		var tth2=document.createElement('th');
		tth2.innerHTML="Name";
		tth2.className='thName';
		var tth3=document.createElement('th');
		tth3.innerHTML="Price";
		tth3.className='thPrice';
		var tth4=document.createElement('th');
		tth4.innerHTML="Status";
		tth4.className='thStatus';
		var tth5=document.createElement('th');
		tth5.className='thButton';
		trhead.appendChild(tth1);
		trhead.appendChild(tth2);
		trhead.appendChild(tth3);
		trhead.appendChild(tth4);
		trhead.appendChild(tth5);
		choosedItemTable.appendChild(trhead);
		/**		add order item to order-item-table 	*/
		var oSOrder = tableData.outStandingOrder;
		if(oSOrder != null){
			var showbill = document.getElementById('bill('+ tableData.idTable +')');
			showbill.setAttribute('style', 'display: inline-block')
			var lst = oSOrder.lstOrderItem;
			for(var j=0; j<lst.length; j++){
				var tr=document.createElement('tr');
				
				var td1=document.createElement('td');/*	id		*/
				td1.innerHTML=j+1;
				var td2=document.createElement('td');/*	name	*/
				td2.innerHTML=lst[j].item.name;
				var td3=document.createElement('td');/*	price	*/
				td3.innerHTML=lst[j].item.price;
				var sttit=lst[j].statusOrderItemByStatusId;
				var td4=document.createElement('td');/*	status	*/
				td4.innerHTML=sttit;
				if(sttit=="nbs"){
					var td5=document.createElement('button');/*	delete button	*/
					td5.setAttribute('onclick', 'deleteOrderItem('+
							lst[j].item.idItem+','+tableData.idTable+')');
					td5.innerHTML="x";
					td5.className="delete-order-item";
				}
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);
				choosedItemTable.appendChild(tr);
			}
			tableStatus.setAttribute('style',"background-color:red; border:red; color: yellow");
		}
		midTable.appendChild(choosedItemTable);
		singleTable.appendChild(midTable);
		/** BOTTOM OF A TABLE
		 * contains buttons */
		var bottomTable=document.createElement('div'); //button container
		bottomTable.className='bottom-table-container';
		var exportBill=document.createElement('button'); //create export bill button
		exportBill.className='single-table-button';
		exportBill.className='bill-button';
		exportBill.id='bill' + tableData.idTable;
		exportBill.setAttribute('onclick', 'exportBill('+ tableData.idTable +')');
		exportBill.innerHTML="Bill";
		var addItem=document.createElement('button');//create add item button
		addItem.className='single-table-button';
		addItem.className='add-button';
		addItem.id='add' + tableData.idTable;
		addItem.setAttribute('onclick', 'addItem('+ tableData.idTable +')');
		addItem.innerHTML="Add";
		bottomTable.appendChild(exportBill); //appends
		bottomTable.appendChild(addItem);
		singleTable.appendChild(bottomTable);

		cTable.appendChild(singleTable);
	}
}
function deleteOrderItem(idItem,idTable){
	
}
				/*	ITEM	POPUP	*/
function loadItemPopup(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState==4&&this.status==200){
			loadItem(JSON.parse(this.response));
		}
	}
	xhttp.open("GET", "waiter/getItem", true);
	xhttp.send();
}
	/*	ITEM	POPUP	DATA	*/
function loadItem(data){ //data-type of data: Item
	var foodsList=document.getElementById('foods-list');
	for (var i=0; i<data.length; i++){
		var item=data[i];
		var tr=document.createElement('tr');
		var td1=document.createElement('td');
		td1.innerHTML=item.idItem;
		var td2=document.createElement('td');
		td2.innerHTML=item.name;
		var td3=document.createElement('td');
		td3.innerHTML=item.price;
		var td4=document.createElement('input');
		td4.setAttribute('type','radio');
		td4.setAttribute('name','checkitem');
		td4.setAttribute('value',item.idItem);
		td4.className="item-checkbox";
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		
		foodsList.appendChild(tr)
	}
}

function addItem(id){
	openItemPopup();
	var acceptItemButton=document.getElementById('accept-button');
	acceptItemButton.setAttribute('onclick', 'accept('+id+')');
    var itempopup=document.getElementById("foods-list");
    var itemcheckbox=itempopup.getElementsByClassName("item-checkbox");
    var itemselected=false;
    for(var i=0;i<itemcheckbox.length;i++){
    	var checking=itemcheckbox[i];
    	if(checking.checked){
    		itemselected=checking.value;
    	}
    }
    if(itemselected){
    	acceptItemButton.style.display="block";
    }
}
function accept(id){
	closeItemPopup();
    var itempopup=document.getElementById("foods-list");
    var itemcheckbox=itempopup.getElementsByClassName("item-checkbox");
    var itemselected;
    for(var i=0;i<itemcheckbox.length;i++){
    	var checking=itemcheckbox[i];
    	if(checking.checked){
    		itemselected=checking.value;
    	}
    }
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
		}
	}
	xhttp.open("POST", "waiter/addItem?idItem="+itemselected+"&idTable="+id, true);
	xhttp.send();	
}
function closeItemPopup(){
	var modal=document.getElementById("item-popup");
    modal.style.display="none";
}
function openItemPopup(){
	var modal=document.getElementById("item-popup");
    modal.style.display="block";
}

			/*	BILL	POPUP	*/
function exportBill(id){
	var modal=document.getElementById("bill-popup-modal");
	modal.style.display="block";
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
		}
	}
	xhttp.open("GET", "waiter/getBill?idTable="+id, true);
	xhttp.send();
}
function payBill(id){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			closeBillPopup();
		}
	}
	xhttp.open("POST", "waiter/payBill?idTable="+id, true);
	xhttp.send();
}
function openBillPopup(){
	var modal=document.getElementById("closebillbutton");
	modal.style.display="block";
}
function closeBillPopup(){
	var modal=document.getElementById("closebillbutton");
	modal.style.display="none";
}












