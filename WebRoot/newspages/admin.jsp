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

<title>�����̨</title>
<!-- ����CSS/admin.css��ʽ -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<%//ʵ��û�е�½�ɹ�����ֱ�ӽ���������Ĺ���
	Object name = session.getAttribute("uname");
	if (name == null) {
		response.sendRedirect("login.jsp");
	}
%>

<!-- ����js/jquery-1.4.3.js�� -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<!-- ��ȡ�����б� -->
<script type="text/javascript">
	$(function() {
	$.post('quoto.do?page=${page}', function(data) { //�����趨�Ľ������ͣ�data�Զ�תΪjson��������
		$('#new').empty();
		for (var i = 0; i < data.length; i++) {
			$('#new').append(
			"<li>"
			+ data[i].ntitle
			+ "<span> ���ߣ�"
			+ data[i].nauthor
			+ "&#160;&#160;&#160;&#160;"
			+ "<a href='/NewsManger/upmanage.do?nid="
			+ data[i].nid
			+ "'>�޸�</a>"
			+ "&#160;&#160;&#160;&#160;"
			+ "<a href='delete.do?nid="
			+ data[i].nid
			+ "' onclick='return clickdel()'>ɾ��</a> </span> "
			+ "</li>");
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
		<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
		<!--ʵ��ȷ�τh������ʾ�� -->
		<script language="javascript">
			function clickdel() {
			return confirm("ɾ������ȷ��");
			}
		</script>
		<!-- �����б� -->
		<ul class="classlist" id="new"> </ul>
		<p align="right">
			��ǰҳ��:[${page}/${totalPage}]&nbsp;
			<a href="admin.do?page=${page-1}">��һҳ</a> 
			<a href="admin.do?page=${page+1}">��һҳ</a> 
			<a href="admin.do?page=${totalPage}">ĩҳ</a>
		</p>
	</div>

</div>
<!-- ����ҳ��ײ� -->
<%@ include file="../element/end.jsp"%>

</body>
</html>
