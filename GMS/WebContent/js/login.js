$(document).ready(function() {
    $("#login_form").validate({  
        rules: {  
            'user.vuserName': {
            	required: true, 
            	minlength:4,
            	maxlength:20
            },  
            'user.vpassward': {
            	required: true, 
            	minlength:4,
            	maxlength:20
            },  
        },  
        messages: {  
        	'user.vuserName': {
            	required: "请输入用户名", 
            	minlength:"用户名长度为4-20个字符",
            	maxlength:"用户名长度为4-20个字符"
            },  
            'user.vpassward': {  
                required: "请输入密码",  
                minlength: "密码长度为4-20个字符",
                maxlength:"密码长度为4-20个字符"
            },  
        }  
    });  
    $("#regist_form").validate({  
    	rules: {  
            'user.vuserName': {
            	required: true, 
            	minlength:4,
            	maxlength:20
            },  
            'vpassward1': {
            	required: true, 
            	minlength:4,
            	maxlength:20
            },
            'user.vpassward': { 
            	equalTo: '#rvPassword1'
            },
            'user.vemail':{
            	required:true,
            	email:true
            }
        },  
        messages: {  
        	'user.vuserName': {
            	required: "请输入用户名", 
            	minlength:"用户名长度为4-20个字符",
            	maxlength:"用户名长度为4-20个字符"
            },  
            'vpassward1': {  
                required: "请输入密码",  
                minlength: "密码长度为4-20个字符",
                maxlength:"密码长度为4-20个字符"
            },
            'user.vpassward': {  
            	 equalTo: "两次输入的密码不一样"  
            },
            'user.vemail':{
            	required:"请输入邮箱",
            	email:"请输入正确的邮箱格式"
            }
        }    
    });  
});  


