<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn | 登录</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
<%--        <div>--%>
<%--            <h1>WeIn</h1>--%>
<%--        </div>--%>
        <h2>欢迎登录WeIn</h2>
        <p>一套功能完备的集团内购系统</p>
        <form class="m-t" role="form" action="login.action">
            <div class="input-group m-b">
                <input type="text" name="user.account" placeholder="用户名"
                       class="form-control">
                <div class="input-group-prepend">
                    <select class="btn btn-white dropdown-toggle" name="user.authority">
                        <option value="0">店铺用户</option>
                        <option value="1">企业管理员</option>
                        <option value="2">平台管理人员</option>
                    </select>
                </div>
            </div>
            <div class="input-group m-b">
                <input type="password" name="user.password" placeholder="密码"
                       class="form-control">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
            <a href="#"><small>忘记密码?</small></a>
            <p class="text-muted text-center"><small>还没有账号?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">创建一个帐户</a>
        </form>
        <p class="m-t"><small>Copyright WeIn &copy; 2021 </small></p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>

</body>

</html>
