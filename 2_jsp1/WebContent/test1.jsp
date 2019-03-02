<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
	
	//System.out.println(basePath);	//    http://localhost:8080/2_jsp1/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<script type="text/javascript" src="js/fun.js"></script>
</head>
<body>
	
	<!-- <img src="images/pic1.jpg"/> -->
	
	<!-- aaaaaaaaaaaaaaa -->

	<button onclick="info()">点击</button>
	
</body>
</html>

































