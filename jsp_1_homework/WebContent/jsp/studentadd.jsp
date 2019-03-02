<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		$("#butt").click(function(){
			$("#Form").submit();
	})
});
</script>
</head>
<body>
	<form action="studentadd.do" id="Form">
		姓名<input type="text" name="name"><br/><br/>
		年龄<input type="text" name="age"><br/><br/>
		<button type="button" id="butt">提交</button>
	</form>
</body>
</html>