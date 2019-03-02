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
	
	$(function(){
		
		$("#djBtn").click(function(){
			
			$.post(
				"myServlet2.do",
				function(data){
					
					/*
						将返回值类型设置为json之后
						data接收之后,一定要alert一下
						alert出来的结果有两种
						
						能弹出东西来,如果能弹,那么一定是[object Object],说明返回的json的语法是正确的
						不能弹出东西来(点击按钮没反应),说明返回的json拼接出现问题,语法错误
					*/
					
					alert(data.str1);
				},
				"json"
			)

			
		
		})
		
		
	
	})
	
</script>
</head>
<body>

	<button id="djBtn">点击</button>


	<br />
	<br />

	<div id="msg" style="width: 200px; height: 200px; background-color: pink">
		
	</div>


</body>
</html>





























