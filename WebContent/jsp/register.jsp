<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script src="../js/register.js"></script>
<link href="../css/register.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="main">
		<h1>注册账号</h1>
		<h2>用作网站简单描述</h2>
		<div class="sc_d">
			<div class="sc_d_d f_s_s1">
				步骤一：<br>账号注册
			</div>
			<div class="sc_d_d f_s_s2">
				步骤二：<br>进入或离开
			</div>
		</div>		
			<div id="a" class="fm_md">
				<h2>创建个人账户</h2>
				<label for="name">用户名</label> <input id="name" type="text">
				<p>该名称将作为登陆名和昵称。</p>
				<label for="email">邮箱地址</label> <input id="email" type="text">
				<p>凡是和账户有关的信息，都会通过这个邮箱发送给您。</p>
				<label for="password">密码</label> <input id="password"
					type="password">
				<p>密码必须包含字母和数字。</p>
				<input id="submit" class="inp_s_s" type="submit" value="注册">
			</div>
		<div id="b" class="th_d">
			<div class="th_d_md">
				<span>网站特点介绍</span>
			</div>
			<div>
				特点内容<br>1...<br>2...
			</div>
		</div>
		<div id="quit" class="quit"><span>退出并关闭</span></div>
	</div>
	
</body>
</html>