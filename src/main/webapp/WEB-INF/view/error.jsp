<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isErrorPage="true"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="uk_UA"/>
<fmt:setBundle basename="messages"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="message.error"/></title>
    </head>
    <body>
        <h2>
           <fmt:message key="message.something.went.wrong"/>
           <br>
           <i><fmt:message key="message.error.description"/><%= exception %></i>
        </h2>
        <br>
        <a href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="message.homepage"/></a>
    </body>
</html>
