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
<title>Insert title here</title>
</head>
<body>
	
	<h3>我是添加页</h3>
	<form action="student/save.do" method="post">
		请输入姓名:<input type="text" name="name"/><br/><br/>
		请输入年龄:<input type="text" name="age"/><br/><br/>
		<input type="submit" value="提交"/>
	</form>
	
</body>
</html>


























