<%-- 
    Document   : header
    Created on : 24-apr-2018, 14.26.15
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="header"> 
    
    <!--Tasto cerca-->
  
    <a id="search_button" href="#" onClick="showSearch()" ><img id="search_image" src="res/site_resources/search_icon.png" alt="Cerca"/></a>
     
    <input id="querybox" onKeyPress="return runScript(event)" name="query" type="text" placeholder="Cerca nel sito...">
    <!--Logo-->
    <a id="home_logo" href="notizie.html">Fast Press Writer</a>
  
        <a class="navbar_buttons" href="notizie.html">Home</a>
        <c:if test="${loggedIn == null || loggedIn == false}">
            <a class="navbar_buttons" href="login.html">Login</a>
        </c:if>
        <c:if test="${isAuthor == true}">
            <a class="navbar_buttons" href="articoli.html">Articoli</a>
        </c:if>     
  

    <!--Nome utente-->
    <c:if test="${loggedIn == true}">
        <c:if test="${user.getIsAuthor() == true}">
             <a class="navbar_buttons" href="scriviArticolo.html">Nuovo Articolo</a>
        </c:if>
        <aside id="user">
            <a id="header_user_profile" href="profilo.html">${user.getName()} ${user.getSurname()}</a> 
            <a id="logout" name="logout" href="login.html?logout=true">Esci</a>
            <img id="header_user_icon" src="<c:url value="${user.getImgUrl()}"/>" alt="Immagine Utente"/>
        </aside>              
    </c:if>
    


</header>
