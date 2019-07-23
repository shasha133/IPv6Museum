<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.museum.domain.*" %>
<% Exhibits list = (Exhibits)request.getAttribute("exhibits"); 

 String id=String.valueOf(request.getSession().getAttribute("User_id"));
    String root=String.valueOf(request.getSession().getAttribute("User_root"));
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理员界面</title>
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=path %>/admin/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="<%=path %>/admin/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path %>/admin/assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="<%=path %>/admin/assets/css/admin.css">
<script src="<%=path %>/admin/assets/js/jquery.min.js"></script>
<script src="<%=path %>/admin/assets/js/app.js"></script>

  <link rel="shortcut icon" href="admin/Exhibits/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/admin/Exhibits/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/admin/Exhibits/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/admin/Exhibits/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/admin/Exhibits/images/ico/apple-touch-icon-57-precomposed.png">
    <link href="<%=path %>/admin/Exhibits/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/Exhibits/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/Exhibits/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=path %>/admin/Exhibits/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/admin/Exhibits/css/main.css" rel="stylesheet">
    <link href="<%=path %>/admin/Exhibits/css/responsive.css" rel="stylesheet">
</head>
<body>
</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="<%=path %>/admin/assets/i/logo.png"></div>


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
			<li><a href="<%=path %>/Exhibits/count.do">展馆信息</a></li> 
		  </ul>
      <h3 class="am-icon-volume-up"><em></em> 咨询管理</h3>
		  <ul>
			<li><a href="<%=path %>/Activity/list.do?p=1&size=5&type=1">展厅活动</a></li>
			<li><a href="<%=path %>/news/list.do?p=1&size=5">展馆新闻</a></li>
			<li><a href="<%=path %>/Activity/list.do?p=1&size=5&type=2">专题讲座</a></li>
		  </ul>
	  <h3 class="am-icon-users"><em></em> 用户管理</h3>
		  <ul>
		  	<li><a href="<%=path %>/user/list.do?p=1&size=5&type=1">用户信息</a></li>
			<li><a href="<%=path %>/comment/list.do?p=1&size=5">评论信息</a></li>
		  </ul>
      <h3 class="am-icon-gears"><em></em> 展品管理</h3>
		  <ul>
		  	<li><a href="<%=path %>/Exhibits/list.do?p=1&size=5">展品信息</a> </li>
			<li><a href="<%=path %>/Exhibits/hall.do?hallId=1&page=1&size=5">展厅展品</a> </li>
		  </ul>
      
      
	  <h3 class="am-icon-gears"><em></em> 统计管理</h3>
		   <ul>
			<li><a href="<%=path %>/Record/Exlist.do?p=1&size=5">浏览统计</a></li>	 
			<li><a href="<%=path %>/Collect/Exlist.do?p=1&size=5">收藏统计</a></li> 
		  </ul>
			<h3 class="am-icon-gears"><em></em> 返回</h3>
		   <ul>
			<li><a href="<%=path %>/News/set.do?User_Id=<%=id %>&User_root=<%=root%>">返回主页</a></li>	
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

<div class="admin">
	<section id="blog" class="container">
    
    
        <div class="center">
            <h2><%=list.getExhibitsName() %></h2>
        </div>

        <div class="blog">
            <div class="row">
                <div class="col-md-8">
                    <div class="blog-item">
                        <img class="img-responsive img-blog" src="<%= list.getExhibitsImagefull()%>" width="50%" alt="" />
                            <div class="row">  
                                
                            </div>
                        </div><!--/.blog-item-->
                        
                       <h3 style="line-height:30px;margin-top:-70px">
							<%=list.getExhibitsDetail() %>
                       </h3>
                        
                </div><!--/.col-md-8-->

                <aside class="col-md-3 col-md-offset-1">

                     <div class="widget categories">
	                 	年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp代 :&nbsp&nbsp<%=list.getDynasty().getDynastyType() %><br/>
	                 	材&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp料 :&nbsp&nbsp<%=list.getMaterial().getMaterialType() %><br/>
	                 	尺&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp寸 :&nbsp&nbsp<%=list.getExhibitsAppearance() %><br/>
	                 	用&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp途 :&nbsp&nbsp<%=list.getApply().getApplylType() %><br/>
	                 	出土地点 :&nbsp&nbsp<%=list.getExhibitsExcavatePlace() %><br/>
	                 	生产地点 :&nbsp&nbsp<%=list.getExhibitsProducePlace() %><br/>
	                 	生产时间 :&nbsp&nbsp<%=list.getExhibitsProduceTime() %><br/>
	                 	浏览次数 :&nbsp&nbsp<%=list.getExhibitsBrowse() %><br/>
	                 	点赞次数 :&nbsp&nbsp<%=list.getExhibitsUpvote() %><br/>
	                 	宗&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp教 :&nbsp&nbsp<%=list.getReligion().getReligionType() %><br/>
	                 	民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族 :&nbsp&nbsp<%=list.getNation().getNationType() %><br/>
	                 	价&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp值 :&nbsp&nbsp<%=list.getValue().getValueType() %><br/>                      
                    </div><!--/.categories-->
                </aside>     

            </div><!--/.row-->


    </section><!--/#blog-->

    
</body>

      <script type="text/javascript">jQuery(".slideTxtBox").slide();</script> 
   
   
   

   
   
</div>


</div>

</div>


</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="<%=path %>/admin/assets/js/amazeui.min.js"></script>
<!--<![endif]-->



</body>
</html>