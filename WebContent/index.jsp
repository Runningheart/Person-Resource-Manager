<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="static/js/login.js"></script>
<link href="static/css/login2.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<h1>
		人力资源管理系统<sup>V2019</sup>
	</h1>

	<div class="login" style="margin-top: 50px;">
		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="LoginServlet" accept-charset="utf-8" id="login_form"
							class="loginForm" method="post">
							<input type="hidden" name="method" value="login" /> <input
								type="hidden" name="did" value="0" /> <input type="hidden"
								name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="u" name="name"
										value="${cookie.name.value}" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="password"
										value="${cookie.password.value}" class="inputstyle" />
								</div>
							</div>

							<div style="margin-left: 45px; margin-top: 10px">
								<input style="vertical-align: middle;" type="checkbox"
									value="yes" name="remember">记住密码<br />

							</div>

							<div style="padding-left: 50px; margin-top: 20px;">
								<input type="submit" value="登 录" style="width: 150px;"
									class="button_blue" />
							</div>
						</form>
					</div>
				</div>
			</div>
			<!--登录end-->
		</div>
	</div>
</body>
</html>