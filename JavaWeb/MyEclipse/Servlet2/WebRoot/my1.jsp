<%@page import="com.rupeng.test.JdbcUtils"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"
    %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1 titl1e1 1h1e1r1e</title>
</head>
<body>
<%-- 
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
	 --%>
	 <%
	 out.append("111");
	 response.getWriter().write("222");
	 out.println("<br/>");
	 
	 request.setAttribute("a1", "requestabc");
	 String v1 = (String)request.getAttribute("a1");
	 out.println(v1+"<br/>");
	 
	 pageContext.setAttribute("a2", "pageContextabc");
	 pageContext.setAttribute("a1", "pageContextabc");
	 String v2 = (String)pageContext.getAttribute("a2");
	 out.println(v2+"<br/>");
	 
	 
	 session.setAttribute("a3", "sessionabc");
	 String v3 = (String)session.getAttribute("a3");
	 out.println(v3+"<br/>");
	 
	 out.println("1:" + pageContext.findAttribute("a2")+"<br/>");
	 out.println("2:" + pageContext.findAttribute("a1")+"<br/>");//这里的a1在pageContext里有，所以直接使用这个
	 out.println("3:" + pageContext.findAttribute("a3")+"<br/>");
	 //pageContext.findAttribute依次从pageContext , request , session , application
	 //四个web域中查找name属性的值

	 
	 /* String s = null;
	 s.toCharArray();
	 JdbcUtils.executeQuery("select * from aaa"); */
	 %>
	<!--  是服务器内部把Error.jsp显示出来的，浏览器是不知道的 -->
	 
	 
	 <!-- 
	 1、防止系统中的内部信息通过报错泄露给访问者
	 2、展示友好的报错页面，避免用户恐慌
	 3、有机会把程序中没有处理的异常记录下来，方便程序员排查错误
	  -->
	 
</body>
</html>