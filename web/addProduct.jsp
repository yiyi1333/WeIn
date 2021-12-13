<%@ page import="cn.edu.zjut.po.WareHouseAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>WeIn 添加商品</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- FooTable -->
    <link href="css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet"><link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/plugins/chosen/bootstrap-chosen.css" rel="stylesheet">
    <link href="css/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css" rel="stylesheet">
    <link href="css/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">
    <link href="css/plugins/cropper/cropper.min.css" rel="stylesheet">
    <link href="css/plugins/switchery/switchery.css" rel="stylesheet">
    <link href="css/plugins/jasny/jasny-bootstrap.min.css" rel="stylesheet">
    <link href="css/plugins/nouslider/jquery.nouislider.css" rel="stylesheet">
    <link href="css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="css/plugins/ionRangeSlider/ion.rangeSlider.css" rel="stylesheet">
    <link href="css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="css/plugins/clockpicker/clockpicker.css" rel="stylesheet">
    <link href="css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
    <link href="css/plugins/select2/select2.min.css" rel="stylesheet">
    <link href="css/plugins/touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet">
    <link href="css/plugins/dualListbox/bootstrap-duallistbox.min.css" rel="stylesheet">
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
                <h2>添加商品</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理商品</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>添加商品</strong>
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
                            <h5>表单填写 <small>按照实际情况填写表格</small></h5>
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
                            <form action="addGoods.action" enctype="multipart/form-data">
                                <div class="form-group  row"  id="goodsNameDiv"><label class="col-sm-1 col-form-label">商品名</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="goodsName" name="goods.goodsName"></div>
                                    <div id="goodsNameResult" style="margin-left: 100px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="goodPriceDiv"><label class="col-sm-1 col-form-label">商品价格</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="goodPrice" name="goods.goodPrice"></div>
                                    <div id="goodsPriceResult" style="margin-left: 100px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-1 col-form-label">商品类型</label>
                                    <div class="col-sm-10"><select class="form-control m-b" id="tags" name="goods.tags">
                                        <option value="电脑">电脑</option>
                                        <option value="电视">电视</option>
                                        <option value="手表">手表</option>
                                        <option value="手机">手机</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row" id="goodsDetailsDiv"><label class="col-sm-1 col-form-label">详细信息</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="goodsDetails" name="goods.goodsDetails"></div>
                                    <div id="goodsDetailsResult" style="margin-left: 100px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="goodsStockDiv"><label class="col-sm-1 col-form-label">商品库存</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="goodsStock" name="goods.goodsStock"></div>
                                    <div id="goodsStockResult" style="margin-left: 100px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-1 col-form-label">商品状态</label>
                                    <div class="col-sm-10"><select class="form-control m-b" id="type" name="goods.isGrouding">
                                        <option value="1">上架</option>
                                        <option value="0">下架</option>
                                    </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="goodsImageDiv"><label class="col-sm-1 col-form-label">商品图片</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="goodsImage" name="goods.goodsImage"></div>
                                    <div id="goodsImageResult" style="margin-left: 100px;"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="row">
                                    <div class="col-md-3"></div>
                                    <div class="col-md-5">
                                        <h4>预览图像</h4>
                                        <img src="" alt="图片不存在" id="image"/>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-white btn-sm" type="reset">取消</button>
                                        <button class="btn btn-primary btn-sm" type="submit">保存更改</button>
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
<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Chosen -->
<script src="js/plugins/chosen/chosen.jquery.js"></script>

<!-- JSKnob -->
<script src="js/plugins/jsKnob/jquery.knob.js"></script>

<!-- Input Mask-->
<script src="js/plugins/jasny/jasny-bootstrap.min.js"></script>

<!-- Data picker -->
<script src="js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- NouSlider -->
<script src="js/plugins/nouslider/jquery.nouislider.min.js"></script>

<!-- Switchery -->
<script src="js/plugins/switchery/switchery.js"></script>

<!-- IonRangeSlider -->
<script src="js/plugins/ionRangeSlider/ion.rangeSlider.min.js"></script>

<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>

<!-- MENU -->
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

<!-- Color picker -->
<script src="js/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

<!-- Clock picker -->
<script src="js/plugins/clockpicker/clockpicker.js"></script>

<!-- Image cropper -->
<script src="js/plugins/cropper/cropper.min.js"></script>

<!-- Date range use moment.js same as full calendar plugin -->
<script src="js/plugins/fullcalendar/moment.min.js"></script>

<!-- Date range picker -->
<script src="js/plugins/daterangepicker/daterangepicker.js"></script>

<!-- Select2 -->
<script src="js/plugins/select2/select2.full.min.js"></script>

<!-- TouchSpin -->
<script src="js/plugins/touchspin/jquery.bootstrap-touchspin.min.js"></script>

<!-- Tags Input -->
<script src="js/plugins/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

<!-- Dual Listbox -->
<script src="js/plugins/dualListbox/jquery.bootstrap-duallistbox.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>
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
            if(r.test($(this).val())){
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

