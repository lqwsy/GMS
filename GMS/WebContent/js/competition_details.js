$(function(){
	var verifyRequest=function(operation){
		$.ajax({
			url:"verifyCompetition.action",
			type:"POST",
			data:{
				ci:$("#ci").val(),
				operation:operation
			},
			success:function(data){
				if(data==="1"){
					$(".operation-tips").html("操作成功！正在跳转……");
				}
				else if(data=="0"){
					$(".operation-tips").html("操作失败！正在跳转……");
				}
				else{
					$(".operation-tips").html("没有操作权限！");
				}
				$(".show-tips-btn").click();
				setTimeout(function(){
					location.reload();
				},3000);
			}
		});
	};
	$(".pass-btn").click(function(){
		verifyRequest("pass");
	});
	$(".unpass-btn").click(function(){
		verifyRequest("unpass");
	});
});