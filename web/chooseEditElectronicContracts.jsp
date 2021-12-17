<%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/16
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.ShopManager" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.EnterpriseUser" %>
<%@ page import="cn.edu.zjut.po.ElectronicContracts" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
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
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="float-right">46 小时前</small>
                                        <strong>小明</strong> 评论了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right text-navy">5 小时前</small>
                                        <strong>小红</strong> 打电话给了 <strong>小黑</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a class="dropdown-item float-left" href="profile.html">
                                        <img alt="image" class="rounded-circle" src="img/profile.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="float-right">23 小时前</small>
                                        <strong>小黑</strong> 点赞了 <strong>小红</strong>. <br>
                                        <small class="text-muted">2017.10.06 7:58</small>
                                    </div>
                                </div>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html" class="dropdown-item">
                                        <i class="fa fa-envelope"></i> <strong>阅读所有消息</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 你有16条消息
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="profile.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 个新的关注者
                                        <span class="float-right text-muted small">12 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <a href="grid_options.html" class="dropdown-item">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> 重启服务器
                                        <span class="float-right text-muted small">4 分钟前</span>
                                    </div>
                                </a>
                            </li>
                            <li class="dropdown-divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html" class="dropdown-item">
                                        <strong>查看所有信息</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
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
                        <strong>企业人员</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox-title">
                        <h5>编辑电子合同</h5>
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
                            <%--<s:hidden name="loginuserEnterpriseId" value="loginuserEnterpriseId"></s:hidden>--%>
                            <div class="input-group">
                            </div>

                        </div>

                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>部门编号</th>
                                    <th>部门名称</th>
                                    <th>部门是否写入合同内</th>
                                </tr>
                                </thead>
                                <tbody>

                                <%
                                    List<EnterpriseDepartment> enterpriseDepartmentList = (List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList");
                                    for (EnterpriseDepartment enterpriseDepartment : enterpriseDepartmentList) {
                                %>
                                <tr>
                                    <td><%=enterpriseDepartment.getEnterpriseDepartmentId()%>
                                    </td>
                                    <td><%=enterpriseDepartment.getEnterpriseDepartmentName()%>
                                    </td>
                                    <% String key = "haveEnterpriseId";
                                        key += String.valueOf(enterpriseDepartment.getEnterpriseDepartmentId());
                                        if (session.getAttribute(key) == null) {
                                    %>
                                    <td>
                                        <form action="chooseDepartmentToElectronicContracts.action"
                                              style="display: inline" method="post">
                                            <input type="hidden"
                                                   value="<%=enterpriseDepartment.getEnterpriseDepartmentId()%>"
                                                   name="enterpriseDepartment.enterpriseDepartmentId">
                                            <input type="hidden"
                                                   value="<%=enterpriseDepartment.getEnterpriseDepartmentName()%>"
                                                   name="enterpriseDepartment.enterpriseDepartmentName">
                                            <button type="submit"
                                                    class="btn btn-primary btn-sm align-middle"
                                                    data-toggle="tooltip"
                                                    data-placement="top">选择
                                            </button>

                                        </form>

                                    </td>
                                    <%
                                    } else {
                                    %>
                                    <td>已经选入
                                    </td>
                                    <%
                                        }
                                    %>
                                </tr>
                                <%}%>
                                </tbody>

                                </tbody>
                                <tfoot>

                                </tfoot>
                            </table>

                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group row">
                            <a href="editElectronicContracts.jsp">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary btn-sm" type="submit">开始编辑合同</button>
                            </div>
                            </a>
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
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            $('.dataTables-example').DataTable({--%>
<%--                pageLength: 25,--%>
<%--                responsive: true,--%>
<%--                dom: '<"html5buttons"B>lTfgitp',--%>
<%--                buttons: [--%>
<%--                    {extend: 'copy'},--%>
<%--                    {extend: 'csv'},--%>
<%--                    {extend: 'excel', title: 'ExampleFile'},--%>
<%--                    {extend: 'pdf', title: 'ExampleFile'},--%>

<%--                    {--%>
<%--                        extend: 'print',--%>
<%--                        customize: function (win) {--%>
<%--                            $(win.document.body).addClass('white-bg');--%>
<%--                            $(win.document.body).css('font-size', '10px');--%>

<%--                            $(win.document.body).find('table')--%>
<%--                                .addClass('compact')--%>
<%--                                .css('font-size', 'inherit');--%>
<%--                        }--%>
<%--                    }--%>
<%--                ]--%>

<%--            });--%>

<%--        });--%>

<%--    </script>--%>
</body>
</html>