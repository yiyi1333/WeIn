<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/1
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 登录</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h2 class="logo-name">WeIn</h2>

        </div>
        <h3>欢迎登录WeIn</h3>
        <p>一套高质量的后台管理html模板</p>
        <form class="m-t" role="form" action="enterpriseAgencyLogin.action">
            <div class="form-group">
                <input type="text" name="enterpriseAgency.enterpriseAgencyAccount" class="form-control"
                       placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="enterpriseAgency.enterpriseAgencyPassword" class="form-control"
                       placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登录</button>

            <a href="#"><small>忘记密码?</small></a>
            <p class="text-muted text-center"><small>还没有账号?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">创建一个帐户</a>
        </form>
        <p class="m-t"><small>Copyright</strong> zzyyqxzyxwyxwsm &copy; 2021 </small></p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>

</body>

</html>
