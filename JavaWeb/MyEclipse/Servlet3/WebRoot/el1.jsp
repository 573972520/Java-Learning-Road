<%@page import="com.rupeng.test.Dog"%>
<%@page import="javax.print.Doc"%>
<%@page import="com.rupeng.test.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Person p1 = new Person();
		p1.setName("tom");
		p1.setId(3);
		p1.setAge(33);

		Dog d1 = new Dog();
		d1.setId(1);
		d1.setName("wangcai");
		d1.setMaster(p1);
		d1.setBirthDay("2016-10-10");
		pageContext.setAttribute("wangcai", d1);
		
		pageContext.setAttribute("test", "hello1");
		request.setAttribute("test", "hello2");
		session.setAttribute("test", "hello3");
		application.setAttribute("test", "hello4");
/* 		对于pageScope , requestScope,sessionScope,applicationScope 这四个map对象 ,
		有一个统一简单的访问方式${key},el会依次访问这四个map对象直到找到key对应的value */

		%>
		
		name:${param.name }
		<br/>
		UserAgent:${header["User-Agent"] }
		<br/>
		${test }  <!-- 根据顺序取值 -->
		<br/>
		${sessionScope.test }  <!-- 强制取session的值 -->
		<br/>
		${applicationScope.test }
		<br/>
		${requestScope.test }
		<br/>
		
		
		${wangcai.name }
		<br/>
		${wangcai.id }
		<br/>
		${wangcai.birthDay }
		<br/>
		${wangcai.master.name } <!-- wangcai对象的master属性的name属性 -->
		
		
</body>
</html>