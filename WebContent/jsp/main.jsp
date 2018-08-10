<%@page import="java.util.List"%>
<%@page import="com.zm.model.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="cartlogo.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页面</title>
<link href="../css/main.css" rel="stylesheet" type="text/css">
<script src="../js/jquery-min.js"></script>
<script src="../js/main.js"></script>
<script>
name="${sessionScope.username}";
goodslist="${sessionScope.goodsList[0]}";
</script>
</head>
<body>
	<!-- head -->
	<div class="head">
		<ul>
			<li class="top_half">喵，欢迎来天猫</li>
			<li class="top_half"><a href="login.jsp" id="loginchange">登陆</a></li>
			<li class="top_half"><a href="register.jsp">免费注册</a></li>

			<li class="bottom_half"><a id="orderlist">我的订单</a></li>
			<li class="bottom_half"><a href="#">购物车<span id="numberOfcart" style="color: red;font-size: 14px;margin: 0px 2px;">0</span>件</a></li>
			<li class="bottom_half"><a href="manager.jsp" target="_blank">后台管理</a></li>
			
		</ul>
	</div>
	<!-- search -->
	<div class="search">
		<div class="logo">
			<img alt="" src="../image/logo_s.png">
			<div class="search_head">商品分类</div>
		</div>
		<div class="search_right">
			<div class="search_form">
					<input type="text" class="form_input">
					<input type="submit" class="form_submit" value="搜索">
			</div>
			<ul class="show_item">
				<li style="margin-left: -10px;">针织衫</li>
				<li>羽绒服</li>
				<li>四件套</li>
				<li>电动牙刷</li>
				<li>客厅灯</li>
				<li>口红</li>
				<li>手机</li>
				<li>运动鞋</li>
				<li>牛奶</li>
			</ul>
		</div>
	</div>
	<!-- turn模块 -->
	<div class="nav_box">
		<div class="nav_box_2">
			<div class="box">
				<ul class="nav_con">
					<li><i>(这里是有一个小小图标的)</i>女装</li>
					<li>男装</li>
					<li>女鞋</li>
					<li>美妆</li>
					<li>腕表</li>
					<li>手机</li>
					<li>母婴</li>
					<li>零食</li>
					<li>生鲜水果</li>
					<li>大家电</li>
					<li>家具器材</li>
					<li>汽车</li>
					<li>家纺</li>
					<li>医药</li>
					<li>厨具</li>
					<li>图音</li>
				</ul>
			</div>

			<div class="aaa">
				<div class="aaa_box">
					<ul>
						<li>
							<div class="show_div">进口食品1</div> <i class="i_undo"></i>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>
					</ul>
				</div>

				<div class="image">
					<ul>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
					</ul>
				</div>
			</div>

			<div class="aaa">
				<div class="aaa_box">
					<ul>
						<li>
							<div class="show_div">进口食品2</div> <i class="i_undo"></i>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>
					</ul>
				</div>

				<div class="image">
					<ul>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
					</ul>
				</div>
			</div>

			<div class="aaa">
				<div class="aaa_box">
					<ul>
						<li>
							<div class="show_div">进口食品3</div> <i class="i_undo"></i>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a>
							</div>
						</li>

						<li>
							<div class="show_div">
								进口食品 <i class="i_undo"></i>
							</div>
							<div class="nav_ul">
								<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
								<a>饼干</a> <a>饼干</a> <a>饼干</a>
							</div>
						</li>
					</ul>
				</div>

				<div class="image">
					<ul>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
						<li><a href="#"> <img src="../image/nav_ul_brand_pic.jpg"
								alt="">
						</a></li>
					</ul>
				</div>
			</div>

			<!-- 应该随着图片切换，改变父div的背景色彩，没有做 -->
			<div class="box_turn">
				<div class="turn" style="z-index: 0; opacity: 0;">
					<img alt="" src="../image/head_ad_1.jpg" />
				</div>
				<div class="turn" style="z-index: 0; opacity: 0;">
					<img alt="" src="../image/head_ad_02.jpg" />
				</div>
				<div class="turn" style="z-index: 0; opacity: 0;">
					<img alt="" src="../image/head_ad_1.jpg" />
				</div>
				<div class="turn" style="z-index: 1; opacity: 1;">
					<img alt="" src="../image/head_ad_02.jpg" />
				</div>
			</div>
		</div>


	</div>
	<!-- brand模块 -->
	<div class="brand">
		<div class="branwall" style="width: 242px !important;">
			<div class="box">
				<span class="title_l">聚名品</span> <span class="title_l_r">LUXURYCHANNEL</span>
				<a class="more" href="#">更多</a>
			</div>
			<a href="#"> <img alt="" src="../image/brand_pic.jpg"
				class="imga" style="display: block; width: 242.5px !important;" />
			</a>
		</div>

		<div class="branwall">
			<div class="box">
				<span class="title_l">聚名品</span> <span class="title_l_r">LUXURYCHANNEL</span>
				<a class="more" href="#">更多</a>
			</div>
			<a href="#"> <img alt="" src="../image/brand_pic.jpg"
				class="imga" />
			</a>
		</div>

		<div class="branwall">
			<div class="box">
				<span class="title_l">聚名品</span> <span class="title_l_r">LUXURYCHANNEL</span>
				<a class="more" href="#">更多</a>
			</div>
			<a href="#"> <img alt="" src="../image/brand_pic.jpg"
				class="imga" />
			</a>
		</div>
	</div>
	<!-- brandwall_2模块 -->
	<div class="brandwall_two">
		<!-- brandwall_two这个class名，放前面会导致ul li下的样式无法生效，不知道什么原因。
			点击最后一个li后ajax切换，以及切换的动态效果没有做，应该在li里面加上一个隐藏区
			域用来存放点击跳转的地址，jq里面绑定的是“#”。
		 -->
		<ul>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
			<li class="a_hid">
				<!-- 这是ul中一个li的内容。需要设置li的postion：absolute，现在设置在《a》标签上 -->
				<div class="single_show">
					<!-- 在eclipse的浏览器里面，图片周围会有一圈显示出来的border，不知道什么原因,只能加个border：none去除 -->
					<img alt="" src="../image/shop_pic.jpg" />
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>belublu</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<!-- goods模块 -->
	<div class="goods">
		
	</div>


	<div>
		<span> 
			<%-- <%
				List<Goods> g=(List<Goods>)request.getSession().getAttribute("goodsList");
				for(Goods gg:g){
			%>		
					<%= gg.getDescription() %>
			<%		
				}
			%> --%>
		</span>
	</div>
</body>
</html>