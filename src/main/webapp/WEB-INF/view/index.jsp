<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="uk_UA"/>
<fmt:setBundle basename="messages"/>

<html>
    <body>
        <h2>
            <fmt:message key="message.welcome"/>
        </h2>
        <br>
        <form action="/Soundtracks/Tracklist" method="get">
            <button type="submit" name="command" value="LoadTracklist"><fmt:message key="message.load.tracklist"/></button>
            <button type="submit" name="command" value="ShuffleTracklist"><fmt:message key="message.shuffle.tracklist"/></button>
            <button type="submit" name="command" value="ClearTracklist"><fmt:message key="message.clear.tracklist"/></button>
        </form>
        <form action="/Soundtracks/Album" method="post">
            <label><fmt:message key="message.album.capacity"/><input type="number" name="capacity" style="width:5em" value="2400" min="0" step="60"></label>
            <button type="submit" name="command" value="MakeAlbum"><fmt:message key="message.make.album"/></button>
        </form>
        <c:if test="${not empty tracklist}">
            <table cellspacing="2" cellpadding="5" border="2">
                <caption><fmt:message key="message.tracklist"/></caption>
                <tr>
                    <th><fmt:message key="message.id"/></th>
                    <th><fmt:message key="message.name"/></th>
                    <th><fmt:message key="message.performer"/></th>
                    <th><fmt:message key="message.genre"/></th>
                    <th><fmt:message key="message.duration"/></th>
                </tr>
                <c:forEach var="track" items="${tracklist}">
                    <tr>
                        <td>${track.id}</td>
                        <td>${track.name}</td>
                        <td>${track.performer}</td>
                        <td>${track.genre.name}</td>
                        <td>${track.duration}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>
        <form action="/Soundtracks/Album" method="get">
            <button type="submit" name="command" value="ShowAlbum"><fmt:message key="message.show.album"/></button>
        </form>
    </body>
</html>
