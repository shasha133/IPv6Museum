<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="museum.entity.News" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    News news=(News)request.getAttribute("news");
    String id=String.valueOf(request.getSession().getAttribute("User_Id"));
    String root=String.valueOf(request.getSession().getAttribute("User_root"));
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
    <link rel="stylesheet" href="../resourcesOne/asserts/css/admin.css">>
    <![endif]-->
</head>

<body>
<strong><HEADER class="am-topbar admin-header"></strong>
<div class="am-topbar-brand"><strong><img src="/admin/assets/i/logo.png"></strong></div>
<li class="am-hide-sm-only" style="float: right;"><strong><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></strong></li>



<div class="am-cf admin-main">
    <div class="nav-navicon admin-main admin-sidebar">
        <font size=3 >
            <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：</div>
            <div class="sideMenu">
                <h3 class="am-icon-flag"><em></em>展馆管理</h3>
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
                    <li><a href="/manage/list?p=1&size=5">展品信息</a> </li>
                    <li><a href="/manage/hall?hallId=1&page=1&size=5">展厅展品</a> </li>
                </ul>


                <h3 class="am-icon-gears"><em></em> 统计管理</h3>
                <ul>
                    <li><a href="/Record/Exlist?p=1&size=5">浏览统计</a></li>
                    <li><a href="/Collect/Exlist?p=1&size=5">收藏统计</a></li>
                </ul>
                <h3 class="am-icon-gears"><em></em> 返回</h3>
                <ul>
                    <li><a href="/user/index?User_Id=<%=id %>&User_root=<%=root%>">返回主页</a></li>
                </ul>
            </div>
        </font>
    </div>
    </font>
</div>


<div class="admin-biaogelist">

    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"><strong> 展厅活动管理</strong></ul>
        <dl class="am-icon-home" style="float: right;"><strong> 当前位置：首页 ><a href="/Activity/list?p=1&size=5&type=1">展厅活动</a></strong></dl>
    </div>

    <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
        <ul>
            <li>
                <div class="am-btn-group am-btn-group-xs">
                </div>
                <br></li>
            <form class="am-form am-g" method="post" method="post" action="/Activity/findBy?page=1&size=5&type=1">
                <li><input type="text" name="activitytitle" class="am-form-field am-input-sm am-input-xm" placeholder="活动标题" /></li>
                <li><input type="text" name="activitytime" class="am-form-field am-input-sm am-input-xm" placeholder="活动发布时间" /></li>
                <li><input type="text" name="activityId" class="am-form-field am-input-sm am-input-xm" placeholder="活动编号" /></li>
                <li><button type="submit"   class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
            </form>
        </ul>
    </div>


    <form class="am-form am-g" method="post" action="/Activity/save">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-title">活动标题</th>
                <th width="163px" class="table-set">活动结束时间</th>
                <th width="163px" class="table-set">活动地点</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="hidden" name="type" value="1"/><strong><input type="text" name="activityTitle" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="activityTimeEnd" class="am-form-field am-input-sm am-input-xm" placeholder="格式：yyyy-MM-dd HH:mm:ss" ></strong></td>
                <td><strong><input type="text" name="activityState" class="am-form-field am-input-sm am-input-xm" ></strong></td>
            </tr>
            <tr class="am-success">
                <th class="table-date am-hide-sm-only">活动摘要</th>
                <th class="table-date am-hide-sm-only">活动发布时间</th>
                <th width="163px" class="table-set">活动开始时间</th>
            </tr>
            <tr>
                <td><strong><input type="text" name="activityAbstract" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="activityTime" class="am-form-field am-input-sm am-input-xm" placeholder="格式：yyyy-MM-dd HH:mm:ss"></strong></td>
                <td><strong><input type="text" name="activityTimeStart" class="am-form-field am-input-sm am-input-xm" placeholder="格式：yyyy-MM-dd HH:mm:ss" ></strong></td>
            </tr>
            <tr class="am-success">
                <th class="table-type">活动内容</th>
            </tr>
            <tr>
                <td><strong><textarea rows="5" cols="5" name="activityContext"></textarea></strong></td>
            </tr>
            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs">
            <strong><button type="submit" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 保存</button></strong>
        </div>
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
