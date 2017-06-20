<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传</title>
<script type="text/javascript">
	window.onload = function()
	{
		/*document.getElementById("btn1").click=function(){
			document.getElementById("f1").value="";
		};*/
		
		//document.getElementById("f1").value="d:/1.txt"; //基于安全考虑，不允许通过程序来给type="file"赋值文件路径
	};
</script>
</head>
<body>
	<form action="upload1" method="post" enctype="multipart/form-data">
		<input type="hidden" name="action" value="uploadSubmit" />
		<input type="file" name="f1" id="f1"/> <br />
		<input type="file" name="f2" id="f2"/>
		<input type="submit" value="上传" />	
		<input type="button" value="清空" id="btn1" />	
	</form>
</body>
</html>