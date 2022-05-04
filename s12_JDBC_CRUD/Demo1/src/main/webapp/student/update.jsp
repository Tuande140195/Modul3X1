<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Student</title>
</head>
<body>
    <h1>Create new Student</h1>
    <a href="${pageContext.request.contextPath}/student?action=list">Back to list</a>
    <form action="${pageContext.request.contextPath}/student" method="post">
        <table border="1">
            <tr>
                <td>ID</td>
                <td>${student.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${student.name}"></td>
            </tr>
            <tr>
                <td>Birthday</td>
                <td><input type="text" name="birthday" value="${student.birthDayAsString}"></td>
            </tr>
            <tr>
                <td>Sex</td>
                <td>
                    <c:choose>
                        <c:when test="${student.sex}">
                            <input type="radio" name="sex" value="Nam" checked> Nam
                            <input type="radio" name="sex" value="Nu"> Nữ
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="sex" value="Nam"> Nam
                            <input type="radio" name="sex" value="Nu" checked> Nữ
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="${student.id}" />
    </form>
</body>
</html>
