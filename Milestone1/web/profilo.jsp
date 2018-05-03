<%-- 
    Document   : utente
    Created on : 25-apr-2018, 19.19.34
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${user.getName()} ${user.getSurname()} - Fast Press Writer</title>
         <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
       
        <link rel="stylesheet" type="text/css" href="M2/Profiles.css" media="screen"/>
                  <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="profilo,fast,press,writer">
    </head>
    <body>
        <jsp:include page="M2/header.jsp" />  
        <jsp:include page="M2/categories.jsp"/>
        <jsp:include page="M2/authors.jsp"/>
        <div id="content">
            <div id="profile_section">
                <h3>Il tuo profilo, ${user.getName()} ${user.getSurname()}</h3>
                <img src="<c:url value="${user.getImgUrl()}"/>" alt="Immagine Profilo" width="160"/>
                <br/>
                <label class="generic_text">Nome</label>                
                <input type="text" class="generic_input" placeholder="${user.getName()}"/>
                <br/>

                <label class="generic_text">Cognome</label>                
                <input type="text" class="generic_input" placeholder="${user.getSurname()}"/>
                <br/>                

                <label class="generic_text">Data Di Nascita </label>                
                <input type="date" class="generic_input"/>
                <br/>

                <label class="generic_text">Url Foto del profilo</label>                
                <input type="text" class="generic_input" placeholder="${user.getImgUrl()}"/>
                <br/>

                <label class="generic_text">Indirizzo email</label>                
                <input type="email" class="generic_input" placeholder="${user.getEmail()}"/>
                <br/>

                <label class="generic_text">Password</label>                
                <input type="password" class="generic_input" placeholder="${user.getPassword()}"/>
                <br/>

                <label class="generic_text">Conferma Password</label>               
                <input type="password" class="generic_input" placeholder="${user.getPassword()}"/>
                <br/>

                <input type="button" id="edit_button" value="Salva"/>
                <br/>
                <input type="button" id="delete_button" value="Elimina Profilo"/>
                <br/>
            </div>
        </div>
    </body>
</html>
