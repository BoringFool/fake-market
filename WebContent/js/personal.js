$(document).ready(function() {
	var pass = new Password();
	var mail = new Email();
	var mov = new Move($("table#show"));
	var uri = window.location.search;
	var userName = uri.split("=")[1];
	a();
	function a() {
		$("button#up").click(function() {
					mov.up();
				});
		$("button#down").click(function() {
					mov.down();
				});
		$("button#left").click(function() {
					mov.left();
				});
		$("button#right").click(function() {
					mov.right();
				});
	}

	$("#fir").click(function() {
				$("div.mailChange").css("display", "none");
				$("div.passChange").css("display", "block");
			});
	$("#sec").click(function() {
				$("div.passChange").css("display", "none");
				$("div.mailChange").css("display", "block");
			});

	// 邮箱改变提交
	$("button#changeE").click(function() {
				var $e = $("div.mailChange");
				var all = $e.find("input");
				if (all.eq(1).val() == "") {
					alert("新密码不可为空！");
				} else {
					mail
							.changeE(userName, all.eq(0).val(),
									all.eq(1).val(), $e);
				}
			});
	// 密码输入判断
	$("input#oldE").on("change", function() {
				if (this.value == "") {
					this.style.backgroundColor = "";
				} else {
					mail.checkOld(this.value, this);
				}
			});

	// 密码改变提交
	$("button#change").click(function() {
				var $p = $("div.passChange");
				var all = $p.find("input");
				if (all.eq(1).val() == "") {
					alert("新密码不可为空！");
				} else {
					pass
							.changeP(userName, all.eq(0).val(),
									all.eq(1).val(), $p);
				}
			});
	// 密码输入判断
	$("input#old").on("change", function() {
				if (this.value == "") {
					this.style.backgroundColor = "";
				} else {
					pass.checkOld(this.value, this);
				}
			});

	// page跳转过来首先查询
	showCheck();
	function showCheck() {
		$.ajax({
					type : "get",
					url : "http://localhost:8080/fake_market/user/getbyname?name="
							+ userName,
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
						if(data.length==0){
							alert("用户不存在！");
						}else{
							
							$("td.diff").eq(0).text(data.name);
							$("td.diff").eq(1).text(data.roles[0].name);
							$("td.diff").eq(2).text(data.password);
							$("td.diff").eq(3).text(data.email);
						}
						
					},
					error : function() {
						alert(0);
					}

				});
	}

	// 移动类
	function Move(a) {
		this.up = function() {
			a.stop(true).animate({
						top : "-=100px"
					}, '500', 'linear');
		}
		this.down = function() {
			a.stop(true).animate({
						top : "+=100px"
					}, '500', 'linear');
		}
		this.left = function() {
			a.stop(true).animate({
						left : "-=100px"
					}, '500', 'linear');
		}
		this.right = function() {
			a.stop(true).animate({
						left : "+=100px"
					}, '500', 'linear');
		}

	}

	// 密码操作类
	function Password() {
		this.checkOld = function() {
			var params = arguments;
			var dataU = {
				"name" : userName,
				"password" : params[0]
			};
			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/user/check",
						data : JSON.stringify(dataU),
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
							if (data) {
								params[1].style.backgroundColor = "#53ee5a";
							} else {
								params[1].style.backgroundColor = "#f15064";
							}

						},
						error : function() {
						}
					});
		}
		this.changeP = function() {
			var params = arguments;
			var dataP = {
				"name" : params[0],
				"old" : params[1],
				"new" : params[2],
				"PorE" : "P"
			};

			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/user/change",
						data : JSON.stringify(dataP),
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
							if (data) {
								params[3].get(0).style.display = "none";
								window.location.reload();
							} else {
								alert("修改失败！");
							}

						},
						error : function() {
						}
					});
		}
	}
	// 密码操作类
	function Email() {
		this.checkOld = function() {
			var params = arguments;
			var dataU = {
				"name" : userName,
				"email" : params[0]
			};
			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/user/check",
						data : JSON.stringify(dataU),
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
							if (data) {
								params[1].style.backgroundColor = "#53ee5a";
							} else {
								params[1].style.backgroundColor = "#f15064";
							}

						},
						error : function() {
						}
					});
		}
		this.changeE = function() {
			var params = arguments;
			var dataP = {
				"name" : params[0],
				"old" : params[1],
				"new" : params[2],
				"PorE" : "E"
			};

			$.ajax({
						type : "post",
						url : "http://localhost:8080/fake_market/user/change",
						data : JSON.stringify(dataP),
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
							if (data) {
								params[3].get(0).style.display = "none";
								window.location.reload();
							} else {
								alert("修改失败！");
							}

						},
						error : function() {
						}
					});
		}
	}
});