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
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/posts.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
    </head>
    
       
       <jsp:include page="M2/header.jsp" />   
              
     
       <jsp:include page="M2/categories.jsp"/>
       <jsp:include page="M2/authors.jsp"/>
        <div id="content">
            
            <c:forEach var="Notizia" items="${listaNews}">
             
                <div id="post">
                    <a href="NewsDetails?id=${Notizia.getId()}">
                    <!--gradiente, icona utente, nome utente-->
                   
                    <img id="post_user_icon" src="<c:url value="${Notizia.getAutore().getImgUrl()}"/>" alt=""/>
                    <label id="post_author">${Notizia.getAutore().getName()} ${Notizia.getAutore().getSurname()}</label>
                    <!--Immagine articolo, altro gradiente, titolo articolo e link ad esso-->
                    
                    <img id="news_pic" src="<c:url value="${Notizia.getImg()}"/>" alt="immagine"/>
                  
                    <label id="post_title">${Notizia.getTitolo()}</label>
                    <label id="post_content">${Notizia.getContent()}</label>
                    
                    <label id="post_category">Categorie : ${Notizia.getCategoria()}</label>
                    <a id="post_open" href="NewsDetails?id=${Notizia.getId()}">Apri Articolo</a>
                </a>
                </div>
                
                <br/>
            </c:forEach>
        </div>
        <br/>
      
     
</html>
