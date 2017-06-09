<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
对不起，系统出错了，我们已将错误信息发送给管理员
<%
	FileOutputStream fos = new FileOutputStream("F:/Programming/Code/JavaDay/JavaWeb/MyEclipse/Servlet2/error.txt");
	OutputStreamWriter osw = new OutputStreamWriter(fos);
	BufferedWriter bf = new BufferedWriter(osw);
	bf.write(exception.toString());
	bf.close();
	osw.close();
	fos.close();
%>
</body>
</html>