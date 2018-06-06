
$.ajax({
		url: 'http://localhost:8080/Tickets/hall/info',
        type: 'post',
        dataType: 'json',
        success: function (data) {
            if (data.result == true) {
                var object = data.object;
                $('#password').val(object.password);
                $('#hallName').val(object.hallName);
                $('#address').val(object.address);
                $('#juniorNum').val(object.juniorNum);
                $('#seniorNum').val(object.seniorNum);
                $('#percent').val(object.percent);
                $('#banner').html("Welcome, " + object.hallName + "(" + object.hallNo + ")");
                $('#hidden').val(object.hallNo);
                $.ajax({
                	url: 'http://localhost:8080/Tickets/update/info',
                    type: 'post',
                    dataType: 'json',
                    data : {
                    	hallNo : $('#hidden').val()
                    },
                    success : function(data){
                    	if(data.object != null){
                    		$('#state').html("先前更新正在审批中");
                    	}
                    },
                    error: function(){
                    	alert("服务器连接失败");
                    }
                });
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
		url: 'http://localhost:8080/Tickets/hall/edit',
        type: 'post',
        dataType: 'json',
        data:{
        	password:$('#password').val(),
        	hallName:$('#hallName').val(),
        	address:$('#address').val(),
        	juniorNum:$('#juniorNum').val(),
        	seniorNum:$('#seniorNum').val(),
        	percent:$('#percent').val(),
        },
        success: function (data) {
            if (data.result == true) {
                alert("信息修改成功,等待审批！");
                top.location="http://localhost:8080/Tickets/page/hall_info.html";
            } else {
                alert('编辑失败，原因：'+data.reason);
            }
        },
        error: function (data) {
            alert('服务器连接失败');
        }
	});
}
	
	
