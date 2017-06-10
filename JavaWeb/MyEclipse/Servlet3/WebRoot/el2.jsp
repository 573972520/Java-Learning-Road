<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${5 div 3}<br/>
	${5 gt 3 }<br/>  
	<!-- 
	（1）gt:greater than   大于    
	（2）ge:greater equal  大于等于  
	（3）lt:less than      小于  
	（4）le:less equle    小于等于  
	（5）eq:equle         等于   
	（6）ne:not equle      不等于
	  --> 
	<%
		request.setAttribute("age", 18);
	%>	
	${age eq 9 }
	<br/>
	
	<sapn style="color:${age >10?'red':'green'}">我的年龄是${age }</sapn>
</body>
</html>