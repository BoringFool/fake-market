$(document).ready(function() {
	var times = 1;
	oneuse = true;
	/* 商品展示 */
	// 页面第一次查询
	if (times === 1) {
		show_goods();
	}
	/*
	 * 如果不加入第二个判断，在抽风式刷新的情况下会 出现两次重复查询
	 */
	$(window).scroll(function() {
		if (($(document).scrollTop() + $(window).height() == $(document)
				.height())
				&& times == 2) {
			show_goods();
		}
	});

	var n = 0;

	$(".nav_con li").each(function(i) {
				$(this).hover(function() {
							$(".aaa").eq(i).css("display", "block");
						}, function() {
							$(".aaa").eq(i).css("display", "none");
						});
			});

	$(".aaa").hover(function() {
				$(this).css("display", "block");
			}, function() {
				$(this).css("display", "none");
			});

			
	$("input.form_submit").click(function(){
		varinputData=$("input.form_input").val();
	});
			
	/* 滚动首页ad */
	function turn(i) {
		if (i == 0) {
			$(".turn").eq(3).animate({
						"z-index" : "0",
						"opacity" : "0"
					}, 1000);
			$(".turn").eq(0).animate({
						"z-index" : "1",
						"opacity" : "1"
					}, 1000);
		} else {
			$(".turn").eq(i - 1).animate({
						"z-index" : "0",
						"opacity" : "0"
					}, 1000);
			$(".turn").eq(i).animate({
						"z-index" : "1",
						"opacity" : "1"
					}, 1000);
		}
		n++;
		if (n == 4) {
			n = 0;
		}
	}

	var intv = setInterval(function() {
				turn(n);
			}, 3000);
	/* 鼠标hover清除轮播效果，离开回复 */
	$(".turn").hover(function() {
				clearInterval(intv);
			}, function() {
				intv = setInterval(function() {
							turn(n);
						}, 3000);
			});

	/* hover透明度调整 */
	$(".imga,.goods_box").hover(function() {
				$(this).addClass("ttt");
			}, function() {
				$(this).removeClass("ttt");
			});

	/*
	 * 消除（更多）应该是在从数据库读取文件后进行判断后设置
	 */
	/*
	 * function chan(){ var a=parseInt($(".branwall").eq("0").css("width"));
	 * if(a==242){ $(this).find(".more").html(null); }else{ } }
	 * $().click(function(){chan();});
	 */

	/* 商标墙的鼠标hover显示 */
	$(".a_hid").hover(function() {
				$(this).find(".show_hidden").stop(true, true).fadeIn(100);
			}, function() {
				$(this).find(".show_hidden").stop(true, true).fadeOut(100);
			});

	$(".a_hid").each(function(i, d) {
				$(this).click(function() {
							$(window).attr("location", "#");
						});
			});

	/* model */
	function md(data) {
		var model = "<div class=\"goods_box\">"
				+ "<span class=\"goodshid\" hidden=\"hidden\">" + data.id
				+ "</span>" + "<img alt=\"\" src=\"" + data.imageurl + "\">"
				+ "<div class=\"content_box\">" + "<p>" + data.name + "</p>"
				+ "<span>" + data.price + "元" + "</span>" + "</div>" + "</div>";

		$(".goods").append(model);
	};

	function goodsjumb() {
		$(".goods_box").click(function() {
			var getid = $(this).find(".goodshid").text();
			var address = "http://localhost:8080/fake_market/jsp/goods.jsp?id=";
			$(location).attr("href", address + getid);
		});
	}

	/* 商品展示 */
	function show_goods() {

		var c = {
			"a" : times,
			"b" : "50"
		};

		$.ajax({
					type : "post",
					url : "/fake_market/goods/showquery",
					data : JSON.stringify(c),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						$.each(data, function(i, good) {
									md(good);
								});
						goodsjumb();
						times++;
					},
					error : function() {
						alert("查询失败！");
					}

				});

	};

	loginChange();
	function loginChange() {
		if (name != "") {
			$("#loginchange").css("color", "red");
			$("#loginchange").text(name);
			$(".bottom_half").eq(2).css("display", "block");
		} else {
			$(".bottom_half").eq(2).css("display", "none");
		}
	}
	// 用户已登陆，阻止a标签跳转登陆页面
	$("#loginchange").click(function() {
				if (name != "") {
					$("#loginchange").attr("href", "");
				}
			});

	/*
	 * 用来打断点进入查看jquery源码入口
	 */
	console.log($());

});