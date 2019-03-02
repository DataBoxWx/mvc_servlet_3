<%@page import="java.util.*,com.bjpowernode.domain.Students"%>
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
<title>Insert title here</title>
<style type="text/css">
	td{
		text-align: center
	}
	a{
		text-decoration: none
	}
</style>
<script type="text/javascript">
	function tj(){
		window.location.href="jsp/addstudent.jsp";
	}
</script>
</head>
<body>
<%
	List<Students> list = (ArrayList)request.getAttribute("list");
	String user = (String)session.getAttribute("user");
%>
	登录名:<%=user %>
	<br>
	<h2 align="center">学生信息管理系统</h2>
	<table border="1" align="center" width=70% cellpadding="10" cellspacing="0">
		<tr>
			<td style="text-align: left">
			<button onclick="tj()">添加学生</button>
			</td>
		</tr>
	</table>
	<table border="1" align="center" width=70% cellpadding="10" cellspacing="0">
		<tr>
			<td>
			编号
			</td>
			<td>
			姓名
			</td>
			<td>
			年龄
			</td>
			<td>
			性别
			</td>
			<td>
			操作
			</td>
		</tr>
		<%
			for(int i = 0;i < list.size();i++){
				Students stu = list.get(i);
		%>
			<tr>
			<td>
				<%=stu.getId() %>
			</td>
			<td>
				<%=stu.getName() %>
			</td>
			<td>
				<%=stu.getAge() %>
			</td>
			<td>
				<%=stu.getSex() %>
			</td>
			<td>
				<a href="editstudent.do?id=<%=stu.getId() %>">修改</a>
				||
				<a href="deletestudent.do?id=<%=stu.getId() %>">删除</a>
			</td>
		</tr>		
		<%
			}
		%>
	</table>
</body>
</html>