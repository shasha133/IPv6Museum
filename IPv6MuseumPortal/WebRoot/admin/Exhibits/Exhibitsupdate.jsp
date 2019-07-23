<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Exhibits exhibits=(Exhibits)request.getAttribute("exhibits");
	List<Apply> aL=(List<Apply>)request.getAttribute("aL");
	List<Dynasty> dL=(List<Dynasty>)request.getAttribute("dL");
	List<Material> mL=(List<Material>)request.getAttribute("mL");
	List<Value> vL=(List<Value>)request.getAttribute("vL");
	List<Religion> rL=(List<Religion>)request.getAttribute("rL");
	List<Hall> hL=(List<Hall>)request.getAttribute("hL");
	List<State> sL=(List<State>)request.getAttribute("sL");
	List<Nation> nL=(List<Nation>)request.getAttribute("nL");
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
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="<%=path %>/Exhibits/list.do?p=1&size=5">展品信息</a> </dl>
      
 
      
    </div>
<form class="am-form am-g" method="post" action="<%=path %>/Exhibits/update.do">
<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
        <select name="materialId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
		   <%
		  		for(Material m : mL){
		  		if(m.getMaterialId()==exhibits.getMaterial().getMaterialId()){
		   %>
		    <option selected="selected" value="<%= m.getMaterialId()%>"><%= m.getMaterialType() %></option>
		   <%
		   		} else{
		   %>
		    <option value="<%= m.getMaterialId()%>"><%= m.getMaterialType() %></option>
		    <%
		          }
		       }
		     %>
        </select>
      </div>
    </li>
    <li>
      <div class="am-btn-group am-btn-group-xs">
      <select name="dynastyId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
         <%
		  		for(Dynasty d: dL){
		  		if(d.getDynastylId()==exhibits.getDynasty().getDynastylId()){
		   %>
		    <option selected="selected" value="<%= d.getDynastylId()%>"><%= d.getDynastyType()%></option>
		   <%
		   		} else{
		   %>
		    <option value="<%= d.getDynastylId()%>"><%= d.getDynastyType()%></option>
		    <%
		          }
		       }
		     %>
      </select>
      </div>
    </li>
	<li >
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="applyId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
        <%
		  		for(Apply a : aL){
		  		if(a.getApplyId()==exhibits.getApply().getApplyId()){
		  		
		   %>
		    <option selected="selected" value="<%=a.getApplyId()%>"><%= a.getApplylType()%></option>
		   <%
		   		} else{
		   %>
		    <option value="<%=a.getApplyId()%>"><%= a.getApplylType()%></option>
		    <%
		          }
		       }
		     %>
      </select>
      </div>
    </li>
    <li >
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="valueId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
  		   <%
		  		for(Value v : vL){
		  		if(v.getValueId()==exhibits.getValue().getValueId()){
		   %>
		    <option selected="selected" value="<%= v.getValueId()%>"><%= v.getValueType() %></option>
		   <%
		   		} else{
		   %>
		    <option value="<%= v.getValueId()%>"><%= v.getValueType() %></option>
		    <%
		          }
		       }
		    %>
      </select>
      </div>
    </li>
   </ul>

  <ul>
    <li>
      <div class="am-btn-group am-btn-group-xs">
        <select name="religionId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
		   <%
		  		for(Religion r : rL){
		  		if(r.getReligionlId()==exhibits.getReligion().getReligionlId()){
		   %>
		    <option selected="selected" value="<%= r.getReligionlId()%>"><%= r.getReligionType()%></option>
		   <%
		   		} else{
		   %>
		    <option value="<%= r.getReligionlId()%>"><%= r.getReligionType() %></option>
		    <%
		          }
		       }
		     %>
        </select>
      </div>
    </li>
    <li>
      <div class="am-btn-group am-btn-group-xs">
      <select name="stateId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
         <%
		  		for(State s: sL){
		  		if(s.getStateId()==exhibits.getState().getStateId()){
		   %>
		    <option selected="selected" value="<%= s.getStateId()%>"><%= s.getStateType()%></option>
		   <%
		   		} else{
		   %>
		    <option value="<%= s.getStateId()%>"><%= s.getStateType()%></option>
		    <%
		          }
		       }
		     %>
      </select>
      </div>
    </li>
	<li >
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="nationId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
        <%
		  		for(Nation n : nL){
		  		if(n.getNationId()==exhibits.getNation().getNationId()){
		  		
		   %>
		    <option selected="selected" value="<%=n.getNationId()%>"><%= n.getNationType()%></option>
		   <%
		   		} else{
		   %>
		    <option value="<%=n.getNationId()%>"><%= n.getNationType()%></option>
		    <%
		          }
		       }
		     %>
      </select>
      </div>
    </li>
    <li >
    	
      <div class="am-btn-group am-btn-group-xs">
      <select name="hallId" data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
  		   <%
		  		for(Hall h : hL){
		  		if(h.getHallId()==exhibits.getHall().getHallId()){
		   %>
		    <option selected="selected" value="<%=h.getHallId() %>"><%= h.getHallId() %>号展厅</option>
		   <%
		   		} else{
		   %>
		    <option value="<%=h.getHallId() %>"><%= h.getHallId() %>号展厅</option>
		    <%
		          }
		       }
		    %>
      </select>
      </div>
    </li>
   </ul>
</div>


          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success">
                <th class="table-id">ID</th>
                <th class="table-title">展品名</th>
                <th class="table-type">展品产地</th>
                <th class="table-type">生产时间</th>
                <th class="table-type">出土地点</th>
                <th class="table-author am-hide-sm-only">出土时间</i></th>
              </tr>
            </thead>
            <tbody>
             <tr>
				  <td><strong><input type="hidden" name="exhibitsId" value="<%= exhibits.getExhibitsId()%>"><%= exhibits.getExhibitsId()%></strong></td>
				  <td><strong><input type="text" name="exhibitsName" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsName()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsProducePlace" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsProducePlace()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsProduceTime" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsProduceTime()%>"></strong></td>
			      <td><strong><input type="text" name="exhibitsExcavatePlace" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsExcavatePlace()%>"></strong></td>
			      <td><strong><input type="text" name="exhibitsExcavateTime" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsExcavateTime()%>"></strong></td>
			 </tr>   
  			 <tr class="am-success">
                <th class="table-id"></th>
                <th class="table-title">展品位置编号</th>
                <th class="table-type">位置x</th>
                <th class="table-type">位置y</th>
                <th class="table-type">展品外貌</th>
                <th class="table-author am-hide-sm-only">展品描述</i></th>
              </tr>
  			
  			<tr>
  				  <td></td>
  			      <td><strong><input type="text" name="exhibitsLocationNumber" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsLocationNumber()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsLocationX" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsLocationX()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsLocationY" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsLocationY()%>"></strong></td>
			      <td><strong><input type="text" name="exhibitsAppearance" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsAppearance()%>"></strong></td>
			      <td><strong><input type="text" name="exhibitsDetail" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsDetail()%>"></strong></td>
  			
  			</tr>	
  				 <tr class="am-success">
                <th class="table-id"></th>
                <th class="table-title">展品语音</th>
                <th class="table-type">展品缩略图</th>
                <th class="table-type">展品全图</th>
                <th class="table-type">点赞数</th>
                <th class="table-type">浏览次数</th>
              </tr>
  			
  			<tr>
  				  <td></td>
  			      <td><strong><input type="text" name="exhibitsVoice" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsVoice()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsImagecut" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsImagecut()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsImagefull" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsImagefull()%>"></strong></td>
				  <td><strong><input type="text" name="exhibitsUpvote" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsUpvote()%>"></strong></td>
			      <td><strong><input type="text" name="exhibitsBrowse" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsBrowse()%>"></strong></td>
			     
  			</tr>
  			
  			</tr>	
  				 <tr class="am-success">
                <th class="table-id"></th>
                <th class="table-title">破损程度</th>
                
                <th class="table-author am-hide-sm-only">收藏次数</i></th>
          
              </tr>
              
  			<tr>
  				  <td></td>
  			       <td><strong><input type="text" name="exhibitsDamage" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsDamage()%>"></strong></td>
  				  <td><strong><input type="text" name="exhibitsCherish" class="am-form-field am-input-sm am-input-xm" value="<%= exhibits.getExhibitsCherish()%>"></strong></td>
				 
  			</tr>
            </tbody>
          </table>
          
                 <div class="am-btn-group am-btn-group-xs">
              <button type="submit" class="am-btn am-btn-default"><span class="am-icon-plus"></span>保存</button>
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