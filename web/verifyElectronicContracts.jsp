<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/18
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="cn.edu.zjut.po.ElectronicContracts" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
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

    <jsp:include page="navigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>数据表格</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>表格</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>数据表格</strong>
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
                            <h5>基本数据表示例与响应插件</h5>
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
                                        <th>合同编号</th>
                                        <th>企业编号</th>
                                        <th>商家编号</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>商品编号</th>
                                        <th>企业部门编号</th>
                                        <th>折扣</th>
                                        <th>合同状态</th>
                                    </tr>
                                    </thead>
                                    <%
                                        if((List<ElectronicContracts>) session.getAttribute("verifyContracts") == null) {
                                            session.putValue("verifyContracts", new ArrayList<ElectronicContracts>());
                                        }
                                        List<ElectronicContracts> list = (List<ElectronicContracts>) session.getAttribute("verifyContracts");
                                    %>
                                    <tbody>
                                    <%
                                        for (int i = 0; i < list.size(); i++) {
                                    %>

                                    <tr class="<%=(i%2==0?"gradeX":"gradeC")%>">

                                        <td><%=list.get(i).getEnterpriseAgencyId()%>
                                        </td>
                                        <td><%=list.get(i).getEnterpriseId()%>
                                        </td>
                                        <td><%=list.get(i).getShopId()%>
                                        </td>
                                        <td><%=list.get(i).getStarttime()%>
                                        </td>
                                        <td><%=list.get(i).getEndtime()%>
                                        </td>
                                        <td><%=list.get(i).getGoodsId()%>
                                        </td>
                                        <td><%=list.get(i).getEnterpriseDepartmentId()%>
                                        </td>
                                        <td><%=list.get(i).getDiscount()%>
                                        </td>
                                        <td><%=(list.get(i).getState() == 0 ? "待审核" : (list.get(i).getState() == 1 ? "生效中" : "已失效"))%>
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                    <tfoot>

                                    </tfoot>

                                </table>
                            </div>
                            <s:form action="verifyElectronicContracts" method="post">
                                <div class="form-group row">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-primary btn-sm" type="submit">审核通过</button>
                                    </div>
                                </div>
                            </s:form>
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
