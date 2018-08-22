$().ready(function() {

	/*
	 * ajax
	 */
	$("#submit").click(function() {
				register();

			});

	/*
	 * 调用关闭
	 */
	$("#quit").click(function() {
				close();
			});

	/*
	 * 注册成后显示
	 */
	function change() {
		$(".f_s_s1").css({
					"color" : "#b6b6b6",
					"background-color" : "#efefef"
				});
		$(".f_s_s2").css({
					"color" : "#000000",
					"background-color" : "#f9f9f9"
				});
		$("#quit").css({
					"display" : "block"
				});
		$("#a").css({
					"display" : "none"
				});
		$("#b").css({
					"display" : "none"
				});
	}

	/*
	 * 关闭浏览器退出
	 */
	function close() {
		window.opener = null;
		window.close();
	}

	/*
	 * ajax注册
	 */
	function register() {
		var name = $("#name").val();
		var password = $("#password").val();
		var email = $("#email").val();
		if (name.length <= 0 || password <= 0 || email <= 0) {
			alert("输入不可为空！");
		} else {
			var Jdata = {
				"name" : name,
				"password" : password,
				"email" : email

			};
			$.ajax({
				type : "post",
				url : "/fake_market/user/register",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(Jdata),
				dataType : "json",
				success : function(data) {
					if (data == 1) {
						alert("注册成功");
						change();
						setTimeout(function() {
							$(location)
									.attr("href",
											"http://localhost:8080/fake_market/jsp/login.jsp");
						}, 2000);

					} else {
						alert("用户已存在");
					}
				},
				error : function() {
					alert("提交失败");
				},
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
				}
			});
		}

	}

		/*
		 * 差登录验证（密码不为空之类的）
		 */

});