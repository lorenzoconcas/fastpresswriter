<%-- 
    Document   : NewArticle
    Created on : 4-mag-2018, 0.57.02
    Author     : lorec
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <!-- non viene utilizzato <base href> perch0è va in conflitto con la ricerca delle varie jsp-->
        <jsp:include page="res/fixed_code/head.jsp" /> 
        <link rel="stylesheet" type="text/css" href="res/css/NewArticle.css" media="screen"/>
       
    </head>
    <body onLoad="routineThings()">
        <jsp:include page="res/fixed_code/header.jsp" />   
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        <div id="content">
            <div id="new_article_section">
                <form action="scriviArticolo.html?send=true">
                    <h3>Scrivi un nuovo articolo</h3>
                    <c:if test="${lastID != null}">
                        <h5>ID articolo : ${lastID}</h5>
                    </c:if>
                    <div class="personal_articles_data">
                        <label>Titolo</label>               
                        <input class="new_article_generic_input" type="text" name="title"  value="${title}"/>
                        <br/>
                        <label>Data</label>              
                        <input class="new_article_generic_input" id="dateBox" type="text" name="date"  value="${date}"/>
                        <br/>
                        <label>Immagine</label>
                        <input class="new_article_generic_input"  type="text" name="imageUrl" value="${imageUrl}"/>                   <br/>                   
                        <label>Testo</label>
                        <br/>
                        <textarea id="new_article_text" name="content">${content}</textarea>
                        <br/>
                    </div>
                    <div id="new_article_categories">
                        <h3>Categorie</h3>
                        <c:forEach var="cat" items="${categories}"> 
                            <div id="new_article_categories_element">
                                <input class="new_article_categories_checkbox" type="checkbox" name="${cat}">
                                <label class="new_article_categories_text">${cat}</label>
                                <br/>
                            </div>

                        </c:forEach>
                    </div>
                    <br/>
                    <button id="new_article_upload_button">Carica articolo</button>
                </form>   
            </div> 
        </div>
        <br/>
    </body> 
</html>
