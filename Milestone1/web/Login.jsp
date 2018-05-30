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
        <jsp:include page="res/fixed_code/head.jsp" /> 
       
        <link rel="stylesheet" type="text/css" href="res/css/login.css" media="screen"/>
    </head>
    <body onLoad="routineThings()">         
       
        <jsp:include page="res/fixed_code/header.jsp" />
        <div id="content">           
            <div id="login_form">
                <label id="loginTitle">Login</label>
                <br/>
                <form action="login.html" method="post" >
                    <label class="input_title"l>Email</label>
                    <br/>
                    <input class="input_box" type="text" name="email" id="email">
                    <br/>
                    <label class="input_title">Password</label>
                    <br/>
                    <input class="input_box" type="password" name="password" id="password">
                    <br/>
                    <button id="loginButton" type="submit">LOGIN</button>
                </form>
                <br/>
                <div id="secondBox">
                    <a href="login.html?register">Non hai un account?Iscriviti qui</a>
                    <br/>                    
                    <a href="">Password dimenticata</a>
                    <br/>
                    <c:if test="${invalidData == true}">
                        <h4  id="invalid">Nome utente e/o password errati, riprova</h4>
                    </c:if>
                </div>
            </div>
             
          
        </div>
        <jsp:include page="res/fixed_code/footer.jsp" />    

    </body>
</html>
