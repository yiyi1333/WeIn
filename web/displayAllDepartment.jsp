<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartmentDisplay" %><%--
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
    <s:head/>
</head>

<body>

<div id="wrapper">

    <jsp:include page="EnterpriseAgencyNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>企业部门</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>企业部门</strong>
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
                            <h5>企业组织架构</h5>

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
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                        <th>部门隶属于</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<EnterpriseDepartmentDisplay> departmentList = (List<EnterpriseDepartmentDisplay>) request.getSession().getAttribute("enterpriseDepartments");
                                        for (int i = 0; i < departmentList.size(); i++) {
                                    %>
                                    <tr class="<%=(i%2==0?"gradeX":"gradeC")%>">
                                        <td><%=departmentList.get(i).getEnterpriseDepartmentId()%>
                                        </td>
                                        <td><%=departmentList.get(i).getEnterpriseDepartmentName()%>
                                        </td>
                                        <td><%=departmentList.get(i).getFaDepartment()%>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>部门编号</th>
                                        <th>部门名称</th>
                                        <th>部门隶属于</th>
                                    </tr>
                                    </tfoot>
                                </table>
                                <div class="text-left">
                                    <a class="btn btn-primary" data-toggle="modal" href="#modal-form">
                                        删除企业部门
                                    </a>
                                    <s:actionerror/>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="ibox-tools">
            <a class="collapse-link">
                <i class="fa fa-chevron-up"></i>
            </a>
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-wrench"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a class="dropdown-item" href="#">选项 1</a>
                </li>
                <li><a class="dropdown-item" href="#">选项 2</a>
                </li>
            </ul>
            <a class="close-link">
                <i class="fa fa-times"></i>
            </a>
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

<div aria-hidden="true" class="modal fade" id="modal-form">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <h3 class="m-t-none m-b">删除部门</h3>
                <p>删除部门将不可撤销。</p>

                <form role="form" action="deleteDepartment.action">
                    <div class="form-group"><label>部门名称</label>
                        <select class="form-control" type="email" name="deleteDepartmentId">
                            <%
                                for (EnterpriseDepartmentDisplay enterpriseDepartmentDisplay : departmentList) {
                                    if (enterpriseDepartmentDisplay.getEnterpriseDepartmentName().equals("企业本身"))
                                        continue;
                            %>
                            <option value="<%=enterpriseDepartmentDisplay.getEnterpriseDepartmentId()%>"><%=enterpriseDepartmentDisplay.getEnterpriseDepartmentName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div>
                        <button class="btn btn-sm btn-primary float-right m-t-n-xs"
                                type="submit"><strong>确认删除</strong></button>
                    </div>
                </form>
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
<script src="js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>

</html>
