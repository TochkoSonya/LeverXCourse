<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SpringApplication</title>
</head>
<body>
<h1 align="center">Main Page</h1>
<div>     <a href="${pageContext.request.contextPath}/authorization">Authorization</a> </div>
<br>
<div>     <a href="${pageContext.request.contextPath}/user/registration">Registration User (Trader)</a> </div>
<br>
<div>     <a href="${pageContext.request.contextPath}/trader/registration">Add Trader (with comment)</a> </div>

        <table border="1" cellpadding="5" align="center">
            <tr>
                <th>TraderId</th>
                <th>Title</th>
                <th>Description</th>
                <th>List comments</th>
            </tr>
            <c:forEach var="trader" items="${listTrader}" >
                <tr>
                    <td><c:out value="${trader.traderId}" /></td>
                    <td><c:out value="${trader.title}" /></td>
                    <td><c:out value="${trader.description}" /></td>
                    <td><a href="${pageContext.request.contextPath}/comment/${trader.traderId}/comments">Comments</a></td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>