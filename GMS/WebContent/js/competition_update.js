// JavaScript Document
$(function(){
	$('.form_datetime').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });
	var checkForm=function(objs){
		var flag=true;
		objs.each(function(n){
	          if($(this).val()==""){
	  			  $(".operation-tips").html("请填写 '"+$(this).attr("label")+"'!");
	              flag=false;
	              return false;
	          }
	     });
		return flag;
	};
	$(".update-btn").click(function(){
		if(!checkForm($(".changable input[type$='text'],#competitionDetailsInput"))){
			$(".show-tips-btn").click();
			return false;
		}
		$.ajax({
			url:"updateCompetition.action",
			type:"POST",
			data:$("#compeition-update-form").serialize(),
			success:function(data){
				if(data==="1"){
					$(".operation-tips").html("赛事更新成功！正在跳转……");
				}
				else if(data=="0"){
					$(".operation-tips").html("赛事更新失败！正在跳转……");
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