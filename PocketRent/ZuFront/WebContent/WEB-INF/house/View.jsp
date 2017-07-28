<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>房源详情</title>
    <%@include file="/WEB-INF/header.jsp" %>
</head>
	<%@include file="/WEB-INF/loading.jsp" %>
	<body>
		<div class="headertwo clearfloat" id="header">
			<a href="javascript:history.go(-1)" class="fl box-s"><i class="iconfont icon-arrow-l fl"></i></a>
			<p class="fl">房源详情</p>
			<a href="#" class="fr" onClick="toshare()"><i class="iconfont icon-fenxiang fl"></i></a>
		</div>
		
		<!--分享内容-->
		<div class="am-share">
		  <h3 class="am-share-title">分享到</h3>
		  <ul class="am-share-sns">
		    <li><a href="#"> <i class="iconfont icon-weixin weixin"></i> <span>微信</span> </a> </li>
		    <li><a href="#"> <i class="iconfont icon-qq qq"></i> <span>QQ</span> </a> </li>
		    <li><a href="#"> <i class="iconfont icon-weibo weibo"></i> <span>微博</span> </a> </li>
		    <li><a href="#"> <i class="iconfont icon-renrenwang renren"></i> <span>人人</span> </a> </li>
		  </ul>
		  <div class="am-share-footer"><button class="share_btn">取消</button></div>
		</div>
		
		<div class="clearfloat" id="main">		
			<div class="service clearfloat">
				<div class="slider one-time">
				<c:forEach items="${pics }" var="pic">
					<div>
						<img src="${pic.url }"/>
						<div class="tit clearfloat box-s">
							<p class="one">${house.communityName }</p>
							<p class="two">${house.communityLocation }</p>
						</div>
					</div>
				</c:forEach>
					
				</div>
			</div>		
			
			<div class="service-top clearfloat box-s">
				<div class="left fl clearfloat box-s">
					<p class="tit titwo">${house.monthRent }<span>元/月</span></p>
					<p class="fu-tit">${house.roomTypeName }  |  ${house.area }m²   |  ${house.decorateStatusName } | ${house.typeName }</p>
				</div>
				<div class="right fl clearfloat">
					<i class="iconfont icon-shoucang"></i>
					<p>收藏</p>
				</div>
			</div>
			
			<div class="service-ctent clearfloat">
				<div class="recom-tit clearfloat box-s">
		    		<p>房屋信息</p>
		    	</div>
		    	<div class="service-list clearfloat box-s">
		    		<ul>
		    			<li>类型： ${house.typeName}</li>
		    			<li>朝向：${house.direction}</li>
		    			<li>楼层：${house.floorIndex}/${house.totalFloorCount} </li>
		    			<li>装修：${house.decorateStatusName}</li>
		    			<li>现状：${house.statusName}</li>
		    			<li>可入驻：${house.checkInDateTime}</li>
		    			<li>建造年代：${house.communityBuiltYear}年</li>
		    			<li>可看房：${house.lookableDateTime}以后</li>
		    		</ul>
		    		<p class="service-tit">交通：${house.communityTraffic}</p>
		    	</div>		    	
			</div>
			
			<div class="service-ctent clearfloat">
				<div class="recom-tit clearfloat box-s">
		    		<p>配置设施</p>
		    	</div>
		    	<div class="service-ties clearfloat box-s">
		    		<ul>
		    		<c:forEach items="${attachs }" var="att">
		    			<li><i class="iconfont ${att.iconName }"></i>${att.name }</li>
		    		</c:forEach>
		    		</ul>
		    	</div>
			</div>
			
			<div class="service-ctent clearfloat">
				<div class="recom-tit clearfloat box-s">
		    		<p>房源描述</p>
		    	</div>
		    	<p class="tit box-s">
		    		${house.description }
		    	</p>
			</div>
			
			<div class="service-ctent clearfloat">
				<div class="recom-tit clearfloat box-s">
		    		<p>相似好房</p>
		    	</div>
		    	<div class="recom-xia clearfloat box-s">
		    		<div class="list clearfloat fl">
		    			<a href="house-details.html">
			    			<div class="tu">
			    				<span></span>
			    				<img src="upload/1.jpg"/>
			    			</div>
			    			<div class="bottom clearfloat">
			    				<div class="top clearfloat">
			    					<p class="biaoti">华府骏苑</p>
			    					<p class="price">1500<span>元/月</span></p>
			    				</div>
			    				<p class="fu-tit">
			    					三室一厅一卫   |  125m²  |  普装
			    				</p>
			    			</div>
		    			</a>
		    		</div>
		    		<div class="list clearfloat fl">
		    			<a href="house-details.html">
			    			<div class="tu">
			    				<span></span>
			    				<img src="upload/1.jpg"/>
			    			</div>
			    			<div class="bottom clearfloat">
			    				<div class="top clearfloat">
			    					<p class="biaoti">华府骏苑</p>
			    					<p class="price">1500<span>元/月</span></p>
			    				</div>
			    				<p class="fu-tit">
			    					三室一厅一卫   |  125m²  |  普装
			    				</p>
			    			</div>
		    			</a>
		    		</div>
		    		<div class="list clearfloat fl">
		    			<a href="house-details.html">
			    			<div class="tu">
			    				<span></span>
			    				<img src="upload/1.jpg"/>
			    			</div>
			    			<div class="bottom clearfloat">
			    				<div class="top clearfloat">
			    					<p class="biaoti">华府骏苑</p>
			    					<p class="price">1500<span>元/月</span></p>
			    				</div>
			    				<p class="fu-tit">
			    					三室一厅一卫   |  125m²  |  普装
			    				</p>
			    			</div>
		    			</a>
		    		</div>
		    	</div>
			</div>
			
		</div>
		
		<div class="footer-look clearfloat" id="footer">
			<a href="#loginmodal" id="modaltrigger">我要看房</a>
		</div>
		
		
		<!--弹窗内容 star-->
	    <div id="loginmodal" class="box-s loginmodal" style="display:none;">	    	
			<form id="loginform" name="loginform" method="post" action="">		
				<div class="center"><input type="button" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="" tabindex="3"></div>
			</form>
			<div class="top clearfloat box-s">
				填写信息
			</div>
			<div class="bottom clearfloat box-s">
				<ul>
					<li class="clearfloat">
						<i class="iconfont icon-user"></i>
						<input type="text" name="" id="" value="" placeholder="您的姓名" />
					</li>
					<li class="clearfloat">
						<i class="iconfont icon-phone"></i>
						<input type="text" name="" id="" value="" placeholder="您的手机号码" />
					</li>
					<li class="clearfloat">
						<i class="iconfont icon-calendar"></i>
						<input type="text" name="" id="" value="" placeholder="请选择看房时间" />
					</li>
				</ul>
				<input type="button" name="" id="" value="立即预约" class="btn" />
			</div>
		</div>
	    <!--弹窗内容 end-->
		
	</body>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
	<script type="text/javascript" src="slick/slick.min.js" ></script>
	<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
	<script type="text/javascript" src="js/tchuang.js" ></script>
	<script type="text/javascript" src="js/hmt.js" ></script>
	<script type="text/javascript">
		$('.one-time').slick({
		  dots: true,
		  infinite: false,
		  speed: 300,
		  slidesToShow: 1,
		  touchMove: false,
		  slidesToScroll: 1
		});
	</script>
	<!--分享js-->
	<script type="text/javascript">
		function toshare(){
			$(".am-share").addClass("am-modal-active");	
			if($(".sharebg").length>0){
				$(".sharebg").addClass("sharebg-active");
			}else{
				$("body").append('<div class="sharebg"></div>');
				$(".sharebg").addClass("sharebg-active");
			}
			$(".sharebg-active,.share_btn").click(function(){
				$(".am-share").removeClass("am-modal-active");	
				setTimeout(function(){
					$(".sharebg-active").removeClass("sharebg-active");	
					$(".sharebg").remove();	
				},300);
			})
		}	
	</script>
</html>