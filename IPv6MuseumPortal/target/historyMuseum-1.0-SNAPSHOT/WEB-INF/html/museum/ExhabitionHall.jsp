<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="museum.entity.Exhibits"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 	List<Exhibits> exhibitionHallOne = (List<Exhibits>) request.getAttribute("exhibitionHallOne");
    List<Exhibits> exhibitionHallTwo = (List<Exhibits>) request.getAttribute("exhibitionHallTwo");
    List<Exhibits> exhibitionHallThree = (List<Exhibits>) request.getAttribute("exhibitionHallThree");
    List<Exhibits> exhibitionHallFour = (List<Exhibits>) request.getAttribute("exhibitionHallFour");
    List<Exhibits> exhibitionHallFive = (List<Exhibits>) request.getAttribute("exhibitionHallFive");
    List<Exhibits> exhibitionHallSix = (List<Exhibits>) request.getAttribute("exhibitionHallSix");
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
    <title>展馆概述</title>

    <!-- core CSS -->
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link href="../resourcesOne/css/font-awesome.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/animate.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/prettyPhoto.css" rel="stylesheet">
    <link href="../resourcesOne/css/main.css" rel="stylesheet">
</head><!--/head-->

<body>

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
<!--/header-->


<section id="blog" class="container">
    <div class="center">
        <h2>西安理工大学校史馆</h2>
        <p class="lead"> 西安理工大学校史馆是一座综合性历史类博物馆。</p>
    </div>

    <div class="blog">
        <div class="row">
            <div class="col-md-8">
                <div class="blog-item">
                    <img class="img-responsive img-blog"
                         src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*imagecut*school*001.jpg" alt="" />
                    <div class="row">
                    </div>
                </div><!--/.blog-item-->

                <h3 style="line-height:30px;margin-top:-70px">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp三秦大地是中华民族生息、繁衍，华夏文明诞生、发展的重要地区之一，中国历史上最为辉煌的周、秦、汉、唐等十三个王朝曾在这里建都。丰富的文化遗存，深厚的文化积淀，形成了陕西独特的历史文化风貌，被誉为“古都明珠，华夏宝库”的陕西历史博物馆则是展示陕西历史文化和中国古代文明的艺术殿堂。 <br/>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp陕西历史博物馆位于西安大雁塔的西北侧，筹建于1983年，1991年6月20日落成开放，是中国第一座大型现代化国家级博物馆，它的建成标志着中国博物馆事业迈入了新的发展里程。这座馆舍为“中央殿堂、四隅崇楼”的唐风建筑群，主次井然有序，高低错落有致，气势雄浑庄重，融民族传统、地方特色和时代精神于一体。馆区占地 65000平方米。建筑面积55600平方米，文物库区面积8000平方米，展厅面积11000平方米。馆藏文物多达 370000余件，上起远古人类初始阶段使用的简单石器，下至1840年前社会生活中的各类器物，时间跨度长达一百多万年。文物不仅数量多、种类全，而且品位高、价值广，其中的商周青铜器精美绝伦，历代陶俑千姿百态，汉唐金银器独步全国，唐墓壁 画举世无双。可谓琳琅满目、精品荟萃。 <br/>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp陕西历史博物馆是一座综合性历史类博物馆。开馆以来，充分发挥文物藏品优势，坚持“有效保护、合理利用、加强管理”的原则，把收藏保管、科学研究和宣传教育功能有机相结合，举办了各种形式的陈列展览，形成了基本陈列、专题陈列和临时展览互为补充、交相辉映的陈列体系，从多角度、多侧面向广大观众揭示历史文物的丰富文化内涵，展现华夏民族博大精深的文明成就。同时，以开放的姿态走出国门， 将灿烂辉煌的中华文明、光彩夺目的三秦文化呈现给世界各国人民。 <br/>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp作为被首批确定为中国“4A”级旅游景点的陕西历史博物馆，以其优上的陈列、优美的环境、优质的服务、优良的秩序和独特的魅力，吸引着众多中外宾客纷至沓来，已成为传播中华民族优秀文化和对外文化交流的重要窗口。在21世纪里，这座汇集着三秦大地文物精华的文化殿堂，将会以充满生机和活力的崭新面貌，为人类的物质文 明和精神文明建设作出更大的贡献。
                </h3>

            </div><!--/.col-md-8-->

            <aside style="margin-top:-200px" class="col-md-4">

                <div class="" style="margin-left:100px">
                    <h2 style="font-family:华文行楷">&nbsp展厅详情</h2>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallOne){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px"
                                             src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagecut().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp一&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallTwo){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagecut().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp二&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallThree){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagefull().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp三&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallFour){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagefull().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp四&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallFive){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagefull().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp五&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <div class="row">
                                <a href="/Exhibition/show">
                                    <% for(Exhibits e : exhibitionHallSix){ %>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <img style="width:60px;height:60px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=e.getExhibitsImagefull().replace("\\","*")%>"/>
                                    </div>
                                    <% } %>
                                </a>
                            </div>
                            <div class="row" style="text-align:center">
                                <p>第&nbsp&nbsp&nbsp&nbsp六&nbsp&nbsp&nbsp&nbsp展&nbsp&nbsp&nbsp&nbsp厅</p>
                            </div>
                            <br/>
                        </div>
                    </div>
                </div><!--/.categories-->

            </aside>

        </div><!--/.row-->

    </div><!--/.blog-->

</section><!--/#blog-->

<footer id="footer" class="midnight-blue">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                Copyright &copy; 2017&nbsp&nbsp&nbsp陕ICP备87654321号
            </div>
            <div class="col-sm-6">
                <ul class="pull-right">
                    <li><a href="<%=path %>/user/index">首页</a></li>
                    <li>咨询热线：&nbsp&nbsp&nbsp029-66666666</li>
                </ul>
            </div>
        </div>
    </div>
</footer><!--/#footer-->

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