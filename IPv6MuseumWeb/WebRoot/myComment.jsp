<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Exhibits"%>
<%@page import="com.museum.domain.User"%>
<%@page import="com.museum.domain.Comment"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<User> list = (List<User>)request.getAttribute("list"); 
   String id=String.valueOf(request.getSession().getAttribute("User_id"));
%>
<% List<Comment> list1 = (List<Comment>) request.getAttribute("list"); %>

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

		<div class="row">
			<div style="text-align: center"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
				展品
			</div>
			<div style="text-align: center"
				class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
				评论内容
			</div>
			<div style="text-align: center"
				class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
				时间
			</div>
			<div style="text-align: center"
				class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
				状态
			</div>
		</div>
		<br/>
		<% for(Comment c : list1){ %>
			<div class="row">
				<div style="text-align: center"
					class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<%=c.getTopicId()%>
				</div>
				<div style="text-align: center"
					class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
					<%=c.getCommentContent() %>
				</div>
				<div style="text-align: center"
					class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
					<%=c.getCommentTime() %>
				</div>
				<div style="text-align: center"
					class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<% if(c.getCommentState()==0){ %>
						<p>已通过审核</p>
					<% }else{ %>
						<p>还未通过审核</p>
					<% } %>
				</div>
			</div> 
		<% } %>



		<script src="<%=path %>/js/jquery.js"></script>
		<script src="<%=path %>/js/bootstrap.min.js"></script>
		<script src="<%=path %>/js/jquery.prettyPhoto.js"></script>
		<script src="<%=path %>/js/jquery.isotope.min.js"></script>
		<script src="<%=path %>/js/main.js"></script>
		<script src="<%=path %>/js/wow.min.js"></script>
		<script type="text/javascript">
	
</script>

	</body>
</html>