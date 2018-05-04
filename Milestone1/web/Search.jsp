<%-- 
    Document   : search
    Created on : 26-apr-2018, 15.57.26
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
        <link rel="stylesheet" type="text/css" href="res/css/search.css" media="screen"/>
        <link rel="shortcut icon" href="res/css/logo_old.png" type="image/x-icon" />
          <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="cerca,fast,press,writer">
    </head>
    <body>

        <jsp:include page="res/fixed_code/header.jsp" />               


        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>

        <div id="content">

            <form action="cerca.html" method="post">
                <input id="querybox" name="query" type="text" placeholder="Cerca nel sito...">
                <img id="submit_search" src="res/site_resources/search_icon.png"/>

            </form>
            <br/>

            <c:if test="${searched == true}"> 
                <div id="searchResultSection">
                    <br/>
                    <c:if test="${foundNewsBool == false}">                     
                        <label>Non ho trovato notizie dal titolo "${query}"</label>  
                        <br/>
                    </c:if>

                    <c:if test="${foundInNewsBool == false}">
                        <br/>
                        <label>Nessuna notizia parla di "${query}"</label> 
                        <br/>
                    </c:if>     

                    <c:if test="${foundNewsBool == true}">
                        <label>Questi articoli hanno "${query}" nel titolo (${tAFound} articolo/i)</label>
                        <br/>
                        <c:forEach var="n" items="${foundNews}">
                            <a href="notizia.html?nid=${n.getId()}">${n.getTitle()} - scritto da ${n.getAuthor().getName()} ${n.getAuthor().getSurname()}</a>   
                            <br/>  
                        </c:forEach>

                    </c:if>  

                    <c:if test="${foundInNewsBool == true}">
                        <br/>
                        <label>Questi articoli parlano di "${query}" (${tATFound} articolo/i)</label>
                        <br/>
                        <c:forEach var="n" items="${foundInNews}">
                            <a href="notizia.html?nid=${n.getId()}">${n.getTitle()} - scritto da ${n.getAuthor().getName()} ${n.getAuthor().getSurname()}<br/>${n.getContentPreview()}</a>   
                            <br/>  
                        </c:forEach>

                    </c:if>   
                      <br/>     
                   
                </div>
            </c:if>
                   

        </div>
    </body>
</html>

