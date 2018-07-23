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
	 * 关闭浏览器推出
	 */
	function close() {
		window.opener = null;
		window.close();
	}

	/*
	 * ajax注册
	 */
	function register() {
		var Jdata = {
			"name" : $("#name").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()

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
					}, 4000);

				} else {
					alert("用户已存在");
				}
			},
			error : function() {
				alert("提交失败");
			}
		});

	}

		/*
		 * 差登录验证（密码不为空之类的）
		 */

});