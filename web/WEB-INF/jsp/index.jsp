<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <c:forEach items="${lista}" var="e">
            <span>${e.getIdEvento()}</span><br>
            <span>${e.titolo}</span><br>
            <span>${e.luogo}</span><br>
            <span>${e.data}</span><br>
            <span>${e.categoria}</span><br><br><br>
        </c:forEach>
    </body>
</html>
