<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
</head>
<body>
	<p><a href="teacher?action=addnew">新建教师</a></p>
	<table>
		<tr>
			<td>删除</td>
			<td>修改</td>
			<td>姓名</td>
			<td>手机号</td>
			<td>生日</td>
		</tr>
		
		<c:forEach items="${teachers }" var="t">
			<tr>
				<td><a href="teacher?action=delete&id=${t.id }">删除</a></td>
				<td><a href="teacher?action=edit&id=${t.id }">修改</a></td>
				<td><c:out value="${t.name }"></c:out></td>
				<td><c:out value="${t.phoneNum }"></c:out></td>
				<td><c:out value="${t.birthDay}"></c:out></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>