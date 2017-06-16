<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
	window.onload = function()
	{
		document.getElementById("submit").onclick = function()
		{
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var password2 = document.getElementById("password2").value;
			var yzm = document.getElementById("yzm").value;
			if(username == "")
			{
				alert("用户名必填！");
				return false;
			}	
			if(password == "")
			{
				alert("密码必填！");
				return false;
			}
			if(password != password2)
			{
				alert("两次输入的密码不一致！");
				return false;
			}
			if(yzm == "")
			{
				alert("验证码必填！");
				return false;
			}
		};
		document.getElementById("imgYzm").onclick = function()
		{
			this.src = "yzm?"+Math.random();   //如果鼠标点击过快，可以瞬间显示新的验证码
			//this.src = "yzm?t="+new Date();  //如果鼠标点击过快，则瞬间显示新的验证码
			//alert(this.src);
		};
	}
</script>
</head>
<body>
	<form action="user" method="post">
		<input type="hidden" name="action" value="registerSubmit" />
		<table>
			<tr><td>用户名:</td><td><input id="username" type="text" name="username" /></td></tr>
			<tr><td>密码:</td><td><input id="password" type="password" name="password" /></td></tr>
			<tr><td>重复密码:</td><td><input id="password2" type="password" name="password2" /></td></tr>
			<tr><td>验证码:</td><td><input id="yzm" type="text" name="yzm" /><img id="imgYzm" src="yzm"/></td></tr>
			<tr><td><input type="submit" id="submit" value="注册" /></td></tr>
		</table>
	</form>
</body>
</html>