<%@ page import="cn.edu.zjut.po.ShopManager" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/12/11
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加发货地址</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="shopNavigation.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="shopTopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>添加发货地址</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>发货地址管理</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>添加发货地址</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">
            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>发货地址详细信息填写<small>按照实际情况填写表格</small></h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#" class="dropdown-item">选项 1</a>
                                    </li>
                                    <li><a href="#" class="dropdown-item">选项 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form action="addWareHouseAddress.action">
                                <div class="form-group  row" id="warehouseNameDiv"><label class="col-sm-2 col-form-label">发货人姓名</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="warehouseName" required="required" name="wareHouseAddress.warehouseName"></div>
                                    <div id="warehouseNameResult"style="position: relative;left: 180px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="warehousePhoneDiv"><label class="col-sm-2 col-form-label">电话号码</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"  id="warehousePhone" required="required" name="wareHouseAddress.warehousePhone"></div>
                                    <div id="warehousePhoneResult" style="position: relative;left: 180px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-2 col-form-label">省份</label>
                                    <div class="col-sm-10"><select class="form-control m-b" id="province" name="wareHouseAddress.province" >
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">市</label>
                                    <div class="col-sm-10"><select class="form-control m-b"  id="city" name="wareHouseAddress.city" >
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">区(县)</label>
                                    <div class="col-sm-10"><select class="form-control m-b" id="district" name="wareHouseAddress.district">
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="warehouseDetailedAddressDiv"><label class="col-sm-2 col-form-label">详细地址</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="warehouseDetailedAddress"  name="wareHouseAddress.warehouseDetailedAddress"></div>
                                    <div id="warehouseDetailedAddressResult" style="position: relative;left:180px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <%
                                    ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");
                                %>
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">商店编号</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"  name="wareHouseAddress.shopId" disabled="disabled" value="<%=shopManager.getShopId()%>"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-white btn-sm" type="submit">取消</button>
                                        <button class="btn btn-primary btn-sm" type="submit">确定</button>
                                    </div>
                                </div>
                            </form>
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
<script  src="js/area.js"></script>
<script language="javascript">new PCAS("wareHouseAddress.province","wareHouseAddress.city","wareHouseAddress.district","浙江省");</script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>

<script>
    $('#warehousePhone').bind('input propertychange', function() {
        var r = /^\+?[0-9][0-9]*$/;　　//正整数
        if($(this).val().length>0&&!r.test($(this).val())){
            document.getElementById("warehousePhoneDiv").className = "form-group row has-error";
            $('#warehousePhoneResult').html('电话号码为纯数字');
        }else{
            if((11 - $(this).val().length)!==0 ){
                document.getElementById("warehousePhoneDiv").className = "form-group row has-error";
                $('#warehousePhoneResult').html('电话号码为11位');
            } else{
                document.getElementById("warehousePhoneDiv").className = "form-group row has-success";
                $('#warehousePhoneResult').html('输入格式正确');
            }
        }
    });
    $('#warehouseName').bind('input propertychange', function() {
        var pattern = new RegExp("[\u4E00-\u9FA5]+");
        if(!pattern.test($(this).val())){
            document.getElementById("warehouseNameDiv").className = "form-group row has-error";
            $('#warehouseNameResult').html('姓名为中文');
        }else{
            if((11 - $(this).val().length) >=4 ){
                document.getElementById("warehouseNameDiv").className = "form-group row has-success";
                $('#warehouseNameResult').html('还剩 '+ (20 - $(this).val().length) + ' 字，请放心输入');
            }
            else if((11 - $(this).val().length) >= 0){
                document.getElementById("warehouseNameDiv").className = "form-group row has-warning";
                $('#warehouseNameResult').html('还剩 '+ (20 - $(this).val().length) + ' 字,请注意');
            }
            else{
                document.getElementById("warehouseNameDiv").className = "form-group row has-error";
                $('#warehouseNameResult').html('您已超出 '+ ($(this).val().length - 20) + ' 字');
            }
        }
    });
    $('#warehouseDetailedAddress').bind('input propertychange', function() {
    if((11 - $(this).val().length) >=4 ){
        document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-success";
        $('#warehouseDetailedAddressResult').html('还剩 '+ (20 - $(this).val().length) + ' 字，请放心输入');
    }
    else if((11 - $(this).val().length) >= 0){
        document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-warning";
        $('#warehouseDetailedAddressResult').html('还剩 '+ (20 - $(this).val().length) + ' 字,请注意');
    }
    else{
        document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-error";
        $('#warehouseDetailedAddressResult').html('您已超出 '+ ($(this).val().length - 20) + ' 字');
    }
    });
</script>
</body>
</html>


