/**
 * 
 */


//url就是请求的地址
//successFunc就是一个请求返回成功之后的一个function，有一个参数，参数就是服务器返回的报文体
function rpajax(url,successFunc)
{
	var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');//创建XMLHTTP对象，考虑兼容性
	xhr.open("POST",url,true);
	xhr.onreadystatechange = function()
	{
		if(xhr.readyState==4) //服务器返回了
		{
			if(xhr.status==200) //拿到xhr.status http状态码
			{
				successFunc(xhr.responseText);
			}
			else
			{
				alert("服务器返回错误！");
			}
		}
	};
	xhr.send(); //发出请求，并不会等服务器返回send方法才结束，因此我们需要提前监听xhr.onreadystatechange事件，以便得知“服务器返回了”


}
