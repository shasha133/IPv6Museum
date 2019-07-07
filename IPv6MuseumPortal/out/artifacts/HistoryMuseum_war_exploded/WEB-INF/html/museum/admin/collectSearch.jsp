<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="museum.entity.Collect" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    List<Collect> list=(List<Collect>)request.getAttribute("SearchList");
    String UserId=String.valueOf(request.getAttribute("UserId"));
    String ExhibitId=String.valueOf(request.getAttribute("ExhibitId"));
    String i=String.valueOf(request.getAttribute("maxPage"));
    String j=String.valueOf(request.getAttribute("page"));
    String id=String.valueOf(request.getSession().getAttribute("User_Id"));
    String root=String.valueOf(request.getSession().getAttribute("User_root"));
    int maxPage=Integer.valueOf(i);
    int nowPage=Integer.valueOf(j);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>


    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <%--这个css暂时没有用--%>
    <link rel="stylesheet" href="../resourcesOne/css/animate.min.css">
    <link rel="stylesheet" href="../resourcesOne/css/style.css">
    <script src="../resourcesOne/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="../resourcesOne/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="admin/assets/i/logo.png"></div>


    <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
    </div>
</header>

<div class="am-cf admin-main">

    <div class="nav-navicon admin-main admin-sidebar">

        <font size=3 >
            <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：</div>
            <div class="sideMenu">
                <h3 class="am-icon-flag"><em></em>展馆管理</h3>
                <ul>
                    <li><a href="Exhibits/count">展馆信息</a></li>
                </ul>
                <h3 class="am-icon-volume-up"><em></em> 咨询管理</h3>
                <ul>
                    <li><a href="Activity/list?p=1&size=5&type=1">展厅活动</a></li>
                    <li><a href="news/list?p=1&size=5">展馆新闻</a></li>
                    <li><a href="Activity/list?p=1&size=5&type=2">专题讲座</a></li>
                </ul>
                <h3 class="am-icon-users"><em></em> 用户管理</h3>
                <ul>
                    <li><a href="user/list?p=1&size=5&type=1">用户信息</a></li>
                    <li><a href="comment/list?p=1&size=5">评论信息</a></li>
                </ul>
                <h3 class="am-icon-gears"><em></em> 展品管理</h3>
                <ul>
                    <li><a href="Exhibits/list?p=1&size=5">展品信息</a> </li>
                    <li><a href="Exhibits/hall?hallId=1&page=1&size=5">展厅展品</a> </li>
                </ul>


                <h3 class="am-icon-gears"><em></em> 统计管理</h3>
                <ul>
                    <li><a href="Record/Exlist?p=1&size=5">浏览统计</a></li>
                    <li><a href="Collect/Exlist?p=1&size=5">收藏统计</a></li>
                </ul>
                <h3 class="am-icon-gears"><em></em> 返回</h3>
                <ul>
                    <li><a href="News/set?User_Id=<%=id %>&User_root=<%=root%>">返回主页</a></li>
                </ul>
            </div>
    </div>
    </font>
    <!-- sideMenu End -->

    <script type="text/javascript">
        jQuery(".sideMenu").slide({
            titCell:"h3", //鼠标触发对象
            targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
            effect:"slideDown", //targetCell下拉效果
            delayTime:300 , //效果时间
            triggerTime:150, //鼠标延迟触发时间（默认150）
            defaultPlay:true,//默认是否执行效果（默认true）
            returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
        });
    </script>

</div>

<div class="admin-biaogelist">

    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"> 评论管理</ul>

        <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 >浏览统计</dl>


    </div>

    <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
        <ul>
            <li>
                <div class="am-btn-group am-btn-group-xs">
                </div>
            </li>
            <form class="am-form am-g" method="post" method="post" action="Collect/findBy?page=1&size=5">
                <li><input type="text" name="UserId" class="am-form-field am-input-sm am-input-xm" placeholder="用户Id" /></li>
                <li><input type="text" name="ExhibitId" class="am-form-field am-input-sm am-input-xm" placeholder="展品Id" /></li>
                <li><button type="submit"   class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
            </form>
        </ul>
    </div>


    <form class="am-form am-g" method="post" action="Collect/delete" method="post">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th></th>
                <th class="table-title">收藏记录ID</th>
                <th class="table-title">收藏展品ID</th>
                <th class="table-title">收藏时间</th>
                <th class="table-title">收藏用户ID</th>
            </tr>
            </thead>
            <tbody>
            <%
                for(Collect c : list){

            %>
            <tr>

                <td><input type="checkbox" name="id" value="<%=c.getCollectId()%>" /></td>
                <td><%=c.getCollectId()%></td>
                <td><%=c.getCollectExhibitId()%></td>
                <td><%=c.getCollectTime()%></td>
                <td><%=c.getUser().getUserId()%></td>
            </tr>

            <%
                }
            %>


            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs">
            <button type="submit" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 删除勾选项</button>
        </div>

        <ul class="am-pagination am-fr">
            <li><a href="Collect/findBy?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=1&size=5">«首页</a></li>
            <li><a href="Collect/findBy?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=nowPage-1 %>&size=5">上一页</a></li>
            <li><a href="Collect/findBy?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=nowPage+1 %>&size=5">下一页</a></li>
            <li><a href="Collect/findBy?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=maxPage %>&size=5">末页»</a></li>
        </ul>




        <hr />
    </form>

</div>

<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="../resourcesOne/asserts/js/app.js"></script>
<script src="../resourcesOne/asserts/js/amazeui.legacy.js"></script>
<script src="../resourcesOne/asserts/js/amazeui.js"></script>
<script src="../resourcesOne/asserts/js/amazeui.min.js"></script>
<script type="text/javascript" src="http://login.114my.cn/memberpic/dgqtqy/cssnew/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://login.114my.cn/memberpic/dgfangmai/cssnew/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        jQuery(".sideMenu").slide({
            titCell: "h3", //鼠标触发对象
            targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
            effect: "slideDown", //targetCell下拉效果
            delayTime: 300, //效果时间
            triggerTime: 150, //鼠标延迟触发时间（默认150）
            defaultPlay: true,//默认是否执行效果（默认true）
            returnDefault: true //鼠标从.sideMen移走后返回默认状态（默认false）
        });
    });

</script>
</body>
</html>
