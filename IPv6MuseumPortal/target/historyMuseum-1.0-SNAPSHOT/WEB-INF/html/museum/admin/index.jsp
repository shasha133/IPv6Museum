<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="museum.entity.Value" %>
<%@ page import="museum.entity.Hall" %>
<%
    String path = request.getContextPath();
    List<Integer> list = (List<Integer>) request.getAttribute("list");
    List<Value> vL = (List<Value>) request.getAttribute("vL");
    List<Hall> hL = (List<Hall>) request.getAttribute("hL");

    String id = String.valueOf(request.getSession().getAttribute("User_Id"));
    String root = String.valueOf(request.getSession().getAttribute("User_root"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理员界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link rel="stylesheet" href="../resourcesOne/asserts/css/amazeui.css"/>
    <link rel="stylesheet" href="../resourcesOne/asserts/css/amazeui.mineeeee.css">
    <link rel="stylesheet" href="../resourcesOne/asserts/css/amazeui.flat.css">
    <link rel="stylesheet" href="../resourcesOne/asserts/css/admin.css">
    <![endif]-->
</head>


<html class="no-js">
<body>
<div class="am-cf admin-main">

    <div class="nav-navicon admin-main admin-sidebar">

        <font size=3>
            <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：</div>
            <div class="sideMenu">
                <h3 class="am-icon-flag">展馆管理</h3>
                <ul>
                    <li><a href="/manage/count">展馆信息</a></li>
                </ul>
                <h3 class="am-icon-volume-up"><em></em> 咨询管理</h3>
                <ul>
                    <li><a href="/Activity/list?p=1&size=5&type=1">展厅活动</a></li>
                    <li><a href="/news/list?p=1&size=5">展馆新闻</a></li>
                    <li><a href="/Activity/list?p=1&size=5&type=2">专题讲座</a></li>
                </ul>
                <h3 class="am-icon-users"><em></em> 用户管理</h3>
                <ul>
                    <li><a href="/adminuser/list?p=1&size=5&type=1">用户信息</a></li>
                    <li><a href="/comment/list?p=1&size=5">评论信息</a></li>
                </ul>
                <h3 class="am-icon-gears"><em></em> 展品管理</h3>
                <ul>
                    <li><a href="/Exhibits/list?p=1&size=5">展品信息</a></li>
                    <li><a href="/Exhibits/hall?hallId=1&page=1&size=5">展厅展品</a></li>
                </ul>


                <h3 class="am-icon-gears"><em></em> 统计管理</h3>
                <ul>
                    <li><a href="/Record/Exlist?p=1&size=5">浏览统计</a></li>
                    <li><a href="/Collect/Exlist?p=1&size=5">收藏统计</a></li>
                </ul>
                <h3 class="am-icon-gears"><em></em> 返回</h3>
                <ul>
                    <li><a href="/user/index">返回主页</a></li>
                </ul>
            </div>
    </font>
</div>
</div>

<div class="admin">


    <div class="admin-index">
        <dl data-am-scrollspy="{animation: 'slide-right', delay: 52}">
            <dt class="qs"></dt>
            <dd>6</dd>
            <dd class="f12" style="font-weight: 700">展厅数量</dd>
        </dl>
        <dl data-am-scrollspy="{animation: 'slide-right', delay: 150}">
            <dt class="cs"></dt>
            <dd><%=list.get(0) %>
            </dd>
            <dd class="f12">展品总量</dd>
        </dl>
        <dl data-am-scrollspy="{animation: 'slide-right', delay: 300}">
            <dt class="hs"></dt>
            <dd><%=list.get(4) %>
            </dd>
            <dd class="f12">注册用户数</dd>
        </dl>
    </div>
    <div class="admin-biaoge">
        <div class="xinxitj">展厅展品数量</div>
        <table class="am-table">
            <thead>
            <tr>
                <%
                    for (Hall H : hL) {
                %>
                <th><%=H.getHallId() %>号展厅</th>
                <%
                    }
                %>

            </tr>
            </thead>

            <tbody>
            <tr>
                <td><%=list.get(1) %>
                </td>
                <td><%=list.get(2) %>
                </td>
                <td><%=list.get(3) %>
                </td>
                <td><%=list.get(17) %>
                </td>
                <td><%=list.get(18) %>
                </td>
                <td><%=list.get(19) %>
                </td>
            </tr>
            </tbody>

        </table>
        <div class="xinxitj">注册用户数量</div>
        <table class="am-table">
            <thead>
            <tr>
                <th>普通用户数量</th>
                <th>管理员数量</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=list.get(5) %>
                </td>
                <td><%=list.get(6) %>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="xinxitj">活动新闻数量</div>
        <table class="am-table">
            <thead>
            <tr>
                <th>活动数量</th>
                <th>新闻数量</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=list.get(7) %>
                </td>
                <td><%=list.get(8) %>
                </td>
            </tr>

            </tbody>
        </table>
    </div>

    <div class="shuju">
        <div class="shujuone">
            <dl>
                <dt>一级文物 : <%=list.get(9) %>
                </dt>
                <dt>二级文物 : <%=list.get(10) %>
                </dt>
                <dt>三级文物 : <%=list.get(11) %>
                </dt>
                <dt>可移动文物 : <%=list.get(12) %>
                </dt>
                <dt>不可移动文物 : <%=list.get(13) %>
                </dt>
            </dl>
        </div>

        <div class="shujutow">
            <dl>
                <dt>浏览数量 : <%=list.get(15) %>
                </dt>
                <dt>收藏数量 : <%=list.get(14) %>
                </dt>
                <dt></dt>
                <dt>评论数量 : <%=list.get(17) %>
                </dt>
                <dt>回复数量 : <%=list.get(16) %>
                </dt>
            </dl>
        </div>
    </div>

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