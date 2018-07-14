$(document).ready(function(){
	
	var url = window.location.search;
	var urlsb = url.substring(4);
	goodsid=urlsb;
	
	$(".firstOne").click(function(){
		lengthCheck();
		var address="http://localhost:8080/fake_market/jsp/pay.jsp?price={0}$buynumber={1}";
		$(location).attr("href",address.placeholder($(".bigDown").text(),$(".numberIn").val()));
	});
	
	//物品数量输入判断
	function lengthCheck(){
		var numberIn=$(".numberIn").val();	
		if(isNaN(numberIn)){
			alert("件数必须是数字！");
		}else if(numberIn.length>4){
			alert("大小不超过4位数！");
		}else if(numberIn.length<=0){
			alert("输入不可为空！");
		}
	}
	
	ajaxLoad();
	function ajaxLoad(){
		var Data={
			"id":goodsid,	
		};
		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/fake_market/goods/getbyid",
			data:JSON.stringify(Data),
			dataType:"json",
			contentType:"application/json;charset=utf-8",
			success:function(data){
				$(".title").text(data.name);
				$(".subTitle").text(data.description);
				$(".bigShow img").attr("src",data.imageurl);
				$(".bigDown").text(data.price);
				$(".saveNumber").text(data.number);
				$(".showList img").hover(function(){
					$(".bigShow img").attr("src",$(this).attr("src"));
				},function(){
					
				});
			},
			error:function(){
				alert("查询失败！");
			}
		});
		
	}
	
	
	
	
	
	
	
	/*
	 * 给String添加一个方法，用来实现占位符
	 */
	String.prototype.placeholder = function() {
		if (arguments.length === 0) {
			return this;
		}
		var param = arguments[0], str = this;
		if (typeof (param) === 'object') {
			for ( var key in param) {
				str = str.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
			}
			return str;
		} else {
			for (var i = 0; i < arguments.length; i++) {
				str = str.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
			}
			return str;
		}
	};
	
	
	
	

});