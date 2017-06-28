<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zf" uri="http://www.zsz.com/functions" %>
<%@taglib prefix="z" uri="http://www.zu.com/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.aaa
	{
		cursor: help;
		border-color: yellow;	
	}
</style>
</head>
<body>

	<c:out value="${fn:length(name) }"></c:out>
	<br/>
	<c:out value="${zf:add(2,8) }"></c:out>
	<br/>
	<c:out value="${zf:contains(strs,name) }"></c:out>
	<c:out value="${zf:contains(list,age) }"></c:out>
	<br />
	<input type="checkbox" id="cbVIP" name="vip" value="isVIP" /><label for="cbVIP">VIP会员</label>
	
	<br />
	<z:checkbox id="cbGender" name="gender" value="${1 }" label="女" />
	<br />
	<z:select items="${persons }" name="stuId" textName="name" valueName="id" id="stuId" selectedValue="${stuId }" attributes="style='color:red;' class='aaa' " />
	
	
</body>
</html>