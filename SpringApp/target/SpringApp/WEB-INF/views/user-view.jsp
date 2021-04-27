<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>User Manager</title>
</head>
<body>
<div align="center">
 <h2>User Manager</h2>
 <form method="get" action="search">
  <input type="text" name="keyword" />
  <input type="submit" value="Search" />
 </form>
 <h3><a href="/new">New User</a></h3>
 <table border="1" cellpadding="5">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>E-mail</th>
   <th>Address</th>
   <th>Action</th>
  </tr>
  <c:forEach var="user" items="${listUser}" >
   <tr>
    <td><c:out value="${user.traderId}" /></td>
    <td><c:out value="${user.title}" /></td>
    <td><c:out value="${user.description}" /></td>
    <td><c:out value="${user.user.firstName}" /></td>
    <td><c:out value="${user.user.lastName}" /></td>

<%--    <td>--%>
<%--     <a href="/edit?id=${user.traderId}">Edit</a>--%>

<%--     <a href="/delete?id=${user.traderId}">Delete</a>--%>
<%--    </td>--%>
   </tr>
  </c:forEach>
 </table>
</div>
</body>
</html>