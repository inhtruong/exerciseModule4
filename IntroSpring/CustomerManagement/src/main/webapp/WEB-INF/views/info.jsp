<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/13/2021
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%@ page import="com.codegym.service.CustomerService" %>--%>
<%--<%@ page import="com.codegym.service.CustomerServiceFactory" %>--%>
<%--<%@ page import="com.codegym.model.Customer" %>--%>
<%--<%!--%>
<%--    private CustomerService customerService = CustomerServiceFactory.getInstance();--%>
<%--%>--%>
<%--<%--%>
<%--    Long id = Long.valueOf(request.getParameter("id"));--%>
<%--    Customer customer = customerService.findOne(id);--%>
<%--%>--%>
<form action="/customers" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.getId()}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.getId()}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.getName()}">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="text" name="email" value="${customer.getEmail()}">
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <input type="text" name="address" value="${customer.getAddress()}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers">Back to list</a>.
</body>
</html>
