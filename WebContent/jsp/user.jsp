<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/user.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-min.js"></script>
<script src="../js/user.js"></script>
<title>user page</title>
</head>
<body>
	<div class="outer">
		<div class="headT">
			<span>hello,管理员！</span>
			<button id="searchB" type="button">搜索</button>
			<input type="text" id="searchIn">
		</div>
		<ul id="show"></ul>
		<div id="register" class="register">
			<div style="width: 60px !important;">新建用户 </div>
			<div><span>name:</span><input id="name" type="text"></div>
			<div><span>email:</span><input id="email" type="text"></div>
			<div><span>password:</span><input id="password" type="text"></div>
			<span class="selSpan">
				<select>
					<option value="2" >商家</option>
					<option value="1">管理员</option>
					<option value="3">顾客</option>
					<option value="4" selected="selected">游客</option>
				</select>
			</span>
			<button id="submit" type="button" value="add" >添加</button>
		</div>
	</div>
</body>
</html>