$(document).ready(function() {

	var url = window.location.search;
	var urlsb = url.substring(4);
	goodsid = urlsb;
	$numIn = $("input.numberIn");

	// 数量输入验证
	$numIn.on("change", function() {
				lengthCheck();

			});

	// 立即购买触发
	$(".firstOne").click(function() {
				lengthCheck();
				ifLogin("any");
			});

	// 数量输入判断方法
	function lengthCheck() {
		var numberIn = $numIn.val();
		if (isNaN(numberIn)) {
			alert("件数必须是数字！");
			$numIn.val(1);
		} else if (numberIn.length > 4) {
			alert("大小不超过4位数！");
			$numIn.val(1);
		} else if (numberIn.length <= 0) {
			alert("输入不可为空！");
			$numIn.val(1);
		}
	}

	// 跳转到当前页面查询展示
	ajaxLoad();
	function ajaxLoad() {
		var Data = {
			"id" : goodsid
		};
		$.ajax({
					type : "post",
					url : "http://localhost:8080/fake_market/goods/getbyid",
					data : JSON.stringify(Data),
					dataType : "json",
					contentType : "application/json;charset=utf-8",
					success : function(data) {
						$(".title").text(data.name);
						$(".subTitle").text(data.description);
						$(".bigShow img").attr("src", data.imageurl);
						$(".bigDown").text(data.price);
						$(".saveNumber").text(data.number);
						$(".showList img").hover(function() {
									$(".bigShow img").attr("src",
											$(this).attr("src"));
								}, function() {

								});
					},
					error : function() {
						alert("查询失败！");
					}
				});

	}

	// 购物车添加
	$(".secondOne").click(function() {
				ifLogin();
			});

	// login判断
	function ifLogin() {
		var param = arguments[0];

		$.ajax({
			type : "get",
			url : "http://localhost:8080/fake_market/user/checkState",
			dataType : "json",
			success : function(data) {
				if (data == "1") {
					if (param != null) {
						var address = "http://localhost:8080/fake_market/jsp/pay.jsp?price={0}&buynumber={1}";
						$(location).attr(
								"href",
								address.placeholder($(".bigDown").text(),
										$numIn.val()));
					} else {
						sessionCart();
						orderlistCart();
					}
				} else if (data == "0") {
					if (window.confirm("未登录！是否登陆？")) {
						window.location
								.href("http://localhost:8080/fake_market/jsp/login.jsp");
					} else {
						alert("未添加成功！");
					};
				}
			},
			error : function() {
			}
		});

	}

	/*
	 * 
	 * 存放到session的部分
	 * 
	 */
	function sessionCart() {
		var address;
		var argument;
		if (arguments.length != 0) {
			argument = arguments[0];
			if (argument) {
				address = "http://localhost:8080/fake_market/orderlist/cart?id={0}&num={1}&times="
						+ argument;
			}
		} else {
			address = "http://localhost:8080/fake_market/orderlist/cart?id={0}&num={1}";
		}
		$.ajax({
					type : "get",
					url : address.placeholder(goodsid, $numIn.val()),
					dataType : "json",
					contentType : "application/json;charset=utf=8",
					complete : function(xhr, status) {
						// 拦截器实现超时跳转到登录页面
						// 通过xhr取得响应头
						var REDIRECT = xhr.getResponseHeader("REDIRECT");
						// 如果响应头中包含 REDIRECT 则说明是拦截器返回的
						if (REDIRECT == "REDIRECT") {
							var win = window;
							while (win != win.top) {
								win = win.top;
							}
							// 重新跳转到 login.html
							var newH = xhr.getResponseHeader("CONTEXTPATH");
							win.location.href = newH;
						}
					},
					success : function(data) {
						if (data == 2) {
							if (window.confirm('商品最近已经添加是否覆盖？')) {
								// 二次调用判断是已存在
								sessionCart(true);
							} else {
								alert("没有添加！");
							}
						} else if (data == 1) {
							alert("商品添加成功！");
						}
					},
					error : function() {

					}
				});
	}

	// orderlist部分
	function orderlistCart() {
		var ol = {
			"number" : $numIn.val(),
			"goods" : {
				"id" : goodsid
			}
		};

		$.ajax({
					type : "post",
					url : "http://localhost:8080/fake_market/orderlist/add",
					data : JSON.stringify(ol),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					complete : function(xhr, status) {
						// 拦截器实现超时跳转到登录页面
						// 通过xhr取得响应头
						var REDIRECT = xhr.getResponseHeader("REDIRECT");
						// 如果响应头中包含 REDIRECT 则说明是拦截器返回的
						if (REDIRECT == "REDIRECT") {
							var win = window;
							while (win != win.top) {
								win = win.top;
							}
							// 重新跳转到 login.html
							var newH = xhr.getResponseHeader("CONTEXTPATH");
							win.location.href = newH;
						}
					},
					seccess : function(data) {
						alert("保存成功！");

					},
					error : function() {
						alert("wrong!");
					}
				});
	}

	// 点击增加
	$("span.upImg").click(function() {
				var newnum = parseInt($numIn.val()) + 1;
				if (newnum > 9999) {
					alert("数量不能超过9999！");
				} else {
					$numIn.val(newnum);
				}

			});
	// 点击减少
	$("span.downImg").click(function() {
				var newnum = parseInt($numIn.val()) - 1;
				if (newnum < 1) {
					alert("最小数量为1！");
				} else {
					$numIn.val(newnum);
				}

			});

	/*
	 * 给String添加一个方法，用来实现占位符
	 */
	String.prototype.placeholder = function() {
		if (arguments.length === 0) {
			return this;
		}
		var param = arguments[0], str = this;
		if (typeof(param) === 'object') {
			for (var key in param) {
				str = str.replace(new RegExp("\\{" + key + "\\}", "g"),
						param[key]);
			}
			return str;
		} else {
			for (var i = 0; i < arguments.length; i++) {
				str = str.replace(new RegExp("\\{" + i + "\\}", "g"),
						arguments[i]);
			}
			return str;
		}
	};

});