<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	//刷新验证码
	var refreshYZM  = function()
	{
		$("#imgYZM").attr("src","login?action=yzm&a="+Math.random());
	};
	
	//写Ajax程序的时候的顺序：请求——处理——响应
	var loginSubmitSuccess = function(data)
	{
		if(data.errorCode == "yzmError")
		{
			$("#msg").text("验证码错误");
			refreshYZM();
		}
		else if(data.errorCode == "userNotFound")
		{
			$("#msg").text("用户名不存在");
			refreshYZM();
		}
		else if(data.errorCode == "passwordError")
		{
			$("#msg").text("密码错误");
			refreshYZM();
		}
		else if(data.errorCode == "ok")
		{
			$("#msg").text("登录成功");
			location.href='index.jsp'; //todo
		}
		
	};
	
	$(function(){
		refreshYZM();//进入页面的时候也刷新下验证码，防止有的浏览器可能会有缓存
		
		/* 	$("#imgYZM").click(function(){
			refreshYZM();
		}); */
		
		$("#imgYZM").click(refreshYZM);
		
		$("#btnLogin").click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			var yzm = $("#yzm").val();
			//todo:三个文本框必填
			$.ajax({
					type:"POST",
					dataType:"json",
					url:"login",
					data:{action:"loginSubmit",username:username,password:password,yzm:yzm},
					success:loginSubmitSuccess,
					error:function(){alert("error");}
			});
		});
	});
</script>
</head>
<body>
		用户名：<input type="text" id="username" /><br/>
		密码：<input type="password" id="password" /><br/>
		验证码：<input type="text" id="yzm" /><img src="login?action=yzm" id="imgYZM" /><br/>
		<input type="button" id="btnLogin" value="登录"/>
		<span id="msg"></span>
</body>
</html>