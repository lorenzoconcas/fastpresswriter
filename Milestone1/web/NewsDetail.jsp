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
        <jsp:include page="res/fixed_code/head.jsp" /> 
        <link rel="stylesheet" type="text/css" href="res/css/posts.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/comments.css" media="screen"/>       
    </head>
    <body>
        <jsp:include page="res/fixed_code/header.jsp" /> 
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        <div id="content">
            <div id="news">            
                <div class="post">
                    <!--icona utente, nome utente-->
                    <img class="post_user_icon" src="<c:url value="${News.getAuthor().getImgUrl()}"/>" alt=""/>

                    <label class="post_author">${News.getAuthor().getName()} ${News.getAuthor().getSurname()}</label>                         

                    <br/>

                    <img class="news_pic" src="<c:url value="${News.getImageUrl()}"/>" alt="Immagine"/>                        
                    <br/>

                    <label class="post_title">${News.getTitle()}</label>
                    <br/>                    

                    <label class="post_category">Scritto il ${News.getDate()} - Categorie : ${News.getCategory()}</label>
                    <br/>

                    <label class="post_content">${News.getContent()}</label>
                    <br/>
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

                                <form action="sendComment?insComment=true">
                                    <c:set var="News" value="${News}">  </c:set>
                                    <label id="pers_comment_title">Commenta (come ${user.getName()} ${user.getSurname()})</label>
                                    <input name="persComment" id="personal_comment_textarea"></input>
                                    <button id="personal_post_comment" >Commenta</button>
                                    <br/>
                                </form>

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
