<%@ page import="java.util.*" %>
<%-- <%
	String iduser=(String)session.getAttribute("iduser");
	String role=(String)session.getAttribute("role");
	if(iduser==null||iduser.equals("")){
		String redirectURL = "logout";
		response.sendRedirect(redirectURL);
    }
%> --%>
<html>
	<head>
		<title>Waiters-Waitresses page</title>
		<link rel="stylesheet" type="text/css" href="styles/waiter.css">
		<script src="javascript/waiter.js"></script>
	</head>
	<body>
		<header>
			<h3>Hi waiter - waitress</h3>
			<a href=logout>Logout</a>
		</header>
		<div id="floor">
					<!-- I T E M 	P O P U P  -->
			<div id="item-popup" class="item-popup popup">
				<div class="popup-contents">
					<div class="top-popup">
						<label>Foods list</label>
						<button class="close-popup-button popup-button" 
								id="close-item-popup" 
								onClick="closeItemPopup()">Cancel</button>
					</div>
					<table class="middle-popup" id="foods-list">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Price</th>
							<th></th>
						</tr>
					</table>
					<div class="bottom-popup">
						<button class="accept-button popup-button" id="accept-button" 
								onClick="acceptchoice()">Accept</button>
					</div>
				</div>
			</div>
					<!-- B I L L 	P O P U P  -->
			<div id="bill-popup" class="bill-popup popup">
				<div class="popup-contents">
					<div class="top-popup">
						<label>Foods list</label>
						<button class="close-popup-button popup-button" 
								id="close-bill-popup" 
								onClick="closeBillPopup()">Cancel</button>
					</div>
					<div class="middle-popup" id="bill-popup-info">
						<div class="form-bill">
							Table Number:
							<div class="bill-info-tablenumber"></div>
						</div>
						<div class="form-bill">
							Order ID:
							<div class="bill-info-orderid"></div>
						</div>
						<div class="form-bill">
							Time:
							<div class="bill-info-datetime"></div>
						</div>
						<div class="form-bill">
							Waiter (Waitress):
							<div class="bill-info-waitress"></div>
						</div>
					
					</div>
					<table class="middle-popup" id="bill-foods">
						<tr>
							<th>Name</th>
							<th>Price</th>
						</tr>
					</table>
					<div class="bill-sum">
						<label id="bill-sum"></label>
					</div>
					<div class="bottom-popup">
						<button class="pay-button popup-button" id="pay-button" 
								onClick="payOrder()">Paid</button>
					</div>
				</div>
			</div>
					<!--	T A B L E S   -->
			<div id="tables-container">
				
			</div>
		</div>
	</body>
</html>