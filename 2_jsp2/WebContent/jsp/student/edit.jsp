<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.bjpowernode.domain.Student"
    %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<%

	Student s = (Student)request.getAttribute("s");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>我是编辑页</h3>
	<form action="student/update.do" method="post">
		<input type="hidden" name="id" value="<%=s.getId()%>"/>
		请编辑姓名:<input type="text" name="name" value="<%=s.getName()%>"/><br/><br/>
		请编辑年龄:<input type="text" name="age" value="<%=s.getAge()%>"/><br/><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>


























