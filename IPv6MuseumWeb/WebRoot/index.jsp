<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.News"%>
<%@page import="com.museum.domain.Activity"%>
<%@page import="com.museum.domain.Exhibits"%>
<%@page import="com.museum.domain.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	List<News> list1 = (List<News>) request.getAttribute("list");
%>
<%
	List<Activity> list2 = (List<Activity>) request
			.getAttribute("list2");
%>
<%
	List<Exhibits> list3 = (List<Exhibits>) request
			.getAttribute("list3");
%>
<% String image = String.valueOf(request.getSession().getAttribute(
			"User_image"));
	 %>

<%
	//request.getSession().setAttribute("User_id",request.getParameter("User_Id"));
	//request.getSession().setAttribute("User_root",request.getParameter("User_root"));

	String id = String.valueOf(request.getSession().getAttribute(
			"User_id"));
	String root = String.valueOf(request.getSession().getAttribute(
			"User_root"));
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>首页</title>

		<!-- core CSS -->
		<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=path%>/css/font-awesome.min.css" rel="stylesheet">
		<link href="<%=path%>/css/animate.min.css" rel="stylesheet">
		<link href="<%=path%>/css/prettyPhoto.css" rel="stylesheet">
		<link href="<%=path%>/css/main.css" rel="stylesheet">
		<link href="<%=path%>/css/responsive.css" rel="stylesheet">
		<!--[if lt IE 9]>
    <script src="<%=path%>/js/html5shiv.js"></script>
    <script src="<%=path%>/js/respond.min.js"></script>
    <![endif]-->
		<link rel="shortcut icon" href="<%=path%>/images/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="<%=path%>/images/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114"
			href="<%=path%>/images/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72"
			href="<%=path%>/images/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed"
			href="<%=path%>/images/ico/apple-touch-icon-57-precomposed.png">
	</head>
	<!--/head-->

	<body class="homepage">

		<header id="header">
		<div class="row" style="background-color: #000000;">
			<div class="col-xs-11 col-sm-11 col-md-11 col-lg-11">
				<nav class="navbar navbar-inverse" role="banner">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.html"
							style="margin-top: -10px"><h1
								style="color: white; font-family: 华文行楷">
								西安理工大学校史馆
							</h1> </a>
					</div>

					<div class="collapse navbar-collapse navbar-right"
						style="color: white">
						<ul class="nav navbar-nav">
							<li class="active">
								<a href="<%=path%>/News/find.do">首&nbsp&nbsp页</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">概&nbsp&nbsp况
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=path%>/ZhanGGS/find.do">展馆概述</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">资&nbsp&nbsp讯
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=path%>/activity/find.do">展馆活动</a>
									</li>
									<li>
										<a href="<%=path%>/allNews/find.do">展馆新闻</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">藏&nbsp&nbsp品
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=path%>/guanCJP/find.do">馆藏精品</a>
									</li>
									<li>
										<a href="<%=path%>/guanCWW.jsp">馆藏文物</a>
									</li>
                                <li><a href="<%=path %>/zhanTZP.jsp">展厅展品</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">推&nbsp&nbsp荐</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=path%>/zhanPTJ.jsp">展品推荐</a>
									</li>
									<li>
										<a href="<%=path%>/luXTJ.jsp">路线推荐</a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">我&nbsp&nbsp的</a>
								<ul class="dropdown-menu">
									<li>
										<a href="<%=path%>/myJsp.jsp">个人主页</a>
									</li>
								</ul>
							</li>
							<%
								if ("max".equals(root)) {
							%>
							<li>
								<a href="<%=path %>/Exhibits/Count.do?USer_id=<%=id%>&User_root=<%=root%>">管&nbsp&nbsp理</a>
							</li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
				<!--/.container-->
				</nav>
				<!--/nav-->
			</div>
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"
				style="margin-top: 27px">
				<div class="row" style="width: 100%;">
					<a href="<%=path%>/myJsp.jsp"><img
							style="margin-left: 20px; width: 40px; height: 40px; border-radius: 100px"
							src="<%=image %>" /> </a>
				</div>
			</div>

			</header>
			<!--/header-->

			<div class="banner" style="margin-top: 80px">
				<div class="container">
					<div class="row">

						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner" role="listbox">

								<div class="item active">
									<a href="<%=path %>/newsIntroduction/find.do?title=1"><img style="border-radius: 10px"
											src="<%=path%>/download/001.jpg" alt="" /> </a>
									<div style="background: #000; opacity: 0.7; z-index: 1">
									</div>
									<div style="color: white; opacity: 1; z-index: 2">
										<h4
											style="color: black; font-family: 华文仿宋; text-align: center">
											我校隆重举行2017届毕业生毕业典礼暨学位授予仪
										</h4>
									</div>
								</div>
								<%
									for (News n : list1) {
								%>

								<div class="item">
									<a href="<%=path %>/newsIntroduction/find.do?title=<%=n.getNewsId() %>"><img style="text-align:center;height:450px;weight:1000px;border-radius: 10px"
											src="<%=n.getNewsImage()%>" alt="" /> </a>
									<div style="background: #000; opacity: 0.7; z-index: 1">
									</div>
									<div style="color: white; opacity: 1; z-index: 2">
										<h4
											style="color: black; font-family: 华文仿宋; text-align: center"><%=n.getNewsAbstract()%></h4>
									</div>
								</div>

								<%
									}
								%>

							</div>

							<!-- Controls -->
							<a class="left carousel-control" href="#carousel-example-generic"
								role="button" data-slide="prev"> <span class="banner_prev"
								aria-hidden="true"></span> </a>
							<a class="right carousel-control"
								href="#carousel-example-generic" role="button" data-slide="next">
								<span class="banner_next" aria-hidden="true"></span> </a>
						</div>
						<div class="row" style="margin-top: 50px"></div>
						<div class="row">
							<div class="testimonial" style="margin-left: 30px">
								<h2>
									最新活动
								</h2>

								</br>

								<%
									for (Activity n : list2) {
								%>
								<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									<div class="media testimonial-inner">
										<div class="pull-left">
											<a href="<%=path %>/ActivityIntroduction/find.do?title=<%=n.getActivityId() %>" ><img
													style="width: 40px; height: 40px; border-radius: 100px"
													class="img-responsive img-circle"
													src="<%=path%>/<%=n.getActivityImage()%>"> </a>
										</div>
										<div class="media-body">
											<p><%=n.getActivityAbstract()%></p>
											<span><%=n.getActivityContext() %></span>
										</div>
									</div>
								</div>

								<%
									}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>



			<section id="recent-works">
			<div class="container">
				<div class="testimonial">
					
				</div>

				</br>

				<!--/.row-->
			</div>
			<!--/.container-->
			</section>
			<!--/#recent-works-->
			<div id="footer" class="midnight-blue" style="margin-top: 50px">
				<div class="row midnight-blue">
					<div class="container">
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/News/find.do">首&nbsp&nbsp&nbsp&nbsp页</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/zhanGGS.jsp">展馆概述</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/activity/find.do">展馆活动</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/allNews/find.do">展馆新闻</a>
						</div>
						</br>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/guanCJP/find.do">馆藏精品</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/zhanPTJ.jsp">展品推荐</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/luXTJ.jsp">路线推荐</a>
						</div>
						<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
							<a href="<%=path%>/myJsp.jsp">个人主页</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row" style="height: 2px"></div>

			<footer id="footer" class="midnight-blue" style="width:100%; ">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						Copyright &copy; 2017&nbsp&nbsp&nbsp陕ICP备87654321号
					</div>
					<div class="col-sm-6">
						<ul class="pull-right">
							<li>
								<a href="<%=path%>/News/find.do">首页</a>
							</li>
							<li>
								咨询热线：&nbsp&nbsp&nbsp029-66666666
							</li>
						</ul>
					</div>
				</div>
			</div>
			</footer>
			<!--/#footer-->

			<script src="<%=path%>/js/jquery.js"></script>
			<script src="<%=path%>/js/bootstrap.min.js"></script>
			<script src="<%=path%>/js/jquery.prettyPhoto.js"></script>
			<script src="<%=path%>/js/jquery.isotope.min.js"></script>
			<script src="<%=path%>/js/main.js"></script>
			<script src="<%=path%>/js/wow.min.js"></script>
			<script type="text/javascript">
	function open1(ExhibitsId){
    		window.location.href='<%=path %>/cangPin2/find.do?ExhibitsId='+ExhibitsId;
    		
    	}
</script>
	</body>
</html>