<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartmentDisplay" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.edu.zjut.po.EnterpriseAgency" %><%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/13
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 企业部门</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/dataTables/datatables.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- FooTable -->
    <link href="css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">


</head>

<body>

<div id="wrapper">

    <jsp:include page="EnterpriseAgencyNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>管理企业部门</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>管理企业部门</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">

            <%--            //模糊查询--%>
            <div class="ibox-content m-b-sm border-bottom">
                <form action="queryEnterpriseDepartment.action">
                    <div class="row">
                        <%
                            EnterpriseAgency enterpriseAgency = (EnterpriseAgency) session.getAttribute("enterpriseAgency");

                        %>
                        <input type="hidden" name="enterpriseDepartment.enterpriseId"
                               value="<%=enterpriseAgency.getEnterpriseId()%>">
                        <div class="col-sm-4">
                            <div class="form-group" id="enterpriseDepartmentEnterpriseDepartmentIdDiv">
                                <label class="col-form-label">企业部门编号</label>
                                <input type="text" id="enterpriseDepartmentEnterpriseDepartmentId"
                                       name="enterpriseDepartment.enterpriseDepartmentId" value="" placeholder="请输入..."
                                       class="form-control">

                            </div>

                        </div>
                        <div class="col-sm-4">
                            <div class="form-group" id="enterpriseDepartmentEnterpriseDepartmentNameDiv">
                                <label class="col-form-label"
                                >企业部门名字</label>
                                <input type="text"
                                       name="enterpriseDepartment.enterpriseDepartmentName"
                                       id="enterpriseDepartmentEnterpriseDepartmentName" value=""
                                       placeholder="请输入..." class="form-control">

                            </div>

                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label">企业部门隶属于</label>
                                <select class="form-control m-b"
                                        name="enterpriseDepartment.enterpriseDepartmentpre">
                                    <option value="<%=-1%>">
                                        <%="无限制"%>
                                    </option>
                                    <%
                                        List<EnterpriseDepartment> enterpriseDepartmentList = (List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList");
                                        if ((List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList") == null) {
                                            session.putValue("enterpriseDepartmentList", new ArrayList<EnterpriseDepartment>());
                                        }
                                        for (EnterpriseDepartment enterpriseDepartment1 : enterpriseDepartmentList) {

                                    %>
                                    <option value="<%=enterpriseDepartment1.getEnterpriseDepartmentId()%>">
                                        <%=enterpriseDepartment1.getEnterpriseDepartmentName()%>
                                    </option>
                                    <%
                                        }
                                    %>

                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div id="enterpriseDepartmentEnterpriseDepartmentIdResult"
                                 style="margin-left: 100px;"></div>
                        </div>
                        <div class="col-sm-4">
                            <div id="enterpriseDepartmentEnterpriseDepartmentNameResult"
                                 style="margin-left: 100px;"></div>
                        </div>
                        <div class="col-sm-4">
                            <button type="submit" class="btn btn-w-m btn-primary">查询</button>
                        </div>

                    </div>


                </form>
            </div>


            <%--  //展示--%>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny"
                                   data-page-size="15">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>部门编号</th>
                                    <th>部门名称</th>
                                    <th>部门隶属于</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%

                                    List<EnterpriseDepartmentDisplay> departmentList = (List<EnterpriseDepartmentDisplay>) request.getSession().getAttribute("enterpriseDepartments");
                                    if ((List<EnterpriseDepartmentDisplay>) session.getAttribute("enterpriseDepartments") == null) {
                                        session.putValue("enterpriseDepartments", new ArrayList<EnterpriseDepartmentDisplay>());
                                    }
                                    for (int i = 0; i < departmentList.size(); i++) {
                                %>

                                <tr>

                                    <td>
                                        <input type="checkbox" class="i-checks"
                                               value="<%=departmentList.get(i).getEnterpriseDepartmentId()%>"
                                               name="input[]">
                                    </td>
                                    <td><%=departmentList.get(i).getEnterpriseDepartmentId()%>
                                    </td>
                                    <td><%=departmentList.get(i).getEnterpriseDepartmentName()%>
                                    </td>
                                    <td><%=departmentList.get(i).getFaDepartment()%>
                                    </td>
                                    <td class="text-middle">
                                        <div class="btn-group">
                                            <a href="selectEnterpriseDepartmentById?EnterpriseDepartmentId=<%=departmentList.get(i).getEnterpriseDepartmentId()%>">
                                                <button class="btn-white btn btn-xs">编辑</button>
                                            </a>
                                            <a href="deleteEnterpriseDepartment?EnterpriseDepartmentId=<%=departmentList.get(i).getEnterpriseDepartmentId()%>">
                                                <button class="btn-white btn btn-xs">删除</button>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td>
                                        <button type="button" class="btn btn-w-m btn-primary"
                                                onclick="deleteEnterpriseDepartment()">批量删除
                                        </button>
                                    </td>
                                    <td colspan="10">
                                        <ul class="pagination float-right"></ul>
                                    </td>
                                </tr>
                                <tfoot>
                            </table>

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

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- FooTable -->
<script src="js/plugins/footable/footable.all.min.js"></script>

<%--省市区三级联动--%>
<script type="text/javascript" src="js/area.js"></script>

<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function () {

        $('.footable').footable();

        $('#date_added').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

        $('#date_modified').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

    });

</script>

<script>

    // 确认删除
    function deleteEnterpriseDepartment() {
        var result = "";
        var count = 0;
        $(".i-checks").each(function () {
            if ($(this).is(':checked')) {
                result += $(this).val() + ",";
                count++;
            } else {
            }
        });
        if (!confirm("确定删除这" + count + "企业部门?")) {
            return;
        }
        window.location.href = "deleteEnterpriseDepartmentByIds?tag=" + result;
    }

    $('#enterpriseDepartmentEnterpriseDepartmentId').bind('input propertychange', function () {
        if ((11 - $(this).val().length) >= 4) {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentIdDiv").className = "form-group row has-success";
            $('#enterpriseDepartmentEnterpriseDepartmentIdResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
        } else if ((11 - $(this).val().length) >= 0) {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentIdDiv").className = "form-group row has-warning";
            $('#enterpriseDepartmentEnterpriseDepartmentIdResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
        } else {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentIdDiv").className = "form-group row has-error";
            $('#enterpriseDepartmentEnterpriseDepartmentIdResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
        }
    });
    $('#enterpriseDepartmentEnterpriseDepartmentName').bind('input propertychange', function () {
        if ((11 - $(this).val().length) >= 4) {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentNameDiv").className = "form-group row has-success";
            $('#enterpriseDepartmentEnterpriseDepartmentNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
        } else if ((11 - $(this).val().length) >= 0) {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentNameDiv").className = "form-group row has-warning";
            $('#enterpriseDepartmentEnterpriseDepartmentNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
        } else {
            document.getElementById("enterpriseDepartmentEnterpriseDepartmentNameDiv").className = "form-group row has-error";
            $('#enterpriseDepartmentEnterpriseDepartmentNameResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
        }
    });

</script>

</body>

</html>

