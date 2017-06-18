<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.onload = function()
	{
		var add = document.getElementById("add");
		add.onclick = function()
		{
			var i = document.getElementById("i").value;			
			var j = document.getElementById("j").value;			
			var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');//创建XMLHTTP对象，考虑兼容性
			
			//XHR对象执行，发出Http请求，页面不用刷新
			xhr.open("POST","ajax1?action=add&i="+i+"&j="+j,true);
			xhr.onreadystatechange = function()
			{
				//alert("onreadystatechange,readyState="+xhr.readyState);
				if(xhr.readyState == 4) //服务器返回了
				{
					if(xhr.status == 200) //拿到xhr.status http状态码
					{
						//alert(xhr.responseText); //xhr.responseText返回的报文体
						document.getElementById("result").innerText = xhr.responseText;
						//根据服务器返回的内容更新需要更新的内容
					}
					else
					{
						alert("服务器返回错误！");
					}
				}
			};
			alert("send之前");
			xhr.send(); //发出请求，并不会等服务器返回send方法才结束，因此我们需要提前监听xhr.onreadystatechange事件，以便得知“服务器返回了”
			
			alert("send之后");
		};
	};
</script>
</head>
<body>
	<input type="text" id="i" />+<input type="text" id="j" />
	<input type="button" id="add" value="=" /><span id="result"></span>
	
</body>
</html>