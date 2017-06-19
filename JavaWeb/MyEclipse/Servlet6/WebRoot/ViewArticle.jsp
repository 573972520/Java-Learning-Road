<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${model.title }"/></title>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	
	var loadCommentSuccess = function(obj)
	{
		$("#ulComments").html("");  //移除旧的评论
		for(var i = 0;i<obj.data.length;i++)
		{
			var comment = obj.data[i];
			$("#ulComments").append($("<li>"+comment.postDataTime+":"+comment.content+"</li>"));
		}
	};
	
	var loadComment = function()
	{
		var aId = ${model.id};
		$.ajax({
				type:"POST",
				dataType:"json",
				url:"article",
				data:{action:"loadComment",aId:aId},
				success:loadCommentSuccess,
				error:function(){alert("评论加载失败");}
		});
	};
	
	var postCommentSuccess = function(data)
	{
		if(data.errorCode == "ok")
		{
			alert("发表成功");
			$("#txtComment").val(""); //清空文本框
			loadComment();//刷新加载评论
		}
		else if(data.errorCode == "diryWord")
		{
			alert("请文明用语!");
		}
	};
	
	$(function(){
		loadComment();//页面打开的时候加载评论
		$("#btnComment").click(function(){
			var content = $("#txtComment").val();
			if(content == "")
			{
				alert("请输入评论内容");
				return;
			}
			var aId = "${model.id}";//当前文章id，通过JSTL动态输出到JS中
			$.ajax({
					type:"POST",
					dataType:"json",
					url:"article",
					data:{action:"postComment",content:content,aId:aId},
					success:postCommentSuccess,
					error:function(){alert("发表评论AJAX错误");}
			});
		});
	});
</script>
</head>
<body>
	<h1><c:out value="${model.title }" /></h1>
	<c:out value="${model.content }" />
	
	<p>
		<textarea rows="5" cols="50" id="txtComment"></textarea>
		<input type="button" value="发布评论" id="btnComment" />
	</p>
	<p>
		<ul id="ulComments"></ul>
	</p>
	
</body>
</html>