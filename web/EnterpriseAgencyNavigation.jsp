<%--
  Created by IntelliJ IDEA.
  User: hydrogen_zyx
  Date: 2021/12/18
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <img alt="image" class="rounded-circle" src="img/profile_small.jpg"/>
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold">${sessionScope.name}</span>
                        <span class="text-muted text-xs block">${sessionScope.type}<b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li><a class="dropdown-item" href="profile.html">个人信息</a></li>
                        <li><a class="dropdown-item" href="contacts.html">好友</a></li>
                        <li><a class="dropdown-item" href="mailbox.html">信箱</a></li>
                        <li class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login.html">登出</a></li>
                    </ul>
                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>

            <li>
                <a href="addConsumer.jsp"><i class="fa fa-envelope"></i> <span class="nav-label">新增企业用户</span></a>
            </li>
            <li>
                <a href="displayAddEnterpriseDepartment.action"><i class="fa fa-envelope"></i> <span class="nav-label">新增部门</span></a>
            </li>
            <li>
                <a href="showenterpriseuser.action"><i class="fa fa-envelope"></i> <span class="nav-label">展示企业人员</span></a>
            </li>
            <li>
                <a href="displayAllDepartment.action"><i class="fa fa-envelope"></i> <span
                        class="nav-label">所有企业部门</span></a>
            </li>
            <li>
            <li>
                <a href="queryElectronicContractsByEnterpriseId.action"><i class="fa fa-envelope"></i> <span
                        class="nav-label">展示已有电子合同</span></a>
            </li>
            <li>
                <a href="./chooseEditElectronicContracts"><i class="fa fa-envelope"></i> <span
                        class="nav-label">编辑电子合同</span></a>
            </li>
        </ul>

    </div>
</nav>