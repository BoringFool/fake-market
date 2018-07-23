$(document).ready(function(){
	$("button#sub").click(function(){
		
		aj();
		
		
	});
	
	function aj(){
		var da={
			"number":1,
			"goods":[
				{
					"id":1,
					"brand":"daddasd"
				},{
					"id":2,
					"brand":"阿斯顿"
				}
			]
		};
		
		
		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/fake_market/orderlist/pay",
			data:JSON.stringify(da),
			contentType:"application/json;charset=utf-8",
			dataType:"json",
			success:function(data){
				alert(data);
			},
			error:function(){}
		
		});
	}
});