init();
function init() {
	$.ajax({
		url : 'http://localhost:8080/Tickets/update/ups',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if(data.result == true){
			var result = data.object;
			for(var i=0;i<result.length;i++){
				$('#updateBody').append('<tr class="unread">'+
						'<td class="cell-status hidden-phone hidden-tablet" id="hallNo'+i+'">'+result[i].hallNo+'</td>'+
						'<td class="cell-status hidden-phone hidden-tablet">'+result[i].hallName+'</td>'+
						'<td class="cell-author">'+result[i].address+'</td>'+
						'<td class="cell-icon">'+result[i].juniorNum+'</td>'+
						'<td class="cell-icon">'+result[i].seniorNum+'</td>'+
						'<td class="cell-icon hidden-phone hidden-tablet">'+result[i].percent+'</td>'+
						'<td class="cell-icon hidden-phone hidden-tablet">'+
						'<button name="approve" type="button" class="btn btn-primary" onclick="approve('+i+')">同意</button>'+
						'<button name="deny" type="button" class="btn btn-danger" onclick="deny('+i+')">拒绝</button>'+
						'</td></tr>');

			}

			}else{
				alert("获取场馆统计失败");
			}
		},
		error : function() {

			alert('数据获取失败');
		}
	});
}

function approve(i){
	var hallNo = $('#hallNo'+i).html();
	var r = confirm("确认同意吗？");
	if(r==true){
	$.ajax({
		url : 'http://localhost:8080/Tickets/manager/approve_update',
		type : 'post',
		dataType : 'json',
		data:{
			hallNo:hallNo
		},
		success:function(data){
			if(data.result==true){
				top.location = 'http://localhost:8080/Tickets/page/approve_reg.html';
				alert("通过更新成功！")
			}else{
				alert("通过更新失败，原因："+data.reason);
			}
		},
		error:function(){
			alert("服务器连接失败！");
		}
	});
	}
}

function deny(i){
	var hallNo = $('#hallNo'+i).html();
	var r = confirm("确认拒绝吗？");
	if(r == true){
	$.ajax({
		url : 'http://localhost:8080/Tickets/manager/deny_update',
		type : 'post',
		dataType : 'json',
		data:{
			hallNo:hallNo
		},
		success:function(data){
			if(data.result==true){
				top.location = 'http://localhost:8080/Tickets/page/approve_reg.html';
				alert("拒绝更新成功！");
			}else{
				alert("拒绝更新失败，原因："+data.reason);
			}
		},
		error:function(){
			alert("服务器连接失败！");
		}
	});
	}
}

