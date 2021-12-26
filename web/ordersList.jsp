<%@ page import="cn.edu.zjut.po.Orders" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.OrderGood" %><%--
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

    <title>xxx | 订单详情</title>

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
                <h2>订单管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>订单管理</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>查看订单信息</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="selectOrders.action">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">订单编号</label>
                                <input type="text" id="orderId" name="orders.orderId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="orderStatus">订单状态</label>
                                <select id="orderStatus" name="orders.orderStatus"  class="form-control">
                                    <option value="">全部</option>
                                    <option value="待发货">待发货</option>
                                    <option value="待收货">待收货</option>
                                    <option value="已收货">已收货</option>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="已收货">仅退款</option>
                                    <option value="已收货">退换货</option>
                                    <option value="退货退款">退货退款</option>
                                    <option value="已完成">已完成</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="consumerId">顾客Id</label>
                                <input type="text" id="consumerId" name="orders.consumerId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="date_added">下单日期</label>
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="date_added" name="orders.orderDate" type="date" class="form-control" value="03/04/2014">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <br><br>
                            <button type="submit" class="btn btn-w-m btn-primary">查询</button>
                        </div>

                    </div>
                </form>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox">
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="15">
                                <thead>
                                <tr>

                                    <th data-toggle="true">订单编号</th>
                                    <th data-hide="phone">顾客Id</th>
                                    <th data-hide="phone">下单时间</th>
                                    <th data-hide="phone">实际支付金额</th>
                                    <th data-hide="phone">商品数量</th>
                                    <th data-hide="all">发货信息</th>
                                    <th data-hide="all">收货信息</th>
                                    <th data-hide="phone">物流单号</th>
                                    <th data-hide="phone">状态</th>
                                    <th class="text-right">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
                                    int sum=0;
                                    int id=0;
                                    for (int i = 0; i < ordersList.size(); i++) {
                                        if(id!= ordersList.get(i).getOrderId()){
                                            id = ordersList.get(i).getOrderId();
                                        }
                                        else{
                                            continue;
                                        }
                                        sum = 0;
                                        for(OrderGood orderGood: ordersList.get(i).getOrderGoodList()){
                                            sum+=orderGood.getNum();
                                        }
                                %>
                                <tr>
                                    <td>
                                        <%=ordersList.get(i).getOrderId()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getConsumerId()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getOrderDate().toInstant().plusSeconds(28800).toString().split("T")[0]%>&nbsp;<%=ordersList.get(i).getOrderTime()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getActuaLAmountPaid()%>元
                                    </td>
                                    <td>
                                        <%=sum%>
                                    </td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;<strong>姓名：</strong><%=ordersList.get(i).getWarehouseName()%>
                                        &nbsp;&nbsp;&nbsp;<strong>电话：</strong><%=ordersList.get(i).getWarehousePhone()%>
                                        &nbsp;&nbsp;&nbsp;<strong>地址：</strong><%=ordersList.get(i).getWarehouseProvince()%> <%=ordersList.get(i).getWarehouseCity()%> <%=ordersList.get(i).getWarehouseArea()%><%=ordersList.get(i).getWarehouseDetailedAddress()%>
                                    </td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;<strong>姓名：</strong><%=ordersList.get(i).getDeliveredName()%>
                                        &nbsp;&nbsp;&nbsp;<strong>电话：</strong><%=ordersList.get(i).getDeliveredPhone()%>
                                        &nbsp;&nbsp;&nbsp;<strong>地址：</strong><%=ordersList.get(i).getDeliverProvince()%> <%=ordersList.get(i).getDeliverCity()%><%=ordersList.get(i).getDeliverArea()%><%=ordersList.get(i).getWarehouseDetailedAddress()%>
                                    </td>
                                    <td>
                                        <%=ordersList.get(i).getLogisticsSingle() == null ? "暂无" : ordersList.get(i).getLogisticsSingle()%>
                                    </td>
                                    <td>
                                        <%
                                            if(ordersList.get(i).getOrderStatus().equals("已完成")){
                                        %>
                                        <span class="label label-primary"><%=ordersList.get(i).getOrderStatus()%></span>
                                        <%
                                        }else if(ordersList.get(i).getOrderStatus().equals("待收货")){
                                        %>
                                        <span class="label label-success"><%=ordersList.get(i).getOrderStatus()%></span>
                                        <%
                                        }else if(ordersList.get(i).getOrderStatus().equals("待发货")){
                                        %>
                                        <span class="label label-warning"><%=ordersList.get(i).getOrderStatus()%></span>
                                        <%
                                        }else if(ordersList.get(i).getOrderStatus().equals("待付款")){
                                        %>
                                        <span class="label label-danger"><%=ordersList.get(i).getOrderStatus()%></span>
                                        <%
                                        }else{
                                        %>
                                        <span class="label label-danger"><%=ordersList.get(i).getOrderStatus()%></span>
                                        <%}%>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <a style="color: #999999" href="selectOrderById?orderId=<%=ordersList.get(i).getOrderId()%>"><button class="btn-white btn btn-xs">详情</button></a>
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
<script>
    $(document).ready(function() {

        $('.footable').footable();

    });

</script>

</body>

</html>

