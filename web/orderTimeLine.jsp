<%@ page import="cn.edu.zjut.po.OrderStatus" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/12/24
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn | 订单明细</title>

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
                <h2>订单明细</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>流水统计</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>订单明细</strong>
                    </li>
                </ol>
            </div>

        </div>
        <div class="wrapper wrapper-content">
            <div class="row animated fadeInRight">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-content" id="ibox-content">
                            <%
                                List<OrderStatus> orderStatusList=(List<OrderStatus>) session.getAttribute("orderStatusList");
                            %>
                            <span>订单编号为: <%=orderStatusList.get(0).getOrderId()%></span>
                            <%
                                for(int i=0;i<orderStatusList.size();i++){
                            %>
                            <div id="vertical-timeline" class="vertical-container dark-timeline center-orientation">
                                <div class="vertical-timeline-block">
                                    <%if(orderStatusList.get(i).getOrderStatusName().equals("待发货")){%>
                                    <div class="vertical-timeline-icon navy-bg">
                                        <i class="fa fa-briefcase"></i>
                                    </div>
                                    <%
                                    }else if(orderStatusList.get(i).getOrderStatusName().equals("待收货")){
                                    %>
                                    <div class="vertical-timeline-icon blue-bg">
                                        <i class="fa fa-file-text"></i>
                                    </div>
                                    <%
                                    }else if(orderStatusList.get(i).getOrderStatusName().equals("已收货")){
                                    %>
                                    <div class="vertical-timeline-icon lazur-bg">
                                        <i class="fa fa-coffee"></i>
                                    </div>
                                    <%
                                    }else if(orderStatusList.get(i).getOrderStatusName().equals("已完成")){
                                    %>
                                    <div class="vertical-timeline-icon yellow-bg">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <%
                                    }else if(orderStatusList.get(i).getOrderStatusName().equals("仅退款")||orderStatusList.get(i).getOrderStatusName().equals("退货退款")){
                                    %>
                                    <div class="vertical-timeline-icon lazur-bg">
                                        <i class="fa fa-user-md"></i>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <div class="vertical-timeline-content">
                                        <h2><%=orderStatusList.get(i).getOrderStatusName()%></h2>
                                        <%if(orderStatusList.get(i).getOrderStatusName().equals("仅退款")||orderStatusList.get(i).getOrderStatusName().equals("退货退款")){
                                        %>
                                        <a href="#" class="btn btn-sm btn-primary"> 更多信息</a>
                                        <%
                                            }
                                        %>
                                        <span class="vertical-date">
                                        <%=orderStatusList.get(i).getOrderStatusDate()%> <br/>
                                        <small><%=orderStatusList.get(i).getOrderStatusTime()%></small>
                                    </span>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
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
