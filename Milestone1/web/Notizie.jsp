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
        <jsp:include page="res/fixed_code/head.jsp" /> 
        <link rel="stylesheet" type="text/css" href="res/css/posts.css" media="screen"/>
    </head>

    <body>
      
        <jsp:include page="res/fixed_code/header.jsp" />   
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        <jsp:include page="res/fixed_code/SearchBox.jsp" /> 
        <div id="content">
              
            
            
            <c:if test="${authorResult == true}">   
                <h1>Articoli scritti da ${authNameSurname}</h1>
            </c:if>
            <c:if test="${categorySearchedName != null}">   
                <h1>Categoria : ${categorySearchedName}</h1>
            </c:if>
            <c:if test="${emptyCategory == true}">   
                <h1>Nessun articolo disponibile</h1>
            </c:if>
           
            <c:forEach var="Notizia" items="${newsList}">
                <div class="post">
                    <a href="notizia.html?nid=${Notizia.getId()}">
                        <!--icona utente, nome utente-->
                        <img class="post_user_icon" src="<c:url value="${Notizia.getAuthor().getImgUrl()}"/>" alt=""/>
                        <label class="post_author">${Notizia.getAuthor().getName()} ${Notizia.getAuthor().getSurname()}</label>
                        <br/>
                        <!--Immagine articolo, titolo articolo e link ad esso-->
                        <img class="news_pic" src="<c:url value="${Notizia.getImageUrl()}"/>" alt="immagine"/>
                        <br/>
                        <label class="post_title">${Notizia.getTitle()}</label>
                        <br/>
                        <label class="post_content">${Notizia.getContentPreview()}</label>
                        <br/>
                        <label class="post_category">Scritto il ${Notizia.getDate()} <br/> Categorie : ${Notizia.getCategory()}</label>
                        <br/>
                        <a class="post_open" href="notizia.html?nid=${Notizia.getId()}">Apri Articolo</a>
                        <br/>
                    </a>
                </div>
                <br/>
            </c:forEach>
        </div>
        <br/>
    </body>
</html>
