<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="cn.edu.zjut.po.ShopManager" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>店铺商家查询</h1>
<table>
    <tr>
        <td>注册店铺商家编号</td>
        <td>账号</td>
        <td>密码</td>
        <td>名字</td>
        <td>所属店铺</td>
        <td>身份证号</td>
    </tr>

    <s:iterator value="shopManagerList">
        <tr>
            <td><s:property value="shopId"/></td>
            <td><s:property value="shopManagerId"/></td>
            <td><s:property value="shopManagerAccount"/></td>
            <td><s:property value="shopManagerPassword"/></td>
            <td><s:property value="shopManagerName"/></td>
            <td><s:property value="idCardNumber"/></td>
        </tr>
    </s:iterator>
</table>

</body>
</html>

