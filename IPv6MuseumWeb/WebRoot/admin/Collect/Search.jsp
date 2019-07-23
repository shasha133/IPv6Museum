	 <%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.museum.domain.*" %>
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
	 String id=String.valueOf(request.getSession().getAttribute("User_id"));
    String root=String.valueOf(request.getSession().getAttribute("User_root"));
    int maxPage=Integer.valueOf(i);
    int nowPage=Integer.valueOf(j);
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

<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"> 评论管理</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 >浏览统计</a></dl>
      
      
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
      </div>
    </li>
    <form class="am-form am-g" method="post" action="<%=path %>/Collect/findBy.do?page=1&size=5">
    <li><input type="text" name="UserId" class="am-form-field am-input-sm am-input-xm" placeholder="用户Id" /></li>
    <li><input type="text" name="ExhibitId" class="am-form-field am-input-sm am-input-xm" placeholder="展品Id" /></li>
    <li><button type="submit"   class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
 	</form>
  </ul>
</div>


    <form class="am-form am-g" action="<%=path %>/Collect/delete.do" method="post">
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
                <li><a href="<%=path %>/Collect/findBy.do?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=1&size=5">«首页</a></li>
                <li><a href="<%=path %>/Collect/findBy.do?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=nowPage-1 %>&size=5">上一页</a></li>
                <li><a href="<%=path %>/Collect/findBy.do?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=nowPage+1 %>&size=5">下一页</a></li>
                <li><a href="<%=path %>/Collect/findBy.do?UserId=<%=UserId %>&ExhibitId=<%=ExhibitId %>&page=<%=maxPage %>&size=5">末页»</a></li>
              </ul>
          
          
          
      
          <hr />
        </form>
 
 
 





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
