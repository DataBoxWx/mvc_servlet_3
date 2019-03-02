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
				"myServlet1.do",
				function(data){
					alert(data);
					if(data=="aaa"){
						alert("success");
					}
				}
				
			)

		
		})
	
	
	})
	

</script>
</head>
<body>

	<button id="djBtn">点击</button>
	
</body>
</html>
























