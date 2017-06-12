<%@page import="java.util.HashMap"%>
<%@page import="com.rupeng.test.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set scope="request" var="name" value="rupeng"></c:set>
	<c:set scope="session" var="name" value="baidu"></c:set>   <!-- scope和var是一对 -->
	<%
		Person p1 = new Person();
		request.setAttribute("p",p1);
		
		HashMap<String,String> map = new HashMap();
		session.setAttribute("map1", map);
		
	%>
	
	${requestScope.name }<br/>
	${sessionScope.name }<br/>
	
	<c:set target="${p }" property="name" value="carl" />    <!-- target和property是一对 -->
	${p.name }
	
	<c:set target="${map1}" property="tom" value="1233"></c:set>
	<p>
		${sessionScope.map1.tom }
	</p>
	
	<!-- 
	对于c:set
	（1）scope和var是一对，用来在scope范围中设定名字为var的值
	（2）target和property是一对，原来在通过target的EL表达式获取对象中属性名为property的值
	 -->
	 
	 <p>
	 	${name }
	 </p>
	 <c:remove var="name" scope="request" />
	 <p>
	 	${name }
	 </p>
	 
	 
	 <c:catch var="ex">
		<%
			String s = request.getParameter("name");
			s.toString();
		%>	 
	 </c:catch>
	 
	 异常对象：<c:out value="${pageScope.ex }"></c:out>
	 <br/>
	 异常堆栈：<c:out value="${ex.stackTrace }"></c:out>
	 
	 
</body>
</html>