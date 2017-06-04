$(function(){
	$(".comp-list-tab").on("click",".cancel-comp-btn",function(){
		var idStr=$(this).attr("id");
		var id=idStr.substring(12,idStr.length);
		$.ajax({
			url:"cancelCompetition.action",
			type:"POST",
			data:{
				ci:id
			},
			success:function(data){
				if(data==="1"){
					$(".operation-tips").html("取消成功！正在跳转……");
				}
				else if(data=="0"){
					$(".operation-tips").html("取消失败！正在跳转……");
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
	});
});