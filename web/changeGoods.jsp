<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 电子商务产品编辑</title>

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
                <h2>电子商务产品编辑</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="index.html">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>电子商务</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>产品编辑</strong>
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
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">产品名称:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.goodsName"
                                                                              class="form-control"
                                                                              value="<%=goods.getGoodsName()%>"></div>
                                            </div>
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">产品价格:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.goodsPrice"
                                                                              class="form-control"
                                                                              value="<%=String.format("%.2f", goods.getGoodsPrice())%>">
                                                </div>
                                            </div>
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">产品详情:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.goodsDetails"
                                                                              class="form-control"
                                                                              value="<%=goods.getGoodsDetails()==null?"":goods.getGoodsDetails()%>">
                                                </div>
                                            </div>
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">产品库存:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.goodsStock"
                                                                              class="form-control"
                                                                              value="<%=goods.getGoodsStock()%>">
                                                </div>
                                            </div>
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">产品图片:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.goodsImage"
                                                                              class="form-control"
                                                                              value="<%=goods.getGoodsImage()%>">
                                                </div>
                                            </div>
                                            <div class="form-group row"><label
                                                    class="col-sm-2 col-form-label">标题关键字:</label>
                                                <div class="col-sm-10"><input type="text" name="goods.tags"
                                                                              class="form-control"
                                                                              value="<%=goods.getTags()%>"></div>
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

</body>

</html>

