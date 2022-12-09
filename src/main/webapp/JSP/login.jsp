<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath( )%>/css/style.css">
<style>
body {
	background: black;
}
label{
color:red;
}
button{
padding-left:100px;
padding-right:100px;
font-size:20px;
}
</style>
  <link rel = "icon" href = "<%=request.getContextPath( )%>/images/ansarbanklogo.png"
        type = "image/x-icon">
<title>Login</title>
</head>
<body>
	<div class="loginpage">
		<h1>Login</h1>
		
		<form action="<%=request.getContextPath( )%>/add" method="post">
			<div class="textbox">
				<input type="tel" name="CustomerId" placeholder="CustomerId" pattern="(2022)[0-9]{3}" required autocomplete="off">
			</div>

			<div class="textbox">
				<input type="password"  name="password" placeholder="Password" required autocomplete="off">
			</div>
			<label >${message }</label><br>
			<button type="submit" name="login" value="login">Login</button>
		</form>







	</div>






</body>
</html>