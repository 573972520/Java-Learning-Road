<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师编辑</title>
</head>
<body>
	<form action="teacher" method="post">
		<input type="hidden" name="action" value="editSubmit" />
		<input type="hidden" name="id" value="${teacher.id }" />
		姓名：<input type="text" name="name" value="${teacher.name }" />
		手机号：<input type="text" name="phoneNum" value="${teacher.phoneNum }" />
		生日：<input type="text" name="birthDay" value="${teacher.birthDay}" />
		<input type="submit" value="保存" />
	</form>
</body>
</html>