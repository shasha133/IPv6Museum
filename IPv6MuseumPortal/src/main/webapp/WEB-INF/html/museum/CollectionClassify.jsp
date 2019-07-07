<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="museum.entity.Exhibits"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Exhibits> exhibitsList = (List<Exhibits>) request.getAttribute("exhibitsList");
    int maxPage = Integer.parseInt(String.valueOf(request.getAttribute("maxPage")));
    int pageNum = Integer.parseInt(String.valueOf(request.getAttribute("curPage")));

    String id = String.valueOf(request.getSession().getAttribute("User_Id"));
    String root = String.valueOf(request.getSession().getAttribute("User_root"));
    String image = String.valueOf(request.getSession().getAttribute("User_image"));
    String materialId = String.valueOf(request.getAttribute("materialId"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>展品</title>

    <!-- core CSS -->
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link href="../resourcesOne/css/font-awesome.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/animate.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/prettyPhoto.css" rel="stylesheet">
    <link href="../resourcesOne/css/main.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/images/ico/apple-touch-icon-57-precomposed.png">


</head><!--/head-->

<body>

<div class="row">
    <div class="row clearfix">
        <%for(Exhibits n : exhibitsList){%>
        <div class="col-md-4 col-sm-6">
            <div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                <div class="media">
                    <div class="pull-left">
                        <form id="form01" method="post" action="/Exhibition/introduction?exhibitsId=<%=n.getExhibitsId()%>">
                            <input id="input01" type="hidden" name="zzz"/>
                            <a target="blank" style="cursor:pointer" href="/Exhibition/introduction?exhibitsId=<%=n.getExhibitsId()%>" >
                                <img style="width:100px;height:100px" class="media-object"
                                     src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=n.getExhibitsImagefull().replace("\\","*")%>"/>
                            </a>
                        </form>
                    </div>

                    <div class="media-body">
                        <h4><%=n.getExhibitsName() %></h4>
                        <% if(n.getDynasty()!=null){%>
                        <h5>
                            <%=n.getDynasty().getDynastyType()%>
                            <%}%>
                            <br/>
                            <br/>
                            <% if(n.getValue()!=null){%>
                            <%=n.getValue().getValueType() %>
                            <%}%>
                            <br/>
                            <br/>
                            <% if(n.getExhibitsAppearance()==null){%>
                            外貌未知
                            <% }else{ %>
                            <%=n.getExhibitsAppearance() %>
                            <% } %>
                        </h5>
                    </div>
                </div><!--/.media -->
            </div>
        </div><!--/.col-lg-4 -->

        <%} %>
    </div>
</div>
<div class="row" >
    <br/>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
        <p style="cursor:pointer" name="prePage" onclick="change1()">上一页</p>
    </div>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
        <p style="cursor:pointer" name="nextPage" onclick="change2()">下一页</p>
    </div>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
        <p name="num">第<%=pageNum %>页</p>
    </div>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
        <p name="sum">共<%=maxPage %>页</p>
    </div>
</div>

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
    function change1(){
        var page = <%=pageNum %>;
        window.location.href='/collections/find.do?pageLast='+page+'&str='+<%=materialId %>;
    }
    function change2(){
        var page2 = <%=pageNum %>;
        window.location.href='/collections/find.do?pageNext='+page2+'&str='+<%=materialId%>;

    }
</script>

</body>
</html>