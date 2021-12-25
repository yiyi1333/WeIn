<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/25
  Time: 02:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | 主页风格 v.2</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

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

                <%
                    double thisyearmoney = (double) session.getAttribute("thisyearmoney");
                    double thismonthmoney = (double) session.getAttribute("thismonthmoney");
                    double thisdaymoney = (double) session.getAttribute("thisdaymoney");
                    int thismonthorder = (int) session.getAttribute("thismonthorder");
                    int shopmanagernumber = (int) session.getAttribute("shopmanagernumber");
                    int thisdayorder = (int) session.getAttribute("thisdayorder");
                %>
                <div class="col-lg-3">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <span class="label label-success float-right">本年</span>
                            <h5>营业额</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=thisyearmoney%>
                            </h1>
                            <div class="stat-percent font-bold text-info"><%=thisdaymoney%><i
                                    class="fa fa-level-up"></i></div>
                            <small>今日增长</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <span class="label label-info float-right">本月</span>
                            <h5>营业额</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=thismonthmoney%>
                            </h1>
                            <div class="stat-percent font-bold text-info"><%=thisdaymoney%><i
                                    class="fa fa-level-up"></i></div>
                            <small>昨日增长</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <span class="label label-primary float-right">本月</span>
                            <h5>订单数</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=thismonthorder%>
                            </h1>
                            <div class="stat-percent font-bold text-navy"><%=thisdayorder%><i
                                    class="fa fa-level-up"></i></div>
                            <small>今日增长</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <span class="label label-danger float-right">平台</span>
                            <h5>活跃商家数</h5>
                        </div>
                        <div class="ibox-content">
                            <h1 class="no-margins"><%=shopmanagernumber%>
                            </h1>
                            <%--                            <div class="stat-percent font-bold text-danger">100<i class="fa fa-level-down"></i></div>--%>
                            <small>商家数量</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>订单</h5>
                            <div class="float-right">
                                <div class="btn-group">
                                    <!--                                    <button type="button" class="btn btn-xs btn-white active">天</button>-->
                                    <!--                                    <button type="button" class="btn btn-xs btn-white">月</button>-->
                                    <!--                                    <button type="button" class="btn btn-xs btn-white">年</button>-->
                                </div>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-lg-9">
                                    <div class="flot-chart">
                                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">
                                        <li>
                                            <h2 class="no-margins"><%=thismonthmoney%>
                                            </h2>
                                            <small>最近一个月交易总额</small>
                                            <div class="stat-percent"><%=thisdaymoney%><i
                                                    class="fa fa-level-up text-navy"></i></div>
                                            <div class="progress progress-mini">
                                                <div style="width: 100%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins "><%=thismonthorder%>
                                            </h2>
                                            <small>最近一个月订单</small>
                                            <div class="stat-percent"><%=thisdayorder%><i
                                                    class="fa fa-level-up text-navy"></i>
                                            </div>
                                            <div class="progress progress-mini">
                                                <div style="width: 100%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <h2 class="no-margins "><%=shopmanagernumber%>
                                            </h2>
                                            <small>活跃商家数</small>
                                            <%--                                            <div class="stat-percent"><i class="fa fa-bolt text-navy"></i></div>--%>
                                            <div class="progress progress-mini">
                                                <div style="width: 100%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-12">

                    <div class="row">

                        <div class="col-lg-12">
                            <div class="ibox ">

                                <div class="ibox-title">
                                    <h5>店铺营业额</h5>
                                    <div class="ibox-tools">
                                        <a class="collapse-link">
                                            <i class="fa fa-chevron-up"></i>
                                        </a>
                                        <a class="close-link">
                                            <i class="fa fa-times"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="ibox-content">

                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="ibox-content m-b-sm border-bottom">
                                                <form action="platformFinancialStatistics.action">
                                                    <div class="row">
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">年份</label>
                                                                <select name="year"
                                                                        class="form-control">
                                                                    <option value="0">全部</option>
                                                                    <option value="2015">2015年</option>
                                                                    <option value="2016">2016年</option>
                                                                    <option value="2017">2017年</option>
                                                                    <option value="2018">2018年</option>
                                                                    <option value="2019">2019年</option>
                                                                    <option value="2020">2020年</option>
                                                                    <option value="2021">2021年</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">月份</label>
                                                                <select name="month" class="form-control">
                                                                    <option value="0">全部</option>
                                                                    <option value="1">1月</option>
                                                                    <option value="2">2月</option>
                                                                    <option value="3">3月</option>
                                                                    <option value="4">4月</option>
                                                                    <option value="5">5月</option>
                                                                    <option value="6">6月</option>
                                                                    <option value="7">7月</option>
                                                                    <option value="8">8月</option>
                                                                    <option value="9">9月</option>
                                                                    <option value="10">10月</option>
                                                                    <option value="11">11月</option>
                                                                    <option value="12">12月</option>
                                                                </select>
                                                            </div>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <div class="form-group">
                                                                <label class="col-form-label">日期</label>
                                                                <select name="date"
                                                                        class="form-control">
                                                                    <option value="0">全部</option>
                                                                    <%
                                                                        for (int i = 1; i <= 31; i++) {
                                                                    %>
                                                                    <option value="<%=i%>"><%=i%>日</option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <br><br>
                                                                <button type="submit" class="btn btn-w-m btn-primary">查询
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>


                                            <table class="table table-hover margin bottom">
                                                <thead>
                                                <tr>
                                                    <th style="width: 1%" class="text-center">店铺ID</th>
                                                    <th>订单数量</th>
                                                    <th class="text-center">销售额度</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%
                                                    Map<Integer, Double> mp1 = (Map<Integer, Double>) session.getAttribute("mp1");
                                                    Map<Integer, Integer> mp2 = (Map<Integer, Integer>) session.getAttribute("mp2");
                                                    Set<Integer> st = mp1.keySet();

                                                    for (Integer it : st) {
                                                %>
                                                <tr>
                                                    <td class="text-center"><%=it%>
                                                    </td>
                                                    <td class="text-center"><%=mp2.get(it)%>
                                                    </td>
                                                    <td class="text-center"><span
                                                            class="label label-primary">¥<%=mp1.get(it)%></span></td>
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
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">
                <li>
                    <a class="nav-link active" data-toggle="tab" href="#tab-1"> 记录 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-2"> 项目 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-3"> <i class="fa fa-gear"></i> </a>
                </li>
            </ul>

            <div class="tab-content">


                <div id="tab-1" class="tab-pane active">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-comments-o"></i> 最新记录</h3>
                        <small><i class="fa fa-tim"></i> 你有10条新消息。</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">

                                    Lorem Ipsum的通道有许多变化。
                                    <br>
                                    <small class="text-muted">今天 4:21 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    使用Lorem Ipsum的观点是它具有或多或少的正常。
                                    <br>
                                    <small class="text-muted">Yesterday 2:45 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    这些年来，有时是意外的，有时是有目的的（注入幽默等）。
                                    <br>
                                    <small class="text-muted">昨天 1:10 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the
                                    <br>
                                    <small class="text-muted">星期一 8:37 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a8.jpg">
                                </div>
                                <div class="media-body">

                                    互联网上的所有Lorem Ipsum发电机往往重复。
                                    <br>
                                    <small class="text-muted">今天 4:21 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a7.jpg">
                                </div>
                                <div class="media-body">
                                    再生。 Lorem Ipsum的第一行“Lorem ipsum dolor sit amet ..”来自1.10.32节的一行。
                                    <br>
                                    <small class="text-muted">昨天 2:45 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    从1500年代以来使用的Lorem Ipsum的标准块转载如下。
                                    <br>
                                    <small class="text-muted">昨天 1:10 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="img/a4.jpg">
                                </div>
                                <div class="media-body">
                                    揭开许多网站仍处于起步阶段。 各种版本有。
                                    <br>
                                    <small class="text-muted">星期一 8:37 pm</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>

                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-cube"></i> 最新项目</h3>
                        <small><i class="fa fa-tim"></i> 你有14个项目。 10没有完成</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>业务估值</h4>
                                一个长期以来的事实是，读者会分心。

                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>与公司签订合同 </h4>
                                许多桌面出版包和网页编辑器。

                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>会议</h4>
                                通过查看其布局时页面的可读内容。

                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>生成的</h4>
                                Lorem Ipsum的通道有许多变化。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>业务估值</h4>
                                一个长期以来的事实是，读者会分心。

                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>与公司签订合同 </h4>
                                许多桌面出版包和网页编辑器。

                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>会议</h4>
                                通过查看其布局时页面的可读内容。

                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>生成的</h4>
                                <!--<div class="small float-right m-t-xs">9小时前</div>-->
                                Lorem Ipsum的通道有许多变化。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>

                    </ul>

                </div>

                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-gears"></i> 设置</h3>
                        <small><i class="fa fa-tim"></i> 你有14个项目。 10没有完成</small>
                    </div>

                    <div class="setings-item">
                    <span>
                        显示通知
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
                                <label class="onoffswitch-label" for="example">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        停用聊天
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox"
                                       id="example2">
                                <label class="onoffswitch-label" for="example2">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        启用历史记录
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
                                <label class="onoffswitch-label" for="example3">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        显示图表
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
                                <label class="onoffswitch-label" for="example4">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        离线用户
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox"
                                       id="example5">
                                <label class="onoffswitch-label" for="example5">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        全球搜索
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox"
                                       id="example6">
                                <label class="onoffswitch-label" for="example6">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        每天更新
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
                                <label class="onoffswitch-label" for="example7">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="sidebar-content">
                        <h4>设置</h4>
                        <div class="small">
                            我相信那个 Lorem Ipsum只是印刷和排版行业的虚拟文字。
                            排版行业。 Lorem Ipsum自15世纪15年代以来一直是行业的标准虚拟文本。
                            多年来，有时偶然地，有时是目的（注入幽默等）。
                        </div>
                    </div>

                </div>
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

<!-- Flot -->
<script src="js/plugins/flot/jquery.flot.js"></script>
<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="js/plugins/flot/jquery.flot.spline.js"></script>
<script src="js/plugins/flot/jquery.flot.resize.js"></script>
<script src="js/plugins/flot/jquery.flot.pie.js"></script>
<script src="js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="js/plugins/flot/jquery.flot.time.js"></script>

<!-- Peity -->
<script src="js/plugins/peity/jquery.peity.min.js"></script>
<script src="js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="js/inspinia.js"></script>
<script src="js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- Jvectormap -->
<script src="js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<!-- EayPIE -->
<script src="js/plugins/easypiechart/jquery.easypiechart.js"></script>

<!-- Sparkline -->
<script src="js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="js/demo/sparkline-demo.js"></script>

<script>
    $(document).ready(function () {
        $('.chart').easyPieChart({
            barColor: '#f8ac59',
//                scaleColor: false,
            scaleLength: 5,
            lineWidth: 4,
            size: 80
        });

        $('.chart2').easyPieChart({
            barColor: '#1c84c6',
//                scaleColor: false,
            scaleLength: 5,
            lineWidth: 4,
            size: 80
        });

        var data2 = [
            <%
            List<Double> money = (List<Double>) session.getAttribute("money");
            List<Integer> number = (List<Integer>) session.getAttribute("number");
            for(int i=0;i<31;i++){
            %>
            [gd(2021, 12, <%=i+1%>), <%=number.get(i)%>],
            <%
            }
            %>
        ];

        var data3 = [
            <%
            for(int i=0;i<31;i++){
            %>
            [gd(2021, 12, <%=i+1%>), <%=money.get(i)%>],
            <%
            }
            %>
        ];


        var dataset = [
            {
                label: "订单数量",
                data: data3,
                color: "#1ab394",
                bars: {
                    show: true,
                    align: "center",
                    barWidth: 24 * 60 * 60 * 600,
                    lineWidth: 0
                }

            }, {
                label: "交易金额",
                data: data2,
                yaxis: 2,
                color: "#1C84C6",
                lines: {
                    lineWidth: 1,
                    show: true,
                    fill: true,
                    fillColor: {
                        colors: [{
                            opacity: 0.2
                        }, {
                            opacity: 0.4
                        }]
                    }
                },
                splines: {
                    show: false,
                    tension: 0.6,
                    lineWidth: 1,
                    fill: 0.1
                },
            }
        ];


        var options = {
            xaxis: {
                mode: "time",
                tickSize: [3, "day"],
                tickLength: 0,
                axisLabel: "Date",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Arial',
                axisLabelPadding: 10,
                color: "#d5d5d5"
            },
            yaxes: [{
                position: "left",
                // max: ,
                color: "#d5d5d5",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Arial',
                axisLabelPadding: 3
            }, {
                position: "right",
                clolor: "#d5d5d5",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: ' Arial',
                axisLabelPadding: 67
            }
            ],
            legend: {
                noColumns: 1,
                labelBoxBorderColor: "#000000",
                position: "nw"
            },
            grid: {
                hoverable: false,
                borderWidth: 0
            }
        };

        function gd(year, month, day) {
            return new Date(year, month - 1, day).getTime();
        }

        var previousPoint = null, previousLabel = null;

        $.plot($("#flot-dashboard-chart"), dataset, options);

        var mapData = {
            "US": 298,
            "SA": 200,
            "DE": 220,
            "FR": 540,
            "CN": 120,
            "AU": 760,
            "BR": 550,
            "IN": 200,
            "GB": 120,
        };

        $('#world-map').vectorMap({
            map: 'world_mill_en',
            backgroundColor: "transparent",
            regionStyle: {
                initial: {
                    fill: '#e4e4e4',
                    "fill-opacity": 0.9,
                    stroke: 'none',
                    "stroke-width": 0,
                    "stroke-opacity": 0
                }
            },

            series: {
                regions: [{
                    values: mapData,
                    scale: ["#1ab394", "#22d6b1"],
                    normalizeFunction: 'polynomial'
                }]
            },
        });
    });
</script>
</body>
</html>
