<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="museum.entity.Exhibits" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String id = String.valueOf(request.getSession().getAttribute("User_Id"));
    String root = String.valueOf(request.getSession().getAttribute("User_root"));

    String image = String.valueOf(request.getSession().getAttribute("User_image"));
    List<Exhibits> exhibitsList = (List<Exhibits>) request.getAttribute("exhibitsList");
    List<Exhibits> one = new ArrayList<Exhibits>(), two = new ArrayList<Exhibits>();
    int i = 0;
    for (Exhibits exhibits : exhibitsList) {
        if (i < 2) {
            one.add(exhibits);
            i++;
        } else {
            two.add(exhibits);
            i++;
        }

    }
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
    <link href="../resourcesOne/css/font-awesome.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/animate.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/prettyPhoto.css" rel="stylesheet">
    <link href="../resourcesOne/css/main.css" rel="stylesheet">
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
                        </h1></a>
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
                                        <a href="/collections/getCollections">馆藏文物</a>
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
                        src="<%=image %>"/> </a>
            </div>
        </div>
    </div>
</header>
<!--/header-->


<section id="about-us">
    <div class="container">
        <!-- Our Skill -->
        <div class="skill-wrap clearfix">
        </div><!--/.our-skill-->


        <!-- our-team -->
        <div class="team" style="margin-top:-150px">
            <div class="center wow fadeInDown">
                <h2 style="font-family:华文行楷;color:purple">馆藏精品</h2>
            </div>


            <div class="row clearfix">
                <%for (Exhibits n : one) {%>
                <div class="col-md-4 col-sm-6 col-md-offset-2">
                    <div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                        <div class="media">
                            <div class="pull-left">
                                <a style="cursor:pointer" onclick="open(<%=n.getExhibitsId()%>)"><img
                                        style="width:100px;height:100px" class="media-object"
                                        src="/<%=n.getExhibitsImagecut() %>" alt=""></a>
                            </div>
                            <div class="media-body">
                                <h4><%=n.getExhibitsName() %>
                                </h4>
                                <h5>
                                    <%if (n.getDynasty() != null) {%>
                                    <%=n.getDynasty().getDynastyType()%>
                                    <%}%>

                                    <%if (n.getValue() != null) {%>
                                    <br/><br/><%=n.getValue().getValueType()%>
                                    <%}%>

                                    <br/><br/><%=n.getExhibitsAppearance() %>
                                </h5>
                            </div>
                        </div><!--/.media -->
                        <p><%=n.getExhibitsDetail() %>
                        </p>
                    </div>
                </div><!--/.col-lg-4 -->
                <%} %>
            </div> <!--/.row -->
            <div class="row team-bar">
                <div class="first-one-arrow hidden-xs">
                    <hr>
                </div>
                <div class="first-arrow hidden-xs">
                    <hr>
                    <i class="fa fa-angle-up"></i>
                </div>
                <div class="second-arrow hidden-xs">
                    <hr>
                    <i class="fa fa-angle-down"></i>
                </div>
                <div class="third-arrow hidden-xs">
                    <hr>
                    <i class="fa fa-angle-up"></i>
                </div>
                <div class="fourth-arrow hidden-xs">
                    <hr>
                    <i class="fa fa-angle-down"></i>
                </div>
            </div> <!--skill_border-->

            <div class="row clearfix">
                <%for (Exhibits n : two) {%>
                <div class="col-md-4 col-sm-6 col-md-offset-2">
                    <div class="single-profile-bottom wow fadeInUp" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="media">
                            <div class="pull-left">
                                <a style="cursor:pointer" onclick="open(<%=n.getExhibitsId()%>)"><img
                                        style="width:100px;height:100px" class="media-object"
                                        src="/<%=n.getExhibitsImagecut() %>" alt=""></a>
                            </div>

                            <div class="media-body">
                                <h4><%=n.getExhibitsName() %>
                                </h4>
                                <%if (n.getDynasty() != null) {%>
                                <%=n.getDynasty().getDynastyType()%>
                                <%}%>

                                <%if (n.getValue() != null) {%>
                                <br/><br/><%=n.getValue().getValueType()%>
                                <%}%>
                                    <br/><br/><%=n.getExhibitsAppearance() %>
                                </h5>
                            </div>
                        </div><!--/.media -->
                        <p><%=n.getExhibitsDetail() %>
                        </p>
                    </div>
                </div>
                <%} %>
            </div>    <!--/.row-->
        </div><!--section-->
    </div><!--/.container-->
</section><!--/about-us-->

<footer id="footer" class="midnight-blue" style="width:100%; ">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                Copyright &copy; 2017&nbsp&nbsp&nbsp陕ICP备87654321号
            </div>
            <div class="col-sm-6">
                <ul class="pull-right">
                    <li><a href="/user/index">首页</a></li>
                    <li>咨询热线：&nbsp&nbsp&nbsp029-66666666</li>
                </ul>
            </div>
        </div>
    </div>
</footer><!--/#footer-->

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

<script type="text/javascript">
    function open(exhibitsId){
        window.location.href='/Exhibition/introduction?exhibitsId='+exhibitsId;
    }
</script>

</body>
</html>