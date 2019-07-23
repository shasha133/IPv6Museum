<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Exhibits"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<Exhibits> list = (List<Exhibits>)request.getAttribute("list"); %>
<% 	String id   = String.valueOf(request.getSession().getAttribute("User_id"));
	String root = String.valueOf(request.getSession().getAttribute("User_root"));
%>
<% String image = String.valueOf(request.getSession().getAttribute(
			"User_image"));
	 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>藏品</title>
    
    <!-- core CSS -->
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path %>/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/main.css" rel="stylesheet">
    <link href="<%=path %>/css/responsive.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="<%=path %>/js/html5shiv.js"></script>
    <script src="<%=path %>/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>

    <header id="header">
    <div class="row" style="background-color:#000000;" >
        <div class="col-xs-11 col-sm-11 col-md-11 col-lg-11">
        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html" style="margin-top:-10px"><h1 style="color:white;font-family:华文行楷">西安理工大学校史馆</h1></a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right" style="color:white">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="<%=path %>/News/find.do">首&nbsp&nbsp页</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">概&nbsp&nbsp况 </a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path%>/ZhanGGS/find.do">展馆概述</a></li>
                            </ul>
                        </li><li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">资&nbsp&nbsp讯 </a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path %>/activity/find.do">展馆活动</a></li>
                                <li><a href="<%=path %>/allNews/find.do">展馆新闻</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">藏&nbsp&nbsp品 </a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path %>/guanCJP/find.do">馆藏精品</a></li>
                                <li><a href="<%=path %>/guanCWW.jsp">馆藏展品</a></li>
                                <li><a href="<%=path %>/zhanQZP.jsp">展厅展品</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">推&nbsp&nbsp荐</a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path %>/zhanPTJ.jsp">展品推荐</a></li>
                                <li><a href="<%=path %>/luXTJ.jsp">路线推荐</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">我&nbsp&nbsp的</a>
                            <ul class="dropdown-menu">
                                <li><a href="<%=path %>/myJsp.jsp">个人主页</a></li>
                            </ul>
                        </li>    <%
                        			if("max".equals(root)){
                        	  %>
                       			 <li><a href="<%=path %>/Exhibits/Count.do?USer_id=<%=id%>&User_root=<%=root%>">管&nbsp&nbsp理</a></li> 
		                        <%
		                        	}
		                         %>
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
        </div>
        <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1" style="margin-top:27px">
        	<div class="row" style="width:100%;height;">
        		<a href="<%=path %>/myJsp.jsp" ><img style="margin-left:20px;width:40px;height:40px;border-radius:100px" src="<%=image %>"/></a>
        	</div>
        </div>
		
    </header><!--/header-->


    <section id="blog" class="container">
    
    <% for(Exhibits n : list){ %>
    
        <div class="center">
            <h2><%=n.getExhibitsName() %></h2>
        </div>

        <div class="blog">
            <div class="row">
                <div class="col-md-8">
                    <div class="blog-item">
                        <img class="img-responsive img-blog" src="<%=path %>/<%=n.getExhibitsImagefull() %>" width="100%" alt="" />
                            <div class="row">  
                                
                            </div>
                        </div><!--/.blog-item-->
                        
                       <h3 style="line-height:30px;margin-top:-70px">
							<%=n.getExhibitsDetail() %>
                       </h3>
                        
                </div><!--/.col-md-8-->

                <aside class="col-md-3 col-md-offset-1">

                     <div class="widget categories">
	                 	年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp代 :&nbsp&nbsp<%=n.getDynasty().getDynastyType() %><br/>
	                 	材&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp料 :&nbsp&nbsp<%=n.getMaterial().getMaterialType() %><br/>
	                 	尺&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp寸 :&nbsp&nbsp<%=n.getExhibitsAppearance() %><br/>
	                 	用&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp途 :&nbsp&nbsp<%=n.getApply().getApplylType() %><br/>
	                 	出土地点 :&nbsp&nbsp<%=n.getExhibitsExcavatePlace() %><br/>
	                 	生产地点 :&nbsp&nbsp<%=n.getExhibitsProducePlace() %><br/>
	                 	生产时间 :&nbsp&nbsp<%=n.getExhibitsProduceTime() %><br/>
	                 	浏览次数 :&nbsp&nbsp<%=n.getExhibitsBrowse() %><br/>
	                 	收藏次数 :&nbsp&nbsp<%=n.getExhibitsUpvote() %><br/>
	                 	宗&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp教 :&nbsp&nbsp<%=n.getReligion().getReligionType() %><br/>
	                 	民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族 :&nbsp&nbsp<%=n.getNation().getNationType() %><br/>
	                 	价&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp值 :&nbsp&nbsp<%=n.getValue().getValueType() %><br/>                      
                    </div><!--/.categories-->
    				
                </aside>     

            </div><!--/.row-->

         </div><!--/.blog-->

	<% } %>

    </section><!--/#blog-->

    <footer id="footer" class="midnight-blue">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    Copyright &copy; 2017&nbsp&nbsp&nbsp陕ICP备87654321号
                </div>
                <div class="col-sm-6">
                    <ul class="pull-right">
                        <li><a href="<%=path %>/News/find.do">首页</a></li>
                        <li>咨询热线：&nbsp&nbsp&nbsp029-66666666</li>
                    </ul>
                </div>
            </div>
        </div>
    </footer><!--/#footer-->

    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/jquery.prettyPhoto.js"></script>
    <script src="<%=path %>/js/jquery.isotope.min.js"></script>
    <script src="<%=path %>/js/main.js"></script>
    <script src="<%=path %>/js/wow.min.js"></script>
</body>
</html>