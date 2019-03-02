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
	<h3 align="center">修改学生页</h3>
	<br/><br/>
	<form action="student/update.do" id="form" style="text-align: center">
		<input type="hidden" name ="id" value="${stu.id}"/>
		姓名<input type="text" name="username" id="usernameid" value="${stu.name}"/><span id= "span1"></span><br/><br/>
		年龄<input type="text" name="age" id="ageid" value="${stu.age}"/><br/><br/>
		<button id="btn">提交</button>
	</form>
</body>
</html>