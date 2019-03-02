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
			
			$("#pid").html("<option>-- 请选择 --</option>");
			
			$.post(
				"province/list.do",
				function(data){
					
					$(data.pList).each(function(){
						
						$("#pid").append("<option value='"+this.id+"'>"+this.name+"</option>");
					
					})
					
				},
				"json"
			)
		
		})
		
		$("#pid").change(function(){
			
			$("#cid").html("<option>-- 请选择 --</option>");
			
			var pid = $("#pid").val();
			
			$.post(
				"city/list.do",
				{"pid":pid},
				function(data){
					
					$(data.cList).each(function(){
					
						$("#cid").append("<option value='"+this.id+"'>"+this.name+"</option>");
					
					})
					
				},
				"json"
			)
			
		})
		
	
	})
	
</script>
</head>
<body>

	<button id="djBtn">点击</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	
	<select id="pid">
		<option>-- 请选择 --</option>
	</select>
	
	&nbsp;&nbsp;

	<select id="cid">
		<option>-- 请选择 --</option>
	</select>

</body>
</html>





