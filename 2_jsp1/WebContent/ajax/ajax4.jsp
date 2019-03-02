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
<style type="text/css">
	td{
		text-align: center
	}
</style>
<script type="text/javascript">
	$(function(){	
		$("#btn").click(function(){
			$("#tbody").html("");
			$.post(
				"myservlet4.do",
				function(data){
					$(data.list).each(function(i){
						$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+this.id
							+"</td><td>"+this.name
							+"</td><td>"+this.age
							+"</td><td>编辑||删除</td></tr>");
						
					})
				},
				"json"
			)
		})
	});
</script>
</head>
<body>
	<button id="btn">点我</button><br><hr><br/>
	<table align="center" width="70%" border="1" cellpadding="6">
		<thead>
			<tr>
				<td>
					编号
				</td>
				<td>
					ID
				</td>
				<td>
					姓名
				</td>
				<td>
					年龄
				</td>
				<td>
					操作
				</td>
			</tr>
		</thead>
		<tbody id="tbody"></tbody>	
	</table>
</body>
</html>