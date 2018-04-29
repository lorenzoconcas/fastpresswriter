<%-- 
    Document   : login
    Created on : 24-apr-2018, 17.57.20
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> 
    <head>
        
        <title>Fast Press Writer - Login</title>
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/login.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
    </head>
    <body>       
       <jsp:include page="M2/header.jsp" />
        <div id="content">
            <div class="login_form">
            <label>Effettua il login per poter creare articoli o commentarli</label>
            <br/>
            <form action="Login" method="post" >
                <label>Nome utente</label>
                <br/>
                <input type="text" name="email" id="email">
                <br/>
                <label>Password</label>
                <br/>
                <input type="password" name="password" id="password">
                <br/>
                <button type="submit">Invia</button>
            </form>
            </div>
            <c:if test="${invalidData == true}">
                <label>Nome utente e/o password errati, riprova</label>
            </c:if>
        </div>
        <jsp:include page="M2/footer.jsp" />    
    </body>
</html>
