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
				"myServlet4.do",
				function(data){
					
					$("#id1").html(data.s1.id);
					$("#name1").html(data.s1.name);
					$("#age1").html(data.s1.age);
					
					$("#id2").html(data.s2.id);
					$("#name2").html(data.s2.name);
					$("#age2").html(data.s2.age);
					
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
	学员1:
	<br />
	编号:<span id="id1"></span>
	<br />
	姓名:<span id="name1"></span>
	<br />
	年龄:<span id="age1"></span>
	
	<br />
	<br />
	学员2:
	<br />
	编号:<span id="id2"></span>
	<br />
	姓名:<span id="name2"></span>
	<br />
	年龄:<span id="age2"></span>


</body>
</html>





























