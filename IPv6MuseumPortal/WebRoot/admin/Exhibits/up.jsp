<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Exhibits exhibits=(Exhibits)request.getAttribute("exhibits");
	 String id=String.valueOf(request.getSession().getAttribute("User_id"));
    String root=String.valueOf(request.getSession().getAttribute("User_root"));

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
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
</head>
<body>
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p><![endif]-->






</head>
<body>
<strong><HEADER class="am-topbar admin-header"></strong>
  <div class="am-topbar-brand"><strong><img src="<%=path %>/admin/assets/i/logo.png"></strong></div>


      <li class="am-hide-sm-only" style="float: right;"><strong><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></strong></li>
    
  
<strong><HEADER></strong>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
    
 <strong> <font size=3 >   
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
  </font></strong></div>
  <strong><script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:150, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script></strong>	      
    <!-- sideMenu End --> 
    
     

 
</div>

<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"><strong> 展品信息</strong></ul>
      
      <dl class="am-icon-home" style="float: right;"><strong> 当前位置： 首页 &gt; <a href="#">展品信息</a></strong></dl>
      
 
      
    </div>
<form class="am-form am-g" method="post" enctype="multipart/form-data" action="<%=path %>/Exhibits/up.do?id=<%=exhibits.getExhibitsId() %>">
<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">

          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success">
                <th class="table-title"><strong>展品Id</strong></th>
                <th class="table-title"><strong>展品图片</strong></th>
              </tr>
            </thead>
            <tbody>
             <tr>
             	  <td><%=exhibits.getExhibitsId() %></td>
			          <td>    <input type="file" name="file1">	 </td>
  			
  		
  			
            </tbody>
          </table>
          
                 <div class="am-btn-group am-btn-group-xs">
              <strong><button type="submit" class="am-btn am-btn-default"><span class="am-icon-plus"></span>上传</button></strong>
            </div>
          
        
          
          
      
          <hr />
        </form>
 
 
 
 
 <div class="foods">
 
  <dl>
    
  </dl>
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