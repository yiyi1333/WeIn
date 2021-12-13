<%@ page import="cn.edu.zjut.po.WareHouseAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 电子支付订单</title>

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
                <h2>发货地址管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>电子商务</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>发货地址</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="col-form-label" for="wareHouseAddress_id">发货地址编号</label>
                            <input type="text" id="wareHouseAddress_id" name="wareHouseAddress_id" value="" placeholder="WareHouseAddress ID" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <br><br>
                        <button type="button" class="btn btn-w-m btn-primary">查询</button>
                    </div>
                    <div class="col-sm-2">
                        <br><br>
                        <button type="button" class="btn btn-w-m btn-success">新增</button>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="15">
                                <thead>
                                <tr>

                                    <th>发货地址编号</th>
                                    <th data-hide="phone">区县编号</th>
                                    <th data-hide="phone">详细地址</th>
                                    <th data-hide="phone">发货人电话</th>
                                    <th data-hide="phone">发货人姓名</th>
                                    <th class="text-right">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<WareHouseAddress> wareHouseAddressList = (List<WareHouseAddress>)session.getAttribute("wareHouseAddressList");
                                    for (int i = 0; i < wareHouseAddressList.size(); i++) {
                                %>
                                <tr>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getWarehouseId()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getDeliveredAeraId()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getWarehouseDetailedAddress()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getWarehousePhone()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getWarehouseName()%>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <button class="btn-white btn btn-xs">编辑</button>
                                            <button class="btn-white btn btn-xs">删除</button>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="7">
                                        <ul class="pagination float-right"></ul>
                                    </td>
                                </tr>
                                </tfoot>
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

</body>

</html>

