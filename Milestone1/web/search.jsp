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
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/search.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />

    </head>
    <body>
      
       <jsp:include page="M2/header.jsp" />               
       
     
       <jsp:include page="M2/categories.jsp"/>
       <jsp:include page="M2/authors.jsp"/>
       
       <div id="content">
           
           <form action="Search" method="post">
               <input id="querybox" name="query" type="text" placeholder="Cerca nel sito...">
               <img id="submit_search" src="M2/search_icon.png"/>
               
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
                      <label>Ho trovato questi articoli che contengono la ricerca :</label>
                      <br/>
                     <c:forEach var="n" items="${foundNews}">
                          <a href="NewsDetails?id=${n.getId()}">${n.getTitolo()} - scritto da ${n.getAutore().getName()} ${n.getAutore().getSurname()}</a>   
                          <br/>  
                      </c:forEach>

                 </c:if>  

                 <c:if test="${foundInNewsBool == true}">
                       <br/>
                      <label>La query è stata trovata nei seguenti articoli</label>
                      <br/>
                     <c:forEach var="n" items="${foundInNews}">
                         <a href="NewsDetails?id=${n.getId()}">${n.getTitolo()} - scritto da ${n.getAutore().getName()} ${n.getAutore().getSurname()}<br/>${n.getContent()}</a>   
                          <br/>  
                      </c:forEach>

                 </c:if>   
                </div>
             </c:if>
             <br/>              
           
       </div>
    </body>
 </html>
       
