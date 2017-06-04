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
	$(".next-page-btn").click(function(){
		if(!checkForm($(".first-page input[type$='text'],#competitionDetailsInput"))){
			$(".show-tips-btn").click();
			return false;
		}
		$(".all-page").toggleClass("next");
	});
	$(".last-page-btn").click(function(){
		$(".all-page").toggleClass("next");
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
	$(".apply-btn").click(function(){
//		if(!checkForm($("#compeition-apply-form input[type$='text']"))){
//			return false;
//		}
		var url="/index.jsp";
		$.ajax({
			url:"addCompetition.action",
			type:"POST",
			data:$("#compeition-apply-form").serialize(),
			success:function(data){
				if(data==="1"){
					url="myCompetitions.action";
					$(".text-success").html("赛事申请提交成功！正在跳转……");
				}
				else if(data=="0"){
					url="addCompetition.action";
					$(".text-success").html("赛事申请提交失败！正在跳转……");
				}
				else{
					url="exit.action";
					$(".text-success").html("未登录！正在跳转……");
				}
			}
		});
		$(".all-page").removeClass("next").addClass("tips");
		setTimeout(function(){
			window.location.href=url;
		},3000);
		
	});
	$("#field-type-select").change(function(){
		var typeId=$(this).val();
		$("#field-info-select").empty();
		$.ajax({
			url:"getFields.action",
			type:"POST",
			data:{
				fieldtypeId:typeId
			},
			success:function(data){
				for(var i in data){
					var option="<option value='"+
					data[i].fieldId+"'>"+
					data[i].fieldName+"</option>";
					$("#field-info-select").append(option);
				}
				$("#field-info-select")[0].selectedIndex=0;
			}
		});
	});
	$("#field-type-select").change();
});
