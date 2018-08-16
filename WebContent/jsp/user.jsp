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
		<div style="width: 100%;height: 30px;line-height: 30px;margin: 5px;">
			<span>hello,管理员！</span>
			<button type="button">搜索</button>
			<input type="text" style="float: right;width: 98px;height:18px;margin: 4px;padding: 2px">
		</div>
		<ul id="show"></ul>
		<div style="width: 1000px;height: 30px;overflow: hidden;border: 1px solid red;margin: 4px;">
			新建用户  
			name:<input>
			<span>
				<select>
					<option value="0" >商家</option>
					<option value="1">管理员</option>
					<option value="2">顾客</option>
					<option value="3" selected="selected">游客</option>
				</select>
			</span>
			<button type="button" value="add" >添加</button>
		</div>
	</div>
</body>
</html>