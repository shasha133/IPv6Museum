<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String error1=String.valueOf(request.getAttribute("error1"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<title>用户注册</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />



    <script src="../resourcesOne/bootStrap/jquery.min.js"></script>
    <script src="../resourcesOne/js/jquery.validate.min.js"></script>
    <script src="../resourcesOne/js/jquery.datepick.js"></script>
    <script src="http://www.jq22.com/jquery/1.7.2/jquery.min.js"></script>

    <link rel="stylesheet" href="../resourcesOne/bootStrap/bootstrap.min.css">
    <link rel="stylesheet" href="../resourcesOne/css/animate.min.css">
    <link rel="stylesheet" href="../resourcesOne/css/style.css">

    <script type="text/javascript">
    //验证确认密码 
    function checkpsd2(){ 
        if(testForm.userPassword.value!=testForm.password1.value) { 
                divpassword2.innerHTML='<font color=red>*您两次输入的密码不一样</font>';
        } else { 
            divpassword2.innerHTML='<font color=green>*输入正确</font>';
        }
    }
    </script>

    <style type="text/css">
        td { padding: 7px; }
        .labels { text-align: right; }
    </style>
    </head>

	<body>
       <div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form name="testForm" method="post" method="post" action="/front/register" class="fh5co-form animate-box" data-animate-effect="fadeIn" type="validate">
						<h2>用户注册</h2>
						
						<div class="form-group">
							<label for="userId" class="sr-only">邮箱</label>
							<input id="userId" type="text" name="userId" valType="MAIL"  msg="<font color=red>*</font>电子邮箱格式不正确" class="form-control" id="userId" placeholder="邮箱" autocomplete="off" onblur="userIdVerify(this.id,this.value);">
						</div>
						<div class="form-group">
							<label for="userName" class="sr-only">用户名</label>
							<input  type="text" name="userName" valType="required"   msg="<font color=red>*</font>用户名不能为空" class="form-control" id="userName" placeholder="用户名" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">密码</label>
							<input id="password" type="password" name="userPassword" valType="OTHER" regString="^[a-zA-Z]\w{5,17}$" msg="<font color=red>*</font>密码格式以字母开头，长度在6-18之间" class="form-control" id="password" placeholder="密码" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password1" class="sr-only">确认密码</label>
							<input id="password1" type="password" class="form-control" name="password1"  msg="<font color=red>*</font>密码不一致" onblur="checkpsd2();" placeholder="确认密码" autocomplete="off" required>
						    <span class="tips" id="divpassword2"></span>
						</div>
						<div class="form-group">
							<%
								if("1".equals(error1)){
							 %>
							 	<h2 style="color: red">帐号已经注册</h2>
							 <%
							      }
							  %>
						</div>
						<div class="form-group">
							<p><a href="/front/login">登录页面</a></p>
						</div>
						<div class="form-group">
							<input type="submit" onclick="return submitForm();" value="注册"  class="btn btn-primary">
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

