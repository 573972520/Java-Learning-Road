<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
</head>
<body>
	<p><a href="student?action=addnew">新建学生</a></p>
	<table>
		<tr>
			<td>删除</td>
			<td>修改</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>班级</td>
			<td>特长生</td>
			<td>民族</td>
		</tr>
		
		<c:forEach items="${student }" var="t">
			<tr>
				<td><a href="student?action=delete&id=${t.id }">删除</a></td>
				<td><a href="student?action=edit&id=${t.id }">修改</a></td>
				<td><c:out value="${t.name }"></c:out></td>
				<td><c:out value="${t.gender }"></c:out></td>
				<td><c:out value="${t.birthDay}"></c:out></td>
				<td><c:out value="${t.classId}"></c:out></td>
				<td><c:out value="${t.teChangSheng}"></c:out></td>
				<td><c:out value="${t.minZuId}"></c:out></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>