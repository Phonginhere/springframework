<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>This is an example</title>
</head>
<body>
    <h1>Product List</h1>
     <table>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Action</th>
        </tr>
        <c:forEach var="i" items="${products}">
            <tr>
                <td>${i.productID}</td>
                <td>${i.productName}</td>
                <td>${i.price}</td>
                <td>${i.description}</td>
                <td><form method="get" action="/product/assignProductToCategoryID/${i.productID}"><input type="submit" value="Add this product to other category"></input></form></td>
            </tr>
        </c:forEach>
      </table>
      <a href="/category">Back to Category</a>
</body>
</html>

