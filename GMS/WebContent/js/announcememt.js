$(document).ready(function() {
	$("#anncouncementform").validate({  
        rules: {  
        	'announcement.vannouncementTitle': {
            	required: true, 
            	minlength:4,
            	maxlength:50
            },  
            'announcement.vannouncementDetails': {
            	required: true, 
            	minlength:20,
            	maxlength:500
            },  
        },  
        messages: {  
        	'announcement.vannouncementTitle': {
            	required: "请输入公告标题", 
            	minlength:"标题内容最少为4个字",
            	maxlength:"标题内容最多为50个字"
            },  
            'announcement.vannouncementDetails': {  
            	required: "请输入公告详情", 
            	minlength:"详情内容最少为20个字",
            	maxlength:"详情内容最多为500个字"
            },  
        }  
    });
});











