<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />

<title>后台管理-添加新闻</title>

<!-- 引入CSS/admin.css样式 -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- 引入js/jquery-1.4.3.js包 -->
<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>

<!-- 获取选项里的主题 -->
<script type="text/javascript">
	$(function() {
		$.get('findtopic1.do', function(data) {
			$('#topic').empty();
			$('#topic').append("<option value='0'>选择</option");
			for (var i = 0; i < data.length; i++) {
				$('#topic').append(
				"<option value='" + data[i].tid + "'>" + data[i].tname+ "</option>");
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
	<h1 id="opt_type">添加新闻：</h1>
	<form action="../addnew.do" method="post">
		<p>
			<label> 主题 </label> 
			<select name="ntid" id="topic">
				<option value="1">选择</option>
			</select>
		</p>
		<p>
			<label> 标题 </label> 
			<input name="ntitle" type="text" class="opt_input" />
		</p>
		<p>
			<label> 作者 </label> 
			<input name="nauthor" type="text" class="opt_input" />
		</p>
		<p>
			<label> 摘要 </label>
			<textarea name="nsummary" cols="40" rows="3"></textarea>
		</p>
		<p>
			<label> 内容 </label>
			<textarea name="ncontent" cols="70" rows="10"></textarea>
		</p>

		<input name="action" type="hidden" value="addnews"> 
		<input type="submit" value="提交" class="opt_sub" /> 
		<input type="reset" value="重置" class="opt_sub" />
	</form>
</div>
</div>
<!-- 引入尾部 -->
<%@ include file="../element/end.jsp"%>
</body>
</html>
