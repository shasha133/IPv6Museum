<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Exhibits"%>
<%@page import="com.museum.domain.User"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<User> list = (List<User>)request.getAttribute("list"); 
   String id=String.valueOf(request.getSession().getAttribute("User_id"));
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>个人信息</title>

		<!-- core CSS -->
		<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
		<link href="<%=path %>/css/animate.min.css" rel="stylesheet">
		<link href="<%=path %>/css/prettyPhoto.css" rel="stylesheet">
		<link href="<%=path %>/css/main.css" rel="stylesheet">
		<link href="<%=path %>/css/responsive.css" rel="stylesheet">
		<!--[if lt IE 9]>
    <script src="<%=path %>/js/html5shiv.js"></script>
    <script src="<%=path %>/js/respond.min.js"></script>
    <![endif]-->
		<link rel="shortcut icon" href="<%=path %>/images/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="<%=path %>/images/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114"
			href="<%=path %>/images/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72"
			href="<%=path %>/images/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed"
			href="<%=path %>/images/ico/apple-touch-icon-57-precomposed.png">


	</head>
	<!--/head-->

	<body>

		<div class="container">
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<% for(User e : list){
					if(id!=null){
				 %>
				<div class="row" style="margin-top: 30px">
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<label>
							用户名:
						</label>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<p><%=e.getUserName() %></p>
					</div>
				</div>
				<div class="row" style="margin-top: 10px"></div>
				<div class="row">
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<label>
							用户权限:
						</label>
					</div>
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<% if(e.getUserRoot().equals("min")){ %>
						<p>
							普通用户
						</p>
						<% }else{ %>
						<p>
							管理员
						</p>
						<% } %>
					</div>
				</div>
				<div style="margin-left:-15px" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<image style="height:100px;weight:100px" src="<%=e.getUserImage() %>"></image>
				<form action="<%=path %>/ChangeMM/find2.do?uid=<%=id %>" enctype="multipart/form-data" method="post">
         			修改头像：<input type="file" name="file1"><br/>
         			<input type="submit" value="提交">
   				 </form>
				</div>
				<br/>
				<div class="row" style="margin-top: 10px"></div>
				<div class="row">
					<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
						<br/>
						<a><p style="cursor: pointer" onclick="change(<%=id %>)">
							修改密码
						</p></a>
					</div>
				</div>
				<div class="row" style="margin-top: 20px"></div>
				<br/>
				<div class="row">
					<iframe id="ifr" scrolling="no" frameborder=0
						style="width: 800px; height: 1400px" src="#"></iframe>
				</div>
			</div>
			
			<% }}%>
			
				<div class="row" style="margin-top: 10px"></div>
				<div class="row">
					<a href="http://localhost:8088/mymuseum/Front/login.do"><input onclick="tiaochu()" type="button" value="请登录" /></a>
				</div>
			
		</div>

		<script src="<%=path %>/js/jquery.js"></script>
		<script src="<%=path %>/js/bootstrap.min.js"></script>
		<script src="<%=path %>/js/jquery.prettyPhoto.js"></script>
		<script src="<%=path %>/js/jquery.isotope.min.js"></script>
		<script src="<%=path %>/js/main.js"></script>
		<script src="<%=path %>/js/wow.min.js"></script>
		<script type="text/javascript">
    	function change(id){
    		var Link = document.getElementById("ifr");
    		Link.src = "<%=path %>/ChangeMM.jsp";
    		return Link.src;
    	}
    	function tiaochu(){
    		if(top.location!=self.location){
    			top.location=self.location;
    		}
    	}
    	
    </script>

	</body>
</html>