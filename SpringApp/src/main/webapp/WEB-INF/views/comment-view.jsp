<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Comment-view</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>CommentID</th>
        <th>Message</th>
        <th>TraderId</th>
        <th>CreatedDate</th>
        <th>Status</th>
    </tr>
    <c:forEach var="comment" items="${listComments}" >
        <tr>
            <td><c:out value="${comment.commentId}" /></td>
            <td><c:out value="${comment.message}" /></td>
            <td><c:out value="${comment.trader.traderId}" /></td>
            <td><c:out value="${comment.createdDate}" /></td>
            <td><c:out value="${comment.status}" /></td>
        </tr>
    </c:forEach>

</table>
<br>
<br>
    <div align="center">
        <h3>Add comment</h3>
        <form:form method="post">
            <table>
                <tr>
                    <td>Message:</td>
                    <td><input path="title" name="message"/></td>
                </tr>
                <td colspan="3" ><input type="submit" value="Submit" align="center"/></td>
            </table>

        </form:form>
    </div>

</body>
</html>
