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
	var pageGenerate=function(cur,count){
		var url="searchAllCompetitions.action?page=";
		var curPage=cur;
		var maxPages=Math.ceil(count/10);
		var sPage=1;
		var pagesUlObj=$(".pages-ul");
		var refreshPages=function(){
			pagesUlObj.html(" ");
			pagesUlObj.append("<li><a class='last-btn' href='javascript:void(0);'>&laquo;</a></li>");
			if(sPage+4<maxPages){
				for(var i=0;i<4;i++){
					pagesUlObj.append("<li class='pagenum'><a href='searchAllCompetitions.action?page="+(sPage+i)+"'>"+(sPage+i)+"</a></li>");
				}
				pagesUlObj.append("<li class='more-points pagenum'><a href='javascript:void(0);'>...</a></li>");
				pagesUlObj.append("<li class='pagenum'><a href='searchAllCompetitions.action?page="+maxPages+"'>"+maxPages+"</a></li>");
			}
			else{
				for(var j=0;j<=maxPages-sPage;j++){
					pagesUlObj.append("<li class='pagenum'><a href='searchAllCompetitions.action?page="+parseInt(sPage+j)+"'>"+(sPage+j)+"</a></li>");
				}
			}
			pagesUlObj.append("<li><a class='next-btn' href='javascript:void(0);'>&raquo;</a></li>");
			//pagesUlObj.find("li.pagenum").eq(0).addClass("active");
			lightUpBtn();
		};
		var lightUpBtn=function(){
			if(curPage===maxPages){
				pagesUlObj.find("li.pagenum").removeClass("active");
				pagesUlObj.find("li:last-child").prev("li").addClass("active");
				return;
			}
			pagesUlObj.find("li.pagenum").removeClass("active");
			pagesUlObj.find("li.pagenum").eq(curPage-sPage).addClass("active");
		};
		var hasMore=function(){
			if(pagesUlObj.find("li.pagenum").hasClass("more-points")){
				return true;
			}
			return false;
		};
		$(".pages-ul").on('click','.last-btn',function(){
			if(curPage<=1){
				return;
			}
			if(curPage-sPage===1){
				if(curPage<=4){
					sPage=1;
				}
				else{
					sPage=curPage-3;
				}
				refreshPages();
			}
			curPage--;
			location.href=url+curPage;
			//lightUpBtn();
		});
		$(".pages-ul").on('click','.next-btn',function(){
			if(curPage>=maxPages){
				return;
			}
			if(curPage-sPage===2&&hasMore()){
				sPage=curPage-1;
				refreshPages();
			}
			curPage++;
			location.href=url+curPage;
			//lightUpBtn();
		});
		$(".pages-ul").on('click','li.pagenum',function(){
			var index=$(this).index()-1;
			if($(this).hasClass("more-points")){
				return false;
			}
			if($(this).hasClass("active")){
				return false;
			}
			curPage=parseInt($(this).find("a").html());
			location.href=url+curPage;
//			if(curPage>=4){
//				if(hasMore()&&index===3){
//					sPage=curPage-1;
//					refreshPages();
//				}
//				else if(index===0){
//					sPage=curPage-2;
//					refreshPages();
//				}
//				else if(hasMore()&&curPage===maxPages){
//					sPage=curPage-4;
//					refreshPages();
//				}
//			}
//			else{
//				if(index===0){
//					sPage=1;
//					refreshPages();
//				}
//			}
			//lightUpBtn();
		});
	   refreshPages();
	}
	$(document).ready(function(){
		$.ajax({
			url:"getAllCopetitionsCount.action",
			type:"GET",
			success:function(data){
				if(data!="-1"){
					var cur=$("#cur-page-span").html();
					pageGenerate(parseInt(cur),data);
				}
			}
		});
	});
});