$(document).ready(function() {
    $("#field-input-form").validate({  
        rules: {  
            'fieldinfo.fieldName': {
            	required: true
            },  
            'fieldinfo.location': {
            	required: true 
            },
            'fieldinfo.size': {
            	required: true,
            	min:0
            },
            'fieldinfo.people': {
            	required: true,
             	min:0
            },
            'fieldinfo.rentH': {
            	required: true,
            	min:0
            }
        },  
        messages: {  
        	'fieldinfo.fieldName': {
            	required: "请输入场地名"
            },  
            'fieldinfo.location': {
            	required: "请输入场地位置" 
            },
            'fieldinfo.size': {
            	required: "请输入场地大小",
            	min:"值必须大于或等于0"
            },
            'fieldinfo.people': {
            	required: "请输入容纳人数",
             	min: "值必须大于或等于0"
            },
            'fieldinfo.rentH': {
            	required: "请输入租用费用",
            	min: "值必须大于或等于0"
            }
        }  
    });  
});  


