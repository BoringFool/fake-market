$(document).ready(function() {
			$("button#sub").click(function() {
						zm();

					});

			
			function CartShow(){
			}
			
			var cartshow=new CartShow();
			CartShow.prototype.aj=function () {
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
			
			CartShow.prototype.checkShow=function (){
				alert(2);
				$.ajax({
					type:"post",
					url:"http://localhost:8080/fake_market/orderlist/aaa",
					dataType:"json",
					success:function(data){
						if(data[0]==0){
							alert("暂无物品在购物车中");
						}else{
							for(var key in data){
								alert("物品id："+ key+"物品数量："+data[key]);
							}
						}
						
							
						
					},
					error:function(){}
				})
			}
			
			
			function zm(){
				$.ajax({
					type:"post",
					url:"http://localhost:8080/fake_market/goods/cartShow",
					dataType:"json",
					success:function(data){
						for(var i in data){
							alert(data[i][0]);
						}
						
							
						
					},
					error:function(){}
				})
			}
		});