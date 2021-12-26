<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page import="cn.edu.zjut.po.WareHouseAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn | 编辑商品</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/plugins/summernote/summernote-bs4.css" rel="stylesheet">

    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">


</head>

<body>

<div id="wrapper">

    <jsp:include page="shopNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="shopTopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>编辑商品</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理商品</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>编辑商品</strong>
                    </li>
                </ol>
            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">

            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">
                        <ul class="nav nav-tabs">
                            <li><a class="nav-link active" data-toggle="tab" href="#tab-1"> 产品编辑</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active">
                                <div class="panel-body">
                                    <%
                                        Goods goods = (Goods) session.getAttribute("goods");
                                    %>
                                    <s:form action="updateGoods">
                                        <fieldset>
                                            <input type="hidden" value="<%=goods.getGoodsId()%>" name="goods.goodsId">
                                            <div class="form-group row" id="goodsNameDiv">
                                                <label class="col-sm-1 col-form-label">产品名称</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="goodsName" name="goods.goodsName" class="form-control" value="<%=goods.getGoodsName()%>">
                                                </div>
                                                <div id="goodsNameResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="form-group row" id="goodPriceDiv">
                                                <label class="col-sm-1 col-form-label">产品价格</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="goods.goodsPrice" id="goodPrice" class="form-control" value="<%=String.format("%.2f", goods.getGoodsPrice())%>">
                                                </div>
                                                <div id="goodsPriceResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="form-group row" id="goodWeightDiv">
                                                <label class="col-sm-1 col-form-label">产品重量</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="goods.goodsWeight" id="goodWeight" class="form-control" value="<%=String.format("%.2f", goods.getGoodsWeight())%>">
                                                </div>
                                                <div id="goodsWeightResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="form-group row" id="goodsDetailsDiv">
                                                <label class="col-sm-1 col-form-label">产品详情</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="goods.goodsDetails" class="form-control" id="goodsDetails" value="<%=goods.getGoodsDetails()==null?"":goods.getGoodsDetails()%>">
                                                </div>
                                                <div id="goodsDetailsResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="form-group row" id="goodsStockDiv">
                                                <label class="col-sm-1 col-form-label">产品库存</label>
                                                <div class="col-sm-10">
                                                    <input type="text" id="goodsStock" name="goods.goodsStock" class="form-control" value="<%=goods.getGoodsStock()%>">
                                                </div>
                                                <div id="goodsStockResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-1 col-form-label">商品类型</label>
                                                <div class="col-sm-10">
                                                    <select class="form-control m-b" id="tags" name="goods.tags">
                                                        <%if(goods.getTags().equals("电脑")){%>
                                                        <option value="电脑" selected>电脑</option>
                                                        <option value="电视">电视</option>
                                                        <option value="手表">手表</option>
                                                        <option value="手机">手机</option>
                                                        <%}else if(goods.getTags().equals("电视")){%>
                                                        <option value="电脑">电脑</option>
                                                        <option value="电视" selected>电视</option>
                                                        <option value="手表">手表</option>
                                                        <option value="手机">手机</option>
                                                        <%}else if(goods.getTags().equals("手表")){%>
                                                        <option value="电脑">电脑</option>
                                                        <option value="电视">电视</option>
                                                        <option value="手表" selected>手表</option>
                                                        <option value="手机">手机</option>
                                                        <%}else{%>
                                                        <option value="电脑">电脑</option>
                                                        <option value="电视">电视</option>
                                                        <option value="手表">手表</option>
                                                        <option value="手机" selected>手机</option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-1 col-form-label">商品状态</label>
                                                <div class="col-sm-10">
                                                    <select class="form-control m-b" id="isGrouding" name="goods.isGrouding">
                                                        <%if(goods.getIsGrouding()==1){%>
                                                        <option value="1" selected>上架</option>
                                                        <option value="0">下架</option>
                                                        <%}else{%>
                                                        <option value="1">上架</option>
                                                        <option value="0" selected>下架</option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row"><label class="col-sm-1 col-form-label">发货地址</label>
                                                <div class="col-sm-10">
                                                    <select class="form-control m-b" id="warehouseId" name="goods.warehouseId">
                                                        <%
                                                            List<WareHouseAddress> wareHouseAddressList = (List<WareHouseAddress>) session.getAttribute("wareHouseAddressList");
                                                            for(WareHouseAddress wareHouseAddress : wareHouseAddressList){
                                                                if(goods.getWarehouseId()==wareHouseAddress.getWarehouseId()){
                                                        %>
                                                        <option value="<%=wareHouseAddress.getWarehouseId()%>" selected><%=wareHouseAddress.getProvince()%><%=wareHouseAddress.getCity()%><%=wareHouseAddress.getDistrict()%><%=wareHouseAddress.getWarehouseDetailedAddress()%></option>
                                                        <%}else{%>
                                                        <option value="<%=wareHouseAddress.getWarehouseId()%>"><%=wareHouseAddress.getProvince()%><%=wareHouseAddress.getCity()%><%=wareHouseAddress.getDistrict()%><%=wareHouseAddress.getWarehouseDetailedAddress()%></option>
                                                        <%}}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row" id="goodsImageDiv">
                                                <label class="col-sm-1 col-form-label">商品图片</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="goods.goodsImage" id="goodsImage" class="form-control" value="<%=goods.getGoodsImage()%>">
                                                </div>
                                                <div id="goodsImageResult" style="margin-left: 100px;"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"></div>
                                                <div class="col-md-5">
                                                    <h4>预览图像</h4>
                                                    <img src="" alt="图片不存在" id="image"/>
                                                </div>
                                            </div>
                                            <button class="btn btn-primary btn-sm" type="submit">保存更改</button>
                                        </fieldset>

                                    </s:form>

                                </div>
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

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- SUMMERNOTE -->
<script src="js/plugins/summernote/summernote-bs4.js"></script>

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<script>
    $(document).ready(function () {

        $('.summernote').summernote();

        $('.input-group.date').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true
        });

    });
</script>
<script>
    $(function (){
        $('#goodsName').bind('input propertychange', function() {
            if((20 - $(this).val().length) >=4 ){
                document.getElementById("goodsNameDiv").className = "form-group row has-success";
                $('#goodsNameResult').html('还剩 '+ (20 - $(this).val().length) + ' 字，请放心输入');
            }
            else if((20 - $(this).val().length) >= 0){
                document.getElementById("goodsNameDiv").className = "form-group row has-warning";
                $('#goodsNameResult').html('还剩 '+ (20 - $(this).val().length) + ' 字,请注意');
            }
            else{
                document.getElementById("goodsNameDiv").className = "form-group row has-error";
                $('#goodsNameResult').html('您已超出 '+ ($(this).val().length - 20) + ' 字');
            }
        });
        $('#goodPrice').bind('input propertychange', function() {
            var r=/^[0-9]+(.[0-9]{1,2})?$/;
            if(r.test($(this).val()) && ($(this).val()>0)){
                document.getElementById("goodPriceDiv").className = "form-group row has-success";
                $('#goodsPriceResult').html('输入正确');
            }
            else{
                document.getElementById("goodPriceDiv").className = "form-group row has-error";
                $('#goodsPriceResult').html('请输入有0-2位小数的正实数');
            }
        });
        $('#goodsDetails').bind('input propertychange', function() {
            if((100 - $(this).val().length) >=10 ){
                document.getElementById("goodsDetailsDiv").className = "form-group row has-success";
                $('#goodsDetailsResult').html('还剩 '+ (100 - $(this).val().length) + ' 字，请放心输入');
            }
            else if((100 - $(this).val().length) >= 0){
                document.getElementById("goodsDetailsDiv").className = "form-group row has-warning";
                $('#goodsDetailsResult').html('还剩 '+ (100 - $(this).val().length) + ' 字,请注意');
            }
            else{
                document.getElementById("goodsDetailsDiv").className = "form-group row has-error";
                $('#goodsDetailsResult').html('您已超出 '+ ($(this).val().length - 100) + ' 字');
            }
        });
        $('#goodsStock').bind('input propertychange', function() {
            var r=/^\+?[1-9][0-9]*$/;
            if(r.test($(this).val())){
                document.getElementById("goodsStockDiv").className = "form-group row has-success";
                $('#goodsStockResult').html('输入正确');
            }
            else{
                document.getElementById("goodsStockDiv").className = "form-group row has-error";
                $('#goodsStockResult').html('请输入正整数');
            }
        });
        $('#goodsImage').bind('input propertychange', function() {
            document.getElementById("image").src = $(this).val();
        });
    });
</script>
</body>

</html>

