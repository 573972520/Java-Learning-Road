<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.rupeng.test.Person"%>
<%@page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${age ge 18 }" var="isCNR">
		我们都是成年人了
	</c:if>
	<br/>
	<c:out value="${isCNR }"></c:out>
	
	<c:if test="${nickName eq null }">
		没有昵称
	</c:if>
	<br/>
	<c:if test="${empty nickName }">
		没有昵称
	</c:if>
	<br/>
	<c:if test="${not empty nickName }">
		我的昵称是:<c:out value="${nickName }" />
	</c:if>	
	<br/>
	<c:out value="${names[1] }"></c:out>
	<c:if test="${empty names }">
		names为空
	</c:if>
	
	<c:if test="${empty names2 }">
		names2为空
	</c:if>
	
	<c:choose>
		<c:when test="${age lt 18 }">
			未成年人
		</c:when>
		<c:when test="${age lt 50 }">
			青年人
		</c:when>
		<c:otherwise>
			老年人
		</c:otherwise>
	</c:choose>
	
	
	<img src="mv.jpg" />
</body>
</html>