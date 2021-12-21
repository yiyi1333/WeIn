<%@ page import="cn.edu.zjut.po.Consumer" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.EnterpriseUser" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartmentDisplay" %>
<%@ taglib prefix="s" uri="/struts-tags" %><%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/3
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
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

    <jsp:include page="EnterpriseAgencyNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>

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
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>企业人员名单</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#" class="dropdown-item">选项 1</a>
                                    </li>
                                    <li><a href="#" class="dropdown-item">选项 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<EnterpriseDepartmentDisplay> enterpriseDepartmentDisplays = (List<EnterpriseDepartmentDisplay>) session.getAttribute("displayEnterpriseDepartments");
                                        List<EnterpriseUser> enterpriseUserList = (List<EnterpriseUser>) session.getAttribute("enterpriseUserlist");
                                        for (EnterpriseUser enterpriseUser : enterpriseUserList) {
                                    %>
                                    <tr>
                                        <td><%=enterpriseUser.getConsumerId()%>
                                        </td>
                                        <td><%=enterpriseUser.getName()%>
                                        </td>
                                        <td><%=enterpriseUser.getEnterpriseDepartmentId()%>
                                        </td>
                                        <td>

                                            <form action="deleteConsumer.action" style="display: inline">
                                                <input type="hidden" value="<%=enterpriseUser.getConsumerId()%>"
                                                       name="enterpriseUser.consumerId">
                                                <button type="submit" class="btn btn-white btn-sm float-right"
                                                        data-toggle="tooltip"
                                                        data-placement="top">删除
                                                </button>
                                            </form>

                                            <form action="updateUserDepartment.action" style="display: inline">
                                                <input type="hidden" value="<%=enterpriseUser.getConsumerId()%>"
                                                       name="enterpriseUser.consumerId">
                                                <select class="btn btn-white dropdown-toggle"
                                                        name="enterpriseDepartment.enterpriseDepartmentId">
                                                    <%
                                                        for (EnterpriseDepartmentDisplay display : enterpriseDepartmentDisplays) {
                                                    %>
                                                    <option value="<%=display.getEnterpriseDepartmentId()%>" <%=(display.getEnterpriseDepartmentId() == enterpriseUser.getEnterpriseDepartmentId() ? "selected='selected'" : "")%>>
                                                        <%=display.getEnterpriseDepartmentName()%>
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                <button type="submit"
                                                        class="btn btn-sm btn-primary float-right" data-toggle="tooltip"
                                                        data-placement="top">修改
                                                </button>
                                            </form>

                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>编号</th>
                                        <th>姓名</th>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>

                        </div>
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
<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('.dataTables-example').DataTable({--%>
<%--            pageLength: 25,--%>
<%--            responsive: true,--%>
<%--            dom: '<"html5buttons"B>lTfgitp',--%>
<%--            buttons: [--%>
<%--                {extend: 'copy'},--%>
<%--                {extend: 'csv'},--%>
<%--                {extend: 'excel', title: 'ExampleFile'},--%>
<%--                {extend: 'pdf', title: 'ExampleFile'},--%>

<%--                {--%>
<%--                    extend: 'print',--%>
<%--                    customize: function (win) {--%>
<%--                        $(win.document.body).addClass('white-bg');--%>
<%--                        $(win.document.body).css('font-size', '10px');--%>

<%--                        $(win.document.body).find('table')--%>
<%--                            .addClass('compact')--%>
<%--                            .css('font-size', 'inherit');--%>
<%--                    }--%>
<%--                }--%>
<%--            ]--%>

<%--        });--%>

<%--    });--%>

<%--</script>--%>

</body>
</html>

