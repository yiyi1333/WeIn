<%@ page import="cn.edu.zjut.po.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.zjut.service.CommentService" %><%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/23
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>xxx | 收件箱</title>

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

        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12 animated fadeInRight">
                    <div class="mail-box-header">

                        <h2>
                            待审核消息
                        </h2>
                        <div class="mail-tools tooltip-demo m-t-md">
                            <div class="btn-group float-right">
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>

                            </div>
                            <form action="reviewComment.action">
                                <button type="submit" class="btn btn-white btn-sm" data-toggle="tooltip"
                                        data-placement="left"
                                        title="刷新收件箱">
                                    <i class="fa fa-refresh"></i> 刷新
                                </button>

                            </form>

                        </div>
                    </div>
                    <div class="mail-box">

                        <%
                            List<Comment> commentList = (List<Comment>) session.getAttribute("comments");
                        %>
                        <table class="table table-hover table-mail">
                            <tbody>
                            <%
                                for (int i = 0; i < commentList.size(); i++) {
                                    Comment com = commentList.get(i);
                            %>
                            <tr class="read">
                                <td class="mail-ontact"><strong>用户ID:<%=com.getConsumerId()%>
                                </strong>
                                    <span class="label label-warning float-right">待审核</span>
                                </td>
                                <td class="mail-subject">
                                    <%=com.getMessage()%>
                                    <%=com.getImage() == null ? "" : "<i class=\"fa fa-paperclip\"></i>"%>
                                </td>
                                <td class=""></td>
                                <td>
                                    <%
                                        for (int j = 0; j < com.getRate(); j++) {
                                    %>
                                    <i class="fa fa-star"></i>
                                    <%
                                        }
                                    %>
                                </td>
                                <td>
                                    <form action="commentJudge.action">
                                        <input type="hidden" name="commentId" value="<%=com.getCommentId()%>">
                                        <input type="hidden" name="judge" value="true">
                                        <button class="btn btn-primary m-t-n-xs right" type="submit">
                                            通过
                                        </button>
                                    </form>

                                </td>
                                <td>
                                    <form action="commentJudge.action">
                                        <input type="hidden" name="commentId" value="<%=com.getCommentId()%>">
                                        <input type="hidden" name="judge" value="false">
                                        <button class="btn btn-danger m-t-n-xs left" type="submit">
                                            拒绝
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <form action="reviewDetail.action">
                                        <input type="hidden" name="commentId" value="<%=com.getCommentId()%>">
                                        <input type="hidden" name="goodsId" value="<%=com.getGoodsId()%>">
                                        <input type="hidden" name="consumerId" value="<%=com.getConsumerId()%>">
                                        <button class="btn btn-white  m-t-n-xs left" type="submit">
                                            更多信息<i class="fa fa-arrow-right"></i>
                                        </button>
                                    </form>
                                </td>

                                <!--                                <td class="text-right mail-date">12月12日</td>-->
                            </tr>
                            <%
                                }
                            %>
                            </tbody>

                        </table>


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
