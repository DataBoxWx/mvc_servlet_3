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
		$("#btn").click(function(){
			$("#form").submit();
		});
	});
</script>
</head>
<body>
	<h3 align="center">新增学生</h3>
	<br/><br/>
	<form action="student/add.do" id="form" style="text-align: center">
		姓名<input type="text" name="username" id="usernameid"><span id= "span1"></span><br/><br/>
		年龄<input type="age" name="age" id="ageid"><br/><br/>
		<button id="btn">提交</button>
	</form>
</body>
</html>