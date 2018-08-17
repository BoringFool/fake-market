$(document).ready(function() {
	//jq对象缓存
	var $reg = $("div#register");
	var showWay = new Show();
	showWay.showCheck();
	// 删除授权事件
	$("ul#show").on("click", "button", function() {
		var id = this.parentNode.childNodes[0].innerHTML;
		var roles = $(this).parent()
				.find("select[name=choise] option:selected").text();
		if (this.value == "set") {
			showWay.saveChange(id, roles);
		} else if (this.value == "delete") {
			showWay.saveChange(id);
		}
	});

	//register调用
	$("button#submit").click(function() {
		var name = $reg.find("input#name").val();
		var email = $reg.find("input#email").val();
		var password = $reg.find("input#password").val();
		var rolesName = $reg.find("select option:selected").val();
		if ((name.length <= 0) || (email.length <= 0) || (password.length <= 0)
				|| (rolesName.length <= 0)) {
			alert("输入不可为空，请检查输入！");
		} else {
			registerN(name, email, password, rolesName);
		}
	});

	function Show() {
		var $this = this;
		/*
		 * 展示模板 第一个参数user.id 第二个参数user.name 第三个参数roles
		 */
		var showMod = function() {
			var params = arguments;
			var s1, s2, s3, s4;
			var selectState = "selected=\"selected\"";
			if (params[2].length <= 0) {
				s4 = selectState;
			} else {
				switch (params[2][0]) {
					case 0 :
						s1 = selectState;
						break;
					case 1 :
						s2 = selectState;
						break;
					case 2 :
						s3 = selectState;
						break;
					case 3 :
						s4 = selectState;
						break;
				}
			}
			var mod = "<li>" + "<span class=\"idSpan\" >" + params[0]
					+ "</span>" + "<span class=\"nameSpan\">" + params[1]
					+ "</span>" + "<span>" + "	<select name=\"choise\">"
					+ "	<option value=\"0\" " + s1 + ">管理员</option>"
					+ "	<option value=\"1\" " + s2 + ">商家</option>"
					+ "	<option value=\"2\" " + s3 + ">顾客</option>"
					+ "	<option value=\"3\" " + s4 + ">游客</option>"
					+ "</select>" + "</span>"
					+ "<button type=\"button\" value=\"set\">授权</button>"
					+ "<button type=\"button\" value=\"delete\">删除</button>"
					+ "</li>";

			$("ul#show").append(mod);
		}

		//全部查询和搜索查询
		this.showCheck = function() {
			if (arguments.length <= 0) {
				$.ajax({
							type : "get",
							url : "http://localhost:8080/fake_market/user/showall",
							dataType : "json",
							success : function(data) {
								for (var n in data) {
									showMod(data[n].id, data[n].name,
											data[n].roles);
								}

							},
							error : function() {
							}
						});
			} else {
				$.ajax({
							type : "",
							url : "",
							data : JSON.stringify(),
							contentType : "application/json;charset=utf-8",
							dataType : "json",
							success : function(data) {
							},
							error : function() {
							}
						});
			}

		}

		//删除和授权 通过参数数量来确定调用方法
		this.saveChange = function() {
			if (arguments.length == 1) {
				$.ajax({
							type : "get",
							url : "http://localhost:8080/fake_market/user/delete?id="
									+ arguments[0],
							dataType : "json",
							success : function(data) {
								alert("删除成功！");
								window.location.reload();
							},
							error : function() {
								alert("wrong!");
							}
						});
			} else if (arguments.length == 2) {
				var dataI = {
					"id" : arguments[0],
					"roles" : arguments[1]
				};

				$.ajax({
							type : "post",
							url : "http://localhost:8080/fake_market/user/authorize",
							data : JSON.stringify(dataI),
							contentType : "application/json;charset=utf-8",
							dataType : "json",
							success : function(data) {
								alert("权限更改成功！");
								window.location.reload();
							},
							error : function() {
							}
						});

			}

		}
	}

	// 注册方法
	function registerN() {
		var dataR = {
			"name" : arguments[0],
			"email" : arguments[1],
			"password" : arguments[2],
			"roles" : [{
						"id" : arguments[3]
					}]
		};
		$.ajax({
					type : "post",
					url : "http://localhost:8080/fake_market/user/register",
					data : JSON.stringify(dataR),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						alert("添加成功！");
						window.location.reload();
					},
					error : function() {
						alert("wrong!");
					}
				});
	}
});