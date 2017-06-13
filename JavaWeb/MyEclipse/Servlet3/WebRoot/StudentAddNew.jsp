<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student" method="post">
		<input type="hidden" name="action" value="addnewSubmit"/>
		<table>
			<tr>
				<td>姓名：</td><td><input type="text" name="name" /></td>
				<td>性别：</td>
				<td>
					<select name="gender">
						<option value="male">男</option>
						<option value="female">女</option>
					</select>
				</td>
				<td>生日：</td><td><input type="text" name="birthDay" /></td>
				<td>教室：</td><td><input type="text" name="classId" /></td>
				<td>特长生：</td><td><input type="checkbox" name="teChangSheng" id="teChangSheng" /></td>
				<td>民族：</td>
				<td>
					<select name="minZuId">
						<c:forEach items="${requestScope.minzus }" var="minzu">
							<option value="${minzu.id }" >${minzu.name }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="保存" />
		
	</form>
</body>
</html>