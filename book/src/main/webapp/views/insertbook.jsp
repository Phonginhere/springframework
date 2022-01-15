<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h2>Insert new book</h2>
    <form method="post" action="/book/insertconfirmed">
        <p><b>Title</b></p> <input type="text" name="title">
        <p><b>Category</b></p>
        <select name='idCate'>
            <c:forEach items="${categories}" var="category">
                <option value="${category.getCategoryID()}">${category.getCategoryName()}</option>
            </c:forEach>
        </select>
        <p><b>Price</b></p> <input type="number" name="price">
        <input type="submit" value="insert">
    </form>
   
</body>

</html>