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
	<div style="width: 1254px;margin: 0px auto;border: 1px solid #BCBCBC;overflow: hidden;">
		<div style="width: 1254px;overflow:hidden; border: 1px solid #F1F1F1;background-color: #F1F1F1">
			<div class="showHead">新添加</div>
			<div  class="showHead" style="color: #FF6000">未使用</div>
			<div class="showHead">已购买</div>
		</div>
		<div style="width: 1244px;border: 1px solid red;float: left;">
			
			<div style="width: 1220px;height: 100px;overflow: hidden;border: 1px solid #F1F1F1;margin: 10px;font-size: 12px;">
				<input type="checkbox" style="display: inline-block;float: left;margin: 44px 4px;">
				<div style="width: 80px;height:84px;float: left;padding: 8px">
					<img alt="" src="../image/goods_pic.jpg" style="width: 72px;height:72px;">
				</div>
				<div style="float: left;width: 300px;height:92px;padding:  4px;">
					<span>data.name</span><br/>
					<span>data.store</span>
				</div>
				<div style="float: left;width: 100px;height:92px;padding:  4px;">
					data.price
				</div>
				<div style="float: left;width: 50px;height:92px;padding:  4px;">
					data.number
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>申请售后</span>
					<span></span>
					
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>number*price</span>
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>交易成功</span>
					
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>评论</span>
					
				</div>
				<div style="float: left;width: 104px;height:92px;padding:  4px;">
					<span>查看物流</span>
					
				</div>
			</div>
			
			<div style="width: 1220px;height: 100px;overflow: hidden;border: 1px solid #F1F1F1;margin: 10px;font-size: 12px;">
				<input type="checkbox" style="display: inline-block;float: left;margin: 44px 4px;">
				<div style="width: 80px;height:84px;float: left;padding: 8px">
					<img alt="" src="../image/goods_pic.jpg" style="width: 72px;height:72px;">
				</div>
				<div style="float: left;width: 300px;height:92px;padding:  4px;">
					<span>data.name</span><br/>
					<span>data.store</span>
				</div>
				<div style="float: left;width: 100px;height:92px;padding:  4px;">
					data.price
				</div>
				<div style="float: left;width: 50px;height:92px;padding:  4px;">
					data.number
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>申请售后</span>
					<span></span>
					
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>number*price</span>
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>交易成功</span>
					
				</div>
				<div style="float: left;width: 120px;height:92px;padding:  4px;border-right: 1px solid #F1F1F1">
					<span>评论</span>
					
				</div>
				<div style="float: left;width: 104px;height:92px;padding:  4px;">
					<span>查看物流</span>
					
				</div>
			</div>
		
		</div>
		<div>
			2
		</div>
		<div>
			3
		</div>
	
	</div>
	<button id="sub" type="button" >submit</button>
	
</body>
</html>