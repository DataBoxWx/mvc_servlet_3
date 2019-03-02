<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		text-align: center;
	}
	
	a{
		text-decoration: none;
	
	}
	
	.ghbs{
		background-color: #F7F7F7;
	}
	
</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#tBody>tr:even").addClass("ghbs");
		
		$("#addBtn").click(function(){
			
			window.location.href = "jsp/student/add.jsp";
			
		})
		
		$("#editBtn").click(function(){
			
			//student/edit.do?id=${s.id} 
			
			var $xz = $("input[name='xz']:checked");
			
			//alert($xz.length);
			if($xz.length==0){
				alert("请选择需要编辑的记录");
			}else if($xz.length>1){
				alert("只能选中一条记录进行编辑");
			
			
			//只有一条
			}else{
				
				//alert("可以操作了");
				//取得id值
				//相当于取得选中这一条的复选框的value值
				
				/*
					
					针对具有value属性的取值和赋值操作(经常用做表单元素) 
					相当于原生js中的 document.getElementById().value
					val():取值
					val(值):赋值
					
					针对于标签对中的内容的取值和赋值
					相当于原生js中的 document.getElementById().innerHTML
					html():取值
					html(值):赋值
				
				*/
				
				/*
					取值方式1
					虽然是复选框,但是在else里,我们能保证只选中了一条,所以我们可以直接取值
				*/
				
				//var id = $xz.val();
				//alert(id);
				
				//取值方式2 jquery对象转换为js对象(dom)
				//var id = $xz[0].value;
				//alert(id);
				
				//取值方式3 js对象(dom)转换为jquery对象  $(dom)
				var id = $($xz[0]).val();
				
				window.location.href = "student/edit.do?id="+id;
				
			}
			
			
		
		})
		
		
		$("#deleteBtn").click(function(){
				
			var $xz = $("input[name='xz']:checked");
			
			if($xz.length==0){
				alert("请选择需要删除的记录");
			
			//一条或多条
			}else{
				
				//alert("可以删除了"); 
				//student/delete.do?id=${s.id}${s.id}
				
				//var id = $xz.val();
				//window.location.href = "student/delete.do?id="+id;
				
				//student/deletes.do?id=A0001&id=A0002&id=A0003
				
				if(confirm("您确定删除所选记录吗?")){
					
					var path = "student/deletes.do?";
					
					for(var i=0;i<$xz.length;i++){
						
						path += "id="+$($xz[i]).val();
						
						if(i<$xz.length-1){
							path += "&";
						}
						
					}
					
					window.location.href = path;
					
				}		
				
				
				
			}
			
		})
		
		$("#qx").click(function(){
			
			var $xz = $("input[name='xz']");
			
			if($("#qx")[0].checked){
				
				for(var i=0;i<$xz.length;i++){
					
					$xz[i].checked = true;
					
				}
				
			}else{
				
				for(var i=0;i<$xz.length;i++){
					
					$xz[i].checked = false;
					
				}
				
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
				<button id="editBtn">编辑学员</button>&nbsp;&nbsp;
				<button id="deleteBtn">删除学员</button>&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
	<table border="1" align="center" width="70%" cellpadding="6" cellspacing="0">
		
		<thead>
			<tr>
				<td>
					<input type="checkbox" id="qx"/>
				</td>
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
		<c:if test="${empty sList}">
			<tr>
				<td colspan="6">
					没有相关的记录
				</td>
			</tr>
		</c:if>
		<tbody id="tBody">
			<c:if test="${!empty sList}">
				<c:forEach items="${sList}" var="s" varStatus="vs">
					
					<tr>
						<td>
							<input type="checkbox" name="xz" value="${s.id}"/>
						</td>
						<td>
							${vs.count}
						</td>
						<td>
							${s.id}
						</td>
						<td>
							${s.name}
						</td>
						<td>
							${s.age}
						</td>
						<td>
							<a href="student/edit.do?id=${s.id}">
								编辑
							</a>
							||
							<a href="student/delete.do?id=${s.id}">
								删除
							</a>
						</td>
					</tr>
					
				</c:forEach>
			</c:if>
		</tbody>
		
	</table>
	
</body>
</html>



























