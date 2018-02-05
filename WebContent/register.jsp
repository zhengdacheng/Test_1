<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <base href="<%=basePath%>">
<html>
	<head>
		<!-- Page title -->
		<title>register</title>
		<!-- End of Page title -->
		<!-- Libraries -->		
		<link type="text/css" href="css/login.css" rel="stylesheet" />	
		<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />	
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/easyTooltip.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		<!-- End of Libraries -->	
	</head>
	<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box"  >
			<form action="servlet/HandleRegister" method="post">
			<p class="main">
				<label >QQ号码: </label>
				<input name="userid" value="" /> 
				<label>用户密码: </label>
				<input type="password" name="password"  value="">	<br>
				<label>重复密码: </label>
				<input type="password" name="again_password"  value="">	
			</p>			
			<p class="space">
				<input type="submit" value="提交" class="login" style="cursor: pointer;"/>			
			</p>
			</form>
		</div>
	</div>
	</body>
</html>