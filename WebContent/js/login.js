function login(){
	 var name = $("#name").val(); //获取
	 var password = $("#password").val(); //获取
		if(name && password != ""){
			$.ajax({
				url : 'http://localhost:8080/admin/adminLogin',
				data : {'name': name,'password': password},
				dataType : 'json',
				success : function(data) {
					if (data.msg == "") {
						alert("用户名或密码错误");
					} else {
						window.location.href ='index.html';
					
					}
				},
				error : function() {
					alert("系统错误");
				}
			});
	}
}