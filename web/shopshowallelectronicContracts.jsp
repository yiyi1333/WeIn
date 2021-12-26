<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="cn.edu.zjut.po.ElectronicContracts" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
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

    <jsp:include page="shopNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="shopTopSidebar.jsp"/>
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
                            <h5>查看合同</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>

                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>

                        <%--            //模糊查询--%>
                        <div class="ibox-content m-b-sm border-bottom">
                            <form action="queryElectronicContractsLike.action">
                                <div class="row">

                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">合同编号</label>
                                            <input type="text"
                                                   name="electronicContractsId" value=""
                                                   placeholder="请输入..."
                                                   class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">企业方负责人编号</label>
                                            <input type="text"
                                                   name="enterpriseAgencyId"
                                                   value=""
                                                   placeholder="请输入..." class="form-control">
                                        </div>
                                    </div>

                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">商家编号</label>
                                            <input type="text"
                                                   name="shopId"
                                                   value=""
                                                   placeholder="请输入..." class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">商品编号</label>
                                            <input type="text"
                                                   name="goodsId"
                                                   value=""
                                                   placeholder="请输入..." class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">企业部门编号</label>
                                            <input type="text"
                                                   name="enterpriseDepartmentId"
                                                   value=""
                                                   placeholder="请输入..." class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-form-label">折扣</label>
                                            <input type="text"
                                                   name="discount"
                                                   value=""
                                                   placeholder="请输入..." class="form-control">
                                        </div>
                                    </div>

                                    <div class="col-sm-3">
                                        <button type="submit" class="btn btn-w-m btn-primary">查询</button>
                                    </div>

                                </div>


                            </form>
                        </div>


                        <div class="ibox-content">

                            <div class="table-responsive">
                                <table class="footable table table-stripped toggle-arrow-tiny"
                                       data-page-size="15">
                                    <thead>
                                    <tr>
                                        <th>合同编号</th>
                                        <th>企业方负责人编号</th>
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
                                        List<ElectronicContracts> list = (List<ElectronicContracts>) session.getAttribute("contractList");
                                    %>
                                    <tbody>
                                    <%
                                        for (int i = 0; i < list.size(); i++) {
                                    %>

                                    <tr class="<%=(i%2==0?"gradeX":"gradeC")%>">
                                        <td><%=list.get(i).getElectronicContractsId()%>
                                        </td>
                                        <td><%=list.get(i).getEnterpriseAgencyId()%>
                                        </td>
                                        <td><%=list.get(i).getEnterpriseId()%>
                                        </td>
                                        <td><%=list.get(i).getShopId()%>
                                        </td>
                                        <td><%=list.get(i).getStarttime().toInstant().plusSeconds(28800).toString().split("T")[0]%>
                                        </td>
                                        <td><%=list.get(i).getEndtime().toInstant().plusSeconds(28800).toString().split("T")[0]%>
                                        </td>
                                        <td><%=list.get(i).getGoodsId()%>
                                        </td>
                                        <td><%=list.get(i).getEnterpriseDepartmentId()%>
                                        </td>
                                        <td><%=list.get(i).getDiscount()%>
                                        </td>
                                        <td><%=(list.get(i).getState() == 0 ? "待审核" : (list.get(i).getState() == 1 ? "生效中" : "已失效"))%>
                                        </td>
                                        <td>
                                            <%
                                                int stateshow = list.get(i).getState();
                                                String ansshow;
                                                if(stateshow == 0) {
                                                    ansshow = "待企业管理员审核";
                                                }
                                                else if(stateshow == 1) {
                                                    ansshow = "待商家店铺审核";
                                                }
                                                else if(stateshow == 2) {
                                                    ansshow = "企业管理员驳回";
                                                }
                                                else if(stateshow == 4) {
                                                    ansshow = "商家驳回";
                                                }
                                                else if(stateshow == 10) {
                                                    ansshow = "有效合同";
                                                }
                                                else {
                                                    ansshow = "无效合同";
                                                }
                                            %>
                                            <%=ansshow%>
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
