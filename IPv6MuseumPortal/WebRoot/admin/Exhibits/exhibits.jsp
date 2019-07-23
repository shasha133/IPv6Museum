<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
	List<Exhibits> list=(List<Exhibits>)request.getAttribute("list");
	List<Apply> aL=(List<Apply>)request.getAttribute("aL");
	List<Dynasty> dL=(List<Dynasty>)request.getAttribute("dL");
	List<Material> mL=(List<Material>)request.getAttribute("mL");
	List<Value> vL=(List<Value>)request.getAttribute("vL");
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
      <ul class="am-icon-flag on"> 展品信息</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > 展品信息</a></dl>
      <form action="<%=path %>/Exhibits/saveinfo.do" method="post">
      <dl>
        <button type="submit"  class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"> 添加展品</button>
      </dl>
      </form>
      
    </div>
<form class="am-form am-g" method="post" action="<%=path %>/Exhibits/findBy.do?page=1&size=5">
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
        <select name="Material" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
		   <%
		  		for(Material m : mL){
		   %>
		    <option value="<%= m.getMaterialId()%>"><%= m.getMaterialType() %></option>
		   <%
		   		} 
		   %>
        </select>
      </div>
    </li>
    <li>
      <div class="am-btn-group am-btn-group-xs">
      <select name="Dynasty" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
          <%
		  		for(Dynasty d : dL){
		   %>
		    <option value="<%= d.getDynastylId()%>"><%= d.getDynastyType() %></option>
		   <%
		   		} 
		   %>
      </select>
      </div>
    </li>
	<li>
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="Apply" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
          <%
		  		for(Apply a : aL){
		   %>
		    <option value="<%= a.getApplyId()%>"><%= a.getApplylType() %></option>
		   <%
		   		} 
		   %>
      </select>
      </div>
    </li>
    <li >
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="Value" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
  		   <%
		  		for(Value v : vL){
		   %>
		    <option value="<%= v.getValueId()%>"><%= v.getValueType() %></option>
		   <%
		   		} 
		   %>
      </select>
      </div>
    </li>
    <li><input type="text" name="exhibitsName" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索" /></li>
    <li><button type="submit" class="am-btn am-radius am-btn-xs am-btn-success" style="margin-top: -1px;">搜索</button></li>
  </ul>
</div>
</form>


    <form class="am-form am-g" action="<%=path %>/Exhibits/delete.do" method="post">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success">
                <th class="table-check"></th>
                <th class="table-id">ID</th>
                <th class="table-title">展品名</th>
                <th class="table-type">年代</th>
                <th class="table-type">材质</th>
                <th class="table-type">用途</th>
                <th class="table-author am-hide-sm-only">展厅\库存 <i class="am-icon-check am-text-warning"></i> <i class="am-icon-close am-text-primary"></i></th>
                <th class="table-date am-hide-sm-only">出土日期</th>
                <th width="163px" class="table-set">操作</th>
              </tr>
            </thead>
            <tbody>
              <%
		            	for(Exhibits exhibits : list){
		            
		             %> 
				    <tr>
				        <td><input type="checkbox" name="id" value="<%= exhibits.getExhibitsId()%>" /></td>
				        <td><%= exhibits.getExhibitsId()%></td>
					    <td><%= exhibits.getExhibitsName()%></td>
						<td><%= exhibits.getDynasty().getDynastyType()%></td>
						<td><%= exhibits.getMaterial().getMaterialType()%></td>
						<td><%= exhibits.getApply().getApplylType()%></td>
						
						<%
						 			if(!"0".equals(exhibits.getHall())){
						%>
						 			<td><i class="am-icon-check am-text-warning"></i>/
						 <% 
						 			}else{
						 %>			
						 			<td><i class="am-icon-close am-text-primary"></i>/
						 			
						 <% 		
						 			}
						 %>
						 			
						 <%
						 			if(!"0".equals(exhibits.getState())){
						  %> 
						          <i class="am-icon-check am-text-warning"></i>
						 <%
						 			}else{
						  %> 			
						  			<td><i class="am-icon-close am-text-primary"></i>/
						 			
						 <% 		
						 			}
						 %>	
						<td><%= exhibits.getExhibitsExcavateTime()%></td>
						<td><div class="am-btn-toolbar">
			                 <div class="am-btn-group am-btn-group-xs">
			                  	<a href="<%=path %>/Exhibits/findById.do?exhibitsId=<%=exhibits.getExhibitsId() %>&type=2" class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="修改"></a>
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
                <li><a href="<%=path %>/Exhibits/list.do?p=1&size=5&type=2">«首页</a></li>
                <li><a href="<%=path %>/Exhibits/list.do?p=<%=nowPage-1 %>&size=5&type=2">上一页</a></li>
                <li><a href="<%=path %>/Exhibits/list.do?p=<%=nowPage+1 %>&size=5&type=2">下一页</a></li>
                <li><a href="<%=path %>/Exhibits/list.do?p=<%=maxPage %>&size=5&type=2">末页»</a></li>
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