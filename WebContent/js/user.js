$(document).ready(function() {
	var showWay = new Show();
	showWay.showCheck();
	$("ul#show").on("click", "button", function() {
		var id = this.parentNode.childNodes[0].innerHTML;
		var roles = $(this).parent()
				.find("select[name=choise] option:selected").val();
		
		if (this.value == "set") {
			showWay.saveChange(id, roles);
		} else if (this.value == "delete") {
			showWay.saveChange(id);
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
					+ "	<option value=\"0\" " + s1 + ">商家</option>"
					+ "	<option value=\"1\" " + s2 + ">管理员</option>"
					+ "	<option value=\"2\" " + s3 + ">顾客</option>"
					+ "	<option value=\"3\" " + s4 + ">游客</option>"
					+ "</select>" + "</span>"
					+ "<button type=\"button\" value=\"set\">授权</button>"
					+ "<button type=\"button\" value=\"delete\">删除</button>"
					+ "</li>";

			$("ul#show").append(mod);
		}

		this.showCheck = function() {
			if (arguments.length <= 0) {
				$.ajax({
							type : "get",
							url : "http://localhost:8080/fake_market/user/showall",
							dataType : "json",
							success : function(data) {
								showMod(data[0].id, data[0].name, data[0].roles)
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

		this.saveChange = function() {
			if (arguments.length == 1) {
				$.ajax({
							type : "get",
							url : "http://localhost:8080/fake_market/user/?id="+Arguments[0],
							dataType : "json",
							success : function(data) {
								alert("删除成功！");
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

				/*$.ajax({
							type : "post",
							url : "http://localhost:8080/fake_market/user/",
							data : JSON.stringify(dataI),
							contentType : "application/json;charset=utf-8",
							dataType : "json",
							success : function(data) {
							},
							error : function() {
							}
						});*/
			}

		}
	}

});