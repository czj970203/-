$.ajax({
		url: 'http://localhost:8080/Tickets/member/info',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.result == true) {
                var object = data.object;
                $('#banner').html("Welcome, "+object.email);
            } else {
                alert('信息获取失败，原因：'+data.reason);
            }
        },
        error: function (data) {
            alert('服务器连接失败');
        }
	});
function update(){
	$.ajax({
		url: 'http://localhost:8080/Tickets/member/change_pswd',
        type: 'post',
        dataType: 'json',
        data:{
        	oldPassword:$('#oldpassword').val(),
        	newPassword:$('#newpassword').val(),
        	confirmPswd:$('#confirmPswd').val(),
        },
        success: function (data) {
            if (data.result == true) {
                alert(data.reason);
                top.location = "http://localhost:8080/Tickets/page/user_info.html";
            } else {
                alert('修改失败，原因：'+data.reason);
            }
        },
        error: function (data) {
            alert('服务器连接失败');
        }
	});
}