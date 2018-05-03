<%-- 
    Document   : newsDetails
    Created on : 25-apr-2018, 16.58.46
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html> 
    <head>
        <title>Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/posts.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/comments.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
         <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="Notizia, Fast, Press, Writer">
    </head>
    <body>

        <jsp:include page="M2/header.jsp" /> 
        <jsp:include page="M2/categories.jsp"/>
        <jsp:include page="M2/authors.jsp"/>
        <div id="content">
            <div id="news">            
                <div id="post">
                    <!--icona utente, nome utente-->
                    <img id="post_user_icon" src="<c:url value="${author.getImgUrl()}"/>" alt=""/>
                    <a href="ViewProfile?id=${author.getId()}">
                        <label id="post_author">Scritto da : ${author.getName()} ${author.getSurname()}</label>                         
                    </a>                        
                    <br/>
                    
                    <img id="news_pic" src="<c:url value="${Notizia.getImg()}"/>" alt="Immagine"/>                        
                    <br/>

                    <label id="post_title">${Notizia.getTitolo()}</label>
                    <br/>

                    <label id="post_content">${Notizia.getContent()}</label>
                    <br/>

                    <label id="post_category">Scritto il ${Notizia.getDate()} - Categorie : ${Notizia.getCategoria()}</label>
                    <br/>
                </div>
                <div id="comment_section">
                    <c:if test="${isCommented == true}">     
                        <label id="comment_section_title">Commenti</label>
                        <c:forEach var="Commenti" items="${comments}">   
                            <br/>
                            <div id="comment_box">                           
                                <label id="comment_username">${Commenti.getAutoreCommento().getName()} ${Commenti.getAutoreCommento().getSurname()}</label>
                                <br/>
                                <label id="comment">${Commenti.getCommento()}</label>
                                <br/>  
                            </div>
                        </c:forEach> 
                    </c:if>       

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
                <br/>
            </div>
        </div>       
    </body>
</html>
