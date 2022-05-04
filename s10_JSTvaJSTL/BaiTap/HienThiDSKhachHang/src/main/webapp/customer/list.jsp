<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: TUAN
  Date: 4/20/2022
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>List Customer</title>
    <style>
        table{
         border: 0 cornflowerblue;

        }
#a{
    "<hr> "
}
    </style>
</head>
<body>
<table  >
      <h1  > Danh sách khách hàng</h1>

          <tr>
              <th>Tên</th>
              <th>Ngày Sinh</th>
              <th>Địa Chỉ</th>
              <th>Ảnh</th>
          </tr>

    <c:forEach items="${list}" var="customer" >

        <tr id="a" >
           <td>${customer.name}</td>
            <td>
                <fmt:formatDate value="${customer.birthDay}" pattern="yyyy/MM/dd"/>
            </td>
            <td>${customer.addr} </td>
            <td><img src="${customer.img}"></td>

        </tr>
    </c:forEach>
      </table>


</body>
</html>
