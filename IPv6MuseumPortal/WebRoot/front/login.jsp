<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

  String error=String.valueOf(request.getAttribute("error")); 
%>
 <!DOCTYPE html>
 <!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>登录页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="<%=path %>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path %>/css/animate.css">
	<link rel="stylesheet" href="<%=path %>/css/style.css">
	<script language="javascript" type="text/javascript">
			$(function() {
				$("#testForm").validate(
					{
						rules: {
							username: {
								required:true,
								email:true
							},
						
							password:{
								required:true,
								rangelength:[6,12]
							}
						},
						messages: {
							username: { 
							    required:"邮箱必填",
								email:"请输入正确的邮箱格式"
							},
							
							password:{
								required:"密码必填",
								rangelength:"密码必须在6~12列之间"

							}
						}

					}
				);

				
			});
		</script>
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="style-3">

		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-push-8">
					

					<!-- Start Sign In Form -->
					<form id="testForm" action="<%=path%>/user/login.do" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInRight">
						<h2>登录</h2>
						<div class="form-group">
							<label for="username" class="sr-only">注册邮箱</label>
							<input type="text" name="username" class="form-control" id="username" placeholder="注册邮箱" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input type="password" name="password" class="form-control" id="password" placeholder="密码" autocomplete="off">
						</div>
						 
						<div class="form-group">
							<%
								if("1".equals(error)){
							 %>
							 	<h2 style="color: red">帐号不存在或密码错误</h2>
							 <%
							      }
							  %>
						</div>
						<!-- 
						<div class="form-group">
							<p><a href="<%= path%>/front/signUP.jsp?error1=2">用户注册</a> </p>
						</div> 
						-->
						<div class="form-group">
							<a href="<%= path%>/front/forget.jsp?error1=2">忘记密码</a> 
						</div>
						<div class="form-group">
							<input type="submit" value="登录" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>
