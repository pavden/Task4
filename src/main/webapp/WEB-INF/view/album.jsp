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
        <form action="/Soundtracks/Album" method="get">
            <button type="submit" name="command" value="ShuffleAlbum"><fmt:message key="message.shuffle.album"/></button>
            <button type="submit" name="command" value="ShowAlbumDuration"><fmt:message key="message.show.album.duration"/></button>
            <button type="submit" name="command" value="SortAlbumByGenre"><fmt:message key="message.sort.album.by.genre"/></button>
            <button type="submit" name="command" value="ClearAlbum"><fmt:message key="message.clear.album"/></button>
        </form>
        <form action="/Soundtracks/Album" method="post">
            <label><fmt:message key="message.track.duration"/><input type="number" name="min" style="width:5em" value="240" min="0" step="60"></label>
            <label> - <input type="number" name="max" style="width:5em" value="360" min="0" step="60"></label>
            <button type="submit" name="command" value="SearchTracksByDuration"><fmt:message key="message.search.tracks.by.duration"/></button>
        </form>
        <c:if test="${not empty duration}">
            <p><b><fmt:message key="message.album.duration"/>${duration}</b></p>
        </c:if>
        <c:if test="${not empty searchresults}">
            <table cellspacing="2" cellpadding="5" border="2">
                <caption><fmt:message key="message.search.results"/></caption>
                <tr>
                    <th><fmt:message key="message.id"/></th>
                    <th><fmt:message key="message.name"/></th>
                    <th><fmt:message key="message.performer"/></th>
                    <th><fmt:message key="message.genre"/></th>
                    <th><fmt:message key="message.duration"/></th>
                </tr>
                <c:forEach var="track" items="${searchresults}">
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
        <c:if test="${not empty album}">
            <table cellspacing="2" cellpadding="5" border="2">
                <caption><fmt:message key="message.album"/></caption>
                <tr>
                    <th><fmt:message key="message.id"/></th>
                    <th><fmt:message key="message.name"/></th>
                    <th><fmt:message key="message.performer"/></th>
                    <th><fmt:message key="message.genre"/></th>
                    <th><fmt:message key="message.duration"/></th>
                </tr>
                <c:forEach var="track" items="${album}">
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
        <form action="/Soundtracks/Tracklist" method="get">
            <button type="submit" name="command" value="ShowTracklist"><fmt:message key="message.show.tracklist"/></button>
        </form>
    </body>
</html>
