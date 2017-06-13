<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生编辑</title>
</head>
<body>
	<form action="student" method="post">
		<input type="hidden" name="action" value="editSubmit" />
		<input type="hidden" name="id" value="${student.id }" />
		<table>
			<tr><td>姓名：</td><td><input type="text" name="name" value="<c:out value='${student.name }'></c:out>"/></td></tr>
			<tr>
				<td>性别：</td>
				<td>
					<%-- <select name="gender">
						<option value="male" ${student.gender?'selected':'' }>男</option>
						<option value="female" >女</option>
					</select> --%>
					<select name="gender">
						<option value="male"  ${student.gender?'selected':'' }>男</option>
						<option value="female" ${student.gender?'':'selected' }>女</option>
					</select>
				</td>
			</tr>
			<tr><td>出生日期：</td><td><input type="text" name="birthDay" value="${student.birthDay }"/></td></tr>
			<tr><td>教室：</td>
				<td>
					<select name="classId">
						<c:forEach items="${requestScope.minzus }" var="classId">
							<option value="${classId.id }" ${student.classId eq classId.id?'selected':'' }>${classId.name }</option>
						</c:forEach>
					</select>
					<input type="text" name="classId" value="${student.classId }"/>
				</td>
			</tr>
			<tr><td>特长生：</td>
			<td>
			<input type="checkbox" name="teChangSheng" id="teChangSheng" value="${student.teChangSheng }"/>
			<%-- <input type="text" name="teChangSheng" value="${student.teChangSheng }"/> --%>
			</td></tr>
			<tr><td>民族：</td>
				<td>
					<select name="minZuId">
						<c:forEach items="${requestScope.minzus }" var="minzu">
							<option value="${minzu.id }" ${student.minZuId eq minzu.id?'selected':'' }>${minzu.name }</option>
						</c:forEach>
					</select>
				</td></tr>
		</table>
		<%-- 姓名：<input type="text" name="name" value="${student.name }"/>
		性别：<input type="text" name="gender" value="${student.gender }"/>
		生日：<input type="text" name="birthDay" value="${student.birthDay }"/>
		教室：<input type="text" name="classId" value="${student.classId }"/>
		特长生：<input type="text" name="teChangSheng" value="${student.teChangSheng }"/>
		民族：<input type="text" name="minZuId" value="${student.minZuId }"/> --%>
		<input type="submit" value="保存" />
	</form>
</body>
</html>