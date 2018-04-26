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
    </head>
    <body>
           <jsp:include page="M2/header_logged.jsp" />   
           <div id="content">
               <h3>Il tuo profilo, ${user.getName()} ${user.getSurname()}</h3>
               <img src="<c:url value="${user.getImgUrl()}"/>" alt="Immagine Profilo" width="168"/>
               <br/>
               <label>Nome</label>
                <br/>
                <input type="text" placeholder="${user.getName()}"/>
                <br/>
                <label>Cognome</label>
                <br/>
                <input type="text" placeholder="${user.getSurname()}"/>
                <br/>                
                <label>Data Di Nascita</label>
                <br/>
                <input type="date"/>
                <br/>
                <label>Url Foto del profilo</label>
                <br/>
                <input type="text" placeholder="${user.getImgUrl()}"/>
                <br/>
                 <label>Indirizzo email</label>
                <br/>
                <input type="email" placeholder="${user.getEmail()}"/>
                <br/>
                <label>Password</label>
                <br/>
                <input type="password" placeholder="${user.getPassword()}"/>
                <br/>
                <label>Conferma Password</label>
                <br/>
                <input type="password" placeholder="${user.getPassword()}"/>
                <br/>
                <input type="button" class="button" value="Salva"/>
                <br/>
                <input type="button" class="button_delete" value="Elimina Profilo"/>
                <br/>
           </div>
           <jsp:include page="M2/footer.jsp"/>
    </body>
</html>
