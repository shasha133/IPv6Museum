<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="museum.entity.Exhibits" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    List<Exhibits> exhibitsList = (List<Exhibits>) request.getAttribute("exhibitsList");
    int i = Integer.parseInt(String.valueOf(request.getAttribute("maxPage")));
    int i2 = Integer.parseInt(String.valueOf(request.getAttribute("curPage")));
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

<body>

<div class="row">
    <div class="row clearfix">
        <%for (Exhibits n : exhibitsList) {%>
        <div class="col-md-4 col-sm-6">
            <div class="single-profile-top wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms">
                <div class="media">
                    <div class="pull-left">
                        <a target="blank" style="cursor:pointer" onclick="open1(<%=n.getExhibitsId()%>)"><img
                                style="width:100px;height:100px" class="media-object"
                                src="http://[2001:da8:270:2021::71]:8082/image/showImg?path=*<%=n.getExhibitsImagecut().replace("\\","*")%>"/></a>
                    </div>
                    <div class="media-body">
                        <h4><%=n.getExhibitsName() %>
                        </h4>
                        <h5><%=n.getDynastyId()%><br/><br/><%=n.getValue() %><br/><br/>
                            <% if (n.getExhibitsAppearance() == null) {%>
                            外貌未知
                            <% } else { %>
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
<div class="row">
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

<!-- jQuery -->
<script src="../resourcesOne/bootStrap/jquery.min.js"></script> <!-- Bootstrap -->
<script src="../resourcesOne/bootStrap/bootstrap.min.js"></script>
<script src="../resourcesOne/js/jquery.prettyPhoto.js"></script>
<script src="../resourcesOne/js/jquery.isotope.min.js"></script>
<script src="../resourcesOne/js/main.js"></script>
<script src="../resourcesOne/js/jquery.js"></script>
<script src="../resourcesOne/js/wow.min.js"></script>
<script type="text/javascript">
    function change1() {
        var page = <%=i2 %>;
        window.location.href = '<%=path %>/tuijian/find.do?pageLast=' + page;

    }

    function change2() {
        var page2 = <%=i2 %>;
        window.location.href = '<%=path %>/tuijian/find.do?pageNext=' + page2;

    }

    function open1(ExhibitsId) {
        window.location.href = '<%=path %>/cangPin3/find.do?ExhibitsId=' + ExhibitsId;

    }
</script>

</body>
</html>