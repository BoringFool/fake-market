$(document).ready(function() {
	var change = new Change();
	var goodsid = judge();

	$(document).ready(function() {

				change.goCheck();
			});

	$(".see").click(function() {
				change.imageview();
			});

	// 属性提交
	$("#sub").click(function() {
				change.ajaxSub();
			});

	// 编辑提交
	$("#allsub").click(function() {
				var a = $(".description").val();
				// 字数限制
				if (a.length > 255) {
					alert("字数不能超过255个！");
				} else {
					change.returnData();
				}
			});

	/*
	 * 防止上传文件选择为空判定,限定只能传jpg
	 */
	$("#fileUploadForm").on("submit", function() {
				if ($("#docFile")[0].files[0]) {
					var tail = $("#docFile").val().toLowerCase().split('.')
							.splice(-1);
					if (tail == "jpg") {
						return true;
					} else {
						alert("必须选择图片!!!");
						return false;
					}

				} else {
					alert("必须选择文件!!!");
					return false;
				}

			});

	/*
	 * 根据地址后缀，判断显示，并获取物品id
	 * 
	 */
	function judge() {
		var url = window.location.search;
		//去除？号
		var urlsb = url.substring(1);
		var urlcutF = urlsb.split("&");
		var urlcutS_f = urlcutF[0].split("=");
		var urlcutS_s = urlcutF[1].split("=");
		// 判断显示div
		if (urlcutS_f != null && urlcutS_f[0] == "div"
				&& urlcutS_f[1] == "attr") {
			$(".allAttr").css("display", "none");
			$(".imageMana").css("display", "none");
		} else if (urlcutS_f != null && urlcutS_f[0] == "div"
				&& urlcutS_f[1] == "allAttr") {
			$(".attr").css("display", "none");
			$(".imageMana").css("display", "none");
		} else if (urlcutS_f != null && urlcutS_f[0] == "div"
				&& urlcutS_f[1] == "imageMana") {
			$(".attr").css("display", "none");
			$(".allAttr").css("display", "none");
		}
		// 获取物品id
		if (urlcutS_s != null && urlcutS_s[0] == "id" && urlcutS_s[1] != null) {
			return urlcutS_s[1];
		} else {
			return 0;
		}
	};

	function Change() {
	}

	/*
	 * 属性提交用
	 */
	Change.prototype.ajaxSub = function() {
		var att = {
			id : goodsid,
			brand : $("#branda").val(),
			size : $("#size").val(),
			color : $("#color").val(),
			imageurl : $("#imageurl").val()
		};
		$.ajax({
			type : "post",
			url : "/fake_market/goods/addgattr",
			data : JSON.stringify(att),
			contentType : "application/json;charset:utf-8",
			success : function(data) {
				if (data == 1) {
					$(location)
							.attr("href",
									"http://localhost:8080/fake_market/jsp/manager.jsp");
				}
			},
			error : function() {
				alert("not ok");
			}
		});
	};

	/*
	 * 跳转到本页面 显示查询
	 */
	Change.prototype.goCheck = function() {
		var data = {
			"id" : goodsid
		};
		$.ajax({
					type : "post",
					url : "/fake_market/goods/getbyid",
					data : JSON.stringify(data),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						$(".id").val(data.id);
						$(".store").val(data.store);
						$(".brand").val(data.brand);
						$(".name").val(data.name);
						$(".imageurl").val(data.imageurl);
						$("#imageurl").val(data.imageurl);
						$(".price").val(data.price);
						$(".color").val(data.color);
						$(".size").val(data.size);
						$(".number").val(data.number);
						$(".description").val(data.description);
					},
					error : function() {

					}
				});
	};
	// 编辑数据提交用
	Change.prototype.returnData = function() {
		var dataC = {
			"id" : $(".id").val(),
			"store" : $(".store").val(),
			"brand" : "_" + $(".brand").val(),
			"name" : $(".name").val(),
			"imageurl" : $(".imageurl").val(),
			"price" : $(".price").val(),
			"color" : $(".color").val(),
			"size" : $(".size").val(),
			"number" : $(".number").val(),
			"description" : $(".description").val()
		};

		$.ajax({
					type : "post",
					url : "/fake_market/goods/addgattr",
					data : JSON.stringify(dataC),
					contentType : "application/json;charset=utf-8",
					dataType : "json",
					success : function(data) {
						$(location)
								.attr("href",
										"http://localhost:8080/fake_market/jsp/manager.jsp");
					},
					error : function() {
					}
				});
	};

	// 图片预览
	Change.prototype.imageview = function() {
		$(".image").trigger("click");
		$(".image").change(function() {
					$("#newfile").val($(this).val());
					$("img").attr("src",
							URL.createObjectURL($(this)[0].files[0]));

					$("#hid").val(goodsid);
				});
	};
});