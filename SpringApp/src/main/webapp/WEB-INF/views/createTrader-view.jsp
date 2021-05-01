<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
    <title align="center">Add trader</title>
</head>
<body>
<h2 align="center">Add trader</h2>
<br>

<div align="center">
    <form:form method="post">
        <table>
            <tr>
                <td>Title:</td>
                <td><input path="title" name="title"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input path="description" name="description"/></td>
            </tr>
            <tr>
                <td>Comment message:</td>
                <td><input name="message"/></td>
            </tr>

            <td colspan="3" ><input type="submit" value="Submit"/></td>
        </table>

    </form:form>

</div>
</body>
</html>
