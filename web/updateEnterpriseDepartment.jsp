<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/24
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改企业部门</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
    <jsp:include page="EnterpriseAgencyNavigation.jsp"/>
    <div id="page-wrapper" class="gray-bg">
        <jsp:include page="EnterpriseAgencytopSidebar.jsp"/>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
                <h2>修改企业部门</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="shopIndex.jsp">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>企业部门管理</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>修改企业部门</strong>
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
                            <h5>企业部门详细信息修改<small>按照实际情况填写表格</small></h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <form action="updateEnterpriseDepartment.action">
                                <%
                                    EnterpriseDepartment enterpriseDepartment = (EnterpriseDepartment) session.getAttribute("enterpriseDepartment");

                                %>

                                <div class="form-group  row"><label class="col-sm-2 col-form-label">企业部门编号</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"
                                                                  name="enterpriseDepartment.enterpriseDepartmentId"
                                                                  disabled="disabled"
                                                                  value="<%=enterpriseDepartment.getEnterpriseDepartmentId()%>">
                                    </div>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <div class="form-group  row" id="enterpriseDepartmentNameDiv"><label
                                        class="col-sm-2 col-form-label">企业部门名字</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"
                                                                  id="enterpriseDepartmentName"
                                                                  name="enterpriseDepartment.enterpriseDepartmentName"
                                                                  value="<%=enterpriseDepartment.getEnterpriseDepartmentName()%>">
                                    </div>
                                    <div id="warehouseNameResult" style="position: relative;left: 180px;"></div>
                                </div>
                                <div class="hr-line-dashed"></div>

                                <div class="form-group  row" id="enterpriseDepartmentpreDiv"><label
                                        class="col-sm-2 col-form-label">企业隶属于</label>
                                    <div class="col-sm-10">
                                        <select class="form-control m-b"
                                                name="enterpriseDepartment.enterpriseDepartmentpre">
                                            <%
                                                List<EnterpriseDepartment> enterpriseDepartmentList = (List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList");
                                                for (EnterpriseDepartment enterpriseDepartment1 : enterpriseDepartmentList) {

                                            %>
                                            <option value="<%=enterpriseDepartment1.getEnterpriseDepartmentId()%>">
                                                <%=enterpriseDepartment1.getEnterpriseDepartmentName()%>
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
                                        <button class="btn btn-primary btn-sm" type="submit">确定</button>
                                    </div>
                                </div>
                            </form>
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
</div>


<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/area.js"></script>

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

<script>
    $('#warehousePhone').bind('input propertychange', function () {
        var r = /^\+?[0-9][0-9]*$/;　　//正整数
        if ($(this).val().length > 0 && !r.test($(this).val())) {
            document.getElementById("warehousePhoneDiv").className = "form-group row has-error";
            $('#warehousePhoneResult').html('电话号码为纯数字');
        } else {
            if ((11 - $(this).val().length) !== 0) {
                document.getElementById("warehousePhoneDiv").className = "form-group row has-error";
                $('#warehousePhoneResult').html('电话号码为11位');
            } else {
                document.getElementById("warehousePhoneDiv").className = "form-group row has-success";
                $('#warehousePhoneResult').html('输入格式正确');
            }
        }
    });
    $('#warehouseName').bind('input propertychange', function () {
        var pattern = new RegExp("[\u4E00-\u9FA5]+");
        if (!pattern.test($(this).val())) {
            document.getElementById("warehouseNameDiv").className = "form-group row has-error";
            $('#warehouseNameResult').html('姓名为中文');
        } else {
            if ((11 - $(this).val().length) >= 4) {
                document.getElementById("warehouseNameDiv").className = "form-group row has-success";
                $('#warehouseNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
            } else if ((11 - $(this).val().length) >= 0) {
                document.getElementById("warehouseNameDiv").className = "form-group row has-warning";
                $('#warehouseNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
            } else {
                document.getElementById("warehouseNameDiv").className = "form-group row has-error";
                $('#warehouseNameResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
            }
        }
    });
    $('#warehouseDetailedAddress').bind('input propertychange', function () {
        if ((11 - $(this).val().length) >= 4) {
            document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-success";
            $('#warehouseDetailedAddressResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
        } else if ((11 - $(this).val().length) >= 0) {
            document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-warning";
            $('#warehouseDetailedAddressResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
        } else {
            document.getElementById("warehouseDetailedAddressDiv").className = "form-group row has-error";
            $('#warehouseDetailedAddressResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
        }
    });
</script>
</body>
</html>



