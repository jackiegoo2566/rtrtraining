<%@ page import="java.util.*" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="styles/waiter.css">
		<script src="javascript/waiter.js"></script>
	</head>
	<body>
		<header>
			<h3>Hi waiters - waitresses!</h3>
			<a href="login">Log out</a>
		</header>
		<!----------------------------FLOOR---------------------------->
		<div class="floor">		
			<!------------------------------ITEM POPUP------------------------------------------->		
			<div id="item-popup-modal"> 
				<div class="item-popup-content">
					<div class="item-popup-title"> 
						<div class="closepopupbutton"><!-- close -->
							<button id="closepopupbutton" onClick="closeItemPopup()">Cancel</button>
						</div> 
						<h3>Food list!</h3>
					</div>
					<table class="food-list" id="food-list">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th></th>
						</tr>
					</table>
					<div class="accept-button"> 
						<button id="accept-button" onClick="accept()">Accept</button>
					</div>
				</div>
			</div>
			<!------------------------------BILL POPUP------------------------------------------->
			<div id="bill-popup-modal"> 
				<div class="bill-popup-content">
					<div class="bill-popup-title"> 
						<div class="closebillbutton"><!-- close -->
							<button id="closebillbutton" onClick="closeBill()">Cancel</button>
						</div> 
						<h3>Your bill!</h3>
					</div>
					<div class="bill-info">
						<div class="form-bill">
							Table Number:
							<label class="bill-info-tablenumber"></label>
						</div>
						<div class="form-bill">
							Order ID:
							<label class="bill-info-orderid"></label>
						</div>
						<div class="form-bill">
							Time: 
							<label class="bill-info-datetime"></label>
						</div>
						<div class="form-bill">
							<label class="bill-info-waitress"></label>
						</div>						
					</div>
					<div>
						<table class="bill-table">
							<tr>
								<th>Name</th>
								<th>Price</th>
							</tr>
						</table>
					</div>
					<div>
						<table class="bill-table" id="bill-table">
						</table>
					</div>
					<div class="export-bill-button"> 
						<button id="export-bill-button" onClick="accept()">Confirm</button>
					</div>
				</div>
			</div>
			<!------------------------------TABLE------------------------------------------->		
			<div class="coffee-table" id="coffee-table-container">
			</div>
			<!------------------------------------------------------------------------->			
		</div>
	</body>	
</html>