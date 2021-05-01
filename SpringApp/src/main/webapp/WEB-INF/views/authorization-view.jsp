<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Authorization and registration page</title>
</head>
<br>
<br>
<div align="center">
    <form:form method="post">
        <table>
            <tr>
            <td>Email</td>
            <td><input path="email" name="email"/></td>
        </tr>
            <tr>
                <td>Password:</td>
                <td><input name="password"/></td>
            </tr>
            <td colspan="3" ><input type="submit" value="Sign in" align="center"/></td>
        </table>
    </form:form>
    <br>
</div>
</body>
</html>
