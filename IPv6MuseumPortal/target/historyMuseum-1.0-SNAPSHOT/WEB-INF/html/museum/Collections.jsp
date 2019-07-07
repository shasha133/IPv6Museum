<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String id   = String.valueOf(request.getSession().getAttribute("User_Id"));
    String root = String.valueOf(request.getSession().getAttribute("User_root"));
    String image = String.valueOf(request.getSession().getAttribute("User_image"));
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
                        src="<%=image %>" /> </a>
            </div>
        </div>
    </div>
</header>
<!--/header-->

<section id="blog" class="container">

    <div class="row">
        <div class="col-md-3">
            <h1 style="color: black">
                馆藏文物
            </h1>
        </div>
        <div class="col-md-6"></div>
        <div style="margin-top:30px;margin-right:-10px" class="col-md-2">
            <input id="Exhibits_name" style="height:30px" />
        </div>
        <div style="margin-top:30px" class="col-md-1">
            <button onclick="selectExhibits()">搜索</button>
        </div>
    </div>

    <div class="row">
        <div class="col-md-2" style="border: 2px solid purple"></div>
        <div class="col-md-10"
             style="border: 1px solid gray; margin-top: 1px"></div>
    </div>

    <br />
    <div class="blog">
        <div class="col-md-1">
            <div class="widget categories">
                <div class="row">
                    <ul class="blog_category">
                        <li>
                            <a class="active" title="" href="#" onclick="select1()">校&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp徽</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select2()">个人肖像</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select3()">集体合影</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select4()">校园景色</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select5()">活动留影</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select6()">硬件设施</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select7()">获奖记录</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select8()">历史文件</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select9()">统计图表</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select10()">历史纪念物</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select11()">科研纪念物</a>
                        </li>
                        <li>
                            <a title="" href="#" onclick="select12()">交流纪念物</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--/.categories-->
        </div>

        <div id="tt" class="row">
            <div class="col-md-10">
                <div class="blog-item">
                    <div class="row">
                        <div class="col-xs-12 col-sm-2 text-center">
                        </div>
                        <iframe id="ifr" scrolling="no" frameborder=0
                                style="width: 800px; height: 2000px"
                                src="/collections/find">
                        </iframe>
                        </div>
                </div>
                <!--/.blog-item-->

            </div>
            <!--/.col-md-8-->
        </div>
        <!--/.row-->
    </div>
</section>
<!--/#blog-->


<footer id="footer" class="midnight-blue" style="width:100%; ">
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
</footer>
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
    var Link;
    function select1(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+1+"&str="+1;
        return Link.src;
    }
    function select2(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+2+"&str="+2;
        return Link.src;
    }
    function select3(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+3+"&str="+3;
        return Link.src;
    }
    function select4(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+4+"&str="+4;
        return Link.src;
    }
    function select5(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+5+"&str="+5;
        return Link.src;
    }
    function select6(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+6+"&str="+6;
        return Link.src;
    }
    function select7(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+7+"&str="+7;
        return Link.src;
    }
    function select8(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+8+"&str="+8;
        return Link.src;
    }
    function select9(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+9+"&str="+9;
        return Link.src;
    }
    function select10(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+10+"&str="+10;
        return Link.src;
    }
    function select11(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+11+"&str="+11;
        return Link.src;
    }
    function select12(){
        Link = document.getElementById("ifr");
        Link.src = "/collections/find.do?materialId="+12+"&str="+12;
        return Link.src;
    }
    function selectExhibits(){
        var Link2 = document.getElementById("Exhibits_name");//Link2.value是input输入框中的值
        if(Link2.value == ""){
            alert("输入不能为空！");
        }else{
            Link = document.getElementById("ifr");
            Link.src = "/cangPin3/find3.do?ExhibitsName="+Link2.value;
            return Link.src;
        }
    }
</script>
</body>
</html>