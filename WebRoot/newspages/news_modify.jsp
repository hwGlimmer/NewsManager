<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- 引入jquery-1.4.3.js包 -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<!-- 引入CSS/admin.css样式 -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>管理后台-修改新闻</title>

<!-- 引入CSS/admin.css样式 -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- 获取选择的新闻的主题 以及评论-->
<script type="text/javascript">
	$(function() {
	$.get('findtopic1.do', function(data) {
		$('#topic').empty();
		$('#topic').append("<option value='0'>选择</option");
		for (var i = 0;i < data.length; i++) {
			if($('#ntid').val()==data[i].tid){
				$('#topic').append("<option selected='selected' value='" + data[i].tid + "'>" + data[i].tname + "</option>");
				}else{
				$('#topic').append("<option value='" + data[i].tid + "'>" + data[i].tname + "</option>");
				}
		}
	}, 'json');

	});
	$(function() {//获取评论
	$.post('findcomment.do?cnid='+$('#nid').val(), function(data) {
		if(data.length == 0){
		 $('#table').append(" <tr><td colspan='6'>暂无评论</td></tr>");
		}
		  for (var i = 0; i < data.length; i++) {
			  $('#table').append(
			  "<tr>"+
	          "<td> 留言人： </td>"+
	          "<td>"+data[i].cauthor+"</td>"+
	          "<td> IP： </td>"+
	          "<td>"+data[i].cip+"</td>"+
	          "<td> 留言时间： </td>"+
	          "<td>"+data[i].cdate+"</td>"+
	          "<td><a href='commentdel.do?cid="+data[i].cid+"&nid="+data[i].cnid+"'>删除</a></td>"+
	          "</tr>"+
	          "<tr>"+
	          "<td colspan='6'>"+data[i].ccontent+"</td>"+
	          "</tr>");
		}
		
	}, 'json');
	});
		
	</script>
</head>

<body>
	
<!-- 引入头部 -->
<%@ include file="../element/top.jsp"%>
<div id="main">
<!-- 引入左部列表 -->
<%@ include file="../element/left.jsp"%>
<div id="opt_area">
	<h1 id="opt_type">修改添加新闻：</h1>
	<form action="update.do" method="post">
		<p>
			<label> 主题 </label> 
			<select name="ntid" id="topic">
			<!-- <option value='1' selected="selected">选择</option> -->
			</select> 
			<input type="hidden" name="nid" id="nid" value="${news1.nid}" /> 
			<input type="hidden" name="ntid" id="ntid" value="${news1.ntid}" />
		</p>
		<p>
			<label> 标题 </label> <input name="ntitle" type="text"
				class="opt_input" value="${news1.ntitle}" />
		</p>
		<p>
			<label> 作者 </label> <input name="nauthor" type="text"
				class="opt_input" value="${news1.nauthor}" />
		</p>
		<p>
			<label> 摘要 </label>
			<textarea name="nsummary" cols="40" rows="3">${news1.nsummary}</textarea>
		</p>
		<p>
			<label> 内容 </label>
			<textarea name="ncontent" cols="70" rows="10">${news1.ncontent}</textarea>
		</p>
		<p>
			<label> 上传图片 </label> <input name="file" type="file"
				class="opt_input" />
		</p>
		<input type="submit" value="提交" class="opt_sub" /> <input
			type="reset" value="重置" class="opt_sub" />
	</form>
	<h1 id="opt_type">修改新闻评论：</h1>
	<table style="width:80%;align:left;" id="table">


	</table>
	</div>
</div>
<!-- 引入尾部 -->
<%@ include file="../element/end.jsp"%>
</body>
</html>