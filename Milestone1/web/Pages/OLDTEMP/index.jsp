<%-- 
    Document   : index
    Created on : 24-apr-2018, 17.57.20
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- non viene utilizzato <base href> perch0è va in conflitto con la ricerca delle varie jsp-->
        <title>Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="res/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/posts.css" media="screen"/>
        <link rel="shortcut icon" href="res/css/logo_old.png" type="image/x-icon" />
                  <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="fast,press,writer">
    </head>


    <jsp:include page="res/fixed_code/header.jsp" />   
    <jsp:include page="res/fixed_code/categories.jsp"/>
    <jsp:include page="res/fixed_code/authors.jsp"/>
    <div id="content">
        <c:forEach var="Notizia" items="${listaNews}">
            <div id="post">
                <a href="notizia.html?id=${Notizia.getId()}">
                    <!--icona utente, nome utente-->
                    <img id="post_user_icon" src="<c:url value="${Notizia.getAutore().getImgUrl()}"/>" alt=""/>
                    <label id="post_author">${Notizia.getAutore().getName()} ${Notizia.getAutore().getSurname()}</label>
                    <br/>
                    <!--Immagine articolo, titolo articolo e link ad esso-->
                    <img id="news_pic" src="<c:url value="${Notizia.getImg()}"/>" alt="immagine"/>
                    <br/>
                    <label id="post_title">${Notizia.getTitolo()}</label>
                    <br/>
                    <label id="post_content">${Notizia.getContentPreview()}</label>
                    <br/>
                    <label id="post_category">Scritto il ${Notizia.getDate()} - Categorie : ${Notizia.getCategoria()}</label>
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
