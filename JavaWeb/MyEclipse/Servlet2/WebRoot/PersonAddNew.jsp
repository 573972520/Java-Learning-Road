<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增人员</title>
</head>
<body>
	<form action="person" method="post">
		<input type="hidden" name="action" value="addnewSubmit" />
		姓名：<input type="text" name="name" />
		年龄：<input type="text" name="age" />
		<input type="submit" value="保存" />
	</form>
</body>
</html>