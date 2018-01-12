document.onreadystatechange=function (){
	if (document.readyState==="complete"){

	}
}
function loadTableSpace(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			loadTables(JSON.parse(this.response));
		}
	}
	xhttp.open("GET", "waiter/getTable", true);
	xhttp.send();
}
function loadTables(data){
	for(var i=0; i<data.length; i++){
		var tableData=data[i];
		var tableContainer=document.getElementById("tables-container"); 
											/* tables container div */
		var table=document.createElement('div'); 	/* table div  */
		table.className='table';
		table.id='table' + tableData.idTable;
		tableContainer.appendChild(table);//

		/**
		 * TOP OF A TABLE
		 */
		var tableLabel=document.createElement('label');
		tableLabel.innerHTML="Table " + tableData.idTable;		
		var tableStatus=document.createElement('div'); /* status table */
		tableStatus.className='table-status';
		tableStatus.innerHTML=tableData.tableStatus;
		var underLine=document.createElement('div'); /* line beneath label */
		underLine.className = 'table-label-line';
		/**
		 * MID	OF	A	TABLE
		 */
		var midTable=document.createElement('div');	/* create choosed item div */
		midTable.className='mid-table';
		var choosedItem=document.createElement('table');/* create choosed item table */
		choosedItem.className='choosed-item';
		midTable.appendChild(choosedItem);
				/* create TR of a TH */
		var trhead=document.createElement('tr'); /* head row */
		trhead.className = 'trhead';
		choosedItem.appendChild(trhead);
				/* create 5 THs */
		var th1mt = document.createElement('th');	
		var th1t = document.createTextNode("ID");
		th1mt.appendChild(th1t);
		th1mt.className = 'thId';
		var th2mt = document.createElement('th');
		var th2t = document.createTextNode("Name");
		th2mt.appendChild(th2t);
		th2mt.className = 'thName';
		var th3mt = document.createElement('th');
		var th3t = document.createTextNode("Price");
		th3mt.appendChild(th3t);
		th3mt.className = 'thPrice';
		var th4mt = document.createElement('th');
		var th4t = document.createTextNode("Status");
		th4mt.appendChild(th4t);
		th4mt.className = 'thStatus';
		var th5mt = document.createElement('th');
		var th5t = document.createTextNode("");
		th5mt.appendChild(th5t);
		th5mt.className = 'thButton';
		trhead.appendChild(th1mt);
		trhead.appendChild(th2mt);
		trhead.appendChild(th3mt);
		trhead.appendChild(th4mt);
		trhead.appendChild(th5mt);
		
		/*		add order item to order-item-table 	*/
		var oSOrder = tableData.outStandingOrder;
		if(oSOrder != null){
			var showbill = document.getElementById('bill('+ tableData.idTable +')');
			showbill.setAttribute('style', 'display: block')
			var lst = oSOrder.lstOrderItem;
			for(var j=0; j<lst.length;j++){
				
				var tr = document.createElement('tr');
				choosedItem.appendChild(tr);
				var td1 = document.createElement('td');/*	id		*/
				td1.innerHTML=j+1;
				var td2 = document.createElement('td');/*	name	*/
				td2.innerHTML=lst[j].item.name;
				var td3 = document.createElement('td');/*	price	*/
				td3.innerHTML=lst[j].item.price;
				var td4 = document.createElement('td');/*	status	*/
				td4.innerHTML=lst[j].statusOrderItemByStatusId;
				var td5 = document.createElement('button');/*	delete button	*/
				td5.setAttribute('onclick', 'deleteOrderItem('+lst[j].item.idItem+')');
				td5.innerHTML = "x";
				td5.className="delete-order-item";

				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tr.appendChild(td5);	
			}
			tableStatus.setAttribute('style',"background-color:red; border:red; color: yellow");
		}

			
		/**
		 * BOTTOM OF A TABLE
		 * contains buttons
		 */
		var buttonTable = document.createElement('div'); /* button container */
		buttonTable.className = 'table-button-container';
		var cbutton = document.createElement('div'); /* container 2 button after choosing */
		cbutton.className='cbutton';
		
		var bill = document.createElement('button'); 		/*  bill  */
		bill.className = 'table-button';
		bill.id = 'bill' + tableData.idTable;
		bill.setAttribute('onclick', 'exportBill('+ tableData.idTable +')');
		var billText = document.createTextNode("Bill");
		bill.appendChild(billText);
		buttonTable.appendChild(bill);
		var add = document.createElement('button'); 		/*  add  */
		add.className = 'table-button';
		add.id = 'add' + tableData.idTable;
		add.setAttribute('onclick', 'add('+ tableData.idTable +')');
		var addText = document.createTextNode("Add");
		add.appendChild(addText);	
		buttonTable.appendChild(add);
	
		table.appendChild(labelTable); 	 /* append label table */	 /*  */
		table.appendChild(tableStatus);	 /* append label status */
		table.appendChild(aLine);		 /* append line beneath label */
		table.appendChild(midTable);	 /* append table table */
		table.appendChild(buttonTable);	 /* append append button */
	}
}
