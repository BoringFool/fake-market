$(document).ready(function() {
	$commonlist=$("div.commonList");
	var cartshow = new CartShow();
	zm("/goods/cartShow");
	$("button#sub").click(function() {

			});

	$("div.showHead").click(function() {
				$("div.showHead").css("color", "");
				this.style.cssText = "color:#FF6000";
				if(this.id=="newList"){
					alert(this.id);
					zm("/goods/cartShow");
				}else if(this.id=="notUsedList"){
					alert(this.id);
				}else if(this.id=="paidList"){
					alert(this.id);
				}
			});
	function CartShow() {
	}

	CartShow.prototype.aj = function() {
		var da = {
			"orderNumber" : {
				1 : 245,
				2 : 24
			}
		};

		$.ajax({
					type : "post",
					url : "http://localhost:8080/fake_market/orderlist/paylist",
					data : JSON.stringify(da),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						alert(data);
					},
					error : function() {
						alert("false");
					}

				});

	}

	CartShow.prototype.checkShow = function() {
		alert(2);
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

	CartShow.prototype.models = function() {
		var param = arguments[0];

		var model = "<div class=\"showList\" >" + "<input type=\"checkbox\" >"
				+ "<div class=\"pic\">" + "	<img alt=\"\" src=\"" + param[0]
				+ "\">" + "</div>" + "<div class=\"titleM\">" + "	<span>"
				+ param[1] + "</span><br/>" + "	<span>" + param[2] + "</span>"
				+ "</div>" + "<div class=\"priceM\">" + param[3] + "</div>"
				+ "<div class=\"numberM\">" + param[4] + "</div>"
				+ "<div class=\"soldM\">" + "	<span>申请售后</span>" + "</div>"
				+ "<div class=\"countM\">" + "	<span>" + param[3] * param[4]
				+ "</span>" + "</div>" + "<div class=\"stateM\">"
				+ "	<span>交易成功</span>" + "</div>" + "<div class=\"reviewM\">"
				+ "	<span>评论</span>" + "</div>" + "<div class=\"logisticsM\">"
				+ "	<span>查看物流</span>" + "</div>" + "</div>";
		var nullDiv = "<div class=\"nullDiv\">最近未添加商品 </div>";
		
		$commonlist.children().remove();
		
		
		
		if (param == false) {
			$commonlist.append(nullDiv);
		} else {
			$commonlist.append(model);
		}

	}

	function zm() {
		var param=arguments[0];
		
		var adress = "http://localhost:8080/fake_market"+param;
		$.ajax({
					type : "post",
					url : adress,
					dataType : "json",
					success : function(data) {

						for (var i in data) {
							if (data[i][0] == "0" && data[i][1] == "0"
									&& data[i][2] == "0") {
								cartshow.models(false);
								break;
							}
							cartshow.models(data[i]);
						}
					},
					error : function() {
					}
				})
	}

});