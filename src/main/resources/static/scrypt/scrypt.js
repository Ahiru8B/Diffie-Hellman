$(document).ready(() => {
	
	$("body").on("click", "#aliceEncrypt", function() {
		console.log("click");
		aliceEncrypt();
	})

	function aliceEncrypt() {
		let text = $("#aliceTextMessage").val();
		console.log(text);
		$.ajax({
			url: "./api/encrypt/Alice/" + text,
			type: 'GET',
			async: false,
			success: function(res) {
				console.log("click");
				$("#bobIncomingMessage").val(res);
				console.log(res);
			},
			error: function encryptError (e) {
				console.log(e["responseJSON"]["message"]);
				$("#bobIncomingMessage").val("from alice to bob");
			}
		});
	}
	
		$("body").on("click", "#bobEncrypt", function() {
		console.log("click");
		bobEncrypt();
	})

	function bobEncrypt() {
		let text = $("#bobTextMessage").val();
		console.log(text);
		$.ajax({
			url: "./api/encrypt/Bob/" + text,
			type: 'GET',
			async: false,
			success: function(res) {
				console.log("click");
				$("#aliceIncomingMessage").val(res);
				console.log(res);
			},
			error: function encryptError (e) {
				$("#aliceIncomingMessage").val("from bob to alice");
				console.log(e["responseJSON"]["message"]);
			}
		});
	}



});