$(function(){
	$(".show-comments-btn").click(function(){
		$(".comments-ul").html("");
		$.ajax({
			url:"getCompetitionComments.action",
			type:"POST",
			data:{
				ci:$("#ci").val()
			},
			success:function(data){
				for(var i in data){
					var li="<li class='list-group-item'>"+
					"<div class='row'>"+
					"<span class='pull-left'><strong>"+data[i].userinfo.vuserName+"</strong></span>"+
					"<span class='pull-right'><small>"+data[i].dcommentTime+"</small></span>"+
					"</div><div class='row'><p>"+data[i].vcommentDetails+"</p></div><div class='row text-right'>"+
					"<a role='button' class='show-reply-btn' data-toggle='collapse' href='#reply"+data[i].bcommentId+"' aria-expanded='false' aria-controls='reply"+data[i].bcommentId+"'>"+
					"查看回复</a></div>"+"<div class='row'>"+"<div class='collapse col-sm-offset-1' id='reply"+data[i].bcommentId+"'>"+
					"<div class='well'><div class='row'><textarea class='form-control textarea"+data[i].bcommentId+"' rows='4'></textarea></div>"+
					"<div class='row text-right'>"+
                    "<button type='button' class='btn btn-default reply-btn'  id='"+data[i].bcommentId+"'>回复</button></div>"+
                    "<div class='row'><ul class='list-group replies-ul"+data[i].bcommentId+"'>"+
                    "</ul></div></div></div></div></li>";
					$(".comments-ul").append(li);
				}
			}
		});
	});
	$(".send-comment-btn").click(function(){
		var contents=$(".comment-textarea").val();
		if($.trim(contents).length<=0){
			$(".operation-tips").html("评论框不能留空！");
			$(".show-tips-btn").click();
			return ;
		}
		$("#comment").val(contents);
		$.ajax({
			url:"addCompetitionComment.action",
			type:"POST",
			data:$("#comment-form").serialize(),
			success:function(data){
				if(data=="-1"){
					$(".operation-tips").html("未登录！请先登录");
					$(".show-tips-btn").click();
					return false;
				}
				var li="<li class='list-group-item'>"+
				"<div class='row'>"+
				"<span class='pull-left'><strong>"+data.userinfo.vuserName+"</strong></span>"+
				"<span class='pull-right'><small>"+data.dcommentTime+"</small></span>"+
				"</div><div class='row'><p>"+data.vcommentDetails+"</p></div><div class='row text-right'>"+
				"<a role='button' class='show-reply-btn' data-toggle='collapse' href='#reply"+data.bcommentId+"' aria-expanded='false' aria-controls='reply"+data.bcommentId+"'>"+
				"查看回复</a></div>"+"<div class='row'>"+"<div class='collapse col-sm-offset-1' id='reply"+data.bcommentId+"'>"+
				"<div class='well'><div class='row'><textarea class='form-control textarea"+data.bcommentId+"' rows='4'></textarea></div>"+
				"<div class='row text-right'>"+
                "<button type='button' class='btn btn-default reply-btn' id='"+data.bcommentId+"'>回复</button></div>"+
                "<div class='row'><ul class='list-group replies-ul"+data.bcommentId+"'>"+
                "</ul></div></div></div></div></li>";
				$(".comments-ul").prepend(li);
				
				$(".comment-textarea").val("");
			}
		});
	});
	$(".cancel-comment-btn").click(function(){
		$(".show-comments-btn").click();
	});
	$(".comments-ul").on("click",".show-reply-btn",function(){
		var idStr=$(this).attr("href");
		var id=idStr.substring(6,idStr.length);
		$("#commentid").val(id);
		$(".replies-ul"+"id").html("");
		$.ajax({
			url:"getCompetitionReplies.action",
			type:"POST",
			data:{
				commentId:$("#commentid").val()
			},
			success:function(data){
				for(var i in data){
					var li="<li class='list-group-item'><div class='row'>"+
						"<span class='pull-left'><strong>"+data[i].userinfo.vuserName+"</strong></span>"+
						"<span class='pull-right'><small>"+data[i].dreplyTime+"</small></span>"+
						"</div><div class='row'>"+
						"<p>"+data[i].vreplyContents+"</p>"+
						"</div></li>";
					$(".replies-ul"+id).append(li);
				}
			}
		});
	});
	$(".comments-ul").on("click",".reply-btn",function(){
		var id=$(this).attr("id");
		var contents=$(".textarea"+id).val();
		$("#reply").val(contents);
		if($.trim(contents).length<=0){
			$(".operation-tips").html("回复框不能留空！");
			$(".show-tips-btn").click();
			return false;
		}
		$.ajax({
			url:"addCompetitionReply.action",
			type:"POST",
			data:$("#reply-form").serialize(),
			success:function(data){
				if(data=="-1"){
					$(".operation-tips").html("未登录！请先登录");
					$(".show-tips-btn").click();
					return false;
				}
				var li="<li class='list-group-item'><div class='row'>"+
					"<span class='pull-left'><strong>"+data.userinfo.vuserName+"</strong></span>"+
					"<span class='pull-right'><small>"+data.dreplyTime+"</small></span>"+
					"</div><div class='row'>"+
					"<p>"+data.vreplyContents+"</p>"+
					"</div></li>";
				$(".replies-ul"+id).prepend(li);
				
				$(".textarea"+$(this).attr("id")).val(" ");
				}
		});
	});
});
