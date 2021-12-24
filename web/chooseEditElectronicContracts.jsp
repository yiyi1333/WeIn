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