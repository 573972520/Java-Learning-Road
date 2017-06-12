<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:out value="${name }"></c:out>
	<p>${name }</p>
	<p><c:out value="${nickname }" default="${age }"></c:out></p>
	<p><c:out value="${requestScope.age }"></c:out></p>
	
	<table>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>age</td>
		</tr>
		
		<c:forEach items="${person }" var="p">
			<tr style="color:${p.age gt 18?'red':'black'}">
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>