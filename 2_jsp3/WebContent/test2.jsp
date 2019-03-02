<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<%-- <%

	String str1 = (String)request.getAttribute("str1");

%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 取得数组中的值 -->
	<%-- ${strArr[1]} --%>
	
	<!-- 取得集合中的值 -->
	<%-- ${sList[1]} --%>
	
	<!-- 取得map中的值 -->
	<%-- ${myMap.str1} --%>
	
	<!-- 取得domain中的属性值 -->
	${s.name}
	
</body>
</html>






















