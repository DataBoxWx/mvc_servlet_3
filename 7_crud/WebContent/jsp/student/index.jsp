<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
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
<style type="text/css">

	a{
		
		text-decoration: none;
		
	}

</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		var pageNo = 1;	//当前页页码
		var pageCount = 0; //每页显示多少条记录
		var pageSize = 0;  //一共有多少页
		var total = 0;	//一共有多少条记录
		
		pageList();
		
		function pageList(){
			$("#tBody").html("");
			$.post(
				"student/list.do",
				{"pageNo":pageNo},
				function(data){
					
					pageNo = data.pu.pageNo;
					pageCount = data.pu.pageCount;
					pageSize = data.pu.pageSize;
					total = data.pu.total;
					
					$("#pageNo").html(pageNo);
					$("#pageCount").html(pageCount);
					$("#pageSize").html(pageSize);
					$("#total").html(total);
					
					var i = 1;
					$(data.sList).each(function(){
						
						$("#tBody").append("<tr><td>"+((i++)+(pageNo-1)*pageCount)+"</td><td>"+this.id
								+"</td><td>"+this.name
								+"</td><td>"+this.age
								+"</td><td><a href='jsp/student/edit.jsp?id="+this.id
										+"'>编辑</a>||<a href='student/delete.do?id="+this.id+"'>删除</a></td></tr>"); 
					
					})
					
				},
				"json"
			)
			
			
		}
		
		
		$("#addBtn").click(function(){
			
			window.location.href = "jsp/student/add.jsp";
			
		})
		
		
		
		
		
		$("#firstPage").click(function(){
			
			if(pageNo==1){
				//强制终止方法
				return false;
			}else{
				
				pageNo = 1;
				pageList();
				
			}
		
		})
		
		$("#proPage").click(function(){
			
			if(pageNo==1){
				return false;
			}else{
				
				pageNo--;
				pageList();
				
			}
		
		})
		
		$("#nextPage").click(function(){
			
			if(pageNo==pageSize){
				return false;
			}else{
				
				pageNo++;
				pageList();
				
			}
		
		})
		
		$("#lastPage").click(function(){
			
			if(pageNo==pageSize){
				return false;
			}else{
				
				pageNo = pageSize;
				pageList();
				
			}
		
		})
		
		
	})
		
		

</script>

</head>
<body>
	
	你好:${username}
	
	<hr/>
	
	<h3 align="center">学生信息管理系统</h3>
	
	<table border="0" align="center" width="70%" cellpadding="6" cellspacing="0">
		<tr>
			<td style="text-align: left">
				<button id="addBtn">添加学员</button>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
	<table border="1" align="center" width="70%" cellpadding="6" cellspacing="0">
		
		<thead>
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
		</thead>
		
		<tbody id="tBody">
			
		</tbody>
		
	</table>
	
	<table border="0" align="center" width="70%" cellpadding="6" cellspacing="0">
		<tr>
			<td style="text-align: center;">
				
				共<span id="total"></span>条记录&nbsp;&nbsp;
				共<span id="pageSize"></span>页&nbsp;&nbsp;
				<span id="pageCount"></span>条/页&nbsp;&nbsp;
				当前第<span id="pageNo"></span>页
				
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">
				
				<a href="javascript:void(0)" id="firstPage">首页</a>&nbsp;&nbsp;
				<a href="javascript:void(0)" id="proPage">上一页</a>&nbsp;&nbsp;
				<a href="javascript:void(0)" id="nextPage">下一页</a>&nbsp;&nbsp;
				<a href="javascript:void(0)" id="lastPage">尾页</a>
				
			</td>
		</tr>
	</table>
	
	
</body>
</html>



























