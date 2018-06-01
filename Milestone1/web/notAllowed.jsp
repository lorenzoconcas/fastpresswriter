<%-- 
    Document   : notAllowed
    Created on : 4-mag-2018, 10.25.56
    Author     : lorec
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>Oooops!</title>
        <jsp:include page="res/fixed_code/head.jsp" /> 
    </head>
    <body onLoad="routineThings()">
        <jsp:include page="res/fixed_code/header.jsp" />   
        <jsp:include page="res/fixed_code/categories.jsp"/>
        <jsp:include page="res/fixed_code/authors.jsp"/>
        
        <div id="content">
            <jsp:include page="res/fixed_code/SearchBox.jsp" />  

            <h1>${errorMessage}</h1>
        </div>
        <br/>

    </body>
</html>
