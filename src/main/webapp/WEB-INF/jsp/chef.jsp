<html>
	<head>
	
		<link rel="stylesheet" type="text/css" href="styles/chef.css">
		<script src="javascript/chef.js"></script>
	</head>
	<body>
		<header>
			<h3>Hi chef!</h3>
		</header>
		<div class="oder-list-container">
			<div class="order-list-table">
				<table id="order-list-table">
					<tr class="table-header">
						<th id="food-name">Name</th>
						<th id="food-time">Time</th>
						<th class="status-checker" id="thstt1">Haven't Started</th>
						<th class="status-checker" id="thstt2">Be Doing</th>
						<th class="status-checker" id="thstt3">Been Finished</th>
					</tr>
				</table>
				<div class="bottom-button">
					<div class="button">
						<button id="refresh" onClick="refresh()">Refresh</button>
					</div>
					<div class="button">
						<button id="save" onClick="save()">Save</button>
					</div>
				</div>
			</div>
		</div>
	</body>	
</html>