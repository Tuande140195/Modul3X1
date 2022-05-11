<%--
  Created by IntelliJ IDEA.
  User: TUAN
  Date: 5/9/2022
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h1>Update product</h1>
<a href=" ${pageContext.request.contextPath}/product?action=list">Back to List</a>
<form action="${pageContext.request.contextPath}/product" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td>${product.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity" value="${product.quantity}" ></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type="text" name="color" value="${product.color}"></td>
        </tr>
        <tr>
            <td>Describe</td>
            <td><input type="text" name="describe" value="${product.describe}"></td>
        </tr>
        <tr>
            <td>Menu</td>
            <td>
                        <input type="radio" name="menu" value="Iphone" ${product.menu}>Iphone
                        <input type="radio" name="menu" value="Samsung" ${product.menu}>Samsung
                        <input type="radio" name="menu" value="Oppo" ${product.menu}>Oppo
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
        <input type="hidden" name="action" value="update"/>
        <input type="hidden" name="id" value="${product.id}"/>
    </table>
</form>
</body>
</html>
