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

<title>��̨����-�������</title>

<!-- ����CSS/admin.css��ʽ -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- ����js/jquery-1.4.3.js�� -->
<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>

<!-- ��ȡѡ��������� -->
<script type="text/javascript">
	$(function() {
		$.get('findtopic1.do', function(data) {
			$('#topic').empty();
			$('#topic').append("<option value='0'>ѡ��</option");
			for (var i = 0; i < data.length; i++) {
				$('#topic').append(
				"<option value='" + data[i].tid + "'>" + data[i].tname+ "</option>");
			}
		}, 'json');
	});
</script>
</head>
<body>

<!-- ����ͷ�� -->
<%@ include file="../element/top.jsp"%>
<div id="main">
<!-- �������б� -->
<%@ include file="../element/left.jsp"%>

<div id="opt_area">
	<h1 id="opt_type">������ţ�</h1>
	<form action="../addnew.do" method="post">
		<p>
			<label> ���� </label> 
			<select name="ntid" id="topic">
				<option value="1">ѡ��</option>
			</select>
		</p>
		<p>
			<label> ���� </label> 
			<input name="ntitle" type="text" class="opt_input" />
		</p>
		<p>
			<label> ���� </label> 
			<input name="nauthor" type="text" class="opt_input" />
		</p>
		<p>
			<label> ժҪ </label>
			<textarea name="nsummary" cols="40" rows="3"></textarea>
		</p>
		<p>
			<label> ���� </label>
			<textarea name="ncontent" cols="70" rows="10"></textarea>
		</p>

		<input name="action" type="hidden" value="addnews"> 
		<input type="submit" value="�ύ" class="opt_sub" /> 
		<input type="reset" value="����" class="opt_sub" />
	</form>
</div>
</div>
<!-- ����β�� -->
<%@ include file="../element/end.jsp"%>
</body>
</html>
