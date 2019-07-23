<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.News"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<News> list = (List<News>)request.getAttribute("list"); %>
<% List<News> list2 = (List<News>)request.getAttribute("list2"); %>
<% int i = Integer.parseInt(String.valueOf(request.getAttribute("maxPage")));  %>
<% int i2 = Integer.parseInt(String.valueOf(request.getAttribute("page")));  %>
<% 
		String id   = String.valueOf(request.getSession().getAttribute("User_id"));
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
    <title>展馆新闻</title>
    
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
    <link rel="shortcut icon" href="<%=path %>/images/ico/favicon.ico">
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
                                <li><a href="<%=path %>/guanCWW.jsp">馆藏文物</a></li>
                                <li><a href="<%=path %>/zhanTZP.jsp">展厅展品</a></li>
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
                        </li> 
 							 <%
                        			if("max".equals(root)){
                        	  %>
                        <li><a href="<%=path %>/Exhibits/Count.do?USer_id=<%=id %>&User_root=<%=root %>">管&nbsp&nbsp理</a></li> 
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

    <section id="feature" class="transparent-bg">
        <div class="container">
           <div class="center wow fadeInDown">
                <h2 style="color:purple">展馆新闻</h2>
            </div>

            <div class="row">
            
            	<% for(News n : list){ %>
            	
                <div class="col-md-4 wow fadeInDown">
                    <div class="clients-comments text-center">
                        <a href="<%=path %>/newsIntroduction/find.do?title=<%=n.getNewsId() %>"><img src="<%=n.getNewsImage() %>" class="img-circle" alt=""></a>
                        <h3><%=n.getNewsTitle() %></h3>
                        <h4><%=n.getNewsContext() %></h4>
                    </div>
                </div>
                
                <% } %>
           </div>

			<div class="get-started center wow fadeInDown" style="text-align:left;margin-top:-40px">
                
                <div class="row" style="margin-left:30px">
                	<p style="color:purple;margin-left:30px;font-size:25px">全部新闻</p>
                </div>
                
                <div style="border:1px solid purple"></div>
                
                <br/>
                
                <div class="row">
                	<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6" style="margin-left:60px">
	                	<% for(News n : list2){ %>
	                	
	                		<li><p id="news" onclick="change(<%=n.getNewsId()%>)" style="font-size:18px;cursor:pointer"><%=n.getNewsTitle() %></p></li>
	              	    
	              	    <% } %>
	              	</div>
              	</div>
              	<div class="row">
              		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"></div>
              		<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
              			<p onclick="change1()" style="cursor:pointer" name="prePage" >上一页</p>
              		</div>
              		<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
              			<p onclick="change2()" style="cursor:pointer" name="nextPage">下一页</p>
              		</div>
              		
              		<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
              			<p name="num">第<%=i2 %>页</p>
              		</div>
              		<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
              			<p name="sum">共<%=i %>页</p>
              		</div>
              	</form>
            </div><!--/.get-started-->


        </div><!--/.container-->
    </section><!--/#feature-->

    <footer id="footer" class="midnight-blue" style="width:100%; ">
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

    <script type="text/javascript">
    	function change1(){
    		var page = <%=i2 %>;
    		window.location.href='<%=path %>/allNews/find.do?page='+page;
    		
    	}
    	function change2(){
    		var page2 = <%=i2 %>;
    		window.location.href='<%=path %>/allNews/find.do?page2='+page2;
    		
    	}
    	
		function change(newsId){
			window.location.href='<%=path %>/newsIntroduction/find.do?title='+newsId;
		}
	</script>
    
</body>
</html>