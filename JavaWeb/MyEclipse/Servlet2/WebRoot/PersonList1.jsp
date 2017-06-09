<%@page import="java.sql.ResultSet"%>
<%@page import="com.rupeng.test.JdbcUtils"%>
<%@page import="javax.sql.rowset.JdbcRowSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员列表</title>
</head>
<body>
<table>
<thead>
	<tr><td>Id</td><td>姓名</td><td>年龄</td></tr>
</thead>
<tbody>
	<%
		ResultSet rs = JdbcUtils.executeQuery("select * from t_persons");
		while(rs.next())
		{
			int id = rs.getInt("Id");
			String name = rs.getString("name");
			int age = rs.getInt("Age");
			//out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td></tr>");
			%>
			<tr><td><%=id %></td><td><%=name %></td><td><%=age %></td></tr><!-- //该段代码在尖括号之外，尖括号里面写Java代码 -->
			<%
		}
	%>	
</tbody>
</table>
</body>
</html>