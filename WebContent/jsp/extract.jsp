<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li>
		<div class="show_div">进口食品1</div> <i class="i_undo"></i>
		<div class="nav_ul">
			<a>进口</a> <a>进口零食</a> <a>进口巧克力</a> <a>进口橄榄油</a> <a>进口葡萄酒</a> <a>进口洋酒</a>
			<a>饼干</a>
		</div>
	</li>
	<li>
		<div class="show_div">${name}</div> <i class="i_undo"></i>
		<div class="nav_ul">
			<a>${name.attr[arg]}</a> <a>${name.attr}</a> <a>${name.attr}</a> <a>${name.attr}</a> <a>${name.attr}</a> <a>${name.attr}</a>
			<a>${name.attr}</a>
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
					<%request.setAttribute("url", "../image/shop_pic.jpg"); %>
					<img alt="" src= "${url}"/>
				</div> <!-- 用jq的fadein（）和fadeout（）来显,可能因为该div的子元素有position属性，导致fadein和fadeout失效 -->
				<!-- 天猫用两个span而不使用div，是因为a包含div（是inner包含block）是不行的，把a设置为block还是不行，要么也可以不用a嵌套，直接js绑定点击事件 -->
				<div class="show_hidden">
					<div id="hidde" class="hidde">
						<div class="s_div">
							<span>${name}</span>
						</div>
						<span class="ss_div">点击进入</span>
					</div>
				</div>
			</li>
	
	
</ul>

<div>
	<div class="branwall" style="width: 242px !important;">
			<div class="box">
				<span class="title_l">聚名品</span> <span class="title_l_r">LUXURYCHANNEL</span>
				<a class="more" href="#">更多</a>
			</div>
			<a href="#"> <img alt="" src="../image/brand_pic.jpg"
				class="imga" style="display: block; width: 242.5px !important;" />
			</a>
		</div>
		
		<!-- .brandwall的style是根据.imga的宽度来定的 -->
		<div class="branwall" style="width: 242px !important;">
			<div class="box">
				<span class="title_l">聚名品</span> <span class="title_l_r">${brand.name}</span>
				<a class="more" href="#">更多</a>
			</div>
			<a href="#"> <img alt="" src="../image/brand_pic.jpg"
				class="imga" style="display: block; width: 242.5px !important;" />
			</a>
		</div>
</div>





<div>
	<div class="goods_box">
		<img alt="" src="../image/goods_pic.jpg">
		<div class="content_box">
			<p>雀巢莜麦黑米黑芝麻3合1牛奶燕麦片即食</p>
			<span>（价格）</span>
		</div>
	</div>
	
	<div class="goods_box">
		<img alt="" src="${url}">
		<div class="content_box">
			<p>${goods.description}</p>
			<span>${goods.price}</span>
		</div>
	</div>
</div>
	

</body>
</html>