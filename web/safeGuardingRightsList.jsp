<%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/24
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.po.SafeGuardingRights" %>
<%@ page import="cn.edu.zjut.po.SafeGuardingRightsProgress" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 维权详情</title>

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
                <h2>维权管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>维权处理</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>用户维权处理</strong>
                    </li>
                </ol>
            </div>

        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">


            <div class="ibox-content m-b-sm border-bottom">
                <form action="selectShopSafeGuardingRights.action">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="safeGuardingRightsId">维权编号</label>
                                <input type="text" id="safeGuardingRightsId" name="safeGuardingRights.safeGuardingRightsId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="orderId">订单编号</label>
                                <input type="text" id="orderId" name="safeGuardingRights.orderId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="goodId">商品编号</label>
                                <input type="text" id="goodId" name="safeGuardingRights.goodId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="safeGuardingRightsProgress">维权状态</label>
                                <select id="safeGuardingRightsProgress" name="safeGuardingRights.safeGuardingRightsProgress" class="form-control">
                                    <option value="">全部</option>
                                    <option value="申请中">申请中</option>
                                    <option value="商家处理中">商家处理中</option>
                                    <option value="退换货">退换货</option>
                                    <option value="仅退款">仅退款</option>
                                    <option value="退货退款">退货退款</option>
                                    <option value="平台处理中">平台处理中</option>
                                    <option value="已完成">已完成</option>
                                </select>
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
                                    List<SafeGuardingRights> safeGuardingRightsList = (List<SafeGuardingRights>) session.getAttribute("safeGuardingRightsList");
                                    int num=0;
                                    int id=0;
                                    Date date = null;
                                    for(int i=0;i<safeGuardingRightsList.size();i++){
                                        if(safeGuardingRightsList.get(i).getSafeGuardingRightsId()!=id){
                                            id = safeGuardingRightsList.get(i).getSafeGuardingRightsId();
                                        }
                                        else{
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
                                        <img style="width:70px;height: 70px" src="<%=safeGuardingRightsList.get(i).getGoods().getGoodsImage()%>">

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
                                            if(safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("退货退款")){
                                        %>
                                        <span class="label label-primary"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        }else if(safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("仅退款") || safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("退换货")){
                                        %>
                                        <span class="label label-success"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        }else if(safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("商家处理中") || safeGuardingRightsList.get(i).getSafeGuardingRightsProgress().equals("申请中")){
                                        %>
                                        <span class="label label-warning"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                        }else{
                                        %>
                                        <span class="label label-danger"><%=safeGuardingRightsList.get(i).getSafeGuardingRightsProgress()%></span>
                                        <%
                                            }
                                        %>
                                    </td>
                                    <td class="text-right">
                                        <div class="btn-group">
                                            <a style="color: #999999" href="selectShopSafeGuardingRightsById?safeGuardingRightsId=<%=safeGuardingRightsList.get(i).getSafeGuardingRightsId()%>"><button class="btn-white btn btn-xs">详情</button></a>
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


