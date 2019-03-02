<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function jd() {
		
		
		//1.创建核心对象
		/*
			xmlhttp:实现ajax技术的核心对象
		*/		
		var xmlhttp;
		//创建xmlhttp对象的流程
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		//2.创建回调函数
		/*
			xmlhttp.onreadystatechange:
				表示创建ajax的回调函数
				指的是该函数的函数体是在执行完后台(servlet)之后,才执行的
		*/
		xmlhttp.onreadystatechange = function() {
			/*
				回调函数的执行条件
				xmlhttp.readyState:表示得到请求状态码 ,码值为4,表示请求成功
				xmlhttp.status:表示得到响应的状态码,码值为200,表示响应成功
				所以,只有当请求成功并且响应成功之后,才执行该函数体
			*/
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				//xmlhttp.responseText:得到后台传递回来的返回值 后台怎么做返回值操作  out.print(值)
				var data = xmlhttp.responseText;
				document.getElementById("msg").innerHTML = data;
			}
		}
		
		
		//3.设置请求信息
		/*
			xmlhttp.open:表示设置发送请求的基本信息
			参数1:设置请求方式 GET/POST
			参数2:设置请求路径
			参数3:设置同步还是异步请求
				true:异步请求
				我们的ajax请求和下面的alert彼此之间不互相影响
				两根线程,一根负责执行ajax,一根执行alert操作
				
				false:同步请求
				必须在上面的代码执行完毕之后,再执行下面的代码
				ajax执行完毕后,才执行下面的alert操作
				一根线程,依次执行
				
				在实际项目开发中,我们使用异步操作比较多,在特殊需求下,我们也会使用到同步操作
				
				
		*/
		xmlhttp.open("post", "myServlet1.do", false);
		
		//该代码在open方法和send方法中间
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//4.发送请求
		//发送请求
		xmlhttp.send("str1=张三&str2=ddd");
		
		//alert(123);

	}
</script>
</head>
<body>

	<button onclick="jd()">点击</button>

	<!-- <br />
	<br />

	<div style="width: 200px; height: 200px; background-color: pink">
		asdfasdfasdf<br /> asdasdfasdf<br />
	</div> -->

	<br />
	<br />

	<div id="msg" style="width: 200px; height: 200px; background-color: pink">
	
	</div>


</body>
</html>





























