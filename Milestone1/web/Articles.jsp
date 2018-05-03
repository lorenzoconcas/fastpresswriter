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
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/PersonalArticles.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
    </head>


    <jsp:include page="M2/header.jsp" />   
    <jsp:include page="M2/categories.jsp"/>
    <jsp:include page="M2/authors.jsp"/>
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
                <c:forEach var="Notizia" items="${Notizie}">   
                    <tr>
                        <td>${Notizia.getDate()}</td>
                        <td><a href="NewsDetails?id=${Notizia.getId()}">${Notizia.getTitolo()}</a></td>
                        <td><a href="NewsDetails?id=${Notizia.getId()}"><img id="edit_button" src="M2/edit.png" alt="Modifica${Notizia.getTitolo()}"></a></td>
                        <td><a href="NewsDetails?id=${Notizia.getId()}"><img id="delete_button" src="M2/delete.png" alt="Modifica${Notizia.getTitolo()}"></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href="NewArticle"><button id="new_article_button" >Crea un nuovo articolo</button></a>   
    </div>
    <br/>
</html>
