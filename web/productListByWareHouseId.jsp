<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>发货地址所存商品</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="css/plugins/toastr/toastr.min.css" rel="stylesheet">

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
                <h2>发货地址管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理发货地址</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>查看发货地址所存商品</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <%
                List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsList");
                for (int i = 0; i < (goodsList.size() + 3) / 4; i++) {
            %>
            <div class="row">
                <%
                    for (int j = i * 4; j < goodsList.size() && j < i * 4 + 4; j++) {
                %>
                <div class="col-md-3">
                    <div class="ibox">
                        <div class="ibox-content product-box">
                            <div>
                                <img src="<%=goodsList.get(j).getGoodsImage()%>" alt="[ 图片 ]"/>
                            </div>
                            <div class="product-desc">
                                <span class="product-price">
                                    ¥<%=String.format("%.2f", goodsList.get(j).getGoodsPrice())%>
                                </span>
                                <small class="text-muted"><%=goodsList.get(j).getTags()%>
                                </small>
                                <a href="#" class="product-name"><%=goodsList.get(j).getGoodsName()%>
                                </a>
                                <div class="small m-t-xs">
                                    <%=goodsList.get(j).getGoodsDetails() == null ? "暂无" : goodsList.get(j).getGoodsDetails()%>
                                    >
                                </div>
                                <div class="m-t text-righ row">
                                    <div class="col-sm-2">
                                        <form action="displayGoodsEditor.action">
                                            <input type="hidden" name="goods.goodsId"
                                                   value=<%=goodsList.get(j).getGoodsId()%>>
                                            <input type="submit" class="btn btn-xs btn-outline btn-primary" value="编辑">
                                        </form>
                                    </div>
                                    <div class="col-sm-2">
                                        <form>
                                            <input type="hidden" name="goods.goodsId"
                                                   value=<%=goodsList.get(j).getGoodsId()%>>
                                            <%
                                                if(goodsList.get(j).getIsGrouding()==1){
                                            %>
                                            <input type="submit" class="btn btn-xs btn-outline btn-primary" value="上架">
                                            <%}else{%>
                                            <input type="submit" class="btn btn-xs btn-outline btn-primary" value="下架">
                                            <%}%>
                                        </form>
                                    </div>
                                    <div class="col-sm-2">
                                        <form action="displaydeleteGoods.action">
                                            <input type="hidden" name="goods.goodsId"
                                                   value=<%=goodsList.get(j).getGoodsId()%>>
                                            <input type="submit" class="btn btn-xs btn-outline btn-primary" value="删除">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>

            </div>
            <%
                }
            %>

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

</body>

</html>
