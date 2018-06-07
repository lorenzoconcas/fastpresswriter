<%-- 
    Document   : Articles
    Created on : 4-mag-2018, 0.49.22
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- non viene utilizzato <base href> perch0è va in conflitto con la ricerca delle varie jsp-->  
        <jsp:include page="res/fixed_code/head.jsp" />        
        <link rel="stylesheet" type="text/css" href="res/css/PersonalArticles.css" media="screen"/>      
    </head>

    <body>
    <jsp:include page="res/fixed_code/header.jsp" />   
    <jsp:include page="res/fixed_code/categories.jsp"/>
    <jsp:include page="res/fixed_code/authors.jsp"/>
    <div id="content">
        <jsp:include page="res/fixed_code/SearchBox.jsp" />  

        <c:if test="${authorNewsList.size() > 0}">          

            <table id="personal_articles_table">
                <thead>
                    <tr>
                        <th class="personal_articles_table_header">Data</th>
                        <th class="personal_articles_table_header">Titolo</th>
                        <th class="personal_articles_table_header">Modifica</th>
                        <th class="personal_articles_table_header">Cancella</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="Notizia" items="${authorNewsList}">   
                        <tr>
                            <td>${Notizia.getDate()}</td>
                            <td><a href="notizia.html?nid=${Notizia.getId()}">${Notizia.getTitle()}</a></td>
                            <td><a href="scriviArticolo.html?edit=${Notizia.getId()}"><img id="edit_button" src="res/site_resources/edit.png" alt="Modifica${Notizia.getTitle()}"></a></td>
                            <td><a href="articoli.html?deletePost=${Notizia.getId()}"><img id="delete_button" src="res/site_resources/delete.png" alt="Modifica${Notizia.getTitle()}"></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
        </c:if>
        <a href="scriviArticolo.html"><button id="new_article_button" >Crea un nuovo articolo</button></a>   

    </div>
    <br/>
    <body>
</html>
