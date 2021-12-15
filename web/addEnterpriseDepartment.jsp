<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lemon
  Date: 2021/12/2
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <s:head/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>xxx | 基础表单</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="navigation.jsp"/>

    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="topSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>添加企业组织</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a>主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理企业组织</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>添加企业组织</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>表格填写 <small>按照实际情况填写表格</small></h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#" class="dropdown-item">选项 1</a>
                                    </li>
                                    <li><a href="#" class="dropdown-item">选项 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <%
                            List<EnterpriseDepartment> enterpriseDepartmentList = (List<EnterpriseDepartment>) request.getSession().getAttribute("displayEnterpriseDepartments");
                            String name = (String) request.getSession().getAttribute("displayEnterpriseName");
                            int enterpriseId = (int) request.getSession().getAttribute("enterpriseId");
                        %>
                        <div class="ibox-content">
                            <form action="addenterpriseDepartment.action">
                                <div class="form-group  row"><label class="col-sm-2 col-form-label">部门名称</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control"
                                               name="enterpriseDepartment.enterpriseDepartmentName">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-2 col-form-label">所属企业</label>
                                    <div class="col-sm-10">
                                        <input type="hidden" name="enterpriseDepartment.enterpriseId"
                                               value="<%=enterpriseId%>">
                                        <input type="text" readonly="readonly" class="form-control" value="<%=name%>">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label">所属部门</label>
                                    <div class="col-sm-10">
                                        <select class="form-control m-b"
                                                name="enterpriseDepartment.enterpriseDepartmentpre">
                                            <%
                                                for (int i = 0; i < enterpriseDepartmentList.size(); i++) {
                                            %>
                                            <option value="<%=enterpriseDepartmentList.get(i).getEnterpriseDepartmentId()%>"><%=enterpriseDepartmentList.get(i).getEnterpriseDepartmentName()%>
                                            </option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>
                                <div class="form-group row">
                                    <div class="col-sm-4 col-sm-offset-2">
                                        <button class="btn btn-white btn-sm" type="submit">取消</button>
                                        <button class="btn btn-primary btn-sm" type="submit">保存更改</button>
                                    </div>
                                    <s:actionerror/>
                                </div>
                            </form>
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

