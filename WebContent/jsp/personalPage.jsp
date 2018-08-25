<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../js/jquery-min.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<link href="../css/personal.css" type="text/css" rel="stylesheet">
<title>personalPage</title>
</head>
<body>
<button id="test">asd</button>
	<table id="show">
		<tr>
			<td>登陆名</td>
			<td class="diff">1</td>
			<td>无法修改</td>
		</tr>
		<tr>
			<td>身份</td>
			<td class="diff">4</td>
			<td>无权修改</td>
		</tr>
		<tr>
			<td>密码</td>
			<td class="diff">2</td>
			<td>修改</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td class="diff">adadas</td>
			<td>修改</td>
		</tr>
	</table>
	<div class="passChange">
		<label class="capable" for="old" style="border: none !important;">旧密码
			：</label> <input class="capable" type="password" id="old" /><br /> <label
			class="capable" for="new" style="border: none !important;">新密码
			：</label> <input class="capable" type="password" id="new" />
		<button class="submit" type="button" id="change">修改</button>
	</div>


</body>
</html>