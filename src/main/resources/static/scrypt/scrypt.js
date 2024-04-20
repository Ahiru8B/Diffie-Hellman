$(document).ready(() => {

	$("body").on("click", "#aliceEncrypt", function() {
		console.log("click");
		aliceEncrypt();
	})

	function aliceEncrypt() {
		let text = $("#aliceTextMessage").val();
		console.log(text);
		message = {};
		message["person"] = "Alice";
		message["message"] = text;
		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(message),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/encrypt/",
			async: false,
			success: function(res) {
				console.log(res);
				$("#bobIncomingMessage").val(res["message"]);

				message = {};
				message["person"] = "Bob";
				message["message"] = $("#bobIncomingMessage").val();
				$.ajax({
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(message),
					dataType: 'json',
					caches: false,
					timeout: 600000,
					url: "./api/decrypt/",
					async: false,
					success: function(res) {
						console.log(res);
						$("#bobIncomingMessageDecrypted").val(res["message"]);
					},
					error: function(e) {
					}
				});

			},
			error: function(e) {
			}
		});
	}

	$("body").on("click", "#bobEncrypt", function() {
		console.log("click");
		bobEncrypt();
	})

	function bobEncrypt() {
		let text = $("#bobTextMessage").val();
		message = {};
		message["person"] = "Bob";
		message["message"] = text;
		console.log(text);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(message),
			dataType: 'json',
			caches: false,
			timeout: 600000,
			url: "./api/encrypt/",
			async: false,
			success: function(res) {
				console.log("click");
				$("#aliceIncomingMessage").val(res["message"]);
				console.log(res);

				message = {};
				message["person"] = "Alice";
				message["message"] = $("#aliceIncomingMessage").val();
				$.ajax({
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify(message),
					dataType: 'json',
					caches: false,
					timeout: 600000,
					url: "./api/decrypt/",
					async: false,
					success: function(res) {
						console.log(res);
						$("#aliceIncomingDecrypted").val(res["message"]);
					},
					error: function(e) {
					}
				});
			},
			error: function encryptError(e) {
				$("#aliceIncomingMessage").val("from bob to alice");
				console.log(e["responseJSON"]["message"]);
			}
		});
	}



});