<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.museum.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<News> list=(List<News>)request.getAttribute("SearchList");
	String newsId=String.valueOf(request.getAttribute("newsId"));
	String newstime=String.valueOf(request.getAttribute("newstime"));
	String newstitle=String.valueOf(request.getAttribute("newstitle"));
	String i=String.valueOf(request.getAttribute("maxPage"));
	String j=String.valueOf(request.getAttribute("page"));
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
			<li><a href="#">展馆信息</a></li>
			<li><a href="#">展厅信息</a></li>
		  </ul>
      <h3 class="am-icon-volume-up"><em></em> 咨询管理</h3>
		  <ul>
			<li><a href="<%=path %>/Activity/list.do?p=1&size=5&type=1">展厅活动</a></li>
			<li><a href="<%=path %>/news/list.do?p=1&size=5">展馆新闻</a></li>
			<li><a href="<%=path %>/Activity/list.do?p=1&size=5&type=2">专题讲座</a></li>
		  </ul>
	  <h3 class="am-icon-users"><em></em> 用户管理</h3>
		  <ul>
		  	<li><a href="#">用户信息</a></li>
			<li><a href="#">评论信息</a></li>
			<li><a href="#">用户权限</a></li>
		  </ul>
      <h3 class="am-icon-gears"><em></em> 展品管理</h3>
		  <ul>
		  	<li><a href="商品列表.html">展品信息</a> </li>
			<li><a href="#">展厅展品</a> </li>
			<li><a href="#">库存展品</a></li>
		  </ul>
      <h3 class="am-icon-gears"><em></em> 服务管理</h3>
		  <ul>
			<li><a href="#">服务项目</a> </li>
			<li><a href="#">投诉信息</a></li>
			<li><a href="#">问卷调查</a></li>
		  </ul>
      
	  <h3 class="am-icon-gears"><em></em> 统计管理</h3>
		   <ul>
			<li><a href="#">浏览统计</a></li>	
			<li><a href="#">展品统计</a></li>	
			<li><a href="#">收藏统计</a></li>
			<li><a href="#">用户统计</a></li>
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
      <ul class="am-icon-flag on"> 新闻管理</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">新闻管理</a></dl>
      
      <dl>
        <button type="button" href="<%=path %>/admin/News/saveNews.jsp" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"> 添加新闻</button>
      </dl>
      
      
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
      </div>
    </li>
    <form class="am-form am-g" method="post" action="<%=path %>/news/findBy.do?page=1&size=5">
    <li><input type="text" name="newstitle" class="am-form-field am-input-sm am-input-xm" placeholder="新闻标题" /></li>
    <li><input type="text" name="newstime" class="am-form-field am-input-sm am-input-xm" placeholder="发布时间" /></li>
    <li><input type="text" name="newsId" class="am-form-field am-input-sm am-input-xm" placeholder="新闻编号" /></li>
    <li><button type="submit"   class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
 	</form>
  </ul>
</div>


    <form class="am-form am-g" action="<%=path %>/news/delete.do" method="post">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success">
                <th ></th>
                <th class="table-id">ID</th>
                <th class="table-title">新闻标题</th>
                <th class="table-type">新闻摘要</th>
                <th class="table-date am-hide-sm-only">发布时间</th>
                <th width="163px" class="table-set">操作</th>
              </tr>
            </thead>
            <tbody>
		            <%
		            	for(News news:list){
		            
		             %> 
				    <tr>
				        <td><input type="checkbox" name="id" value="<%=news.getNewsId() %>" /></td>
				        <td><%=news.getNewsId()%></td>
					    <td><%=news.getNewsTitle()%></td>
						<td><%=news.getNewsAbstract()%></td>
						<td><%=news.getNewsTime()%></td>
						<td><div class="am-btn-toolbar">
			                 <div class="am-btn-group am-btn-group-xs">
			                  	<a  class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
			                  	<a href="<%=path %>/news/findById.do?NewsId=<%=news.getNewsId() %>" class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="编辑"></a>
			                 </div>
			                 </div>
			             </td>
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
                <li><a href="<%=path %>/news/findBy.do?newsId=<%=newsId %>&newstime=<%=newstime %>&newstitle=<%=newstitle %>&page=1&size=5">«首页</a></li>
                <li><a href="<%=path %>/news/findBy.do?newsId=<%=newsId %>&newstime=<%=newstime %>&newstitle=<%=newstitle %>&page=<%=nowPage-1 %>&size=5">上一页</a></li>
                <li><a href="<%=path %>/news/findBy.do?newsId=<%=newsId %>&newstime=<%=newstime %>&newstitle=<%=newstitle %>&page=<%=nowPage+1 %>&size=5">下一页</a></li>
                <li><a href="<%=path %>/news/findBy.do?newsId=<%=newsId %>&newstime=<%=newstime %>&newstitle=<%=newstitle %>&page=<%=maxPage %>&size=5">末页»</a></li>
             </ul>
          <hr />
          <p>注：.....</p>
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
