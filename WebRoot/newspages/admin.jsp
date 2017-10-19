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

<title>管理后台</title>
<!-- 引入CSS/admin.css样式 -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<%//实现没有登陆成功则不能直接进入管理界面的功能
	Object name = session.getAttribute("uname");
	if (name == null) {
		response.sendRedirect("login.jsp");
	}
%>

<!-- 引入js/jquery-1.4.3.js包 -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<!-- 获取新闻列表 -->
<script type="text/javascript">
	$(function() {
	$.post('quoto.do?page=${page}', function(data) { //根据设定的接收类型，data自动转为json对象数组
		$('#new').empty();
		for (var i = 0; i < data.length; i++) {
			$('#new').append(
			"<li>"
			+ data[i].ntitle
			+ "<span> 作者："
			+ data[i].nauthor
			+ "&#160;&#160;&#160;&#160;"
			+ "<a href='/NewsManger/upmanage.do?nid="
			+ data[i].nid
			+ "'>修改</a>"
			+ "&#160;&#160;&#160;&#160;"
			+ "<a href='delete.do?nid="
			+ data[i].nid
			+ "' onclick='return clickdel()'>删除</a> </span> "
			+ "</li>");
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
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<!--实现确认刪除的提示框 -->
		<script language="javascript">
			function clickdel() {
			return confirm("删除请点击确认");
			}
		</script>
		<!-- 新闻列表 -->
		<ul class="classlist" id="new"> </ul>
		<p align="right">
			当前页数:[${page}/${totalPage}]&nbsp;
			<a href="admin.do?page=${page-1}">上一页</a> 
			<a href="admin.do?page=${page+1}">下一页</a> 
			<a href="admin.do?page=${totalPage}">末页</a>
		</p>
	</div>

</div>
<!-- 引入页面底部 -->
<%@ include file="../element/end.jsp"%>

</body>
</html>
