
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message List</title>
</head>
<body>
<a href="<c:url value="/login.jsp" />">Login</a>
<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
<c:forEach items="${messages}" var="message">
    <table>
        <tr>
            <td>Author</td>
            <td>${message.author}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td>${message.title}</td>
        </tr>
        <tr>
            <td>Body</td>
            <td>${message.body}</td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="messageDelete?messageId=${message.id}">Delete</a>
            </td>
        </tr>
    </table>
    <hr />
</c:forEach>
<a href="messagePost.htm">Post</a>
</body>
</html>
