<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>欢迎登录</title>
<link rel="stylesheet" type="text/css" href="${path}/staticResource/css/login/normalize.css" />
<link rel="stylesheet" type="text/css" href="${path}/staticResource/css/login/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${path}/staticResource/css/login/component.css" />
<!--[if IE]>
    <script src="${path}/staticResource/javascript/login/html5.js"></script>
    <![endif]-->
<script src="${path}/js/jquery-3.1.1.js"></script>
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="../login.do" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="loginName" id="loginName" class="text"
									   style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="loginPwd" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value=""
									   type="password" placeholder="请输入密码">
							</div>
							<div class="" >
								<input name="remember" id="remember" type="checkbox">&nbsp;记住密码
									<a href="" style="float: right;color: #FFFFFF">忘记密码？</a>
							</div>
							<div class="mb2"><a class="act-but submit" id="loginBtn" href="javascript:;void(0)"
									onclick="login()"	style="color: #FFFFFF">登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${path}/staticResource/javascript/login/TweenLite.min.js"></script>
		<script src="${path}/staticResource/javascript/login/EasePack.min.js"></script>
		<script src="${path}/staticResource/javascript/login/rAF.js"></script>
		<script src="${path}/staticResource/javascript/login/demo-1.js"></script>
		<script src="${path}/staticResource/javascript/login/login.js"></script>
		<div style="text-align:center;">
</div>
	</body>
</html>