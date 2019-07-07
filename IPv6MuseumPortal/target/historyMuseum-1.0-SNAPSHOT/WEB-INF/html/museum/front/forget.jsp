<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String error = String.valueOf(request.getAttribute("error"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>忘记密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>


    <script src="../resourcesOne/bootStrap/jquery.min.js"></script>
    <script src="../resourcesOne/js/jquery.validate.min.js"></script>
    <script src="../resourcesOne/js/jquery.datepick.js"></script>
    <script src="http://www.jq22.com/jquery/1.7.2/jquery.min.js"></script>

    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link rel="stylesheet" href="../resourcesOne/css/animate.min.css">
    <link rel="stylesheet" href="../resourcesOne/css/style.css">

    <script language="javascript" type="text/javascript">
        $(function () {
            $("#testForm").validate(
                {
                    rules: {
                        userId: {
                            required: true,
                            email: true
                        }

                    },
                    messages: {
                        userId: {
                            required: "邮箱必须填写~~~",
                            email: "请输入正确的邮箱格式"
                        }
                    }

                }
            );
        });
    </script>
    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <!-- Start Sign In Form -->
            <form id="testForm" method="post" action="/front/forget" class="fh5co-form animate-box" data-animate-effect="fadeIn">
                <h2>忘记密码</h2>

                <div class="form-group">
                    <label for="userId" class="sr-only">注册邮箱</label>
                    <input type="text" name="userId" class="form-control" id="userId" placeholder="注册邮箱"
                           autocomplete="off">
                </div>
                <%
                    if ("1".equals(error)) {
                %>
                <h2 style="color: red">帐号不存在</h2>
                <%
                    }
                %>
                <div class="form-group">
                    <p><a href="/front/login">登录页面</a></p>
                </div>
                <div class="form-group">
                    <input type="submit" onclick="return submitForm();" value="发送认证邮件" class="btn btn-primary">
                </div>
            </form>
            <!-- END Sign In Form -->
        </div>
    </div>
</div>
</body>
</html>

