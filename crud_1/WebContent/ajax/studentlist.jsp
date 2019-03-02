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
		var total = 0;//总数
		var pageCount = 0;//每页数量
		var pageNu = 1;//当前页
		var pageSize = 0;//最大页数
		/* page();
		function page(){ 
			$.post(
				"controller/list.do",
				function(data){
					$(data.slist).each(function(i){
						$("#tbody").append("<tr><td>"+i+"</td><td>"+this.id
								+"</td><td>"+this.name+"</td><td>"+this.age
								+"</td><td><a href='jsp/studentedit.jsp?id="+this.id
								+"'>编辑</a>||<a href='controller/delete.do?id="+this.id
								+"'>删除</a></td></tr>");
					})
				},
				"json"
			)
		} */
		
		$("#addBtn").click(function(){
			location.href="jsp/studentadd.jsp";
		});
		pageList();
		function pageList(){ 
			$("#tbody").html("");
			$.post(
				"controller/list.do",
				{"pageNu":pageNu},
				function(data){
					total = data.pu.total;
					pageNu = data.pu.pageNu;
					pageCount = data.pu.pageCount;
					pageSize = data.pu.pageSize;
					$("#total").html(total);
					$("#pageNu").html(pageNu);
					$("#pageCount").html(pageCount);
					$("#pageSize").html(pageSize);
					 
					$(data.slist).each(function(i){
						$("#tbody").append("<tr><td>"+(i+1)+"</td><td>"+this.id
								+"</td><td>"+this.name+"</td><td>"+this.age
								+"</td><td><a href='jsp/studentedit.jsp?id="+this.id
								+"'>编辑</a>||<a href='controller/delete.do?id="+this.id
								+"'>删除</a></td></tr>");
					}) 
				},
				"json"
			)
		}
		$("#firstPage").click(function(){
			//var pageNo = $("#").val();
			if(pageNu==1){
				return false;
			}else{
				pageNu=1;
				pageList();
			}
		});
		$("#nextPage").click(function(){
			
			if(pageNu==pageSize){
				return false
			}else{
				pageNu++;
				pageList();
			}
		});
		$("#previousPage").click(function(){
			if(pageNu==1){
				return false;
			}else{
				pageNu--;
				pageList();
			}
		});
		$("#lastPage").click(function(){
			if(pageNu == pageSize){
				return false;
			}else{
				pageNu = pageSize;
				pageList();
			}
		});
		
	});
</script>
</head>
<body>
	<h3 align="center">学生信息管理系统</h3>	
	<span style="margin-left: 270px" >欢迎您:${username}&nbsp;&nbsp;&nbsp;&nbsp;
	</span><br/>
	<hr/><br>
	<table align="center" border="1" cellpadding="6" width="60%">
		<thead>
			<tr>
				<td style="text-align: left" colspan="5">
					<button id="addBtn">添加学员</button>&nbsp;&nbsp;
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
		<tbody id="tbody">
			
		</tbody>
	</table>
	<table align="center" border="0">
			<tr>
				<td>
					|共<span id="total"></span>条|&nbsp;&nbsp;&nbsp;&nbsp;
					&<span id="pageCount"></span>条/页&&nbsp;&nbsp;&nbsp;&nbsp;
					|第<span id="pageNu"></span>页|&nbsp;&nbsp;&nbsp;&nbsp;
					&共<span id="pageSize"></span>页&
				</td>
			</tr>
			<tr>
				<td>
					<a id="firstPage" href="javascript:void(0)">首页</a>&nbsp;&nbsp;&nbsp;
					<a id="previousPage" href="javascript:void(0)">上一页</a>&nbsp;&nbsp;&nbsp;
					<a id="nextPage" href="javascript:void(0)">下一页</a>&nbsp;&nbsp;&nbsp;
					
					<a id="lastPage" href="javascript:void(0)">尾页</a>
				</td>
			</tr>
	</table>
</body>
</html>