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
<title>�����̨-�����б�</title>

<!-- ����CSS/admin.css��ʽ -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- ����js/jquery-1.4.3.js�� -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<script type="text/javascript">
	$(function() {//��ҳ��ʾ��������
	$.get('findtopic.do?page=${page}', function(data) {
		$('.classlist').empty();
		for (var i = 0; i < data.length; i++) {
			$('.classlist').append(
				"<li> &#160;&#160;&#160;&#160;" + data[i].tname +
				"&#160;&#160;&#160;&#160; <span>"+
				"<a href='newspages/topic_modify.jsp?tid=" + data[i].tid + "&tname=" + data[i].tname + "' >�޸�</a> "+
				"&#160;&#160;&#160;&#160; <a href='topic_delete.do?tid=" + data[i].tid + "'onclick='return clickdel()' >ɾ��</a> </li></span>");
			}

	}, 'json');
	});
</script>
</head>

<body>
<!-- ����ҳ��ͷ�� -->	
<%@ include file="../element/top.jsp"%>

<div id="main">
<!-- ����ҳ������б� -->

<%@ include file="../element/left.jsp"%>
		<div id="opt_area">
<!--��ʾ�Ƿ�ɾ������ -->
		<script language="javascript">
			function clickdel() {
				return confirm("ɾ������ȷ��");
			}
		</script>
	<!-- �����б���ʾ -->
		<ul class="classlist">  
		</ul>
			<p align="right">
			��ǰҳ��:[${page}/${totalPage}]&nbsp;<a href="topic.do?page=${page-1}">��һҳ</a>
			<a href="topic.do?page=${page+1}">��һҳ</a> 
			<a href="topic.do?page=${totalPage}">ĩҳ</a>
		</p>
		</div>
	</div>
	<!-- ����ҳ��ײ� -->
<%@ include file="../element/end.jsp"%>
</body>
</html>

