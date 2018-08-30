$(document).ready(function() {
	/*
	 * 实际上查询展示和模糊查询，都是在第一次查询的时候查询了两次， 因为数据少，直接触发了滚条到底的查询
	 */

	var times = 1;
	// 记录搜索状态,同时用作计算查询位置起始点
	var likeTime = 1;
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
		if ($(document).scrollTop() + $(window).height() == $(document)
				.height()) {

			if (times >= 2) {
				show_goods();
			}
			if (likeTime >= 2) {
				like();
			}
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

	// 搜索调用
	$("input.form_submit").click(function() {
				like();
			});
	// 确保搜索框输入变化后，会清除之前的查询结果
	$("input.form_input").on("change", function() {
				likeTime = 1;
			});

	// 模糊查询
	function like() {
		var dataI = {
			"id" : likeTime,
			"name" : $("input.form_input").val()
		};
		if ($("input.form_input").val().length <= 0) {
			alert("输入不可为空！");
		} else {
			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/goods/likeLimit",
						data : JSON.stringify(dataI),
						contentType : "application/json;charset=utf-8",
						dataType : "json",
						success : function(data) {
							if (likeTime == 1) {
								$(".goods").children().remove();
							}

							$.each(data, function(i, good) {
										md(good);
									});
							goodsjumb();
							likeTime++;
							window.location.href = "#goods";
						},
						error : function() {
							alert("wrong");
						}
					});
		}
	}
	// 跳转cart页面
	$("a#orderlist").click(function() {
		window.location.href = "http://localhost:8080/fake_market/jsp/cartShow.jsp";
	});

	$("a#cart").click(function() {
		window.location.href = "http://localhost:8080/fake_market/jsp/cartShow.jsp?div=cart";
	});

	// 本来准备做实时刷新的，但购物的goods页面是本页跳转，就没有做了
	onTime();
	function onTime() {
		$.ajax({
					type : "get",
					url : "http://localhost:8080/fake_market/orderlist/countcartn",
					dataType : "json",
					success : function(data) {
						$("span#numberOfcart").text(data);
					},
					error : function() {
					}
				});
	}

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

	// 查看登陆者是否有权限,根据权限显示
	loginChange();
	function loginChange() {
		if (name != "") {
			$("#loginchange").css("color", "red");
			$("#loginchange").text(name);
		} else {
			$("li.bottom_half").eq(0).css("display", "none");
			$("li.bottom_half").eq(1).css("display", "none");
		}

		if (roles != "") {
			switch (roles) {
				case "管理员" :
					$("ul#headTitle")
							.append("<li class=\"bottom_half\"><a href=\"manager.jsp\" target=\"_blank\">后台管理</a></li>");
					$("ul#headTitle")
							.append("<li class=\"bottom_half\"><a href=\"user.jsp\" target=\"_blank\">用户管理</a> </li>");
					$("li.bottom_half").eq(0).css("display", "block");
					$("li.bottom_half").eq(1).css("display", "block");
					break;
				case "商人" :
					$("ul#headTitle")
							.append("<li class=\"bottom_half\"><a href=\"manager.jsp\" target=\"_blank\">后台管理</a></li>");
					$("li.bottom_half").eq(0).css("display", "block");
					$("li.bottom_half").eq(1).css("display", "block");
					break;
				case "顾客" :
					$("li.bottom_half").eq(0).css("display", "block");
					$("li.bottom_half").eq(1).css("display", "block");
					break;
				case "游客" :
					break;
			}
		}
	}
	// 用户已登陆，阻止a标签跳转登陆页面
	$("#loginchange").click(function() {
				if (name != "") {
					$("#loginchange").attr("href", "");
				}
			});

	// 用户个人管理div显示管理
	jumpShowOrNot();
	function jumpShowOrNot() {
		var timeout;
		$("#loginchange").hover(function() {
					if (name != "") {
						$("div.userJump").css("display", "block");
					}
				}, function() {
					timeout = setTimeout(function() {
								$("div.userJump").css("display", "none");
							}, 200);

				});

		$("div.userJump").hover(function() {
					clearTimeout(timeout);
					$("div.userJump").css("display", "block");
				}, function() {
					$("div.userJump").css("display", "none");
				});
	}

	//
	$("div.userJump ul li").click(function() {
		var textC = $(this).text();
		if (textC == "账号管理") {
			window.location.href = "http://localhost:8080/fake_market/jsp/personalPage.jsp?name="
					+ name;
		} else if (textC == "退出") {
			$.ajax({
						type : "get",
						url : "/fake_market/user/signout",
						success : function() {
							$("li.bottom_half").css("display", "block");
							window.location.reload();
						},
						error : function() {
							alert("wrong!");
						}
					});
		}
	});

	/*
	 * 用来打断点进入查看jquery源码入口
	 */
	console.log($());

});