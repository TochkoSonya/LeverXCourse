<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <title align="center">Create new user-trader</title>
</head>
<body>
<h2 align="center">Add new user-trader</h2>
<br>

<div align="center">
    <form:form method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input path="firstName" name="firstName"/></td>
            </tr>
            <tr>
                <td>LastName</td>
                <td><input path="lastName" name="lastName"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input path="password" name="password"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input path="email" name="email"/></td>
            </tr>
            <tr>
                <td>CreatedDate:</td>
                <td><input path="createdDate" name="createdDate"/></td>
            </tr>
            <tr>
                <td>TraderTitle:</td>
                <td><input path="trader.title"  name="title"/></td>
            </tr>
            <tr>
                <td>TraderDescription:</td>
                <td><input path="trader.description" name="description"/></td>
            </tr>
            <td colspan="3" ><input type="submit" value="Submit"/></td>
        </table>

    </form:form>

</div>
</body>
</html>
