<%@ page import="cn.edu.zjut.po.Orders" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/12/3
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
    <jsp:include page="navigation.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="topSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>订单管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>电子商务</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>电子商务订单</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="col-form-label" for="order_id">订单编号</label>
                            <input type="text" id="order_id" name="order_id" value="" placeholder="Order ID" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="col-form-label" for="status">订单状态</label>
                            <input type="text" id="status" name="status" value="" placeholder="Status" class="form-control">
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="col-form-label" for="customer">顾客</label>
                            <input type="text" id="customer" name="customer" value="" placeholder="Customer" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label class="col-form-label" for="date_added">下单日期</label>
                            <div class="input-group date">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="date_added" type="text" class="form-control" value="03/04/2014">
                            </div>
                        </div>
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

                                    <th>订单编号</th>
                                    <th data-hide="phone">顾客Id</th>
                                    <th data-hide="phone">下单时间</th>
                                    <th data-hide="phone">实际支付金额</th>
                                    <th data-hide="phone">优惠金额</th>
                                    <th data-hide="phone">商品数量</th>
                                    <!--                                    <th data-hide="phone,tablet" >修改日期</th>-->
                                    <th data-hide="phone">物流单号</th>
                                    <th data-hide="phone">状态</th>
                                    <th class="text-right">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
                                    for (int i = 0; i < ordersList.size(); i++) {
                                %>
                                <tr>
                                    <td>
                                        <%=ordersList.get(i).getOrderId()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getConsumerId()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getOrderTime()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getActualAmountPaid()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getDiscountAmount()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getGoodsnumber()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getLogisticsSingle() == null ? "暂无" : ordersList.get(i).getLogisticsSingle()%>
                                    </td>
                                    <td>
                                        <span class="label label-primary"><%=ordersList.get(i).getOrderStatus()%></span>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <button class="btn-white btn btn-xs">详情</button>
                                            <button class="btn-white btn btn-xs">编辑</button>
                                            <button class="btn-white btn btn-xs">取消</button>
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

