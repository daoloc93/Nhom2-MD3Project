<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Author</th>
            <th>Price</th>
            <th>Image</th>
            <th>Release Date</th>
            <th>Note</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.category}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.price}"/></td>
                <td><c:out value="${book.image}"/></td>
                <td><c:out value="${book.releaseDate}"/></td>
                <td><c:out value="${book.note}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button><a href="/users?action=findUser">Find User</a></button>
</div>
</body>
</html>