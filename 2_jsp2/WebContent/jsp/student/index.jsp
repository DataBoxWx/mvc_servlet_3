<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.bjpowernode.domain.Student,java.util.*"
    %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>

<%

	List<Student> sList = (List<Student>)request.getAttribute("sList");
	
	String username = (String)session.getAttribute("username");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	td{
		text-align: center;
	}
	
	a{
		text-decoration: none;
	
	}

</style>
<script type="text/javascript">


	function tjxy(){
		
		
		window.location.href = "jsp/student/add.jsp";
		
		
	}

</script>

</head>
<body>
	
	你好:<%=username%>
	
	<hr/>
	
	<h3 align="center">学生信息管理系统</h3>
	
	<table border="0" align="center" width="70%" cellpadding="6" cellspacing="0">
		<tr>
			<td style="text-align: left">
				<button onclick="tjxy()">添加学员</button>
			</td>
		</tr>
	</table>
	
	<table border="1" align="center" width="70%" cellpadding="6" cellspacing="0">
		
		<tr>
			<td>
				序号
			</td>
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
				操作
			</td>
		</tr>
		
		<%
		
			for(int i=0;i<sList.size();i++){
				Student s = sList.get(i);
		%>
				
				<tr>
					<td>
						<%=i+1%>
					</td>
					<td>
						<%=s.getId()%>
					</td>
					<td>
						<%=s.getName()%>
					</td>
					<td>
						<%=s.getAge()%>
					</td>
					<td>
						<a href="student/edit.do?id=<%=s.getId()%>">
							修改
						</a>
						||
						<a href="student/delete.do?id=<%=s.getId()%>">
							删除
						</a>
					</td>
				</tr>
				
		<%	
			}
		
		%>
		
	</table>
	
</body>
</html>



























