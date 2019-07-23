<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Exhibits"%>
<%@page import="com.museum.domain.User"%>
<%@page import="com.museum.domain.Comment"%>
<%@page import="com.museum.domain.Reply"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<Exhibits> list = (List<Exhibits>)request.getAttribute("list"); %>
<% List<User> list2 = (List<User>)request.getAttribute("list2"); %>
<% List<Comment> list3 = (List<Comment>)request.getAttribute("list3"); %>
<% Map<Comment,Reply> list5 =  (Map<Comment,Reply>)request.getAttribute("list5"); %>
<% 
		String id   = String.valueOf(request.getSession().getAttribute("User_id"));
	String root = String.valueOf(request.getSession().getAttribute("User_root"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>藏品</title>
    
    <!-- core CSS -->
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path %>/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/main.css" rel="stylesheet">
    <link href="<%=path %>/css/responsive.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="<%=path %>/js/html5shiv.js"></script>
    <script src="<%=path %>/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
  <div class="row">
   <% for(Exhibits n : list){ %>
                	<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                		<form action="<%=path %>/collection/save.do" method="post">
                			<input type="hidden" name="userid" value="<%=id %>">
                			<input type="hidden" name="exhibitsId" value="<%= n.getExhibitsId()%>">
                			
                			<input type="submit" value="收藏"/>
                		</form>
            
                	</button></div>
                </div> 
          <%} %>      
	<form id="form01" action="<%=path %>/cangPin3/find.do" accept-charset="UTF-8">
    <section id="blog" class="container">
    
    <% for(Exhibits n : list){ %>
    
        <div class="center">
            <input type="hidden" name="zzz" value="<%=n.getExhibitsId() %>" /><h2><%=n.getExhibitsName() %></h2>
        </div>
		<input type="hidden" name="xxx" value="<%=id %>" />
        <div class="blog">
            <div class="row">
                <div class="col-md-8">
                    <div class="blog-item">
                        <img class="img-responsive img-blog" src="<%=n.getExhibitsImagefull() %>" width="100%" alt="" />
                            <div class="row">  
                                
                            </div>
                        </div><!--/.blog-item-->
                        
                       <h3 style="line-height:30px;margin-top:-70px">
							<%=n.getExhibitsDetail() %>
                       </h3>
                        
                </div><!--/.col-md-8-->

                <aside class="col-md-3 col-md-offset-1">

                     <div class="widget categories">
	                 	年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp代 :&nbsp&nbsp<%=n.getDynasty().getDynastyType() %><br/>
	                 	材&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp料 :&nbsp&nbsp<%=n.getMaterial().getMaterialType() %><br/>
	                 	尺&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp寸 :&nbsp&nbsp<%=n.getExhibitsAppearance() %><br/>
	                 	用&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp途 :&nbsp&nbsp<%=n.getApply().getApplylType() %><br/>
	                 	出土地点 :&nbsp&nbsp<%=n.getExhibitsExcavatePlace() %><br/>
	                 	生产地点 :&nbsp&nbsp<%=n.getExhibitsProducePlace() %><br/>
	                 	生产时间 :&nbsp&nbsp<%=n.getExhibitsProduceTime() %><br/>
	                 	浏览次数 :&nbsp&nbsp<%=n.getExhibitsBrowse() %><br/>
	                 	收藏次数 :&nbsp&nbsp<%=n.getExhibitsUpvote() %><br/>
	                 	宗&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp教 :&nbsp&nbsp<%=n.getReligion().getReligionType() %><br/>
	                 	民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族 :&nbsp&nbsp<%=n.getNation().getNationType() %><br/>
	                 	价&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp值 :&nbsp&nbsp<%=n.getValue().getValueType() %><br/>                      
                    </div><!--/.categories-->
                </aside>    
               
              

            </div><!--/.row-->
			<div class="row"><h2 style="margin-left:230px">评论</h2></div>
			<div class="row">
				<div class="row">
					<% int i = 0; %>
					<% if(list3 != null){%>
						<% for(Comment e : list3){ 
						%>	
							<div style="margin-top:10px" class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
								<%=e.getFromUid() %>:
							</div>
							<div style="margin-top:10px" class="col-xs-11 col-sm-11 col-md-11 col-lg-11">
								<%=e.getCommentContent() %>
							</div>
							<br/>
							<% if(list5.get(e)!=null){ %>
							<div style="margin-top:10px" class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
								
							</div>
							<div style="margin-top:10px" class="col-xs-11 col-sm-11 col-md-11 col-lg-11">
								<div style="margin-left:-20px" class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
									作者回复:
								</div>
								<div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
									<p><%=list5.get(e).getReplyContent() %></p>
								</div>
							</div>
							<br/>
							<% } %>
							<br/>
						<%} %>
					<%} %>
				</div>
			</div>
			<br/>
			<div class="row">
				<textarea id="text" rows="10" cols="80" name="text" value=""></textarea>
			</div> 
         </div><!--/.blog-->

	<% } %>
    <input type="submit" value="提交评论" onclick="winclose()"></input>

    </section><!--/#blog-->
    <form>

    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/jquery.prettyPhoto.js"></script>
    <script src="<%=path %>/js/jquery.isotope.min.js"></script>
    <script src="<%=path %>/js/main.js"></script>
    <script src="<%=path %>/js/wow.min.js"></script>
    <script>
    	var link = document.getElementById("text");
    	if(link.innerHTNL!=null){
    		link.value = link.innerHTNL;
    	}
    </script>
    <script type="text/javascript">
    	function collect(ExhibitsId){
    		window.alert("收藏成功！");
    	}
    </script>
    
    <script language=javascript>
       function winclose() {
       //此处填写要处理的逻辑代码
            window.opener.location.reload();//刷新
       }
    </script>
   
</body>
 
</html>