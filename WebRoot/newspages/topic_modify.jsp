<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
    + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�����̨-�޸���������</title>

<!-- ����CSS/admin.css��ʽ -->
<link href="../CSS/admin.css" rel="stylesheet" type="text/css" />
<%
	String tname=new String(request.getParameter("tname").getBytes("ISO-8859-1"),"GBK");
%>
</head>

<body>
<!-- ����ͷ�� -->
<%@ include file="../element/top.jsp"%>
<div id="main">

<!-- �������б� -->
<%@ include file="../element/left.jsp"%>

  <div id="opt_area">
    <h1 id="opt_type"> ������⣺ </h1>
    <form action="../topicmodify.do" method="post" onsubmit="return check()">
      <p>
        <label> �������� </label>
        <input name="tname" type="text" class="opt_input" value="<%=tname %>"/>
        <input name="tid" type="hidden" value="${param.tid}">
      </p>
      <input name="action" type="hidden" value="addtopic">
      <input type="submit" value="�ύ" class="opt_sub" />
      <input type="reset" value="����" class="opt_sub" />
    </form>
  </div>
</div>
<!-- ����ҳ��ײ� -->
<%@ include file="../element/end.jsp"%>
</body>
</html>
