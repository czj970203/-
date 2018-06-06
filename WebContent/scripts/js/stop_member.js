function stopMember() {
	var results = $('#banner').html().split(" ");
	var email = results[1];
	var r = confirm("确定要注销会员资格吗？");
	if (r == true) {
		$.ajax({
			url : 'http://localhost:8080/Tickets/member/stopMember',
			type : 'POST',
			dataType : 'json',
			data : {
				email : email
			},
			success : function(data) {
				if (data.result == true) {
					alert("注销成功");
					top.location = "http://localhost:8080/Tickets/page/user_login.html";
				} else {
					alert(data.reason);
				}
			},
			error : function(XMLHttpRequest) {
				alert("服务器连接失败");
			}
		});
		logout();
	}
}