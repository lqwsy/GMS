$(document).ready(function() {
    $("#changepasspage").css("display","none");  
    $("#usermangerpage").css("display","none");  
    $("#adduserpage").css("display","none");  
    $("#surecancel").css("display","none");
    
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
$("#userinfo").click(function(){
	$("#userinfopage").css("display","block");  
	$("#changepasspage").css("display","none");
    $("#usermangerpage").css("display","none");  
    $("#adduserpage").css("display","none"); 
});
$("#changepass").click(function(){
	$("#userinfopage").css("display","none");  
	$("#changepasspage").css("display","block");
    $("#usermangerpage").css("display","none");  
    $("#adduserpage").css("display","none"); 
});
$("#usermanger").click(function(){
	$("#userinfopage").css("display","none");  
	$("#changepasspage").css("display","none");
    $("#usermangerpage").css("display","block");  
    $("#adduserpage").css("display","none"); 
});
$("#adduser").click(function(){
	$("#userinfopage").css("display","none");  
	$("#changepasspage").css("display","none");
    $("#usermangerpage").css("display","none");  
    $("#adduserpage").css("display","block"); 
});
$("#cancelchange").click(function(){
	 $("#surecancel").css("display","none");  
	 $("#changeinfo").css("display","block");  
});
$("#changeuserinfo").click(function(){
	$("#changeinfo").css("display","none");  
	$("#surecancel").css("display","block");  
});










