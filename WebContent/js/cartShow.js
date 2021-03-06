$(document).ready(function() {
	$commonlist = $("div.commonList");

	var cartshow = new CartShow();
	zm("/goods/cartShow");
	var urlS = window.location.search;
	// 跳转是否带参 判断
	if (urlS.length > 0) {
		var urlN = urlS.substring(5);
		if (urlN == "cart") {
			$("div.showHead").css("color", "");
			$("div#notUsedList").css("color", "#FF6000");
			zm("/orderlist/statelist?bool=false");
		}
	}

	// button样式改变
	$("button#sub").mousedown(function() {
				this.style.border = "#00d936";
				this.style.background = "#00d936";
			});
	$("button#sub").mouseup(function() {
				this.style.border = "";
				this.style.background = "";
			});
	// 结算 新添加模块没有实现结算
	$("button#sub").click(function() {
				cartshow.paylist();
			});
	// 默认非全选
	$("input#allChecked").prop("checked", false);

	// checkBox全选事件触发
	$("input#allChecked").on("change", function() {
				if ($(this).prop('checked')) {
					$("input[name='choose']").prop("checked", true);
				} else {
					$("input[name='choose']").prop("checked", false);
				}

			});
	// 子元素非全选时取消全选
	$commonlist.on("change", "input[name='choose']", function() {
				if (!this.checked) {
					$("input#allChecked").prop("checked", false);
				}
			});
	// 三个不同div查询切换
	$("div.showHead").on("click", function() {
				$("div.showHead").css("color", "");
				$("input#allChecked").prop("checked", false);
				this.style.cssText = "color:#FF6000";
				if (this.id == "newList") {
					zm("/goods/cartShow");
				} else if (this.id == "notUsedList") {
					zm("/orderlist/statelist?bool=false");
				} else if (this.id == "paidList") {
					zm("/orderlist/statelist?bool=true");
				}
			});

	// 定义类
	function CartShow() {
	}

	CartShow.prototype.paylist = function() {
		var dataA = [];
		var priceCount = 0;
		$("input[name='choose']").each(function() {
			if ($(this).is(":checked")) {
				// 拿到数据
				var id = $(this).parent().find("input[name='orderListId']")
						.val();
				dataA.push(id);
				var M = $(this).parent().find("div.countM span").text();
				priceCount = priceCount + parseInt(M);
			}
		});
		if (window.confirm("支付" + priceCount + "？")) {
			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/orderlist/paylist",
						data : JSON.stringify(dataA),
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
						success : function(data) {
							if (data == "1") {
								alert("支付成功请刷新页面！");
							} else {
								alert("库存不足请确定库存后重新下单！");
							}
						},
						error : function() {
							alert("false");
						}
					});
		}
	}

	// 查询session中的cart信息，返回值是map(未使用)
	CartShow.prototype.checkShow = function() {
		$.ajax({
					type : "post",
					url : "http://localhost:8080/fake_market/orderlist/aaa",
					dataType : "json",
					success : function(data) {
						if (data[0] == 0) {
							alert("暂无物品在购物车中");
						} else {
							for (var key in data) {
								alert("物品id：" + key + "物品数量：" + data[key]);
							}
						}
					},
					error : function() {
					}
				})
	}

	// 查询数据显示拼接html
	CartShow.prototype.models = function() {
		var param = arguments[0];
		if (arguments.length == 2) {
			var param2 = arguments[1];
			if (param2.payState) {
				var pay = "交易成功";
				var payData = param2.payData;
			} else {
				var pay = "未下单";
				var payData = "";
			}
			var model2 = "<div class=\"showList\" >"
					+ "<input type=\"checkbox\" name=\"choose\" >"
					+ "<input name=\"orderListId\" type=\"hidden\" value=\""
					+ param2.id + "\"/>" + "<div class=\"pic\">"
					+ "	<img alt=\"\" src=\"" + param2.goods.imageurl + "\">"
					+ "</div>" + "<div class=\"titleM\">" + "	<span>"
					+ param2.goods.name + "</span><br/>" + "	<span>"
					+ param2.goods.store + "</span>" + "</div>"
					+ "<div class=\"priceM\">" + param2.goods.price + "</div>"
					+ "<div class=\"numberM\">" + param2.number + "</div>"
					+ "<div class=\"soldM\">" + "	<span>申请售后</span>" + "</div>"
					+ "<div class=\"countM\">" + "	<span>" + param2.goods.price
					* param2.number + "</span>" + "</div>"
					+ "<div class=\"stateM\">" + "	<span>" + pay
					+ "</span></br>" + "<span>" + payData + "</span>"
					+ "</div>" + "<div class=\"reviewM\">" + "	<span>评论</span>"
					+ "</div>" + "<div class=\"logisticsM\">"
					+ "	<span>查看物流</span>" + "</div>" + "</div>";
		}

		var model = "<div class=\"showList\" >"
				+ "<input type=\"checkbox\" name=\"choose\">"
				+ "<div class=\"pic\">" + "	<img alt=\"\" src=\"" + param[0]
				+ "\">" + "</div>" + "<div class=\"titleM\">" + "	<span>"
				+ param[1] + "</span><br/>" + "	<span>" + param[2] + "</span>"
				+ "</div>" + "<div class=\"priceM\">" + param[3] + "</div>"
				+ "<div class=\"numberM\">" + param[4] + "</div>"
				+ "<div class=\"soldM\">" + "	<span>申请售后</span>" + "</div>"
				+ "<div class=\"countM\">" + "	<span>" + param[3] * param[4]
				+ "</span>" + "</div>" + "<div class=\"stateM\">"
				+ "	<span>未下单</span>" + "</div>" + "<div class=\"reviewM\">"
				+ "	<span>评论</span>" + "</div>" + "<div class=\"logisticsM\">"
				+ "	<span>查看物流</span>" + "</div>" + "</div>";

		var nullDiv = "<div class=\"nullDiv\">最近未添加商品 </div>";

		if (param == false) {
			$commonlist.append(nullDiv);
		} else if (param == "orderlist") {
			$commonlist.append(model2);
		} else {
			$commonlist.append(model);
		}
	}

	// 购物车数据查询
	function zm() {
		var param = arguments[0];

		var adress = "http://localhost:8080/fake_market" + param;

		$.ajax({
					type : "get",
					url : adress,
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
					success : function(data) {
						$commonlist.children().remove();
						if (param == "/goods/cartShow") {
							for (var i in data) {
								if (data[i][0] == "0" && data[i][1] == "0"
										&& data[i][2] == "0") {
									cartshow.models(false);
									break;
								}
								cartshow.models(data[i]);
							}
						} else {
							if (data.length == 0) {
								cartshow.models(false);
							} else {
								for (var i in data) {
									cartshow.models("orderlist", data[i]);
								}
							}
						}
					},
					error : function() {
					}
				});
	}

});