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
                <link rel="stylesheet" type="text/css" href="M2/news.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />

    </head>
    <body>
      
               <jsp:include page="M2/header.jsp" />               
       
     
       <jsp:include page="M2/categories.jsp"/>
       <jsp:include page="M2/authors.jsp"/>
       
       <div id="content">
           <div id="news">
               <img id="post_user_icon" src="<c:url value="${author.getImgUrl()}"/>" alt=""/>
              
               <a href="ViewProfile?id=${author.getId()}"><label id="post_author">Scritto da : ${author.getName()} ${author.getSurname()}</label> </a>
               <br/>
               <img id="news_pic" src="<c:url value="${imageUrl}"/>" alt="Immagine"/>
               <br/>
               <div id="news_infos">
                
                    <label id="post_title">${newsTitle}</label>
                    <br/>
                    <label id="post_category">Categorie : ${newsCat}</label>
                    <br/>
                    <label id="post_content">${newsContent}</label>
               </div>
               <br/>
               <div id="comment_section">
                    <label>Commenti</label>
                     <c:forEach var="Commenti" items="${comments}">                   
                        <br/>
                        <label id="comment_username">${Commenti.getAutoreCommento().getName()} ${Commenti.getAutoreCommento().getSurname()}</label>
                        <br/>
                        <label id="comment">${Commenti.getCommento()}</label>
                        <br/>                        
                     </c:forEach>  
                     <c:if test="${loggedIn == true}">
                        <label>Commenta (come ${user.getName()} ${user.getSurname()})</label>
                        <br/>
                        <textarea id="comment_area"></textarea>
                        <button id="post_comment">Commenta</button>   
                    </c:if>  
                </div> 
           </div>
       </div>
       <jsp:include page="M2/footer.jsp" />
    </body>
</html>
