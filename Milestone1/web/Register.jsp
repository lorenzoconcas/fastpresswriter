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
        <title>Fast Press Writer - Register</title>
        <jsp:include page="res/fixed_code/head.jsp" /> 
        <link rel="stylesheet" type="text/css" href="res/css/login.css" media="screen"/>

    </head>
    <body>
        <jsp:include page="res/fixed_code/header.jsp" />
        <div id="content">
            <div id="login_form">
                <label id="loginTitle">Registrazione</label>
                <br/>
                <form action="login.html?register=true" method="post" >
                    <label class="input_title"l>Nome</label>
                    <br/>
                    <input class="input_box" type="text" name="nome" id="nome">
                    <br/>
                    <label class="input_title"l>Cognome</label>
                    <br/>
                    <input class="input_box" type="text" name="cognome" id="nome">
                    <br/>
                    <label class="input_title"l>Email</label>
                    <br/>
                    <input class="input_box" type="text" name="email" id="email">
                    <br/>
                    <label class="input_title">Password</label>
                    <br/>
                    <input class="input_box" type="password" name="password" id="password">
                    <br/>
                    <label class="input_title">Conferma password</label>
                    <br/>
                    <input class="input_box" type="password" name="password" id="confirm_password">
                    <br/>
                    <button id="loginButton" type="submit"><label id="loginButtonText">Registrati</label></button>
                    <div id="secondBox">
                        <input type="checkbox" name="willBeAuthor">Iscriviti come autore per soli 99€/anno</input>                   
                    </div>
                </form>
                <br/>

            </div>

            <c:if test="${invalidData == true}">
                <label>Nome utente e/o password errati, riprova</label>
            </c:if>
        </div>
        <jsp:include page="res/fixed_code/footer.jsp" />    

    </body>
</html>
