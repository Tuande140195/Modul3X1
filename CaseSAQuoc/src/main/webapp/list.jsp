<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
     <h1>Product List</h1>
     <table border="1">
         <tr>
             <th>STT</th>
             <th>ID</th>
             <th>Name</th>
             <th>Price</th>
             <th>Quantity</th>
             <th>Color</th>
             <th>Describe</th>
             <th>Menu</th>
         </tr>
       <c:forEach items="${list}" var="product" varStatus="index" >
           <tr>
               <td>${index.index}</td>
               <td>${product.id}</td>
               <td>${product.name}</td>
               <td>${product.price}</td>
               <td>${product.quantity}</td>
               <td>${product.color}</td>
               <td>${product.describe}</td>
               <td>${product.menu}</td>

           </tr>
       </c:forEach>
     </table>
</body>
</html>
