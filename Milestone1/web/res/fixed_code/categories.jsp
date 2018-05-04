<%-- 
    Document   : categories
    Created on : 24-apr-2018, 22.04.12
    Author     : lorec
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<aside id="aside_left">
    <div class="aside_content_cat">   
        <h3>Categorie</h3>
        <ul>  
            <c:forEach var="cat" items="${categories}">
                 <li><a href="notizie.html?category=${cat}" >${cat}</a></li>
            </c:forEach>
           
        </ul>
    </div>
</aside>
