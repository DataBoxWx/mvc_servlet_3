<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
	
	System.out.println(basePath);	//    http://localhost:8080/2_jsp1/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	我是abc文件夹下的test1.jsp
	
	<!-- 
		使用相对路径,访问abc下的test2.jsp
	 -->
	 <!-- <a href="test2.jsp">
	 	点击
	 </a> -->
	
	
	<!-- 
		使用相对路径,访问abc外面的test1.jsp
	 -->
	<!--  <a href="../test1.jsp">
	 	点击
	 </a> -->
	

	<!-- 
		使用绝对路径,访问abc下的test2.jsp
	 -->
	 <!-- <a href="/2_jsp1/abc/test2.jsp">
	 	点击
	 </a> -->

	<!-- 
		使用绝对路径,访问外面的test1.jsp
	 -->
	 <!-- <a href="/2_jsp1/test1.jsp">
	 	点击
	 </a> -->

	<!-- 
		使用绝对路径,访问abc下的test2.jsp,结合basePath变量
	 -->
	<%-- <a href="<%=basePath%>abc/test2.jsp">
	 	点击
	 </a> --%>
	 
	 <!-- 
		使用绝对路径,访问外面的test1.jsp,结合basePath变量
	 -->
	 <%-- <a href="<%=basePath%>test1.jsp">
	 	点击
	 </a> --%>
	 
	 
	 <!-- 
		使用绝对路径,访问abc下的test2.jsp,结合basePath变量,结合base标签
	 -->
	<a href="abc/test2.jsp">
	 	点击
	 </a>
	 
	 <!-- 
		使用绝对路径,访问外面的test1.jsp,结合basePath变量,结合base标签
	 -->
	 <a href="test1.jsp">
	 	点击
	 </a>
	 
	 
</body>
</html>









