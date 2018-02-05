<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.logging.SimpleFormatter"%>
<%@ page language="java" import="java.util.*  ,  entity.check"  
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<!-- Page title -->
<title>LoginSuccess</title>
<!-- End of Page title -->
<!-- Libraries -->
<link type="text/css" href="css/login.css" rel="stylesheet" />
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/easyTooltip.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<!-- End of Libraries -->
</head>
<%
		check ck=(check)request.getSession().getAttribute("ck");
		Date date = new Date ();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box" style="text-align: center">
			<form action="servlet/HandleLogin" method="post"
				style="text-align: center">
				<table border="1" align="center">
					<tr>
						<th>电话号码：<%= ck.getPhone_number()%></th>
						<th>QQ号码：<%=ck.getQq_id() %></th>
					</tr>
					<tr>
						<th>第一志愿：<%=ck.getFirst_wish() %></th>
						<th>第二志愿：<%=ck.getSecond_wish() %></th>
					</tr>
					<tr>
						<th colspan="3">兴趣爱好：<%=ck.getFavourite() %></th>
					</tr>
					<tr>
						<th colspan="3">选取部门的理由：<%=ck.getReason() %></th>
					</tr>		
					<tr>报名时间：<%=sp.format(date) %></tr>			
				</table>
			</form>
		</div>
	</div>
</body>
</html>