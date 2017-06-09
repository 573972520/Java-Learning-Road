<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.rupeng.test.Person"%> <!-- 导入Person类 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员列表</title>
</head>
<body>
<p>
	<a href="person?action=addnew" >新增</a>
</p>
<table>
	<thead>
		<tr><td>Id</td><td>姓名</td><td>年龄</td><td>编辑</td><td>删除</td></tr>
	</thead>
	<tbody>
		<%
			List<Person> persons = (List<Person>)request.getAttribute("persons");
			for(Person person : persons)
			{
			%>	
			<tr><td><%=person.getId() %></td><td><%=person.getName() %></td><td><%=person.getAge() %></td>
			<td><a href="person?action=edit&id=<%=person.getId() %>">编辑</a></td>
			<td><a onclick="return confirm('确认要删除吗?')" href="person?action=delete&id=<%=person.getId() %>">删除</a></td></tr>
			<% }%>
	</tbody>
</table>
</body>
</html>