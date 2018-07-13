$(document).ready(function(){
	
	$(".firstOne").click(function(){
		lengthCheck();
	});
	
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
	
	
});