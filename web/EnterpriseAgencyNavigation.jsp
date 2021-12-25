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

                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>

            <li>
                <a href="displayAddConsumer.action"><i class="fa fa-envelope"></i> <span class="fa fa-plus-square">企业用户认证</span></a>
            </li>

            <li>
                <a href="showenterpriseuser.action"><i class="fa fa-envelope"></i> <span class="nav-label">展示企业人员</span></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-sign-out"></i> <span class="nav-label">管理企业部门</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="displayAddEnterpriseDepartment.action"><i class="fa fa-plus-square"></i> <span class="nav-label">增加企业部门</span></a>
                    </li>
                    <li>
                        <a href="displayAllDepartment.action"><i class="fa fa-envelope"></i> <span
                                class="nav-label">查看企业部门</span></a>
                    </li>
                </ul>
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