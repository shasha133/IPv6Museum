<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="museum.entity.User" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%  User user = (User) request.getAttribute("user");
    String id=String.valueOf(request.getSession().getAttribute("User_Id"));
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>首页</title>

    <!-- core CSS -->
    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link href="../resourcesOne/css/font-awesome.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/animate.min.css" rel="stylesheet">
    <link href="../resourcesOne/css/prettyPhoto.css" rel="stylesheet">
    <link href="../resourcesOne/css/main.css" rel="stylesheet">
</head>
<!--/head-->

<body>

<div class="container">
    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
        <div class="row" style="margin-top: 30px">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <label>
                    用户名:
                </label>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <p><%=user.getUserName() %></p>
            </div>
        </div>
        <div class="row" style="margin-top: 10px"></div>
        <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <label>
                    用户权限:
                </label>
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <% if(user.getUserRoot().equals("min")){ %>
                <p>
                    普通用户
                </p>
                <% }else{ %>
                <p>
                    管理员
                </p>
                <% } %>
            </div>
        </div>
        <div style="margin-left:-15px" class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <image style="height:100px;weight:100px" src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=user.getUserImage().replace("\\","*")%>"/>
            <form method="post" action="/person/changeImage?uid=<%=id %>" enctype="multipart/form-data" method="post">
                修改头像：<input type="file" name="file1"><br/>
                <input type="submit" value="提交">
            </form>
        </div>
        <br/>
        <div class="row" style="margin-top: 10px"></div>
        <div class="row">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <br/>
                <a><p style="cursor: pointer" onclick="change(<%=id %>)">
                    修改密码
                </p></a>
            </div>
        </div>
        <div class="row" style="margin-top: 20px"></div>
        <br/>
        <div class="row">
            <iframe id="ifr" scrolling="no" frameborder=0
                    style="width: 800px; height: 1400px" src="#"></iframe>
        </div>
    </div>

    <div class="row" style="margin-top: 10px"></div>
    <div class="row">
        <a href="http://localhost:8088/mymuseum/Front/login"><input onclick="tiaochu()" type="button" value="请登录" /></a>
    </div>
</div>

<!-- jQuery -->
<script src="../resourcesOne/bootStrap/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../resourcesOne/bootStrap/bootstrap.min.js"></script>
<script src="../resourcesOne/js/jquery.prettyPhoto.js"></script>
<script src="../resourcesOne/js/jquery.isotope.min.js"></script>
<script src="../resourcesOne/js/main.js"></script>
<script src="../resourcesOne/js/jquery.js"></script>
<script src="../resourcesOne/js/wow.min.js"></script>
<script type="text/javascript">
    function change(id){
        var Link = document.getElementById("ifr");
        Link.src = "/ChangeMM.jsp";
        return Link.src;
    }
    function tiaochu(){
        if(top.location!=self.location){
            top.location=self.location;
        }
    }

</script>

</body>
</html>