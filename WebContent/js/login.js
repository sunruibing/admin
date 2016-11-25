function login(){
	//获取参数
	var name = $.trim($("#name").val());
	var password = $.trim($("#password").val());
	var check= true;//表示检测通过 false未通过
	if(name==""){
		check=false;
	}
	if(password ==""){
		check==false;
	}
		if(check){
			$.ajax({
				url : 'http://localhost:8080/admin/adminLogin',
				data : {'name': name,'password': password},
				dataType : 'json',
				success : function(data) {
					if (data.msg == "") {
						alert("用户名或密码错误");
					} else {
						 alert('管理员登录成功！');
						 location.href = "index.html";
						 console.log("保持登录:" + data.msg);
					}
				},
				error : function() {
					alert("系统错误");
				}
			});
	}
}