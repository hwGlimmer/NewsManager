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
<title>管理后台-添加新闻主题</title>

<!-- 引入CSS/admin.css样式 -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- 引入页面头部 -->	
<%@ include file="../element/top.jsp"%>

<div id="main">
<!-- 引入页面左边列表 -->
<%@ include file="../element/left.jsp"%>
	<div id="opt_area">
		<h1 id="opt_type">添加主题：</h1>
		<form action="topicadd.do" method="post">
			<p>
				<label> 主题名称 </label> <input name="tname" type="text"
					class="opt_input" />
			</p>
			<input name="action" type="hidden" value="addtopic"> 
			<input type="submit" value="提交" class="opt_sub" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	</div>
</div>
<!-- 引入页面底部 -->
<%@ include file="../element/end.jsp"%>
</body>
</html>
