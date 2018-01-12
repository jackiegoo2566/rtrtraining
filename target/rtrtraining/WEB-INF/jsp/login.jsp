<html>
	<head>
		<title>Login page</title>		
		<link rel="stylesheet" type="text/css" href="styles/login.css">
		<script src="javascript/login.js"></script>
	</head>
	<body>
		<header id="header-login">
			<h3>X COFFEE</h3>
		</header>
		<form class="login-form" action="login/authenticate" method="POST">
			<div class="login-form-title">
				<h3>Login</h3>		
			</div>
			<div class="input-form">
				<div class="username-form">
					<label>Username: </label>
					<input type="text" id=iduser name=iduser>
				</div>
				<div class="password-form">
					<label>Password: </label>
					<input type="password" id=password name=password>
				</div>
			</div>
			<div>
				<button type="submit" class="login-button" onclick="login()">Login</button>
			</div>
			<div class="loading-bar">
				<div id="dualring"></div>
			</div>
		</form>
	</body>
</html>