<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Exhibits"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<Exhibits> list = (List<Exhibits>)request.getAttribute("list"); %>
<% int i = Integer.parseInt(String.valueOf(request.getAttribute("maxPage")));  %>
<% int i2 = Integer.parseInt(String.valueOf(request.getAttribute("numPage")));  %>
<% 
		String id   = String.valueOf(request.getSession().getAttribute("User_id"));
	String root = String.valueOf(request.getSession().getAttribute("User_root"));
%>
<% String str = String.valueOf(request.getAttribute("material")); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>展品</title>
	
	<!-- core CSS -->
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=path %>/css/main.css" rel="stylesheet">
    <link href="<%=path %>/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<%=path %>/js/html5shiv.js"></script>
    <script src="<%=path %>/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<%=path %>/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=path %>/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=path %>/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=path %>/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=path %>/images/ico/apple-touch-icon-57-precomposed.png">
    

</head><!--/head-->

<body>
	
    <div class="row">
    	<div class="row clearfix">
					<%for(Exhibits n : list){%>
					<div class="col-md-4 col-sm-6">	
						<div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
							<div class="media">
								<div class="pull-left">
								<form id="form01" action="<%=path %>/cangPin3/find2.do?title=<%=n.getExhibitsId() %>">
									<input id="input01" type="hidden" name="zzz"/>
									<a target="blank" style="cursor:pointer" onclick="open1(<%=n.getExhibitsId() %>)" ><img style="width:100px;height:100px" class="media-object" src="<%=n.getExhibitsImagefull() %>" alt=""></a>
									
								</form>
								</div>
								<div class="media-body">
									<h4><%=n.getExhibitsName() %></h4>
									<h5><%=n.getDynasty().getDynastyType()%><br/><br/><%=n.getValue().getValueType() %><br/><br/>
									<% if(n.getExhibitsAppearance()==null){%>
										外貌未知
										<% }else{ %>
										<%=n.getExhibitsAppearance() %>
									<% } %>
									</h5>
								</div>
							</div><!--/.media -->
						</div>
					</div><!--/.col-lg-4 -->
					
					<%} %>
		</div>
    </div>
    <div class="row" >
        <br/>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <p style="cursor:pointer" name="prePage" onclick="change1()">上一页</p>
        </div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <p style="cursor:pointer" name="nextPage" onclick="change2()">下一页</p>
        </div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <p name="num">第<%=i2 %>页</p>
        </div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
            <p name="sum">共<%=i %>页</p>
        </div>
    </div>
	
    <script src="<%=path %>/js/jquery.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/jquery.prettyPhoto.js"></script>
    <script src="<%=path %>/js/jquery.isotope.min.js"></script>
    <script src="<%=path %>/js/main.js"></script>
    <script src="<%=path %>/js/wow.min.js"></script>
    <script type="text/javascript">
    	function open1(ExhibitsId){
    		var Link = document.getElementById("input01");
    		Link.value = ExhibitsId;
    		$("#form01").submit();
    	}
    	function change1(){
    		var page = <%=i2 %>;
    		window.location.href='<%=path %>/guanCWW/find.do?page='+page+'&str='+<%=str %>;
    	}
    	function change2(){
    		var page2 = <%=i2 %>;
    		window.location.href='<%=path %>/guanCWW/find.do?page2='+page2+'&str='+<%=str %>;
    		
    	}
    </script>
    
</body>
</html>