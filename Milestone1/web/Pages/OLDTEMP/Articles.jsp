<%-- 
    Document   : PersonalArticles
    Created on : 1-mag-2018, 10.35.17
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
        <link rel="stylesheet" type="text/css" href="res/css/PersonalArticles.css" media="screen"/>
        <link rel="shortcut icon" href="res/css/logo_old.png" type="image/x-icon" />
                   <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="Nuovo,articolo,fast,press,writer">
    </head>


    <jsp:include page="res/fixed_code/header.jsp" />   
    <jsp:include page="res/fixed_code/categories.jsp"/>
    <jsp:include page="res/fixed_code/authors.jsp"/>
    <div id="content">
        <table id="personal_articles_table">
            <thead>
                <tr>
                    <th>Data</th>
                    <th>Titolo</th>
                    <th>Modifica</th>
                    <th>Cancella</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="Notizia" items="${authorNewsList}">   
                    <tr>
                        <td>${Notizia.getDate()}</td>
                        <td><a href="notizia.html?id=${Notizia.getId()}">${Notizia.getTitle()}</a></td>
                        <td><a href="notizia.html?id=${Notizia.getId()}"><img id="edit_button" src="res/site_resources/edit.png" alt="Modifica${Notizia.getTitle()}"></a></td>
                        <td><a href="notizia.html?id=${Notizia.getId()}"><img id="delete_button" src="res/site_resources/delete.png" alt="Modifica${Notizia.getTitle()}"></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href="nuovoArticolo.html"><button id="new_article_button" >Crea un nuovo articolo</button></a>   
    </div>
    <br/>
</html>