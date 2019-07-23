<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.museum.domain.*"%>
<%
 
	List<Integer> list=(List<Integer>)request.getAttribute("list"); 
	List<Value> vL=(List<Value>)request.getAttribute("vL"); 
	List<Hall> hL=(List<Hall>)request.getAttribute("hL");  

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
	

   <div class="admin-index">
      <dl data-am-scrollspy="{animation: 'slide-right', delay: 52}">
        <dt class="qs"> </dt>
        <dd>6</dd>
        <dd class="f12" style="font-weight: 700">展厅数量</dd>
      </dl>
      <dl data-am-scrollspy="{animation: 'slide-right', delay: 150}">
        <dt class="cs"> </dt>
        <dd><%=list.get(0) %></dd>
        <dd class="f12">展品总量</dd>
      </dl>
      <dl data-am-scrollspy="{animation: 'slide-right', delay: 300}">
        <dt class="hs"> </dt>
        <dd><%=list.get(4) %></dd>
        <dd class="f12">注册用户数</dd>
      </dl> 
    </div>
    <div class="admin-biaoge">
      <div class="xinxitj">展厅展品数量</div>
      <table class="am-table">
        <thead>
          <tr>
          	<%
          		for(Hall H : hL){
          	 %>
            <th><%=H.getHallId() %>号展厅</th>
			<%
				}
			 %>
        
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><%=list.get(1) %></td>
            <td><%=list.get(2) %></td>
            <td><%=list.get(3) %></td>
            <td><%=list.get(17) %></td>
            <td><%=list.get(18) %></td>
            <td><%=list.get(19) %></td>
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
            <td><%=list.get(5) %></td>
            <td><%=list.get(6) %></td>
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
            <td><%=list.get(7) %></td>
            <td><%=list.get(8) %></td>
          </tr>
          
        </tbody>
      </table>
    </div>
    <div class="shuju">
      <div class="shujuone">
        <dl>
          <dt>一级文物            : <%=list.get(9) %></dt>
          <dt>二级文物            : <%=list.get(10) %></dt>
          <dt>三级文物            : <%=list.get(11) %></dt>
          <dt>可移动文物       : <%=list.get(12) %></dt> 
          <dt>不可移动文物  : <%=list.get(13) %></dt>  
        </dl> 
      </div>
      <div class="shujutow">
       <dl>
          <dt>浏览数量  : <%=list.get(15) %></dt>
          <dt>收藏数量  : <%=list.get(14) %></dt>
          <dt></dt>
          <dt>评论数量  : <%=list.get(17) %></dt> 
          <dt>回复数量  : <%=list.get(16) %></dt>  
        </dl>  
      </div>
  
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