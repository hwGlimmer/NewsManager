<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>管理后台-主题列表</title>

<!-- 引入CSS/admin.css样式 -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- 引入js/jquery-1.4.3.js包 -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<script type="text/javascript">
	$(function() {//分页显示新闻主题
	$.get('findtopic.do?page=${page}', function(data) {
		$('.classlist').empty();
		for (var i = 0; i < data.length; i++) {
			$('.classlist').append(
				"<li> &#160;&#160;&#160;&#160;" + data[i].tname +
				"&#160;&#160;&#160;&#160; <span>"+
				"<a href='newspages/topic_modify.jsp?tid=" + data[i].tid + "&tname=" + data[i].tname + "' >修改</a> "+
				"&#160;&#160;&#160;&#160; <a href='topic_delete.do?tid=" + data[i].tid + "'onclick='return clickdel()' >删除</a> </li></span>");
			}

	}, 'json');
	});
</script>
</head>

<body>
<!-- 引入页面头部 -->	
<%@ include file="../element/top.jsp"%>

<div id="main">
<!-- 引入页面左边列表 -->

<%@ include file="../element/left.jsp"%>
		<div id="opt_area">
<!--提示是否删除主题 -->
		<script language="javascript">
			function clickdel() {
				return confirm("删除请点击确认");
			}
		</script>
	<!-- 主题列表显示 -->
		<ul class="classlist">  
		</ul>
			<p align="right">
			当前页数:[${page}/${totalPage}]&nbsp;<a href="topic.do?page=${page-1}">上一页</a>
			<a href="topic.do?page=${page+1}">下一页</a> 
			<a href="topic.do?page=${totalPage}">末页</a>
		</p>
		</div>
	</div>
	<!-- 引入页面底部 -->
<%@ include file="../element/end.jsp"%>
</body>
</html>

