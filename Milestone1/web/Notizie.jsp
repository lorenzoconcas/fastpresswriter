<%-- 
    Document   : Notizie
    Created on : 3-mag-2018, 22.33.53
    Author     : lorec
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="res/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/posts.css" media="screen"/>
        <link rel="shortcut icon" href="res/css/logo_old.png" type="image/x-icon" />
        <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="fast,press,writer">
        <meta name="viewport" content="width:device-width, target-densityDpi=device-dpi">
    </head>


    <jsp:include page="res/fixed_code/header.jsp" />   
    <jsp:include page="res/fixed_code/categories.jsp"/>
    <jsp:include page="res/fixed_code/authors.jsp"/>
    <div id="content">
        <c:if test="${categorySearchedName != null}">   
            <h1>Categoria : ${categorySearchedName}</h1>
        </c:if>
        <c:if test="${emptyCategory == true}">   
            <h1>Nessun articolo in questa categoria</h1>
        </c:if>
        <c:if test="${authorResult == true}">   
            <h1>Articoli scritti da ${authNameSurname}</h1>
        </c:if>
        <c:forEach var="Notizia" items="${newsList}">
            <div id="post">
                <a href="notizia.html?nid=${Notizia.getId()}">
                    <!--icona utente, nome utente-->
                    <img id="post_user_icon" src="<c:url value="${Notizia.getAuthor().getImgUrl()}"/>" alt=""/>
                    <label id="post_author">${Notizia.getAuthor().getName()} ${Notizia.getAuthor().getSurname()}</label>
                    <br/>
                    <!--Immagine articolo, titolo articolo e link ad esso-->
                    <img id="news_pic" src="<c:url value="${Notizia.getImageUrl()}"/>" alt="immagine"/>
                    <br/>
                    <label id="post_title">${Notizia.getTitle()}</label>
                    <br/>
                    <label id="post_content">${Notizia.getContentPreview()}</label>
                    <br/>
                    <label id="post_category">Scritto il ${Notizia.getDate()} <br/> Categorie : ${Notizia.getCategory()}</label>
                    <br/>
                    <a id="post_open" href="NewsDetails?id=${Notizia.getId()}">Apri Articolo</a>
                    <br/>
                </a>
            </div>
            <br/>
        </c:forEach>
    </div>
    <br/>
</html>
