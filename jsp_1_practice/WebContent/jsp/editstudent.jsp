<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.bjpowernode.domain.Students" %>
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
	<%
		Students stu = (Students)request.getAttribute("stu");
	%>
	<h3>修改学生信息</h3>
	<hr/>
	<form action = "undatestudent.do">
			<input type="hidden" name="id" value=<%=stu.getId() %>>
		学生姓名<input type="text" name="name" value=<%=stu.getName() %>><br>
		学生年龄<input type="text" name="age" value=<%=stu.getAge() %>><br>
		学生性别<input type="text" name="sex" value=<%=stu.getSex() %>><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>