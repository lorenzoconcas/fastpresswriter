<%-- 
    Document   : Profile
    Created on : 4-mag-2018, 0.54.30
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>  
    <head>
        <title>${user.getName()} ${user.getSurname()} - Fast Press Writer</title>
        <jsp:include page="res/fixed_code/head.jsp" />         
        <link rel="stylesheet" type="text/css" href="res/css/Profiles.css" media="screen"/>
    </head>
    <body>
        <jsp:include page="res/fixed_code/header.jsp" />  
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
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
                <a href="profilo.html?deleteUser=true"><input type="button" id="delete_button" value="Elimina Profilo"/></a>
                <br/>
            </div>
        </div>
    </body>
</html>
