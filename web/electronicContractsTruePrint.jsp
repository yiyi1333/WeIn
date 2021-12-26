<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn | 打印</title>

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
    <jsp:include page="shopNavigation.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="shopTopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>合同管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>合同打印</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>提交审核合同打印</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <%
                        if((List<ElectronicContracts>) session.getAttribute("printlist") == null) {
                            session.putValue("printlist", new ArrayList<ElectronicContracts>());
                        }
                        List<ElectronicContracts> list = (List<ElectronicContracts>) session.getAttribute("printlist");
                    %>
                    <div class="ibox-content p-xl">
                        <div class="row">
                            <div class="col-sm-8">

                                <h4>合同开始时间</h4>
                                <address>
                                    <strong><%=list.get(0).getStarttime()%></strong><br>
                                </address>
                            </div>
                            <div class="col-sm-4">

                                <h4>合同结束时间</h4>
                                <address>
                                    <strong><%=list.get(0).getEndtime()%></strong><br>
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-4">

                                <h4>合作商家编号</h4>
                                <address>
                                    <strong><%=list.get(0).getShopId()%></strong><br>
                                </address>
                            </div>
                            <div class="col-sm-4">

                                <h4>企业用户负责人编号（审核对象）</h4>
                                <address>
                                    <strong><%=list.get(0).getEnterpriseAgencyId()%></strong><br>
                                </address>
                            </div>

                            <div class="col-sm-4">
                                <h4>商品ID</h4>
                                <address>
                                    <strong><%=list.get(0).getGoodsId()%></strong><br>
                                </address>
                            </div>
                        </div>

                        <div class="table-responsive m-t">
                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                <tr>
                                    <th>合同编号</th>
                                    <th>企业部门编号</th>
                                    <th>折扣</th>
                                    <th>合同状态</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%
                                    for (int i = 0; i < list.size(); i++) {
                                %>

                                <tr class="<%=(i%2==0?"gradeX":"gradeC")%>">
                                    <td><%=list.get(i).getGoodsId()%>
                                    </td>
                                    <td><%=list.get(i).getEnterpriseDepartmentId()%>
                                    </td>
                                    <td><%=list.get(i).getDiscount()%>
                                    </td>
                                    <td> <%
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
                            </table>

                        </div><!-- /table-responsive -->


                        <div class="well m-t">
                            <strong>起草人签字</strong><br>

                            <%=list.get(0).getEnterpriseAgencyId()%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="float-right">
                <strong>WeIn</strong>
            </div>
            <div>
                <strong>Copyright</strong> WeIn &copy; 2021
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
<!-- Page-Level Scripts -->
<script type="text/javascript">
    window.print();
</script>

</body>

</html>

