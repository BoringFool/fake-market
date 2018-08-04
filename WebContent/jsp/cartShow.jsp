<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="../css/cartShow.css" rel="stylesheet">
<script src="../js/jquery-min.js"></script>
<script src="../js/cartShow.js"></script>
</head>
<body>
	<div class="outer">
		<div class="outerHead">
			<div id="newList" class="showHead" style="color: #FF6000">新添加</div>
			<div id="notUsedList" class="showHead" >未使用</div>
			<div id="paidList" class="showHead">已购买</div>
		</div>
		<div class="titleHead">
		    <ul style="">
		    	<li style="width: 25px;">
		    		<input id="allChecked" type="checkbox" style="margin: 6px 5px;"/>
		    	</li>
		    	<li style="width: 96px;	">图片</li>
		    	<li style="width: 308px;"></li>
		    	<li style="width: 108px;">价钱</li>
		    	<li style="width: 58px;">数量</li>
		    	<li style="width: 129px;">售后</li>
		    	<li style="width: 129px;">总价</li>
		    	<li style="width: 129px;">状态</li>
		    	<li style="width: 129px;">评论查看</li>
		    	<li style="width: 100px;">物流查看</li>
		    </ul>
		</div>
		<div class="commonList">
			
		</div>
		
		<button id="sub" type="button" class="toPay">结算</button>
	</div>
	
	
</body>
</html>