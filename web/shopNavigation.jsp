<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <img alt="image" class="rounded-circle" src="img/profile_small.jpg"/>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold">${sessionScope.name}</span>
                        <span class="text-muted text-xs block">${sessionScope.type} <b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="dropdown-item" href="profile.html">个人信息</a></li>
                        <li class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login.html">退出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    WeIn
                </div>
            </li>
            <li class="active">
                <a href="shopIndex.jsp"><i class="fa fa-th-large"></i> <span class="nav-label">Dashboards</span></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-shopping-cart"></i> <span class="nav-label">商品管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="./displayAddress"><i class="fa fa-plus-square"></i>添加商品</a></li>
                    <li><a href="./displayShopGoods"><i class="fa fa-bars"></i>查看商品信息</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-sign-out"></i> <span class="nav-label">发货地址管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="addWareHouseAddress.jsp"><i class="fa fa-plus-square"></i>增加发货地址</a></li>
                    <li><a href="./displayShopWareHouseAddress.action"><i class="fa fa-bars"></i>查看发货地址</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-calculator"></i> <span class="nav-label">订单管理</span><span class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li><a href="ordersList.jsp"><i class="fa fa-plus-square"></i>查看订单</a></li>
                    <li><a href="displayShopOrders.action"><i class="fa fa-plus-square"></i>查看订单</a></li>
                    <li><a href="ordersList.jsp"><i class="fa fa-check-square-o"></i>填写物流信息</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o"></i> <span class="nav-label">流水统计</span></a>
            </li>
            <li>
                <a href="shopRights.jsp"><i class="fa fa-envelope"></i> <span class="nav-label">维权处理</span></a>
            </li>
            <li>
                <a href="shopAdvertisement.jsp"><i class="fa fa-file-image-o"></i> <span class="nav-label">广告</span></a>
            </li>
            <li>
                <a href="showShopElectronicContracts.action"><i class="fa fa-newspaper-o"></i> <span class="nav-label">合同</span></a>
            </li>
        </ul>

    </div>
</nav>