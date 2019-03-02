<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		//为点击按钮绑定事件
		$("#djBtn").click(function() {
			
			$.ajax({
				url : "http://localhost:8088/ky1/ky/myServlet1.do",
				type : "GET",
				dataType : "jsonp", //指定服务器返回的数据类型
				success : function(data) {
					alert(data.tq);
				}
			});

		})
	})
</script>
</head>
<body>

	<button id="djBtn">点击</button>

	<br />
	<br />
	<span id="msg"></span>
</body>
</html>






















