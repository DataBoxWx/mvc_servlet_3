<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
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
	h3{
		text-align: center
	}
	a{
		text-decoration: none
	}
	.ys{
		background-color: aqua;
	}
	button{
		background-color: lime
	}
	div{
		color: fuchsia
	}
</style>
<script type="text/javascript">
	$(function(){
		//添加学生操作
		$("#addBtn").click(function(){
			location.href="jsp/studentadd.jsp";
		});
		//修改学生操作
		$("#editBtn").click(function(){
			var ch = $("input[name='check']:checked")
			if(ch.length==0){
				alert("请选择一条记录");
			}else if(ch.length == 1){
				location.href="student/edit.do?id="+$("input[name='check']").val();
			}else{
				alert("只能选择一条记录");
			}
		})
		//删除学生操作
		$("#delBtn").click(function(){
			var ch = $("input[name='check']:checked");
			if(ch.length==0){
				alert("请选择至少一条记录");
			}else{
				var path = "student/deletes.do?"
				for(var i =0;i <ch.length;i++){
					path += "id=" + ch[i].value;
					if(i < ch.length -1){
						path += "&";
					}
				}
				location.href=path;
			}
		});
		$("#topc").click(function(){
			var $ch = $("input[name='check']");
			if($("#topc")[0].checked ==true){
				for(var i = 0;i< $ch.length;i++){
					$ch[i].checked=true;
				}
			}else{
				for(var i = 0;i< $ch.length;i++){
					$ch[i].checked=false;
				}
			}
		});
		//隔行变色
		$("#t>tr:even").addClass("ys");
		//前往controller2
		$("#tz").click(function(){
			location.href="ajax/studentlist.jsp";
		})
	});
</script>
</head>
<body>
	<h3>学生信息管理系统</h3>	
	<div style="margin-left: 270px" >欢迎您:${username}</div><br/>
	<hr/><br>
	<table align="center" border="1" cellpadding="6" width="60%">
		<thead>
			<tr>
				<td colspan="6" style="text-align:left">
					<button id="addBtn">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="editBtn">编辑</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="delBtn">删除</button>&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="qx" id="topc"></td>
				<td>编号</td>
				<td>ID</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id="t">
			 <b:forEach items="${list}" var="stu" varStatus="count">
				<tr>
					<td><input type="checkbox" name="check" value="${stu.id}"></td>
					<td>${count.count}</td>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.age}</td>
					<td><a href="student/edit.do?id=${stu.id}">编辑</a>
							||
						<a href="student/delete.do?id=${stu.id}">删除</a>
					</td>
				</tr>
			</b:forEach> 
		</tbody>
	
	</table>
	<button id="tz">点击前往controller2</button>
</body>
</html>