<%@ page import="cn.edu.zjut.po.Orders" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.OrderGood" %>
<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page import="cn.edu.zjut.po.ShopManager" %><%--
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

    <title>WeIn | 订单详情打印</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- FooTable -->
    <link href="css/plugins/footable/footable.core.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

</head>

<body class="white-bg">

<div class="wrapper wrapper-content p-xl">

    <div class="ibox-content p-xl">
        <div class="row">
            <div class="col-sm-6">
                <%
                    Orders orders=(Orders) session.getAttribute("order");
                %>
                <h5>发货信息</h5>
                <address>
                    <strong><%=orders.getWarehouseName()%></strong><br>
                    <%=orders.getWarehouseProvince()%><%=orders.getWarehouseCity()%><%=orders.getWarehouseArea()%><br>
                    <%=orders.getWarehouseDetailedAddress()%><br>
                    <abbr title="Phone">电话:</abbr> <%=orders.getWarehousePhone()%>
                </address>
            </div>

            <div class="col-sm-6 text-right">
                <h4>订单编号</h4>
                <h4 class="text-navy"><%=orders.getOrderId()%></h4>
                <span><strong>收货信息</strong></span>
                <address>
                    <strong><%=orders.getDeliveredName()%></strong><br>
                    <%=orders.getDeliverProvince()%><%=orders.getDeliverCity()%><%=orders.getDeliverArea()%><br>
                    <%=orders.getDeliveredDetailedAddress()%><br>
                    <abbr title="Phone">电话:</abbr> <%=orders.getDeliveredPhone()%>
                </address>
                <p>
                    <span><strong>下单时间:</strong><%=orders.getOrderDate()%>&nbsp;<%=orders.getOrderTime()%></span><br />
                    <span><strong>物流单号:</strong>
                                        <%=orders.getLogisticsSingle() == null ? "暂无" : orders.getLogisticsSingle()%>
                                    </span>
                </p>
            </div>
        </div>

        <div class="table-responsive m-t">
            <table class="table invoice-table">
                <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品图片</th>
                    <th>数量</th>
                    <th>单价</th>
                    <th>优惠价</th>
                    <th>实付总价</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsList");
                    List<OrderGood> orderGoods=(List<OrderGood>) session.getAttribute("orderGoods");
                    int sum=0;
                    int id=0;
                    for(int i=0;i<goodsList.size();i++){
                %>
                <tr>
                    <td>
                        <br>
                        <%=goodsList.get(i).getGoodsId()%>
                    </td>
                    <td>
                        <br>
                        <%=goodsList.get(i).getGoodsName()%>
                    </td>
                    <td>
                        <img style="width:70px;height: 70px" src="<%=goodsList.get(i).getGoodsImage()%>">

                    </td>
                    <td>
                        <br>
                        <%=orderGoods.get(i).getNum()%>
                    </td>
                    <td>
                        <br>
                        <%=goodsList.get(i).getGoodsPrice()%>元
                    </td>
                    <td>
                        <br>
                        <%=orderGoods.get(i).getSinglePieceActualPrice()%>元
                    </td>
                    <td>
                        <br>
                        <%=orderGoods.get(i).getSinglePieceActualPrice()*orderGoods.get(i).getNum()%>元
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div><!-- /table-responsive -->

        <table class="table invoice-total">
            <tbody>
            <tr>
                <td><strong>售价 :</strong></td>
                <td><%=orders.getGoodTotalPrices()%>元</td>
            </tr>
            <tr>
                <td><strong>优惠金额 :</strong></td>
                <td><%=orders.getDiscountAmount()%>元</td>
            </tr>
            <tr>
                <td><strong>实际支付 :</strong></td>
                <td><%=orders.getActuaLAmountPaid()%>元</td>
            </tr>
            </tbody>
        </table>
        <div class="well m-t">
            <strong>店铺管理员签字</strong><br>
            <%
                ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");
            %>
            <%=shopManager.getShopManagerName()%>
        </div>
    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>

<script type="text/javascript">
    window.print();
</script>

</body>

</html>

