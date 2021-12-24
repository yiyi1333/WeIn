<%@ page import="cn.edu.zjut.po.OrderGood" %>
<%@ page import="cn.edu.zjut.po.Orders" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/12/23
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn | 流水统计</title>

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
                <h2>流水统计</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>流水统计</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>流水统计</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="getFundFlowByDate.action" >
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="types">统计类型</label>
                                <select id="types"  class="form-control">
                                    <option value="年">年</option>
                                    <option value="月">月</option>
                                    <option value="日">日</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2" id="yearDiv" >
                            <div class="form-group">
                                <label class="col-form-label" for="year">年</label>
                                <select id="year"  name="year" class="form-control">
                                    <option value="全部">全部</option>
                                    <option value="2019">2019</option>
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-3" id="dateDiv" style="display: none">
                            <div class="form-group">
                                <label class="col-form-label" >天</label>
                                <div class="input-group date">
                                    <input id="date"  name="date" type="date" class="form-control" value="">
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3" id="monthDiv" style="display: none">
                            <div class="form-group">
                                <label class="col-form-label" >月</label>
                                <div class="input-group date">
                                    <input id="month" name="month" type="month" class="form-control" value="">
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-2">
                            <br>
                            <br>
                            <button type="submit" class="btn btn-w-m btn-primary" onclick="check()">查询</button>
                        </div>

                    </div>
                </form>

            </div>
            <div class="row">
                <%
                    List<Orders> ordersList=(List<Orders>) session.getAttribute("ordersList");
                    List<Double> earningList=(List<Double>) session.getAttribute("earningList");
                    List<String> endTimeList=(List<String>) session.getAttribute("endTimeList");
                    List<Integer> goodsNumList=(List<Integer>) session.getAttribute("goodsNumList");
                    int sum=0;
                    double saleSum=0;

                    for(int i=0;i<earningList.size();i++)
                    {
                        saleSum+=earningList.get(i);
                    }
                    for(int i=0;i<goodsNumList.size();i++)
                    {
                        sum+=goodsNumList.get(i);
                    }

                %>
                <div class="col-lg-4">
                    <div class="ibox ">
                        <div class="ibox-title">

                            <h5>销售数量</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=sum%></h1> <span class="label label-primary float-right">件</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox ">
                        <div class="ibox-title">

                            <h5>订单总数</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=ordersList.size()%></h1> <span class="label label-info float-right">单</span>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>销售额</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=saleSum%></h1> <span class="label label-warning float-right">元</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="ibox-content">

                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover dataTables-example" >
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>下单时间</th>
                            <th>完成时间</th>
                            <th>商品数量</th>
                            <th>收入</th>
                            <th>状态</th>
                            <th class="text-right">明细</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for(int i=0;i<ordersList.size();i++){
                        %>
                        <tr class="gradeX">
                            <td><%=ordersList.get(i).getOrderId()%></td>
                            <td><%=ordersList.get(i).getOrderDate()%>&nbsp;<%=ordersList.get(i).getOrderTime()%></td>
                            <td><%=endTimeList.get(i)%></td>
                            <td class="center"><%=goodsNumList.get(i)%></td>
                            <td class="center">+<%=earningList.get(i)%>元</td>
                            <td><%=ordersList.get(i).getOrderStatus()%></td>
                            <td class="text-right">
                                <div class="btn-group">
                                    <a style="color: #999999" href="getOrderStatusById?orderId=<%=ordersList.get(i).getOrderId()%>"><button class="btn-white btn btn-xs">查看</button></a>
                                </div>
                            </td>
                        </tr>
                        <%
                            }
                        %>

                        </tbody>
                        <tfoot>
                        <tr>
                            <th>订单编号</th>
                            <th>下单时间</th>
                            <th>完成时间</th>
                            <th>商品数量</th>
                            <th>收入</th>
                            <th>状态</th>
                            <th>明细</th>
                        </tr>
                        </tfoot>
                    </table>
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

<script src="js/plugins/dataTables/datatables.min.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap4.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- FooTable -->
<script src="js/plugins/footable/footable.all.min.js"></script>
<!-- Page-Level Scripts -->
<script>
    $(document).ready(function(){
        $('.dataTables-example').DataTable({
            pageLength: 25,
            responsive: true,
            dom: '<"html5buttons"B>lTfgitp',
            buttons: [
                { extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'pdf', title: 'ExampleFile'},

                {extend: 'print',
                    customize: function (win){
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
<script>
    $(document).ready(function() {

        $('.footable').footable();
    });

</script>

<script>
    function check()
    {
        var date=document.getElementById("date").value;
        var week=document.getElementById("week").value;
        var month=document.getElementById("month").value;
        alert(date);
        alert(week);
        alert(month);
    }
    $(document).ready(function() {
        $('#types').change(function() {
            var v = $(this).val();
            switch (v) {
                case '年' :
                    $('#monthDiv').hide();
                    $('#yearDiv').show();
                    $('#dateDiv').hide();
                    break;
                case '月' :
                    $('#monthDiv').show();
                    $('#yearDiv').hide();
                    $('#dateDiv').hide();
                    break;
                case '日' :
                    $('#monthDiv').hide();
                    $('#yearDiv').hide();
                    $('#dateDiv').show();
                    break;
            }
        })
    })


</script>
</body>

</html>


