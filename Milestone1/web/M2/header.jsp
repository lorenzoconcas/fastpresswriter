<%-- 
    Document   : header
    Created on : 24-apr-2018, 14.26.15
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="header"> 
    <!--Tasto cerca-->
    <a id="search_button" href="Search"><img id="search_image" src="M2/search_icon.png" alt="Cerca"/></a>
   <!--Logo-->
    <a id="home_logo" href="notizie.html">Fast Press Writer</a>
    <!--Nome utente-->
        <c:if test="${loggedIn == true}">
            <aside id="user">
                <a id="header_user_profile" href="articoli.html">${user.getName()} ${user.getSurname()}</a> 
                <a id="logout" name="logout" href="login.html?logout=true">Esci</a>
                <img id="header_user_icon" src="<c:url value="${user.getImgUrl()}"/>" alt="Immagine Utente"/>
            </aside>              
        </c:if>
   
    
    <!--Tasti di navigazione -->
    <nav class="navbar">     
        <a class="navbar_buttons" href="notizie.html">Home</a>
        <a class="navbar_buttons" href="profilo.html">Profilo</a>
      
   
    </nav>
</header>
