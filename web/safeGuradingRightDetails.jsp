<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/24
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/21
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>订单详情</title>

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
                        <a>查看维权信息</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>维权详情</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="changeSafeGuardingRightsProgress.action">
                    <%
                        SafeGuardingRights safeGuardingRights=(SafeGuardingRights) session.getAttribute("safeGuardingRights");
                        Orders orders = safeGuardingRights.getOrders();
                        Goods goods = safeGuardingRights.getGoods();
                        List<SafeGuardingRightsProgress> safeGuardingRightsProgressList = safeGuardingRights.getSafeGuardingRightsProgresslist();
                    %>
                    <span>维权号为<%=safeGuardingRights.getSafeGuardingRightsId()%>的维权的详细信息:</span>
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">收货人姓名：</label>
                                <input type="text" id="orderId" name="orders.orderId" value="<%=orders.getDeliveredName()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">收货人电话号码：</label>
                                <input type="text"  name="orders.orderId" value="<%=orders.getDeliveredPhone()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-5">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">收货地址：</label>
                                <input type="text"  name="orders.orderId" value="<%=orders.getDeliverProvince()%> <%=orders.getDeliverCity()%><%=orders.getDeliverArea()%><%=orders.getDeliveredDetailedAddress()%>" disabled class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">发货人姓名：</label>
                                <input type="text"  name="orders.orderId" value="<%=orders.getWarehouseName()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">发货人电话号码：</label>
                                <input type="text"  name="orders.orderId" value="<%=orders.getWarehousePhone()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-5">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">发货地址：</label>
                                <input type="text"  name="orders.orderId" value="<%=orders.getWarehouseProvince()%> <%=orders.getWarehouseCity()%><%=orders.getWarehouseArea()%><%=orders.getWarehouseDetailedAddress()%>" disabled class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">申请维权件数</label>
                                <input type="text"  name="orders.orderId" value="<%=safeGuardingRights.getSafeGuardingRightsNum()%>份" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">申请维权类型：</label>
                                <input type="text"  name="orders.orderId" value="<%=safeGuardingRights.getSafeGuardingRightsType()%>" disabled class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">修改状态：</label>
                                <select id="safeGuardingRightsProgress" name="safeGuardingRights.safeGuardingRightsProgress" class="form-control">
                                    <%
                                        if(safeGuardingRights.getSafeGuardingRightsProgress().equals("商家处理中")){
                                    %>
                                    <option value="退换货">退换货</option>
                                    <option value="仅退款">仅退款</option>
                                    <option value="退货退款">退货退款</option>
                                    <%}else if(safeGuardingRights.getSafeGuardingRightsProgress().equals("退换货")){%>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="仅退款">仅退款</option>
                                    <option value="退货退款">退货退款</option>
                                    <%}else if(safeGuardingRights.getSafeGuardingRightsProgress().equals("仅退款")){%>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="退换货">退换货</option>
                                    <option value="退货退款">退货退款</option>
                                    <%}else if(safeGuardingRights.getSafeGuardingRightsProgress().equals("退货退款")){%>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="退换货">退换货</option>
                                    <option value="仅退款">仅退款</option>
                                    <%}else if(safeGuardingRights.getSafeGuardingRightsProgress().equals("申请中")){%>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="退换货">退换货</option>
                                    <option value="仅退款">仅退款</option>
                                    <option value="退货退款">退货退款</option>
                                    <%}else{%>
                                    <option value="已完成提交平台">已完成提交平台</option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <br><br>
                                <button type="submit" class="btn btn-w-m btn-primary">提交</button>
                            </div>
                        </div>
                    </div>

                </form>
            </div>

            <div class="row animated fadeInRight">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="text-center  p-md" style="float: left">
                            <span>个性化选择: </span>
                            <a href="#" class="btn btn-xs btn-primary" id="leftVersion">类型转换 </a>
                        </div>
                        <div class="ibox-content" id="ibox-content">
                            <div id="vertical-timeline" class="vertical-container dark-timeline center-orientation">
                                <%
                                    for(SafeGuardingRightsProgress safeGuardingRightsProgress:safeGuardingRightsProgressList){
                                        if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("申请中")){
                                %>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon blue-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>顾客：<%=orders.getConsumerId()%></h2>
                                        <p>购买商品：<%=goods.getGoodsName()%></p>
                                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=goods.getGoodsImage()%>" alt="图片无法显示" style="height: 80px"></p>
                                    </div>
                                </div>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon blue-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>顾客：<%=orders.getConsumerId()%></h2>
                                        <p>维权理由：<%=safeGuardingRights.getSafeGuardingRightsDetails()%></p>
                                        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=safeGuardingRights.getSafeGuardingRightsImage()%>" alt="用户没有上传图片" style="height: 80px"></p>
                                    </div>
                                </div>
                                <%}else if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("商家处理中")){%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon yellow-bg">
                                        <i class="fa fa-phone"></i>
                                    </div>

                                    <div class="vertical-timeline-content">
                                        <h2>商家</h2>
                                        <p>处理协商中</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}else if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("仅退款")){%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>商家</h2>
                                        <p>同意退款</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}else if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("退换货")){%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>商家</h2>
                                        <p>同意退货</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}else if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("退货退款")){%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>商家</h2>
                                        <p>同意退货退款</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}else if(safeGuardingRightsProgress.getSafeGuardingRightsProgressStatus().equals("已完成")){%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>平台</h2>
                                        <p>已完成</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}else{%>
                                <div class="vertical-timeline-block">
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <div class="vertical-timeline-content">
                                        <h2>平台</h2>
                                        <p>申请平台处理</p>
                                        <span class="vertical-date">
                                            <%=safeGuardingRightsProgress.getSafeGuardingRightsProgressDate().toInstant().plusSeconds(28800).toString().split("T")[0]%> <br/>
                                            <small><%=safeGuardingRightsProgress.getSafeGuardingRightsProgressTime()%></small>
                                        </span>
                                    </div>
                                </div>
                                <%}}%>
                            </div>

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

<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- Peity -->
<script src="js/demo/peity-demo.js"></script>


<script>
    $(document).ready(function(){

        // Local script for demo purpose only
        $('#lightVersion').click(function(event) {
            event.preventDefault()
            $('#ibox-content').removeClass('ibox-content');
            $('#vertical-timeline').removeClass('dark-timeline');
            $('#vertical-timeline').addClass('light-timeline');
        });

        $('#darkVersion').click(function(event) {
            event.preventDefault()
            $('#ibox-content').addClass('ibox-content');
            $('#vertical-timeline').removeClass('light-timeline');
            $('#vertical-timeline').addClass('dark-timeline');
        });

        $('#leftVersion').click(function(event) {
            event.preventDefault()
            $('#vertical-timeline').toggleClass('center-orientation');
        });


    });
</script>

</body>

</html>


