<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="user" method="post">
		<input type="hidden" name="action" value="loginSubmit" />
		<table>
			<tr><td>用户名:</td><td><input type="text" name="username" /></td></tr>
			<tr><td>密码:</td><td><input type="password" name="password" /></td></tr>
			<tr><td>验证码:</td><td><input type="text" name="yzm"/><img src="yzm"/></td></tr>
			<tr><td><input type="submit" value="登录" /></td><td><a href="user?action=register">注册</a></td></td></tr>
		</table>
	</form>
</body>
</html>