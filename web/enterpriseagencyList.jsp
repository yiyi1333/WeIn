<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.ShopManager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>企业查询</h1>
<table>
    <tr>
        <td>商家编号</td>
        <td>账号</td>
        <td>密码</td>
        <td>权限</td>
        <td>名字</td>
        <td>身份证号</td>
        <td>所属企业</td>
    </tr>

    <s:iterator value="enterpriseagencyList">
        <tr>
            <td><s:property value="enterpriseAgencyId"/></td>
            <td><s:property value="enterpriseAgencyAccount"/></td>
            <td><s:property value="enterpriseAgencyPassword"/></td>
            <td><s:property value="enterpriseAgencyRight"/></td>
            <td><s:property value="enterpriseAgencyName"/></td>
            <td><s:property value="idCardNumber"/></td>
            <td><s:property value="enterpriseId"/></td>
        </tr>
    </s:iterator>
</table>

</body>
</html>


