<%@ page language="java" import="java.util.*" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>新闻中国</title>

<!-- 引入js/ajax.js包 -->
<script type="text/javascript" src="js/ajax.js"></script>

<!-- 引入js/jquery-1.4.3.js包 -->
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>

<!-- 引入CSS/main.css样式 -->
<link href="CSS/main.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function login() {//实现验证用户
		var name = document.getElementById("uname").value;
		var pwd = document.getElementById("upwd").value;
		if (name == "") {
			alert("用户名为空");
			return;
		} else if (pwd == "") {
			alert("密码为空");
			return;
		} else {
			doAjax();
		}
	}
	function doAjax() {//利用Ajax技术发送异步请求
		var name = document.getElementById("uname").value;
		var pwd = document.getElementById("upwd").value;
		//1.创建核心对象
		var xhr=new XMLHttpRequest();
		//2.打开连接
		xhr.open('post', 'login.do', true);
		//3.设置消息头，以表单方式提交数据
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		//4.发送请求
		xhr.send("name=" + name + "&pwd=" + pwd);
		//5.处理状态改变函数
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var str = xhr.responseText;
				if (str=="true") {
					document.getElementById("top_login").innerHTML = "欢迎"
					+ name + "登录&nbsp;&nbsp;<a href='admin.do?page=1'>欢迎进入管理员界面</a>";

				} else {
					document.getElementById("error").innerHTML = "用户名或密码错误";
				}
			}
		}
	}
	$(function() {//从数据库获取主题列表，显示在首页
		$.get('findtopic1.do', function(data) {
			$('.class_date').empty();
			for(var i = 0; i < data.length; i++){
			//十个主题就换行显示
			if(i==11){
			$('.class_date').append("<br>");
			}
			//输出全部主题
			$('.class_date').append(
				"<a href='#'><b>"+data[i].tname+"</b></a>&#160;&#160;&#160;&#160;&#160;"
			     );
			}
		}, 'json');
		});
	$(function() {//从数据库获取新闻摘要列表，显示在首页
	$.post('findNewslist.do', function(data) { //根据设定的接收类型，data自动转为json对象数组
		$('#new').empty();
		for (var i = 0; i < data.length; i++) {
		//每隔5条新闻空三行
		if(i==5){
		$('#new').append("<br><br><br>");
		}
		//输出新闻
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
		<label> 登录名 </label> 
		<input type="text" id="uname" value="" class="login_input" /> 
		<label> 密&#160;&#160;码 </label> 
		<input type="password" id="upwd" value="" class="login_input" /> 
		<input type="button" class="login_sub" value="登录" onclick="login()" /> 
		<label id="error"> </label> 
		<img src="Images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		
		<div id="nav">
			<div id="logo">
				<img src="Images/banner.jpg" alt="新闻发布系统" />
			</div>
			
			<!--mainnav end-->
		</div>
	</div>
	
	<div id="container" >
		<div class="sidebar" style="position:relativ; height:600px; overflow-y:auto">
		<h1><img src="Images/title_1.gif" alt="国内新闻" /></h1>
			<div class="side_list">
			<ul>
				<li><a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b> </a></li>
				<li><a href='#'><b> 发改委：4万亿投资计划不会挤占民间投资空间 </b> </a></li>
				<li><a href='#'><b> 河南2个乡镇政绩报告内容完全一致引关注 </b> </a>	</li>
			</ul>
			</div>
			<h1><img src="Images/title_2.gif" alt="国际新闻" /></h1>
			
			<div class="side_list">
			<ul>
				<li><a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b> </a>
				</li>
				<li><a href='#'><b> 黎巴嫩以色列再次交火互射炮弹 </b> </a>
				</li>
				<li><a href='#'><b> 伊朗将于30日前就核燃料供应方案作出答复 </b> </a>
				</li>
				<li><a href='#'><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b> </a>
				</li>
			</ul>
			</div>
			
			<h1><img src="Images/title_3.gif" alt="娱乐新闻" /></h1>
			<div class="side_list">
			<ul>
				<li><a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b> </a>
				</li>
				<li><a href='#'><b> 《沧海》导演回应观众质疑 自信能超越《亮剑》 </b> </a>
				</li>
				<li><a href='#'><b> 《海角七号》导演新片开机 吴宇森等出席 </b> </a>
				</li>
				<li><a href='#'><b> 《四大名捕》敦煌热拍 八主演飙戏火花四溅 </b> </a>
				</li>
			</ul>
		</div>
	</div>
		
		<div class="main">
			<div class="class_type">
				<img src="Images/class_type.gif" alt="新闻中心" />
			</div>
			
			<div class="content">
			<!-- 主题列表显示 -->
			<ul class="class_date">
			</ul>
			<!-- 新闻摘要显示 -->	
			<ul class="classlist" style="position:relativ; height:600px; overflow:auto" id="new">
			</ul>
			</div>
			
			<!-- 显示右边图片 -->
			<div class="picnews" style="position:relativ; height:600px; overflow:auto">
			<!-- 引入首页右边图片链接 -->
			<%@ include file="../index-elements/index_rightbar.jsp"%>
			</div>
			
		</div>
	</div>
<!-- 引入首页合作伙伴和尾部jsp -->
	<%@ include file="../index-elements/index_bottom.jsp"%>

</body>
</html>
