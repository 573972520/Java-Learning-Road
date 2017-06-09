<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1 titl1e1 1h1e1r1e</title>
</head>
<body>
	helloz中国飞人
	<%
		int a = 5;
		System.out.println(a);
		String name = request.getParameter("name");
		System.out.println(name);
		out.println("name is" + name);
		session.getId();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		fis.toString();
	%>
	<br/>
	<%=name %>
	<br/>
	<%=1+2+3+5 %>
</body>
</html>