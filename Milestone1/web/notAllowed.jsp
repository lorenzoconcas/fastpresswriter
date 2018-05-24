<%-- 
    Document   : notAllowed
    Created on : 4-mag-2018, 10.25.56
    Author     : lorec
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oooops!</title>
        <meta http-equiv="" content="30">
        <link rel="stylesheet" type="text/css" href="res/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="res/css/aside_right.css" media="screen"/>
        <link rel="shortcut icon" href="res/site_resources/logo_old.png" type="image/x-icon" />
                  <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="Non,trovato,fast,press,writer">
    </head>
    <body>
        <jsp:include page="res/fixed_code/header.jsp" />   
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        <div id="content">
            <h1>${errorMessage}</h1>
        </div>
        <br/>

    </body>
</html>
