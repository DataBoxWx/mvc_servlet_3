<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#but").click(function(){
			$("#form").submit();
		});
	});
</script>
</head>
<body>
	<h3 align="center">登陆学生管理系统</h3>
	<br/><br/>
	<form action="controller/user.do" id="form" style="text-align: center">
		用户名<input type="text" name="username" id="usernameid"></span><br/><br/>
		密码<input type="password" name="password" id="passwordid"><br/><br/>
		<button id="but">提交</button>
	</form>
</body>
</html>