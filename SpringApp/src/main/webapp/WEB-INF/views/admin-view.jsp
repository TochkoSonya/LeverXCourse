<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>

<h3 align="center">Hello admin</h3>
<br>
<h4 align="center">Trader-User table</h4>

    <table border="1" cellpadding="5" align="center">
        <tr>
            <th>TraderId</th>
            <th>Title</th>
            <th>Description</th>
            <th>User firstName</th>
            <th>User lastName</th>
            <th>User email</th>
            <th>User createdDate</th>
            <th>User status (active/inactive)</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
       <c:forEach var="trader" items="${listTrader}" >
        <form:form action="${pageContext.request.contextPath}/trader/updateStatus/${trader.traderId}">
            <tr>
                <td >${trader.traderId}</td>
                <td>${trader.title}</td>
                <td>${trader.description}</td>
                <td>${trader.user.firstName}</td>
                <td>${trader.user.lastName}</td>
                <td>${trader.user.email}</td>
                <td>${trader.user.createdDate}</td>
                <td><input type="text" name="traderStatus" value="${trader.user.status}"/></td>
                <td><a href="${pageContext.request.contextPath}/trader/delete/${trader.traderId}">Delete</a></td>
                <td><input type="submit" value="Update"/></td>
            </tr>
        </form:form>
        </c:forEach>
    </table>
<br>
<br>
<h4 align="center">Comment table</h4>
<table  border="1" cellpadding="5" align="center">
    <tr>
        <th>CommentId</th>
        <th>Message</th>
        <th>CreatedDate</th>
        <th>TraderId</th>
        <th>Trader title</th>
        <th>Comment status</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <c:forEach var="comment" items="${listComment}" >
        <form:form action="${pageContext.request.contextPath}/comment/update/${comment.commentId}">
        <tr>
            <td><c:out value="${comment.commentId}" /></td>
            <td><c:out value="${comment.message}" /></td>
            <td><c:out value="${comment.createdDate}" /></td>
            <td><c:out value="${comment.trader.traderId}" /></td>
            <td><c:out value="${comment.trader.title}" /></td>
            <td><input type="text" name="commentStatus" value="${comment.status}"/></td>
            <td><a href="${pageContext.request.contextPath}/comment/delete/${comment.commentId}">Delete</a></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
        </form:form>
    </c:forEach>
</table>
</body>
</html>
