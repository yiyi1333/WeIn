<%@ page import="cn.edu.zjut.po.Goods" %>
<%@ page import="cn.edu.zjut.po.Consumer" %>
<%@ page import="cn.edu.zjut.po.Comment" %><%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/23
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>评论详细内容</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body>

<div id="wrapper">

    <jsp:include page="platformAdministratorNavigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="platformAdministratorTopSidebar.jsp"/>

        <%
            Goods goods = (Goods) session.getAttribute("goods");
            Consumer consumer = (Consumer) session.getAttribute("consumer");
            Comment comment = (Comment) session.getAttribute("comment");
        %>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12 animated fadeInRight">
                    <div class="mail-box-header">
                        <h2>
                            用户评价
                        </h2>
                        <div class="mail-tools tooltip-demo m-t-md">


                            <h3>
                                <span class="font-normal">用户名： </span><%=consumer.getName() == null ? "此用户已注销" : consumer.getName()%>

                            </h3>
                            <h5>
                                <span class="font-normal">用户编号: </span><%=comment.getCommentId()%>
                            </h5>
                        </div>

                        <div class="mail-tools tooltip-demo m-t-md">

                            <h3>
                                <span class="font-normal">商品名： </span><%=goods.getGoodsName() == null ? "此商品已下架" : goods.getGoodsName()%>
                            </h3>
                            <span class="float-right font-normal">

                            评分：
                                <%
                                    for (int i = 0; i < comment.getRate(); i++) {
                                %>
                            <i class="fa fa-star"></i>
                                <%
                                    }
                                %>
                            </span>
                            <h5>
                                <span class="font-normal">商品编号: </span><%=goods.getGoodsId()%>
                            </h5>
                        </div>

                    </div>
                    <div class="mail-box">

                        <div class="mail-body">
                            <h3>
                                用户评价
                            </h3>
                            <p>
                                <%=comment.getMessage()%>
                            </p>
                        </div>
                        <%
                            if (comment.getImage() != null) {
                        %>
                        <div class="mail-attachment">
                            <p>
                                <span><i class="fa fa-paperclip"></i> 1个附件 -</span>
                                <a href="<%=comment.getImage()%>">全部下载</a>
                            </p>

                            <div class="attachment">
                                <div class="">
                                    <div class="">
                                        <a href="<%=comment.getImage()%>">
                                            <span class="corner"></span>

                                            <div class="image">
                                                <img alt="image" class="img-fluid"
                                                     src="<%=comment.getImage()%>">
                                            </div>
                                        </a>

                                    </div>
                                </div>

                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <div class="mail-body text-right tooltip-demo">
                            <form action="commentJudge.action">
                                <input type="hidden" name="commentId" value="<%=comment.getCommentId()%>">
                                <input type="hidden" name="judge" value="true">
                                <button class="btn btn-primary m-t-n-xs right" type="submit">
                                    通过
                                </button>
                            </form>
                            <form action="commentJudge.action">
                                <input type="hidden" name="commentId" value="<%=comment.getCommentId()%>">
                                <input type="hidden" name="judge" value="false">
                                <button class="btn btn-danger m-t-n-xs left" type="submit">
                                    拒绝
                                </button>
                            </form>
                        </div>
                        <div class="clearfix"></div>


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
</body>

</html>
