<%@ page import="cn.edu.zjut.po.Orders" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.OrderGood" %><%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/21
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn</title>

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
                <h2>物流单号管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>填写物流单号</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>填写物流单号</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="addLogisticsSingle.action">
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
                                    <option value="待发货">待发货</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="consumerId">顾客Id</label>
                                <input type="text" id="consumerId" name="orders.consumerId" value="" placeholder="Customer" class="form-control">
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

                            <form action="addLogisticsSingleList.action">
                                <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="15">
                                    <thead>
                                    <tr>
                                        <th data-toggle="true">订单编号</th>
                                        <th data-hide="phone">下单时间</th>
                                        <th data-hide="all"></th>
                                        <th data-hide="all"></th>
                                        <th data-hide="all"></th>
                                        <th data-hide="phone">物流单号</th>
                                        <th class="text-right" data-sort-ignore="true">产品操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
                                        int id=0;
                                        for (int i = 0; i < ordersList.size(); i++) {
                                            if(id!= ordersList.get(i).getOrderId()){
                                                id = ordersList.get(i).getOrderId();
                                            }
                                            else{
                                                continue;
                                            }
                                    %>
                                    <tr>
                                        <td>
                                            <input style="width: 50px;" readonly = "readonly" value="<%=ordersList.get(i).getOrderId()%>" name="ordersList[<%=i%>].orderId"/>
                                        </td>
                                        <td>
                                            <%=ordersList.get(i).getOrderDate().toInstant().plusSeconds(28800).toString().split("T")[0]%>&nbsp;<%=ordersList.get(i).getOrderTime()%>
                                        </td>
                                        <td>
                                            <%
                                                for(OrderGood orderGood : ordersList.get(i).getOrderGoodList()){
                                            %>
                                            <br>
                                            <strong>商品编号：</strong><%=orderGood.getGoodId()%>&nbsp;<strong>商品件数：</strong><%=orderGood.getNum()%>
                                            <%}%>
                                        </td>
                                        <td>
                                            <strong>发货地址：</strong><%=ordersList.get(i).getWarehouseProvince()%> <%=ordersList.get(i).getWarehouseCity()%> <%=ordersList.get(i).getWarehouseArea()%><%=ordersList.get(i).getWarehouseDetailedAddress()%>
                                        </td>
                                        <td>
                                            <strong>收货地址：</strong><%=ordersList.get(i).getDeliverProvince()%> <%=ordersList.get(i).getDeliverCity()%><%=ordersList.get(i).getDeliverArea()%><%=ordersList.get(i).getWarehouseDetailedAddress()%>
                                        </td>
                                        <td>
                                            <div id="logisticsSingle<%=ordersList.get(i).getOrderId()%>Div" class="form-group">
                                                <input id="logisticsSingle<%=ordersList.get(i).getOrderId()%>" width="250px" placeholder="请输入订单号" name="ordersList[<%=i%>].logisticsSingle"/>
                                                <div id="logisticsSingle<%=ordersList.get(i).getOrderId()%>Result"></div>
                                            </div>
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
                                        <td>
                                            <input type="submit" class="btn btn-w-m btn-primary" value="提交">
                                        </td>
                                        <td colspan="10">
                                            <ul class="pagination float-right"></ul>
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </form>

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

<!-- FooTable -->
<script src="js/plugins/footable/footable.all.min.js"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function() {

        $('.footable').footable();

    });
    $(function () {
        <%
        for (int i = 0; i < ordersList.size(); i++) {
        %>
        $('#logisticsSingle<%=ordersList.get(i).getOrderId()%>').bind('input propertychange', function() {
            var r=/^\+?[1-9][0-9]*$/;
            if(r.test($(this).val()) && ((14 - $(this).val().length) ==0 )){
                document.getElementById("logisticsSingle<%=ordersList.get(i).getOrderId()%>Div").className = "form-group has-success";
                $('#logisticsSingle<%=ordersList.get(i).getOrderId()%>Result').html('输入正确');
            }
            else{
                document.getElementById("logisticsSingle<%=ordersList.get(i).getOrderId()%>Div").className = "form-group has-error";
                $('#logisticsSingle<%=ordersList.get(i).getOrderId()%>Result').html('请输入14位数字');
            }
        });
        <%}%>
    })
</script>
<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

</body>
</html>
