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
	<div class="topB">
		<button id="up" style="z-index: 3; position: relative;">up</button>
		<button id="down" style="z-index: 3; position: relative;">down</button>
		<button id="left" style="z-index: 3; position: relative;">left</button>
		<button id="right" style="z-index: 3; position: relative;">right</button>
	</div>
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
			<td id="fir" class="submit">修改</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td class="diff">adadas</td>
			<td id="sec" class="submit">修改</td>
		</tr>
	</table>
	<div class="passChange">
		<label class="capable" for="old" style="border: none !important;">旧密码
			：</label> <input class="capable" type="password" id="old" /><br /> <label
			class="capable" for="new" style="border: none !important;">新密码
			：</label> <input class="capable" type="password" id="new" />
		<button class="submit" type="button" id="change">修改</button>
	</div>
	<div class="mailChange">
		<label class="capable" for="oldE" style="border: none !important;">旧邮箱
			：</label> <input class="capable" type="password" id="oldE" /><br /> <label
			class="capable" for="newE" style="border: none !important;">新邮箱
			：</label> <input class="capable" type="password" id="newE" />
		<button class="submit" type="button" id="changeE">修改</button>
	</div>

</body>
</html>