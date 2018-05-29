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
        <h3 id="ciao" >Autori</h3>
        <ul>
            <c:forEach var="a" items="${authors}">
                <li><a href="notizie.html?author=${a.getId()}">${a.getName()} ${a.getSurname()}</a></li>
            </c:forEach>
        </ul>
    </div>
</aside>