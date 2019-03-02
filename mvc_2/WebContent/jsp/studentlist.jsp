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
	td{text-align: center}
</style>
<script type="text/javascript">
	$(function(){
		var pageCount = 0;//总条数
		var pageNum = 1; //当前页
		var pageSize = 0;//几条/页
		var pageSum=0;//总页数
		var count = 3;//设置每页显示数量
/* 		stuList();
		function stuList(){
			$("#tbody").html("");
			$.post(
				"student/list.do",		
				function(data){
					$(data.slist).each(function(i){
						$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+this.id
								+"</td><td>"+this.name+"</td><td>"+this.age
								+"</td><td><a href='jsp/studentEdit.jsp?id="+this.id
										+"'>编辑</a>||<a href='student/delete.do?id="+this.id
										+"'>删除</a></td></tr>");
						
					})
				},
				"json"
			)
		} */
		$("#addBtn").click(function(){
			window.location.href="jsp/studentAdd.jsp";
		})
		pageList();
		function pageList(){
			$("#tbody").html("");
			$.post(
				"student/list.do",	
				{"pageNum":pageNum,"count":count},
				function(data){
					pageCount = data.pu.pageCount;
					pageNum = data.pu.pageNum;
					pageSize = data.pu.pageSize;
					pageSum = data.pu.pageSum;
					$("#pageCount").html(pageCount);
					$("#pageNum").html(pageNum);
					$("#pageSize").html(pageSize);
					$("#pageSum").html(pageSum);
					
					$(data.slist).each(function(i){
						$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+this.id
								+"</td><td>"+this.name+"</td><td>"+this.age
								+"</td><td><a href='jsp/studentEdit.jsp?id="+this.id
										+"'>编辑</a>||<a href='student/delete.do?id="+this.id
										+"'>删除</a></td></tr>");
						
					})
				},
				"json"
			)
		}
		$("#firstPage").click(function(){
			if(pageNum==1){
				return false;
			}else{
				pageNum=1;
				pageList();
			}
		})
			$("#proviewsPage").click(function(){
			if(pageNum==1){
				return false;
			}else{
				pageNum -= 1;
				pageList();
			}
		})
			$("#nextPage").click(function(){
			if(pageNum==pageSum){
				return false;
			}else{
				pageNum += 1;
				pageList();
			}
		})
			$("#lastPage").click(function(){
			if(pageNum==pageSum){
				return false;
			}else{
				pageNum=pageSum;
				pageList();
			}
		})
		$("#count").change(function(){
			count = $("#count").val();
			pageList();
		})
		
	})
</script>

</head>
<body>
	<h3 align="center">学生信息管理系统</h3><br/>
	<div style="margin-left: 300px">欢迎您：${username}</div><hr>
	<table border="1" align="center" width="60%" cellpadding="8">
		<thead>
			<tr>
				<td style="text-align: left" colspan="5">
					<button id="addBtn">添加学员</button>
				</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>ID</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id ="tbody">
		
		</tbody>
	</table>
	<table border="1" align="center" width="60%" cellpadding="8">
		<tr>
			<td>
				<select id="count">
					<option>2</option>
					<option selected>3</option>
					<option>4</option>
					<option>5</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&共<span id="pageCount"></span>条&&nbsp;&nbsp;&nbsp;&nbsp;
				&第<span id="pageNum"></span>页&&nbsp;&nbsp;&nbsp;&nbsp;
				  &<span id="pageSize"></span>条&&nbsp;&nbsp;&nbsp;&nbsp;
				&共<span id="pageSum"></span>页&
				
			</td>
		</tr>
		<tr>
			<td>
				<a href="javascript:viod(0)" id="fristPage">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:viod(0)" id="proviewsPage">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:viod(0)" id="nextPage">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:viod(0)" id="lastPage">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>