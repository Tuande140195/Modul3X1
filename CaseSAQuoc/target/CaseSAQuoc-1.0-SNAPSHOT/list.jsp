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
     <a href="${pageContext.request.contextPath}/product?action=create">Create new Product</a>
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
               <td>
                   <a href="${pageContext.request.contextPath}/product?action=delete&id=${product.id}">Delete</a>
                   <a href="${pageContext.request.contextPath}/product?action=update&id=${product.id}">Update</a>

               </td>
           </tr>
       </c:forEach>
         <c:if test="message != null">
             <h4>
                ${message}
             </h4>
         </c:if>

     </table>
</body>
</html>
