<%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/13
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold">WeIn</span>
                        <span class="text-muted text-xs block">平台管理员<b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="dropdown-item" href="#">个人信息</a></li>
                        <li class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="registerShopmanager.jsp">登出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>
            <li>
                <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">企业信息管理</span> <span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="registerEnterpriseagency.jsp">注册企业用户</a></li>
                    <li><a href="./displayEnterpriseagency">查询企业用户信息</a></li>
                    <li><a href="queryEnterpriseStructure.jsp">查询企业结构</a></li>
                    <li><a href="deleteEnterpriseagency.jsp">删除企业用户</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">商家信息管理</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="registerShopmanager.jsp">注册企业用户</a></li>
                    <li>
                    <a href="./displayShopmanager">查询商家店铺信息</a></li>
                    <li><a href="dashboard_3.html">查询企业结构</a></li>
                    <li><a href="dashboard_4_1.html">删除企业</a></li>
                    <li><a href="graph_flot.html">注册</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">企业员工信息管理</span><span
                        class="fa arrow"></span></a>

                <ul class="nav nav-second-level collapse">
                    <li><a href="mailbox.html">收件箱</a></li>
                    <li><a href="mail_detail.html">邮件内容</a></li>
                    <li><a href="mail_compose.html">撰写邮件</a></li>
                    <li><a href="email_template.html">邮件模板</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">平台管理员</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="mailbox.html">收件箱</a></li>
                    <li><a href="mail_detail.html">邮件内容</a></li>
                    <li><a href="mail_compose.html">撰写邮件</a></li>
                    <li><a href="email_template.html">邮件模板</a></li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">订单相关</span><span
                        class="fa arrow"></span></a>

                <ul class="nav nav-second-level collapse">
                    <li><a href="mailbox.html">抽成</a></li>
                    <li><a href="mail_detail.html">维权</a></li>
                    <li><a href="mail_compose.html">撰写邮件</a></li>
                    <li><a href="email_template.html">邮件模板</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">流水统计</span><span
                        class="fa arrow"></span></a>

                <ul class="nav nav-second-level collapse">
                    <li><a href="mailbox.html">收件箱</a></li>
                    <li><a href="mail_detail.html">邮件内容</a></li>
                    <li><a href="mail_compose.html">撰写邮件</a></li>
                    <li><a href="email_template.html">邮件模板</a></li>
                </ul>
            </li>
            <li>
                <a href="reviewComment.action"><i class="fa fa-envelope"></i> <span class="nav-label">审核评论</span></a>
            </li>
        </ul>

    </div>
</nav>

