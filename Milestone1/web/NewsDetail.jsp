<%-- 
    Document   : NewsDetail
    Created on : 3-mag-2018, 22.22.29
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
        <link rel="stylesheet" type="text/css" href="res/css/comments.css" media="screen"/>
        <link rel="shortcut icon" href="res/css/logo_old.png" type="image/x-icon" />
        <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="Notizia, Fast, Press, Writer">
    </head>
    <body>

        <jsp:include page="res/fixed_code/header.jsp" /> 
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        <div id="content">
            <div id="news">            
                <div id="post">
                    <!--icona utente, nome utente-->
                    <img id="post_user_icon" src="<c:url value="${News.getAuthor().getImgUrl()}"/>" alt=""/>

                    <label id="post_author">Scritto da : ${News.getAuthor().getName()} ${News.getAuthor().getSurname()}</label>                         

                    <br/>

                    <img id="news_pic" src="<c:url value="${News.getImageUrl()}"/>" alt="Immagine"/>                        
                    <br/>

                    <label id="post_title">${News.getTitle()}</label>
                    <br/>

                    <label id="post_content">${News.getContent()}</label>
                    <br/>

                    <label id="post_category">Scritto il ${News.getDate()} - Categorie : ${News.getCategory()}</label>
                    <br/>
                </div>
                <!--Mostro questa sezione solo se sono loggato o se ci sono commenti-->
                <c:if test="${loggedIn == true || isCommented == true}">
                    <!--Sezione commenti utenti-->
                    <div id="comment_section">
                        <c:if test="${isCommented == true}">     
                            <label id="comment_section_title">Commenti</label>
                            <br/>
                            <c:forEach var="Commenti" items="${comments}">   
                                <br/>
                                <div id="comment_box">                           
                                    <label id="comment_username">${Commenti.getCommentAuthor().getName()} ${Commenti.getCommentAuthor().getSurname()}</label>
                                    <br/>
                                    <label id="comment">${Commenti.getComment()}</label>
                                    <br/>  
                                </div>
                            </c:forEach> 
                        </c:if>       
                        <!--Sezione commento personale-->
                        <c:if test="${loggedIn == true}">
                            <div id="personal_comment">
                                <label>Commenta (come ${user.getName()} ${user.getSurname()})</label>
                                <br/>

                                <textarea id="personal_comment_textarea"></textarea>
                                <button id="personal_post_comment">Commenta</button> 
                                <br/>
                            </div>
                        </c:if>  

                        <br/>
                    </div> 
                </c:if>

                <br/>
            </div>
        </div>       
    </body>
</html>
