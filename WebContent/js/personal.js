$(document).ready(function() {
			var uri = window.location.search;
			var userName = uri.split("=")[1];

			function showCheck() {
				$.ajax({
							type : "get",
							url : "http://localhost:8080/fake_market/user/",
							data : JSON.stringify({
										"name" : userName
									}),
							contentType : "application/json;charset=utf-8",
							dataType : "json",
							sucess : function(data) {

							},
							error : function() {
							}
						});
			}
		});