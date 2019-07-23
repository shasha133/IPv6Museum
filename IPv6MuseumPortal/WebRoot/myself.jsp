<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.museum.domain.Record"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% List<Record> list = (List<Record>)request.getAttribute("list"); %>
<% int i = Integer.parseInt(String.valueOf(request.getAttribute("maxPage")));  %>
<% int i2 = Integer.parseInt(String.valueOf(request.getAttribute("numPage")));  %>
<% String id = String.valueOf(request.getSession().getAttribute("User_id"));
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>个人主页</title>
	
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
    		<div class="col-md-8 col-sm-8">	
						<div class="col-md-2 col-sm-2">
							<p>展品号</p>
						</div>
						<div class="col-md-4 col-sm-4">
							<p>浏览时间</p>
						</div>
						
					</div><!--/.col-lg-4 -->
    	</div>
    	<div class="row clearfix">
    				
					<%for(Record n : list){
					
						if(id.equals(n.getUser().getUserId())){
						
						
					%>
					
					<div class="col-md-8 col-sm-8">	
						<div class="col-md-2 col-sm-2">
							<p><%=n.getRecordExhibitId() %></p>
						</div>
						<div class="col-md-4 col-sm-4">
							<p><%=n.getRecordTime() %></p>
						</div>
						
					</div><!--/.col-lg-4 -->
					
					<%}} %>
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
    		window.location.href='<%=path %>/cangPin3/find.do?ExhibitsId='+ExhibitsId;
    		
    	}
    	function change1(){
    		var page = <%=i2 %>;
    		window.location.href='<%=path %>/myself/find.do?page='+page;
    	}
    	function change2(){
    		var page2 = <%=i2 %>;
    		window.location.href='<%=path %>/myself/find.do?page2='+page2;
    		
    	}
    </script>
    
</body>
</html>