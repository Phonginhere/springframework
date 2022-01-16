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
    <h1>List All Books</h1>
    <table>
        <tr>
            <th>Book Id</th>
            <th>Title</th>
            <th>Category</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="i" items="${booklist2}">
            <tr>
                <td>${i.getBookID()}</td>
                <td>${i.getTitle()}</td>
                <td>${i.getCategoryName()}</td>
                <td>${i.getPrice()}</td>
                <td><a href="/book/bookDeleteConfirm?bookId=${i.getBookID()}">Delete</a></td>
            </tr>
            </c:forEach>

    </table>
    <a href="/book/welcome">Return to welcome page</a></td>
</body>
</html>