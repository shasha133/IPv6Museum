<%@page language="java" import="museum.entity.Activity" pageEncoding="utf-8"%>
<%@page import="museum.entity.Exhibits"%>
<%@page import="museum.entity.News"%>
<%@page import="java.util.List"%>
<%
    List<News> newsList = (List<News>) request.getAttribute("newsList");
    List<Activity> activityList = (List<Activity>) request.getAttribute("activityList");
    List<Exhibits> exhibitsList = (List<Exhibits>) request.getAttribute("exhibitsList");
    String image = String.valueOf(request.getSession().getAttribute("User_image"));

    String id = String.valueOf(request.getSession().getAttribute("User_Id"));
    String root = String.valueOf(request.getSession().getAttribute("User_root"));
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
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link href="../resourcesOne/css/main.css" rel="stylesheet">
</head>
<!--/head-->

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
                                <a href="/user/index">首&nbsp&nbsp页</a>
                            </li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">概&nbsp&nbsp况
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/Exhibition/find">展馆概述</a>
                                    </li>
                                </ul>
                            </li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">资&nbsp&nbsp讯
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/activity/find">展馆活动</a>
                                    </li>
                                    <li>
                                        <a href="/news/find">展馆新闻</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">藏&nbsp&nbsp品
                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/exhibitionBoutique/find">馆藏精品</a>
                                    </li>
                                    <li>
                                        <a href="//collections/getCollections">馆藏文物</a>
                                    </li>
                                    <li><a href="/Exhibition/show">展厅展品</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">推&nbsp&nbsp荐</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/collections/getCollections">展品推荐</a>
                                    </li>
                                    <li>
                                        <a href="/Exhibition/pathRecommond">路线推荐</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">我&nbsp&nbsp的</a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a href="/person/information">个人主页</a>
                                    </li>
                                </ul>
                            </li>
                            <%
                                if ("max".equals(root)) {
                            %>
                            <li>
                                <a href="/manage/count?User_Id=<%=id%>&User_root=<%=root%>">管&nbsp&nbsp理</a>
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
                <a href="/person/information"><img
                        style="margin-left: 20px; width: 40px; height: 40px; border-radius: 100px"
                        src="<%=image %>" /> </a>
            </div>
        </div>
    </div>
</header>

<div class="banner" style="margin-top: 80px">
    <div class="container">
        <div class="row">

            <div id="carousel-example-generic" class="carousel slide"
                 data-ride="carousel">
                <div class="carousel-inner" role="listbox">

                    <div class="item active">
                        <a href="/newsIntroduction/find?title=1">
                            <img style="border-radius: 10px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*imagecut*school*001.jpg" alt="" />
                        </a>
                        <div style="background: #000; opacity: 0.7; z-index: 1"></div>
                        <div style="color: white; opacity: 1; z-index: 2">
                            <h4 style="color: black; font-family: 华文仿宋; text-align: center">
                                我校隆重举行2017届毕业生毕业典礼暨学位授予仪
                            </h4>
                        </div>
                    </div>

                    <%
                        for (News n : newsList) {
                    %>
                    <div class="item">
                        <a href="/newsIntroduction/find?title=<%=n.getNewsId() %>">
                            <img style="text-align:center;height:450px;weight:1000px;border-radius: 10px"
                                 src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=<%=n.getNewsImage().replace("\\","*")%>" alt="" />
                        </a>
                        <div style="background: #000; opacity: 0.7; z-index: 1"></div>
                        <div style="color: white; opacity: 1; z-index: 2">
                            <h4 style="color: black; font-family: 华文仿宋; text-align: center"><%=n.getNewsAbstract()%></h4>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="banner_prev" aria-hidden="true"></span> </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
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
                        for (Activity n : activityList) {
                    %>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div class="media testimonial-inner">
                            <div class="pull-left">
                                <a href="/ActivityIntroduction/find?title=<%=n.getActivityId() %>">
                                    <img style="width: 40px; height: 40px; border-radius: 100px" class="img-responsive img-circle"
                                         src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=n.getActivityImage().replace("\\","*")%>"/>
                                </a>
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
            <h2>
                最新藏品
            </h2>
        </div>
        </br>
        <div class="row">
            <%
                for (Exhibits n : exhibitsList) {
            %>
            <div class="col-xs-12 col-sm-4 col-md-3">
                <a target="blank" style="cursor: pointer" href="/Exhibition/introduction?exhibitsId=<%=n.getExhibitsId()%>" >
                    <img style="height: 100px; widht: 80px"
                         src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=<%=n.getExhibitsImagecut().replace("\\","*")%>" alt="" />
                </a>
            </div>
            <%
                }
            %>
        </div>
        <!--/.row-->
    </div>
    <!--/.container-->
</section>
<!--/#recent-works-->
<div id="footer" class="midnight-blue" style="margin-top: 50px">
    <div class="row midnight-blue">
        <div class="container">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/user/index">首&nbsp&nbsp&nbsp&nbsp页</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/zhanGGS.jsp">展馆概述</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/activity/find">展馆活动</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/news/find">展馆新闻</a>
            </div>
            </br>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/exhibitionBoutique/find">馆藏精品</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/collections/getCollections">展品推荐</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/Exhibition/pathRecommond">路线推荐</a>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <a href="/person/information">个人主页</a>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                Copyright &copy; 2017&nbsp&nbsp&nbsp陕ICP备87654321号
            </div>
            <div class="col-sm-6">
                <ul class="pull-right">
                    <li>
                        <a href="/user/index">首页</a>
                    </li>
                    <li>
                        咨询热线：&nbsp&nbsp&nbsp029-66666666
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!--/#footer-->

<!-- jQuery -->
<script src="../resourcesOne/bootStrap/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../resourcesOne/bootStrap/bootstrap.min.js"></script>
<script src="../resourcesOne/js/jquery.prettyPhoto.js"></script>
<script src="../resourcesOne/js/jquery.isotope.min.js"></script>
<script src="../resourcesOne/js/main.js"></script>
<script src="../resourcesOne/js/jquery.js"></script>
<script src="../resourcesOne/js/wow.min.js"></script>
</body>
</html>