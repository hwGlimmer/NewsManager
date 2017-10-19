<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>�����й�</title>

<!-- ����js/ajax.js�� -->
<script type="text/javascript" src="js/ajax.js"></script>

<!-- ����js/jquery-1.4.3.js�� -->
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>

<!-- ����CSS/main.css��ʽ -->
<link href="CSS/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function login() {//ʵ����֤�û�
		var name = document.getElementById("uname").value;
		var pwd = document.getElementById("upwd").value;
		if (name == "") {
			alert("�û���Ϊ��");
			return;
		} else if (pwd == "") {
			alert("����Ϊ��");
			return;
		} else {
			doAjax();
		}
	}
	function doAjax() {//����Ajax���������첽����
		var name = document.getElementById("uname").value;
		var pwd = document.getElementById("upwd").value;
		//1.�������Ķ���
		var xhr=new XMLHttpRequest();
		//2.������
		xhr.open('post', 'login.do', true);
		//3.������Ϣͷ���Ա���ʽ�ύ����
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//4.��������
		xhr.send("name=" + name + "&pwd=" + pwd);
		//5.����״̬�ı亯��
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var str = xhr.responseText;
				if (str=="true") {
					document.getElementById("top_login").innerHTML = "��ӭ"
					+ name + "��¼&nbsp;&nbsp;<a href='admin.do?page=1'>��ӭ�������Ա����</a>";

				} else {
					document.getElementById("error").innerHTML = "�û������������";
				}
			}
		}
	}
	$(function() {//�����ݿ��ȡ�����б���ʾ����ҳ
		$.get('findtopic1.do', function(data) {
			$('.class_date').empty();
			for(var i = 0; i < data.length; i++){
			//ʮ������ͻ�����ʾ
			if(i==11){
			$('.class_date').append("<br>");
			}
			//���ȫ������
			$('.class_date').append(
				"<a href='#'><b>"+data[i].tname+"</b></a>&#160;&#160;&#160;&#160;&#160;"
			     );
			}
		}, 'json');
		});
	$(function() {//�����ݿ��ȡ����ժҪ�б���ʾ����ҳ
	$.post('findNewslist.do', function(data) { //�����趨�Ľ������ͣ�data�Զ�תΪjson��������
		$('#new').empty();
		for (var i = 0; i < data.length; i++) {
		//ÿ��5�����ſ�����
		if(i==5){
		$('#new').append("<br><br><br>");
		}
		//�������
			$('#new').append("<li><a href='#'>"
			+ data[i].nsummary
			+ "</a><span>"
			+ data[i].ncreatedate
			+"</span></li><br>"
			);
			}
		}, 'json');
	});
</script>
</head>

<body>
	<div id="header">
		<div id="top_login">
		<label> ��¼�� </label> 
		<input type="text" id="uname" value="" class="login_input" /> 
		<label> ��&#160;&#160;�� </label> 
		<input type="password" id="upwd" value="" class="login_input" /> 
		<input type="button" class="login_sub" value="��¼" onclick="login()" /> 
		<label id="error"> </label> 
		<img src="Images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		
		<div id="nav">
			<div id="logo">
				<img src="Images/banner.jpg" alt="���ŷ���ϵͳ" />
			</div>
			
			<!--mainnav end-->
		</div>
	</div>
	
	<div id="container" >
		<div class="sidebar" style="position:relativ; height:600px; overflow-y:auto">
		<h1><img src="Images/title_1.gif" alt="��������" /></h1>
			<div class="side_list">
			<ul>
				<li><a href='#'><b> ������ڸ�����ǿ��ͥ�����Դ��໥ì�� </b> </a></li>
				<li><a href='#'><b> ����ί��4����Ͷ�ʼƻ����ἷռ���Ͷ�ʿռ� </b> </a></li>
				<li><a href='#'><b> ����2��������������������ȫһ������ע </b> </a>	</li>
			</ul>
			</div>
			<h1><img src="Images/title_2.gif" alt="��������" /></h1>
			
			<div class="side_list">
			<ul>
				<li><a href='#'><b> �ձ������ɽ�״�ȫ������������⽻���� </b> </a>
				</li>
				<li><a href='#'><b> �������ɫ���ٴν������ڵ� </b> </a>
				</li>
				<li><a href='#'><b> ���ʽ���30��ǰ�ͺ�ȼ�Ϲ�Ӧ���������� </b> </a>
				</li>
				<li><a href='#'><b> ������й���֯���ƶ԰͸��������ը���� </b> </a>
				</li>
			</ul>
			</div>
			
			<h1><img src="Images/title_3.gif" alt="��������" /></h1>
			<div class="side_list">
			<ul>
				<li><a href='#'><b> ʩ����������Ӱ��ҵ��Ǩ�ƻ� �ƽ����ݾ��ø��� </b> </a>
				</li>
				<li><a href='#'><b> ���׺������ݻ�Ӧ�������� �����ܳ�Խ�������� </b> </a>
				</li>
				<li><a href='#'><b> �������ߺš�������Ƭ���� ����ɭ�ȳ�ϯ </b> </a>
				</li>
				<li><a href='#'><b> ���Ĵ��������ػ����� �������Ϸ���Ľ� </b> </a>
				</li>
			</ul>
		</div>
	</div>
		
		<div class="main">
			<div class="class_type">
				<img src="Images/class_type.gif" alt="��������" />
			</div>
			
			<div class="content">
			<!-- �����б���ʾ -->
			<ul class="class_date">
			</ul>
			<!-- ����ժҪ��ʾ -->	
			<ul class="classlist" style="position:relativ; height:600px; overflow:auto" id="new">
			</ul>
			</div>
			
			<!-- ��ʾ�ұ�ͼƬ -->
			<div class="picnews" style="position:relativ; height:600px; overflow:auto">
			<!-- ������ҳ�ұ�ͼƬ���� -->
			<%@ include file="../index-elements/index_rightbar.jsp"%>
			</div>
			
		</div>
	</div>
<!-- ������ҳ��������β��jsp -->
	<%@ include file="../index-elements/index_bottom.jsp"%>

</body>
</html>
