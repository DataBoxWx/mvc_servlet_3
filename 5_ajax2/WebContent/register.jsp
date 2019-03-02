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
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		
		$("#usernameId").blur(function(){
			
			//取得账号
			var username = $("#usernameId").val();
			
			$.post(
				"checkUsername.do",
				//"username="+username,
				//"str1=aaa&str2=bbb&str3=ccc"
				//{"str1":"aaa","str2":"bbb","str3":"ccc"}
				{"username":username},
				function(data){
					
					if(data=="a"){
						
						$("#msg").html("<font color='green'>用户名可用</font>");
						
					}else{
						
						$("#msg").html("<font color='red'>用户名重复</font>");
						
					}
					
				},
				"text"
			)
			
		
		})
		
	
	})
	
</script>
</head>
<body>

	<h3>我是注册页</h3>
	<form action="" method="post">
		请输入账号:<input type="text" name="username" id="usernameId"/>
		<span id="msg"></span>
		<br/><br/>
		请输入密码:<input type="text" name="password" id="passwordId"/><br/><br/>
		<input type="submit" value="提交"/>
	</form>
	
</body>
</html>