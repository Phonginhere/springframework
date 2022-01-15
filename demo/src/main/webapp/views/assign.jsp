<%-- Document : assign.jsp Created on : Nov 30, 2021, 7:27:54 AM Author : Phong_learning --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
            </head>

            <body>
                <h1>Do you want to assign product ${nameProduct} to other category!</h1>
                <form method="post" action="/category/updateCustomerContacts">
                     <input type="hidden" name="idProduct" value="${idProduct}">

                    <p>${nameCategories}</p>
                    <select name='idCate'>
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.getCategoryID()}">${category.getCategoryName()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Submit">
                </form>

            </body>

            </html>