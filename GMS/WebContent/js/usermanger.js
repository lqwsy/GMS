$(document).ready(function() {
	$("#changepasswordform").validate({  
        rules: {  
        	formGroupInputSmall12: {
            	required: true, 
            	minlength:4,
            	maxlength:20
            },  
            'user.vpassward': {
            	equalTo: formGroupInputSmall12
            },  
        },  
        messages: {  
        	formGroupInputSmall12: {
            	required: "请输入新密码", 
            	minlength:"密码长度为4-20个字符",
            	maxlength:"密码长度为4-20个字符"
            },  
            'user.vpassward': {  
            	equalTo: "两次输入的密码不一样"
            },  
        }  
    });
});
$("#cancelchange").click(function(){
	 $("#surecancel").css("display","none");  
	 $("#changeinfo").css("display","block");  
});
$("#changeuserinfo").click(function(){
	$("#changeinfo").css("display","none");  
	$("#surecancel").css("display","block");  
});










