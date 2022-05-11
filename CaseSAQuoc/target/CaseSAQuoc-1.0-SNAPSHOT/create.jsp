
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h1> Cretate new Product</h1>
<a href=" ${pageContext.request.contextPath}/product?action=list">Back to List</a>
<form action="${pageContext.request.contextPath}/product" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input type="text" name="color"></td>
        </tr>
        <tr>
            <td>Describe</td>
            <td><input type="text" name="describe"></td>
        </tr>
        <tr>
            <td>Menu</td>
            <td>
            <input type="radio" name="menu" value="Iphone">Iphone
            <input type="radio" name="menu" value="Samsung">Samsung
            <input type="radio" name="menu" value="Oppo">Oppo
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="register">
            </td>
        </tr>
        <input type="hidden" name="action" value="create"/>
    </table>
</form>
</body>
</html>
