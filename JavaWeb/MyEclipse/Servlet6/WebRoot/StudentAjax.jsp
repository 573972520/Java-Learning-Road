<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
<style type="text/css">
#dialog
	{
		position:absolute;
		top: 0;
		left: 0;
		right: 0;
		bottim: 0;
		width:100%;
		height:100%;
		background-color:#8FB0D1;
		-moz-opacity:0.8;
		opacity:0.8;
		z-index:1001;
		filter:alpha(opacity=40);
	}
#dialog img
	{
		display:block;
		width:200px;
		margin: 100px auto;
	}
</style>

<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">


	var reloadDataSuccess = function(obj)
	{
		$("#stuBody").html(""); //清除上一次reloadDataSuccess的时候生成的tr
		var students = obj.data;
		for(var i = 0;i<students.length;i++)
		{
			var student = students[i];
			/*$("#stuBody").append($("<tr><td><input type='button' name='delete' onclick='deleteById("+student.id+")' value='删除' /></td><td>"+student.name+"</td><td>"+(student.gender?"男":"女")+"</td><td>"+student.birthDay+"</td><td>"+(student.teChangSheng?"是":"不是")+"</td></tr>"));*/
			$("#stuBody").append($("<tr><td><input type='button' name='delete' value='删除' studentId='"+student.id+"' /></td><td><input type='button' name='edit' value='编辑' studentId='"+student.id+"' /></td><td>"+student.name+"</td><td>"+(student.gender?"男":"女")+"</td><td>"+student.birthDay+"</td><td>"+(student.teChangSheng?"是":"不是")+"</td></tr>"));
			
		}
		//动态生成元素之后，再添加删除按钮的监听
		//$("input[name=delete]").click(function(){alert($(this).attr("myid"));});
		$("input[name=delete]").click(function(){
			//deleteById($(this).attr("studentId"));
			var stuId = $(this).attr("studentId");
			deleteById(stuId);
		});
		
		$("input[name=edit]").click(function(){
			var stuId = $(this).attr("studentId");
			editById(stuId);
		});
		
	};
	
	//刷新学生数据
	var reloadData = function()
	{
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"student",
			data:{action:"getAll"},
			success:reloadDataSuccess,
			erroe:function(){alert("加载列表失败");}
		});
	};
	
	var editByIdSuccess = function(obj)
	{
		if(obj.errorCode == "isNotFound")
		{
			alert("查无此人")
		}		
		else if(obj.errorCode == "ok")
		{
			$("#divEdit").show(); //显示"编辑"这个层	
			$("#editId").val(obj.data.id);
			$("#editName").val(obj.data.name);
			$("#editGender").val(obj.data.gender?"male":"female");
			$("#editBrithDay").val(obj.data.brithDay);
			$("#editClassId").val(obj.data.classId);
			$("#editTeChangSheng").val(obj.data.teChangSheng);
			$("#editMinZu").val(obj.data.minZuId);
			
		}
	};
	
	var editById = function(id)
	{
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"student",
			data:{action:'getById',id:id},
			success:editByIdSuccess, //
			error:function(){alert("编辑加载数据失败");}
		});	
	};
	
	var deleteById = function(id)
	{
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"student",
			data:{action:'deleteById',id:id},
			success:reloadData, //删除成功刷新列表
			error:function(){alert("删除失败");}
		});
	};
	
	//加载学生数据到两个下拉列表
	var getAllClassSuccess = function(obj)
	{
		var classes = obj.data;
		$("#classId").html(""); //将旧的删除
		for(var i=0;i<classes.length;i++)
		{
			var classInfo = classes[i];
			var option = "<option value="+classInfo.id+">"+classInfo.name+"</option>";
			$("#classId").append($(option)); //新增的班级下拉列表
			$("#editClassId").append($(option)); //编辑的班级下拉列表
			
		}
	};
	
	//加载民族数据到两个下拉列表
	var getAllMinZuSuccess = function(obj)
	{
		var minzus = obj.data;
		$("#minZuId").html(""); //将旧的删除
		for(var i=0;i<minzus.length;i++)
		{
			var minZuInfo = minzus[i];
			var option = "<option value="+minZuInfo.id+">"+minZuInfo.name+"</option>";
			$("#minZuId").append($(option));
			$("#editMinZuId").append($(option));
		}
	};
	
	var addnewSubmitSuccess = function(obj)
	{
		//$("#dialog").hide(); //隐藏遮罩层
		if(obj.errorCode == "error")
		{
			alert("保存错误"+obj.data);		
		}
		else if(obj.errorCode == "ok")
		{
			alert("保存成功");	
			reloadData(); //重新刷新数据
			$("#divAddNew").hide(); //隐藏新增的层
			
		}
	};
	
	var editSubmitSuccess =function()
	{
		alert("保存成功");
		reloadData(); //重新刷新数据
		$("#divEdit").hide(); //隐藏新增的层
	};
	
	$(function(){
		
		//页面中任何ajax请求发起之前，ajaxSend都会触发
		$("body").bind("ajaxSend",function(){
			$("#dialog").show();
		});
		
		//页面中任何ajax请求处理完成之后，ajaxComplete都会触发
		$("body").bind("ajaxComplete",function(){
			$("#dialog").hide();
		});
		
		$("body").bind("ajaxError",function(){
			alert("服务器处理失败");
		});
		
		
		
		reloadData();
		$("#btnRefresh").click(reloadData);
		//alert($("input[name=delete]").length); //删除按钮还没有创建
		/*$("input[name=delete]").click(function(){alert($(this).attr("myid"));});*/
		
		// jquery中$().click()给已有存在的元素添加事件
		//$().live("click",)是动态生成的元素添加事件
		//jquery1.9之后不支持live
		//$("input[name=delete]").live("click",function(){alert($(this).attr("myid"));})
		
		$("#btnAddNew").click(function(){
			$("#name").val(""); //清空上一次新增填的内容
			$("#birthDay").val("");
			$("#divAddNew").show(); // 点击新增的时候，显示新增的层
		});
		$("#btnCancel").click(function(){
			$("#divAddNew").hide();// 点击取消的时候，隐藏新增的层
		});
		
		
		$.ajax({
				type:"POST",
				dataType:"json",
				url:"class",
				data:{action:"getAll"},
				success:getAllClassSuccess,
				error:function(){alert("加载班级列表失败");}
		});
		
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"minZu",
			data:{action:"getAll"},
			success:getAllMinZuSuccess,
			error:function(){alert("加载民族列表失败");}
	});
		
		$("#btnSave").click(function(){
			//todo:检查所有字段都填写了
			var name = $("#name").val();
			var gender = $("#gender").val();
			var birthDay = $("#birthDay").val();
			var classId = $("#classId").val();
			var minZuId = $("#minZuId").val();
			var teChangSheng = $("#teChangSheng").attr("checked") == "checked";
			
			//$("#dialog").show(); //显示loading遮罩层
			
			$.ajax({
					type:"POST",
					dataType:"json",
					url:"student",
					data:{action:"addnewSubmit",name:name,gender:gender,birthDay:birthDay,classId:classId,minZuId:minZuId,teChangSheng:teChangSheng},
					success:addnewSubmitSuccess,
					error:function(){$("#dialog").hide();alert("保存Ajax请求失败");}
			});
		});
		
		$("#btnEditSave").click(function(){
			//todo:检查所有字段都填写了
			var id = $("#editId").val();
			var name = $("#editName").val();
			var gender = $("#editGender").val();
			var birthDay = $("#editBirthDay").val();
			var classId = $("#editClassId").val();
			var minZuId = $("#editMinZuId").val();
			var teChangSheng = $("#editTeChangSheng").attr("checked") == "checked";
			
			$.ajax({
					type:"POST",
					dataType:"json",
					url:"student",
					data:{action:"editSubmit",id:id,name:name,gender:gender,birthDay:birthDay,classId:classId,minZuId:minZuId,teChangSheng:teChangSheng},
					success:editSubmitSuccess,
					error:function(){alert("保存Ajax请求失败");}
			});
		});
		
	});
</script>
</head>
<body>
<input type="button" id="btnAddNew" value="新增" />
<input type="button" id="btnRefresh" value="刷新" />
	<table>
		<thead>
			<tr>
				<td>删除</td>
				<td>编辑</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生日期</td>
				<td>是否特长生</td>
			</tr>
		</thead>
		<tbody id="stuBody">
			
		</tbody>
	</table>
	
	<br/>
	<div id="divAddNew" style="display:none;background-color:gray">
		姓名：<input type="text" id="name" />
		性别:
		<select id="gender">
			<option value="male">男</option>
			<option value="female">女</option>
		</select>
		<br/>
		出生日期:<input type="text" id="birthDay" />
		班级：
		<select id="classId">
		</select>
		<br/>
		是否特长生:<input type="checkbox" id="teChangSheng" />
		民族：
		<select id="minZuId">
		</select>
		<br/>
		<input type="button" value="保存" id="btnSave" />
		<input type="button" value="取消" id="btnCancel" />
	</div>
	
	<div id="divEdit" style="display:none;background-color:red">
		<input type="hidden" id="editId" />
		姓名：<input type="text" id="editName" />
		性别:
		<select id="editGender">
			<option value="male">男</option>
			<option value="female">女</option>
		</select>
		<br/>
		出生日期:<input type="text" id="editBirthDay" />
		班级：
		<select id="editClassId">
		</select>
		<br/>
		是否特长生:<input type="checkbox" id="editTeChangSheng" />
		民族：
		<select id="editMinZuId">
		</select>
		<br/>
		<input type="button" value="保存" id="btnEditSave" />
		<input type="button" value="取消" id="btnCancelEdit" />
	</div>
	
	<div id="dialog" style="display:none">
		<img src="loading.gif" />
	</div>
</body>
</html>