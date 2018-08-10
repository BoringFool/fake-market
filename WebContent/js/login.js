$().ready(function() {

	$("#commit").click(function() {
		var name = $("#name").val();
		var password = $("#password").val();
		if (name == "" || password == "") {
			alert("输入不可为空！");
		} else {
			var Jdata = {
				"name" : name,
				"password" : password
			};

			$.ajax({
				type : "post",
				url : "/fake_market/user/in",
				contentType : "application/json;charset=utf-8",// 指定为json类型，这个属性是配合注解@RequestBody使用的
				dataType : "json",
				data : JSON.stringify(Jdata),
				success : function(data) {
					if (data == 0) {
						alert("密码错误！");
					} else if (data == 3) {
						alert("用户不存在！");
					} else {
						$(location)
								.attr("href",
										"http://localhost:8080/fake_market/jsp/main.jsp");
					}
				},
				error : function() {
					alert("提交失败！");
				}
			});
		}

	});
});