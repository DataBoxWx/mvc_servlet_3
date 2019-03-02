<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core"%>
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
	${str1}<br>
	${str2[1]}<br>
	${str3[2]}<br>
	${str4.str_1}<br>
	${stu.name}<br>
	<b:if test="${4<3}">4小于3</b:if>
	<b:if test="${4>3}">4大于3</b:if><br>
	<b:forEach items="${str3}" var="list">
	${list}<br>
	</b:forEach>
	${str4.str_2}<br>
</body>
</html>