<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Hello User</title>
</head>
<body>
<div align="center">
 <h2>Hello User</h2>

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
   <th>Update</th>
  </tr>
   <form:form commandName="trader" action="${pageContext.request.contextPath}/trader/update/${trader.traderId}">
    <tr>
     <td><input name="traderId" value="${trader.traderId}" /></td>
     <td><input name="title" value="${trader.title}" /></td>
     <td><input name="description" value="${trader.description}" /></td>
     <td><input name="firstName" value="${trader.user.firstName}" /></td>
     <td><input name="lastName" value="${trader.user.lastName}" /></td>
     <td><input name="email" value="${trader.user.email}" /></td>
     <td>${trader.user.createdDate}</td>
     <td>${trader.user.status}</td>
     <td><input type="submit" value="Update"/></td>
    </tr>
   </form:form>
 </table>
</div>

<br>
<br>
<table border="1" cellpadding="5" align="center">
 <tr>
  <th>CommentID</th>
  <th>Message</th>
  <th>TraderId</th>
  <th>CreatedDate</th>
  <th>Status</th>
 </tr>
 <c:forEach var="comment" items="${listComment}" >
  <tr>
   <td><c:out value="${comment.commentId}" /></td>
   <td><c:out value="${comment.message}" /></td>
   <td><c:out value="${comment.trader.traderId}" /></td>
   <td><c:out value="${comment.createdDate}" /></td>
   <td><c:out value="${comment.status}" /></td>
  </tr>
 </c:forEach>

</table>
</body>
</html>