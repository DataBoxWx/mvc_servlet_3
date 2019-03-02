<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.bjpowernode.domain.Student,java.util.*"
    %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		 
		/*
			创建5个学生
			将5个学生存放到list中
			通过table表格来显示学生
		*/
		
		Student s1 = new Student("A0001","zs",23);
		Student s2 = new Student("A0002","ls",24);
		Student s3 = new Student("A0003","ww",25);
		Student s4 = new Student("A0004","zl",26);
		Student s5 = new Student("A0005","sq",27);
		
		List<Student> sList = new ArrayList<Student>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		
	%>
	
	<table border="1">
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
				//取得每一个学生
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
						修改||删除
					</td>
				</tr>
		
		
		<%
			}
		
		%>
		
	</table>
	
	
</body>
</html>























