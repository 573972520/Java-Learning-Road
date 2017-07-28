<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>输入新密码</title>
     <%@include file="/WEB-INF/header.jsp" %>
     <script type="text/javascript">
    	$(function () {
			$("#next").click(function () {
				/* 如果将这段判断两次密码是否相同的代码放到ajax请求外面的话，那么只要页码一打开这段判断的代码就会立马执行，那么此时的password的值就会被赋为空字符串 ，所以必须放到click里面来*/
				var password = $("#password").val(); 
				var password2 = $("#password2").val();
	    		if(password != password2)
	   			{
	    			alert("两次输入的密码不一致")	;
	    			return;
	   			};
				$.ajax({
					type:"post",
					url:"<%=ctxPath%>/User",
					data:{action:"findPasswordSubmit3",password:password},
					success:function(result){
						if(result.status == "ok")
						{
							location.href="<%=ctxPath%>/User?action=findPasswordComplete";//重置密码成功
						}
						else
						{
							alert(result.msg);
						}
					},
					error:function(){
						alert("ajax请求网络失败");
					}
				});
				
			});
			
		});
    </script>
</head>
	<%@include file="/WEB-INF/loading.jsp" %>	
	<body>
		<div class="headertwo clearfloat" id="header">
			<a href="javascript:history.go(-1)" class="fl box-s"><i class="iconfont icon-arrow-l fl"></i></a>
			<p class="fl">输入新密码</p>
		</div>
		
		<div class="modify clearfloat" id="main">
			<ul>
				<li class="clearfloat">
					<input type="password" name="" id="password" value="" placeholder="请输入新密码" class="sname snametwo" />
				</li>
				<li class="clearfloat">
					<input type="password" name="" id="password2" value="" placeholder="请再次输入新密码" class="sname snametwo" />
				</li>	
			</ul>
			<a href="javascript:void(0)" id="next" class="pay-btn clearfloat">
				确认修改
			</a>
		</div>
	</body>
	<script type="text/javascript" src="<%=ctxPath%>/js/jquery.SuperSlide.2.1.js" ></script>
	<script type="text/javascript" src="<%=ctxPath%>/slick/slick.min.js" ></script>
	<script type="text/javascript" src="<%=ctxPath%>/js/jquery.leanModal.min.js"></script>
	<script type="text/javascript" src="<%=ctxPath%>/js/tchuang.js" ></script>
	<script type="text/javascript" src="<%=ctxPath%>/js/hmt.js" ></script>
</html>
