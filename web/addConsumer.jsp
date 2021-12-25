<%@ page import="cn.edu.zjut.po.EnterpriseDepartment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加企业人员</title>
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
                <h2>添加企业人员</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="showenterpriseuser.action">主页</a>
                    </li>
                    <li class="breadcrumb-item">
                        <a>管理企业人员</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>添加企业人员（用于用户认证）</strong>
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
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <!--addconsumer是添加企业认证-->
                            <%
                                String message = (String) session.getAttribute("message");
                                if(message == null) {}
                                else {
                            %>
                            <div style="margin-left: 100px;color: #c69500 "><%=message%> </div>
                            <%
                            }
                            %>
                            <form action="addconsumer.action">
                                <div class="form-group  row" id="consumerNameDiv">
                                    <label class="col-sm-1 col-form-label">姓名</label>
                                    <div class="col-sm-10">
                                        <input type="text" id="consumerName" class="form-control" name="consumer.name">
                                    </div>
                                    <div id="consumerNameResult" style="margin-left: 100px;"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="consumerIdCardNumberDiv">
                                    <label
                                            class="col-sm-1 col-form-label">身份证号</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="consumerIdCardNumber"
                                               name="consumer.idCardNumber"></div>
                                    <div id="consumerIdCardNumberResult" style="margin-left: 100px;"></div>
                                </div>

                                <div class="hr-line-dashed"></div>


                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="consumerEmailDiv"><label
                                        class="col-sm-1 col-form-label">邮箱地址</label>
                                    <div class="col-sm-10"><input type="text" class="form-control" id="consumerEmail"
                                                                  name="consumer.email"></div>
                                    <div id="consumerEmailResult" style="margin-left: 100px;"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group  row" id="consumerPhoneNumberDiv"><label
                                        class="col-sm-1 col-form-label">手机号</label>
                                    <div class="col-sm-10"><input type="text" class="form-control"
                                                                  id="consumerPhoneNumber"
                                                                  name="consumer.phoneNumber"></div>
                                    <div id="consumerPhoneNumberResult" style="margin-left: 100px;"></div>
                                </div>

                                <div class="hr-line-dashed"></div>
                                <div class="form-group row"><label class="col-sm-1 col-form-label">部门编号</label>

                                    <div class="col-sm-10">

                                        <select class="form-control m-b"
                                                name="consumer.enterpriseDepartmentNumber">

                                            <%
                                                List<EnterpriseDepartment> enterpriseDepartmentList = (List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList");
                                                if ((List<EnterpriseDepartment>) session.getAttribute("enterpriseDepartmentList") == null) {
                                                    session.putValue("enterpriseDepartmentList", new ArrayList<EnterpriseDepartment>());
                                                }
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
                                        <button class="btn btn-primary btn-sm" type="submit">保存更改</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
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

<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js"></script>
<script>
    // consumerEmail
    $('#consumerName').bind('input propertychange', function () {
        var pattern = new RegExp("[\u4E00-\u9FA5]+");
        if (!pattern.test($(this).val())) {
            document.getElementById("consumerNameDiv").className = "form-group row has-error";
            $('#consumerNameResult').html('姓名为中文');
        } else {
            if ((11 - $(this).val().length) >= 4) {
                document.getElementById("consumerNameDiv").className = "form-group row has-success";
                $('#consumerNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
            } else if ((11 - $(this).val().length) >= 0) {
                document.getElementById("consumerNameDiv").className = "form-group row has-warning";
                $('#consumerNameResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
            } else {
                document.getElementById("consumerNameDiv").className = "form-group row has-error";
                $('#consumerNameResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
            }
        }
    });
    $('#consumerIdCardNumber').bind('input propertychange', function () {
        var r = /^\+?[0-9][0-9]*$/;　　//正整数
        if ($(this).val().length > 0 && !r.test($(this).val())) {
            document.getElementById("consumerIdCardNumbereDiv").className = "form-group row has-error";
            $('#consumerIdCardNumberResult').html('电话号码为纯数字');
        } else {
            if ((11 - $(this).val().length) !== 0) {
                document.getElementById("consumerIdCardNumberDiv").className = "form-group row has-error";
                $('#consumerIdCardNumberResult').html('身份证为18位');
            } else {
                document.getElementById("consumerIdCardNumberDiv").className = "form-group row has-success";
                $('#consumerIdCardNumberResult').html('输入格式正确');
            }
        }
    });
    $('#consumerPhoneNumber').bind('input propertychange', function () {
        var r = /^\+?[0-9][0-9]*$/;　　//正整数
        if ($(this).val().length > 0 && !r.test($(this).val())) {
            document.getElementById("consumerPhoneNumberDiv").className = "form-group row has-error";
            $('#consumerPhoneNumberResult').html('电话号码为纯数字');
        } else {
            if ((11 - $(this).val().length) !== 0) {
                document.getElementById("consumerPhoneNumberDiv").className = "form-group row has-error";
                $('#consumerPhoneNumberResult').html('电话号码为11位');
            } else {
                document.getElementById("consumerPhoneNumberDiv").className = "form-group row has-success";
                $('#consumerPhoneNumberResult').html('输入格式正确');
            }
        }
    });

    $('#consumerPassword').bind('input propertychange', function () {
        if ((11 - $(this).val().length) >= 4) {
            document.getElementById("consumerPasswordDiv").className = "form-group row has-success";
            $('#consumerPasswordResult').html('还剩 ' + (20 - $(this).val().length) + ' 字，请放心输入');
        } else if ((11 - $(this).val().length) >= 0) {
            document.getElementById("consumerPasswordDiv").className = "form-group row has-warning";
            $('#consumerPasswordResult').html('还剩 ' + (20 - $(this).val().length) + ' 字,请注意');
        } else {
            document.getElementById("consumerPasswordDiv").className = "form-group row has-error";
            $('#consumerPasswordResult').html('您已超出 ' + ($(this).val().length - 20) + ' 字');
        }
    });

    $('#consumerEmail').bind('input propertychange', function () {
        var emailPat = /^(.+)@(.+)$/;
        var matchArray = $(this).val().match(emailPat);
        if (matchArray == null) {
            document.getElementById("consumerEmailDiv").className = "form-group row has-success";
            $('#consumerEmailResult').html('电子邮件地址必须包括 ( @ 和 . )');
        } else {
            document.getElementById("consumerEmailDiv").className = "form-group row has-success";
            $('#consumerEmailResult').html('电子邮件地址格式正确');
        }
    });

</script>
</body>

</html>

