<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<!-- Page title -->
<title>register</title>
<!-- End of Page title -->
<!-- Libraries -->
<link type="text/css" href="css/login.css" rel="stylesheet" />
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html"
	rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/easyTooltip.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
<!-- End of Libraries -->
<title>肇院易班迎新报名系统</title>
<script>
	function showFileInput() {
		var fileInput = document.getElementById("fileInput");
		fileInput.click();
	}
</script>
</head>
<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box" style="text-align: center">
			<form action="servlet/HandleChecking" method="post">
				电话号码：<input type="text" name="phonenumber"
					style="border-top: hidden; border-left: hidden; border-right: hidden;" /><br />
				QQ号码：<input type="text" name="QQ_id"
					style="border-top: hidden; border-left: hidden; border-right: hidden;" /><br />
				第一志愿：<select name="first">
					<OPTION>办公室</OPTION>
					<OPTION>新闻部</OPTION>
					<OPTION>策划部</OPTION>
					<OPTION>运营部</OPTION>
					<OPTION>技术部</OPTION>
				</select> <br /> 第二志愿：<select name="second">
					<OPTION>办公室</OPTION>
					<OPTION>新闻部</OPTION>
					<OPTION>策划部</OPTION>
					<OPTION>运营部</OPTION>
					<OPTION>技术部</OPTION>
				</select> <br /> 意愿理由:
				<textarea style="vertical-align: middle;" name="reason" rows="3"
					cols="20"></textarea>
				<br /> 兴趣爱好:
				<textarea name="favourite" rows="3" cols="20"
					style="vertical-align: middle;"></textarea>
				<br /> <input type="submit" value="报名">
			</form>
		</div>
	</div>
</body>
</html>
