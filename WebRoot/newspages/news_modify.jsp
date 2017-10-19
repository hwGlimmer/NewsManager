<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- ����jquery-1.4.3.js�� -->
<script type="text/javascript" src="/NewsManger/js/jquery-1.4.3.js"></script>

<!-- ����CSS/admin.css��ʽ -->
<link href="/NewsManger/CSS/admin.css" rel="stylesheet" type="text/css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�����̨-�޸�����</title>

<!-- ����CSS/admin.css��ʽ -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />

<!-- ��ȡѡ������ŵ����� �Լ�����-->
<script type="text/javascript">
	$(function() {
	$.get('findtopic1.do', function(data) {
		$('#topic').empty();
		$('#topic').append("<option value='0'>ѡ��</option");
		for (var i = 0;i < data.length; i++) {
			if($('#ntid').val()==data[i].tid){
				$('#topic').append("<option selected='selected' value='" + data[i].tid + "'>" + data[i].tname + "</option>");
				}else{
				$('#topic').append("<option value='" + data[i].tid + "'>" + data[i].tname + "</option>");
				}
		}
	}, 'json');

	});
	$(function() {//��ȡ����
	$.post('findcomment.do?cnid='+$('#nid').val(), function(data) {
		if(data.length == 0){
		 $('#table').append(" <tr><td colspan='6'>��������</td></tr>");
		}
		  for (var i = 0; i < data.length; i++) {
			  $('#table').append(
			  "<tr>"+
	          "<td> �����ˣ� </td>"+
	          "<td>"+data[i].cauthor+"</td>"+
	          "<td> IP�� </td>"+
	          "<td>"+data[i].cip+"</td>"+
	          "<td> ����ʱ�䣺 </td>"+
	          "<td>"+data[i].cdate+"</td>"+
	          "<td><a href='commentdel.do?cid="+data[i].cid+"&nid="+data[i].cnid+"'>ɾ��</a></td>"+
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
	
<!-- ����ͷ�� -->
<%@ include file="../element/top.jsp"%>
<div id="main">
<!-- �������б� -->
<%@ include file="../element/left.jsp"%>
<div id="opt_area">
	<h1 id="opt_type">�޸�������ţ�</h1>
	<form action="update.do" method="post">
		<p>
			<label> ���� </label> 
			<select name="ntid" id="topic">
			<!-- <option value='1' selected="selected">ѡ��</option> -->
			</select> 
			<input type="hidden" name="nid" id="nid" value="${news1.nid}" /> 
			<input type="hidden" name="ntid" id="ntid" value="${news1.ntid}" />
		</p>
		<p>
			<label> ���� </label> <input name="ntitle" type="text"
				class="opt_input" value="${news1.ntitle}" />
		</p>
		<p>
			<label> ���� </label> <input name="nauthor" type="text"
				class="opt_input" value="${news1.nauthor}" />
		</p>
		<p>
			<label> ժҪ </label>
			<textarea name="nsummary" cols="40" rows="3">${news1.nsummary}</textarea>
		</p>
		<p>
			<label> ���� </label>
			<textarea name="ncontent" cols="70" rows="10">${news1.ncontent}</textarea>
		</p>
		<p>
			<label> �ϴ�ͼƬ </label> <input name="file" type="file"
				class="opt_input" />
		</p>
		<input type="submit" value="�ύ" class="opt_sub" /> <input
			type="reset" value="����" class="opt_sub" />
	</form>
	<h1 id="opt_type">�޸��������ۣ�</h1>
	<table style="width:80%;align:left;" id="table">


	</table>
	</div>
</div>
<!-- ����β�� -->
<%@ include file="../element/end.jsp"%>
</body>
</html>