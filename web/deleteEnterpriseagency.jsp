<%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/14
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.ShopManager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 数据表格</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/dataTables/datatables.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>
<body>
<div id="wrapper">

    <jsp:include page="platformAdministratorNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i>
                    </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search"
                                   id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎来到xxx管理后台</span>
                    </li>


                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>企业人员</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="showenterpriseuser.action">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理企业人员</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>查询企业结构</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <%--                        后续模糊查询--%>
                        <%--                        <div class="search-form">--%>
                        <%--                            <form action="deleteEnterpriseagency" method="post">--%>
                        <%--                                <div class="input-group">--%>
                        <%--                                    <input type="text" placeholder="输入企业ID或者姓名或者账号进行模糊查询" name="enterpriseDepartment.enterpriseId" class="form-control input-lg">--%>
                        <%--                                    <div class="input-group-btn">--%>
                        <%--                                        <button class="btn btn-lg btn-primary" type="submit">--%>
                        <%--                                            搜索--%>
                        <%--                                        </button>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>

                        <%--                            </form>--%>
                        <%--                        </div>--%>
                        <div class="ibox-title">

                            <h5>删除企业用户</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="search-form">
                                <form action="deleteEnterpriseagency" method="post">
                                    <div class="input-group">
                                        <input type="text" placeholder="输入企业用户ID"
                                               name="enterpriseDepartment.enterpriseId" class="form-control input-lg">
                                        <div class="input-group-btn">
                                            <button class="btn btn-lg btn-primary" type="submit">
                                                删除
                                            </button>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                        <%--                        <div class="ibox-content">--%>
                        <%--                            <div class="table-responsive">--%>
                        <%--                                <table class="table table-striped table-bordered table-hover dataTables-example">--%>
                        <%--                                    <thead>--%>
                        <%--                                    <tr>--%>
                        <%--                                        <td>商家编号</td>--%>
                        <%--                                        <td>账号</td>--%>
                        <%--                                        <td>密码</td>--%>
                        <%--                                        <td>权限</td>--%>
                        <%--                                        <td>名字</td>--%>
                        <%--                                        <td>身份证号</td>--%>
                        <%--                                        <td>所属企业</td>--%>
                        <%--                                    </tr>--%>
                        <%--                                    </thead>--%>
                        <%--                                    <tbody>--%>

                        <%--                                    <s:form action="delete" method="post">--%>
                        <%--                                        <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>--%>
                        <%--                                        <s:submit value="删除"/>--%>
                        <%--                                    </s:form>--%>
                        <%--                                    <s:form action="delete" method="post">--%>

                        <%--                                    <s:iterator value="enterpriseagencyList">--%>
                        <%--                                        <tr>--%>
                        <%--                                            <s:hidden name="loginUser.customerId" value="%{#request.loginUser.customerId}"/>--%>
                        <%--                                                --%>
                        <%--                                   --%>
                        <%--                                            <td><s:property value="enterpriseAgencyId"/></td>--%>
                        <%--                                            <td><s:property value="enterpriseAgencyAccount"/></td>--%>
                        <%--                                            <td><s:property value="enterpriseAgencyPassword"/></td>--%>
                        <%--                                            <td><s:property value="enterpriseAgencyRight"/></td>--%>
                        <%--                                            <td><s:property value="enterpriseAgencyName"/></td>--%>
                        <%--                                            <td><s:property value="idCardNumber"/></td>--%>
                        <%--                                            <td><s:property value="enterpriseId"/></td>--%>
                        <%--                                        </tr>--%>
                        <%--                                    </s:iterator>--%>
                        <%--                                    </s:form>--%>
                        <%--                                    </tbody>--%>
                        <%--                                    <tfoot>--%>

                        <%--                                    </tfoot>--%>
                        <%--                                </table>--%>
                        <%--                            </div>--%>

                        <%--                        </div>--%>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="float-right">
                <strong>2.9.2 inspinia</strong>
            </div>
            <div>
                <strong>Copyright</strong> xxx &copy; 2020
            </div>
        </div>

    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<script src="js/plugins/dataTables/datatables.min.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap4.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {
        $('.dataTables-example').DataTable({
            pageLength: 25,
            responsive: true,
            dom: '<"html5buttons"B>lTfgitp',
            buttons: [
                {extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'pdf', title: 'ExampleFile'},

                {
                    extend: 'print',
                    customize: function (win) {
                        $(win.document.body).addClass('white-bg');
                        $(win.document.body).css('font-size', '10px');

                        $(win.document.body).find('table')
                            .addClass('compact')
                            .css('font-size', 'inherit');
                    }
                }
            ]

        });

    });

</script>
</body>
</html>