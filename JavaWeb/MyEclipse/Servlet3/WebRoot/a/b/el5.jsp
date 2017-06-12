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
	<img src="/Servlet3/mv.jpg" />
	<img src="<c:url value='/mv.jpg' />" />
	
	<p>
		URL:<c:url value="/mv.jpg" />
	</p>
	
	<a href="<c:url value='/index.jsp' var='fPath' />" >index</a>
	
	<c:out value="${fPath }"></c:out>
	
	<!-- <c:redirect url="/index.jsp"></c:redirect>  重定向 -->
	
</body>
</html>