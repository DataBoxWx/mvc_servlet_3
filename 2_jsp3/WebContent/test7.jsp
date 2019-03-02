<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	
	<%-- <c:if test="${5>3}">
		5大于3
	</c:if>
	
	<c:if test="${5<=3}">
		5小于等于3
	</c:if> --%>
	
	
	<!-- 
		items:要遍历的集合
				注意:要搭配el表达式取得域中的集合
		var:表示每一次遍历出来的变量
				在使用s的时候,一定要将s放到el表达式中
		begin:表示设置取值的开始下标
		end:表示设置取值的结尾下标
		step:表示取值的步长
		varStatus:表示当前变量的状态
				我们在实际项目开发中应用到这个状态的一个属性 count,表示取得序号
				必须搭配el表达式来使用
	 -->
	<%-- <c:forEach items="${sList}" var="s" varStatus="vs">
		
		${vs.count}--------${s}<br/>
		
	</c:forEach> --%>
	
	
	<c:set var="count" value="4"/><!-- 相当于 pageContext.setAttribute("count",4)  -->
	<c:choose>
		<c:when test="${count==1}">
			计数1
		</c:when>
		<c:when test="${count==2}">
			计数2
		</c:when>
		<c:when test="${count==3}">
			计数3
		</c:when>
		<c:otherwise>
			不在范围内
		</c:otherwise>
	</c:choose>
	

</body>
</html>






















