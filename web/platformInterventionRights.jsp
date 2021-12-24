<%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/24
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.safeGuardingRights" %>
<%@ page import="cn.edu.zjut.po.safeGuardingRightsProgress" %>
<%@ page import="java.util.Date" %>
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
    <jsp:include page="platformAdministratorNavigation.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="platformAdministratorTopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>维权管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>维权处理</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>用户维权平台介入</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="platformInterventionRights.action">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="safeGuardingRightsId">维权编号</label>
                                <input type="text" id="safeGuardingRightsId"
                                       name="safeGuardingRights.safeGuardingRightsId" value="" placeholder="请输入..."
                                       class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">订单编号</label>
                                <input type="text" id="orderId" name="safeGuardingRights.orderId" value=""
                                       placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="goodId">商品编号</label>
                                <input type="text" id="goodId" name="safeGuardingRights.goodId" value=""
                                       placeholder="请输入..." class="form-control">
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
                                    <th data-toggle="true">编号</th>
                                    <th data-toggle="true">维权编号</th>
                                    <th data-hide="phone">商品图片</th>
                                    <th data-toggle="true">订单编号</th>
                                    <th data-toggle="true">商品编号</th>
                                    <th data-hide="phone">维权状态</th>
                                    <th data-hide="phone">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    List<safeGuardingRights> safeGuardingRightsList = (List<safeGuardingRights>) session.getAttribute("sgrlist");
                                    int num = 0;
                                    int id = 0;
                                    Date date = null;
                                    for (int i = 0; i < safeGuardingRightsList.size(); i++) {
                                        if (safeGuardingRightsList.get(i).getSafeGuardingRightsId() != id) {
                                            id = safeGuardingRightsList.get(i).getSafeGuardingRightsId();
                                        } else {
                                            continue;
                                        }
                                        num++;
                                %>
                                <tr>
                                    <td>
                                        <br>
                                        <%=num%>
                                    </td>
                                    <td>
                                        <br>
                                        <%=safeGuardingRightsList.get(i).getSafeGuardingRightsId()%>
                                    </td>
                                    <td>
                                        <img style="width:70px;height: 70px"
                                             src="<%=safeGuardingRightsList.get(i).getGoods().getGoodsImage()%>">

                                    </td>
                                    <td>
                                        <br>
                                        <%=safeGuardingRightsList.get(i).getOrderId()%>
                                    </td>
                                    <td>
                                        <br>
                                        <%=safeGuardingRightsList.get(i).getGoodId()%>
                                    </td>
                                    <td>
                                        <br>
                                        <%
                                            if (safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("退货退款")) {
                                        %>
                                        <span class="label label-primary"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        } else if (safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("仅退款") || safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("仅退货")) {
                                        %>
                                        <span class="label label-success"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        } else if (safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("商家处理中")) {
                                        %>
                                        <span class="label label-warning"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        } else {
                                        %>
                                        <span class="label label-danger"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                            }
                                        %>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <a style="color: #999999"
                                               href="platformInterventionRightsDetails?safeGuardingRightsId=<%=safeGuardingRightsList.get(i).getSafeGuardingRightsId()%>">
                                                <button class="btn-white btn btn-xs">详情</button>
                                            </a>
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
    $(document).ready(function () {

        $('.footable').footable();

    });

</script>

</body>

</html>


