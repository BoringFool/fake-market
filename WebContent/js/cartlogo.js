$().ready(function() {

	$("div.cart").hover(function() {
				this.style.setProperty("background-color", "#fa1205");
				this.style.setProperty("border-color", "#fa1205");
			}, function() {
				this.style.setProperty("background-color", "#000000");
				this.style.setProperty("border-color", "#000000");
			});

	$("div.cart").click(function() {
		$(location).attr("href",
				"http://localhost:8080/fake_market/jsp/cartShow.jsp");
	});
});