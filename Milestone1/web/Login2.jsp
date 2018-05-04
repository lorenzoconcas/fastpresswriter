<%-- 
    Document   : Login
    Created on : 3-mag-2018, 22.16.57
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <title>Fast Press Writer - Login</title>
        <link rel="stylesheet" type="text/css" href="res/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/login.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
                  <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="login,fast,press,writer">
    </head>
    <body>
         <jsp:include page="res/fixed_code/header.jsp" />
         <div id="content">
            <div class="login_form">
            <label>Effettua il login per poter creare articoli o commentarli</label>
            <br/>
            <form action="login.html" method="post" >
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
        <jsp:include page="res/fixed_code/footer.jsp" />    

    </body>
</html>
