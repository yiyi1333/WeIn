<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 电子商务网格</title>

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
                <h2>店铺商品管理</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理商品</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>查看商品</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="ibox-content m-b-sm border-bottom">
                <form action="displayGoods">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="col-form-label" for="name">商品名称</label>
                                <input type="text" id="name" name="goods.goodsName" value="" placeholder="请输入商品名称" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="status">状态</label>
                                <select name="goods.isGrouding" id="status" class="form-control">
                                    <option value="" selected>全部</option>
                                    <option value="1">上架</option>
                                    <option value="0">下架</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="col-form-label" for="status">类别</label>
                                <select name="goods.tags" id="type" class="form-control">
                                    <option value="" selected>全部</option>
                                    <option value="电脑">电脑</option>
                                    <option value="电视">电视</option>
                                    <option value="手表">手表</option>
                                    <option value="手机">手机</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <input class="btn btn-primary" type="submit" value="查询" style="margin-top: 20%;margin-left: 20%">
                            </div>
                        </div>
                    </div>
                </form>

            </div>
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
                                            <a href="displayComment?goodsId=<%=goodsList.get(j).getGoodsId()%>" class="btn btn-xs btn-outline btn-primary">详情</a>
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

</body>

</html>
