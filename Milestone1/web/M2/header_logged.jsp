<%-- 
    Document   : header
    Created on : 24-apr-2018, 14.26.15
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="header">
    <!--Tasto cerca-->
    <a id="search_button"><img id="search_image" src="M2/search_icon.png" alt="Cerca"/></a>
   <!--Logo-->
    <a id="home_logo" href="Notizie">Fast Press Writer</a>
    <!--Nome utente-->
    <aside id="user">

        <a id="logout" name="logout" href="Login?logout=true">${user.getName()} - Esci</a>
        <img id="header_user_icon" src="<c:url value="${user.getImgUrl()}"/>" alt="Immagine Utente"/>
        
    </aside>
    
    <!--Tasti di navigazione -->
    <nav class="navbar">     
        <a class="navbar_buttons" href="Notizie">Home</a>
        <a class="navbar_buttons" href="Profilo">Profilo</a>
        <a class="navbar_buttons" href="notImplementedPage.jsp">Articoli</a>
    </nav>
    
    
</header>
