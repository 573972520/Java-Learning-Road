<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>函数</title>
</head>
<body>
	<c:if test="${fn:contains(name3,name2) }">
		含有<br />
	</c:if> 
	
	<c:if test="${fn:contains(name3,'tor') }">
		yes
	</c:if>
	
	111<c:out value="${fn:trim(name) }"></c:out>222
</body>
</html>