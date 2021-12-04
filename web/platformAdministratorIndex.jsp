<%@ page import="cn.edu.zjut.po.ShopManager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rainbow
  Date: 2021/12/3
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
    <title>平台运营人员主页-简单版</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="UTF-8"/>
</head>
<body>


<%--平台运营人员对商家或者企业进行注册--%>
<h1>注册店铺商家</h1>
<s:form action="registerShopmanager" method="post" >
    <s:textfield name="shopManager.shopManagerAccount" label="账号"/>
    <s:password name="shopManager.shopManagerPassword" label="密码"/>
    <s:textfield name="shopManager.shopManagerName" label="名字"/>
    <s:textfield name="shopManager.shopId" label="所属店铺"/>
    <s:textfield name="shopManager.idCardNumber" label="身份证号"/>
    <s:submit label="提交" value="提交"/>
    <s:reset label="重置" value="重置"/>
</s:form>

<s:form action="displayShopmanager" method="POST">
    <s:submit label="提交" value="查看店铺商家信息"/>
</s:form>

<h1>注册企业</h1>
<s:form action="registerEnterpriseagency" method="post">
    <s:textfield name="enterpriseAgency.enterpriseAgencyAccount" label="账号"/>
    <s:password name="enterpriseAgency.enterpriseAgencyPassword" label="密码"/>
    <s:textfield name="enterpriseAgency.enterpriseAgencyName" label="名字"/>
    <s:textfield name="enterpriseAgency.enterpriseId" label="企业编号"/>
    <s:textfield name="enterpriseAgency.idCardNumber" label="身份证号"/>
     <s:textfield name="enterpriseAgency.enterpriseAgencyRight" label="权限"/>
    <s:submit label="提交" value="提交"/>
    <s:reset label="重置" value="重置"/>
</s:form>

<s:form action="displayEnterpriseagency" method="POST">
    <s:submit label="提交" value="查看企业信息"/>
</s:form>

</body>

</html>
