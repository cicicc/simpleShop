<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript" >
	$(function(){

	    //给用户名框绑定一个事件 异步查询数据库中的数据 判断是否有相同的用户名已经被使用
	    $("#username").blur(function () {
			//获取文本框的值
            var value = $(this).val();
            //异步提交数据
            if (value != null) {
                var url = "${pageContext.request.contextPath}/userServlet";
                var params = {"method": "checkUsername", "username": value};
                $.get(url, params, function(data){
                    //alert(data)
                    if (data != -1) {
                        $("#remind").html("用户名可以使用").css("color","#0f0");
                    } else {
                        $("#remind").html("用户名已经被使用").css("color", "#f00");
                    }
				});
            }
        });

		//获取密码框和确认密码框的输入 并且判断两次输入是否一致 如果不一致的话 那么就提醒用户
	    $("#confirmpwd").blur(function(){
           	var confirmValue = $(this).val();
            var password = $("#password").val();
            //alert(confirmValue);
            //alert(password);
            if (confirmValue != password) {
                $("#verifyPassword").html("您两次输入的密码不同 请确认后重新输入").css("color", "#f00");
            } else if (confirmValue==password) {
                $("#verifyPassword").html("您两次输入的密码相同,请记住您的密码").css("color", "#0f0");

            }
		});
	    $("#email").blur(function () {
			var mail = $(this).val();
			if (mail != "") {//判断
				var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
				if (!reg.test(mail)) {
					//alert('邮箱格式不正确，请重新填写!');
                    $("#emailInfo").html("您的邮箱格式不正确，请重新填写!").css("color", "#f00");
				}else{
                    $("#emailInfo").html("");
				}
			}
		});

	});
</script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">

				<font>会员注册</font>USER REGISTER
				<form class="form-horizontal" style="margin-top: 5px;" method="post" action="${pageContext.request.contextPath}/userServlet?method=register">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"  name="username"
								placeholder="请输入用户名">
							<div id="remind"></div>

						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"  name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="confirmpwd"
								placeholder="请输入确认密码">
							<div id="verifyPassword"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
							<div id="emailInfo"></div>
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label" >性别</label>
						<div class="col-sm-6">
							<label class="radio-inline" > <input type="radio"
								name="sex" id="inlineRadio1" value="男">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="女">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control"  name="birthday">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="date" name="verificationCode">

						</div>
						<div class="col-sm-2">
							<img src="./image/captcha.jhtml" />
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




