<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<%
  		HashMap<String,String> map1 = new HashMap<String,String>();
  		map1.put("tom", "maomao");
  		map1.put("jerry", "shushu");
  		map1.put("carl", "pangzi");
  		map1.put("a b", "aaaaa");
  		map1.put("()", "123");
  		//pageContext.setAttribute("m1", map1);
  		request.setAttribute("m1", map1);
  	
  		LinkedList<String> list = new LinkedList();
  		list.add("adc");
  		list.add("hello");
  		pageContext.setAttribute("list", list);
  		
  		ArrayList<String> arr = new ArrayList();
  		arr.add("123");
  		arr.add("13423");
  		arr.add("1255543");
  		pageContext.setAttribute("arr", arr);
  		
  	%>
  	
  	<%-- el访问Map对象的元素值${map.key }或者${map['key']} --%>
  	${m1['tom']}
  	<br/>
  	${m1["jerry"]}
  	<br/>
  	${m1.carl }
  	<br/>
  	${m1['a b'] } 
  	<%-- ${m1.a b }  当key中有特殊字符，那么就不能使用这个用法 --%>
  	<br/>
  	${m1['()'] }
  	<br/>
  	
  	<%-- 访问Collection对象的元素值${collection[i] } --%>
  	${list[1] }
  	<br/>
  	
  	<%-- 访问数组对象的元素值${array[i] } --%>
  	${arr[2] }
  	
  	
  </body>
  
</html>
