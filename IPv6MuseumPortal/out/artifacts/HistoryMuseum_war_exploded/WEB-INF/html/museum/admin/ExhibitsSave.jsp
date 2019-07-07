<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="museum.entity.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<Apply> aL=(List<Apply>)request.getAttribute("aL");
    List<Dynasty> dL=(List<Dynasty>)request.getAttribute("dL");
    List<Material> mL=(List<Material>)request.getAttribute("mL");
    List<Value> vL=(List<Value>)request.getAttribute("vL");
    List<Religion> rL=(List<Religion>)request.getAttribute("rL");
    List<Hall> hL=(List<Hall>)request.getAttribute("hL");
    List<State> sL=(List<State>)request.getAttribute("sL");
    List<Nation> nL=(List<Nation>)request.getAttribute("nL");
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
                    <li><a href="/user/index?User_Id=<%=id %>&User_root=<%=root%>">返回主页</a></li>
                </ul>
            </div>
        </font>
    </div>
</div>


<div class="admin-biaogelist">

    <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on"><strong> 展品信息</strong></ul>
        <dl class="am-icon-home" style="float: right;"><strong> 当前位置： 首页 &gt; <a href="<%=path %>/Exhibits/list.do?p=1&size=5">展品信息</a> </strong></dl>
    </div>
    <form class="am-form am-g" method="post" method="post" action="/manage/findBy?page=1&size=5">
        <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
            <ul>
                <li>
                    <div class="am-btn-group am-btn-group-xs">
                        <select name="Material" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                            <option value="1">历史纪念物</option>
                            <option value="2">个人肖像</option>
                            <option value="3">集体合影</option>
                            <option value="4">校园景色</option>
                            <option value="5">活动留影</option>
                            <option value="6">校徽</option>
                            <option value="7">交流纪念物</option>
                            <option value="8">历史文件</option>
                            <option value="9">获奖记录</option>
                            <option value="10">硬件设施</option>
                            <option value="11">科研纪念物</option>
                            <option value="12">统计图表</option>
                        </select>
                    </div>
                </li>
                <li>
                    <div class="am-btn-group am-btn-group-xs">
                        <select name="Dynasty" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                            <option value="1">北京高级商业职业学校</option>
                            <option value="2">北京市财经学校</option>
                            <option value="3">北京机械学院</option>
                            <option value="4">西安交通大学水利系、纺织系</option>
                            <option value="5">西安化工学院</option>
                            <option value="6">西安机械制造学院</option>
                            <option value="7">陕西科技大学</option>
                            <option value="8">陕西工业大学</option>
                            <option value="9">陕西机械学院</option>
                            <option value="10">西安理工大学</option>
                        </select>
                    </div>
                </li>
                <li>
                    <div class="am-btn-group am-btn-group-xs">
                        <select name="Apply" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                            <option value="1">历史照片</option>
                            <option value="2">纪念物</option>
                            <option value="3">学校介绍</option>
                        </select>
                    </div>
                </li>
                <li>
                    <div class="am-btn-group am-btn-group-xs">
                        <select name="Value" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                            <option value="1"> 一级文物</option>
                            <option value="2"> 二级文物</option>
                            <option value="3"> 三级文物</option>
                            <option value="4"> 未分级</option>
                        </select>
                    </div>
                </li>
                <li><input type="text" name="exhibitsName" class="am-form-field am-input-sm am-input-xm"
                           placeholder="关键词搜索"/></li>
                <li>
                    <button type="submit" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">
                        搜索
                    </button>
                </li>
            </ul>
        </div>
    </form>


        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
            <tr class="am-success">
                <th class="table-title"><strong>展品名</strong></th>
                <th class="table-type"><strong>展品产地</strong></th>
                <th class="table-type"><strong>生产时间</strong></th>
                <th class="table-type"><strong>出土地点</strong></th>
                <th class="table-author am-hide-sm-only"><strong>出土时间</strong></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><strong><input type="hidden" name="exhibitsId" value=""><input type="text" name="exhibitsName" class="am-form-field am-input-sm am-input-xm" "></strong></td>
                <td><strong><input type="text" name="exhibitsProducePlace" class="am-form-field am-input-sm am-input-xm"></strong></td>
                <td><strong><input type="text" name="exhibitsProduceTime" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsExcavatePlace" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsExcavateTime" class="am-form-field am-input-sm am-input-xm" ></strong></td>
            </tr>
            <tr class="am-success">
                <th class="table-title"><strong>展品位置编号</strong></th>
                <th class="table-type"><strong>位置x</strong></th>
                <th class="table-type"><strong>位置y</strong></th>
                <th class="table-type"><strong>展品外貌</strong></th>
                <th class="table-author am-hide-sm-only"><strong>展品描述</strong></th>
            </tr>

            <tr>
                <td><strong><input type="text" name="exhibitsLocationNumber" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsLocationX" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsLocationY" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsAppearance" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsDetail" class="am-form-field am-input-sm am-input-xm"></strong></td>

            </tr>
            <tr class="am-success">
                <th class="table-title"><strong>展品语音</strong></th>
                <th class="table-type"><strong>点赞数</strong></th>
                <th class="table-type"><strong>浏览次数</strong></th>
                <th class="table-author am-hide-sm-only"><strong>收藏次数</strong></th>
                <th class="table-title"><strong>破损程度</strong></th>
            </tr>

            <tr>
                <td><strong><input type="text" name="exhibitsVoice" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsUpvote" class="am-form-field am-input-sm am-input-xm"></strong></td>
                <td><strong><input type="text" name="exhibitsBrowse" class="am-form-field am-input-sm am-input-xm" ></strong></td>
                <td><strong><input type="text" name="exhibitsDamage" class="am-form-field am-input-sm am-input-xm"></strong></td>
                <td><strong><input type="text" name="exhibitsCherish" class="am-form-field am-input-sm am-input-xm" ></strong></td>

            </tr>

            </tr>

            </tbody>
        </table>

        <div class="am-btn-group am-btn-group-xs">
            <strong><button type="submit" class="am-btn am-btn-default"><span class="am-icon-plus"></span>保存</button></strong>
        </div>
        <hr />
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