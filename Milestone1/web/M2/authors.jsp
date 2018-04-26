<%-- 
    Document   : categories
    Created on : 24-apr-2018, 22.04.12
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <aside id="aside_right">
    <div class="aside_content_auth">
        <h3>Autori</h3>
        <ul>
            <c:forEach var="a" items="${autori}">
                <a  href="ViewProfile?id=${a.getId()}"><li>${a.getName()} ${a.getSurname()}</li></a>
            </c:forEach>
        </ul>
    </div>
</aside>