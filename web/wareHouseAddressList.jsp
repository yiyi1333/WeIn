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
                <form action="selectWareHouseAddress.action">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="wareHouseAddress.warehouseId">发货地址编号</label>
                                <input type="text" id="wareHouseAddress.warehouseId" name="wareHouseAddress.warehouseId" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="wareHouseAddress.warehouseName">发货人姓名</label>
                                <input type="text" id="wareHouseAddress.warehouseName" name="wareHouseAddress.warehouseName" value="" placeholder="请输入..." class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="wareHouseAddress.province">省份</label>
                                <select id="wareHouseAddress.province" name="wareHouseAddress.province"  class="form-control">
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="wareHouseAddress.city">市</label>
                                <select id="wareHouseAddress.city" name="wareHouseAddress.city"  class="form-control">
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="col-form-label" for="wareHouseAddress.district">区/县</label>
                                <select id="wareHouseAddress.district" name="wareHouseAddress.district"  class="form-control">
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-4"></div>
                        <div class="col-sm-4"></div>
                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-w-m btn-primary">查询</button>
                        </div>
                        <div class="col-sm-2">
                            <a href="addWareHouseAddress.jsp"><button type="button" class="btn btn-w-m btn-success">新增</button></a>
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

                                    <th></th>
                                    <th>发货地址编号</th>
                                    <th data-hide="phone">省</th>
                                    <th>市</th>
                                    <th>区县</th>
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
                                        <input type="checkbox"  class="i-checks" value="<%=wareHouseAddressList.get(i).getWarehouseId()%>" name="input[]">
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getWarehouseId()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getProvince()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getCity()%>
                                    </td>
                                    <td>
                                        <%=wareHouseAddressList.get(i).getDistrict()%>
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
                                            <a href="selectWareHouseAddressById?warehouseId=<%=wareHouseAddressList.get(i).getWarehouseId()%>"><button class="btn-white btn btn-xs">编辑</button></a>
                                            <a href="deleteWareHouseAddress?warehouseId=<%=wareHouseAddressList.get(i).getWarehouseId()%>"><button class="btn-white btn btn-xs">删除</button></a>
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
                                        <button type="button" class="btn btn-w-m btn-primary" onclick="deleteWareHouseAddress()">批量删除</button>
                                    </td>
                                    <td colspan="10">
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

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- FooTable -->
<script src="js/plugins/footable/footable.all.min.js"></script>

<%--省市区三级联动--%>
<script type="text/javascript" src="js/area.js"></script>
<script language="javascript">new PCAS("wareHouseAddress.province","wareHouseAddress.city","wareHouseAddress.district","-省-");</script>

<script>
    $(document).ready(function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function() {

        $('.footable').footable();

        $('#date_added').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

        $('#date_modified').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

    });

</script>
<script>
    function deleteWareHouseAddress(){
        var result="";
        var count=0;
        $(".i-checks").each(function(){
            if($(this).is(':checked')){
                result+=$(this).val()+",";
                count++;
            }else{}
        });
        if(!confirm("确定删除这"+count+"个发货地址?")){
            return;
        }
        window.location.href= "deleteWareHouseAddressByIds?tag="+result;
    }
</script>

</body>

</html>

