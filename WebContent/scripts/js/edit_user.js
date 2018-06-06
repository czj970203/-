
$.ajax({
		url: 'http://localhost:8080/Tickets/member/info',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.result == true) {
                var object = data.object;
                $('#password').val(object.password);
                $('#name').val(object.name);
                $('#telephone').val(object.telephone);
                $('#sex').val(object.sex==0?"男":"女");
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
		url: 'http://localhost:8080/Tickets/member/edit',
        type: 'post',
        dataType: 'json',
        data:{
        	password:$('#password').val(),
        	name:$('#name').val(),
        	telephone:$('#telephone').val(),
        	sex:$('#sex').val(),
        },
        success: function (data) {
            if (data.result == true) {
                alert("信息修改成功！");
                top.location = "http://localhost:8080/Tickets/page/user_info.html";
            } else {
                alert('编辑失败，原因：'+data.reason);
            }
        },
        error: function (data) {
            alert('服务器连接失败');
        }
	});
}
	
	
