<%-- 
    Document   : ViewProfile
    Created on : 25-apr-2018, 19.43.02
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${target.getName()} ${target.getSurname()} - Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/Profiles.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/posts.css" media="screen"/>

    </head>
    <body>

        <jsp:include page="M2/header.jsp" />   
        <jsp:include page="M2/categories.jsp"/>
        <jsp:include page="M2/authors.jsp"/>
        <div id="content">
            <div id="profile_section">

                <img id="profile_pic" src="<c:url value="${target.getImgUrl()}"/>" alt="Immagine Profilo" />
                <h4 id="user_name">${target.getName()} ${target.getSurname()}</h4>

                <c:if test="${authWroteArticles == true}">  
                    <h5>Articoli scritti da ${target.getName()}  ${target.getSurname()}</h5>
                    <c:forEach var="Notizia" items="${listaNews}">
                        <div id="post">
                            <a href="NewsDetails?id=${Notizia.getId()}">
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
                                <label id="post_category">Categorie : ${Notizia.getCategoria()}</label>
                                <br/>
                                <a id="post_open" href="NewsDetails?id=${Notizia.getId()}">Apri Articolo</a>
                                <br/>
                            </a>
                        </div>
                        <br/>
                    </c:forEach>
                </c:if>
            </div>
        </div>

    </body>
</html>
