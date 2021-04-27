<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Comment-view</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>Address</th>
        <th>Action</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="user" items="${listComment}" >
        <tr>
            <td><c:out value="${user.commentId}" /></td>
            <td><c:out value="${user.createdDate}" /></td>
            <td><c:out value="${user.message}" /></td>

            <td><c:out value="${user.trader.traderId}" /></td>
            <td><c:out value="${user.trader.title}" /></td>
            <td><c:out value="${user.trader.description}" /></td>

<%--            <td>--%>
<%--                <a href="/edit?id=${user.commentId}">Edit</a>--%>

<%--                <a href="/delete?id=${user.commentId}">Delete</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
