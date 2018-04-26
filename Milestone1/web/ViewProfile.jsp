<%-- 
    Document   : ViewProfile
    Created on : 25-apr-2018, 19.43.02
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${target.getName()} ${target.getSurname()} - Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
    </head>
    <body>
       
               <jsp:include page="M2/header.jsp" />   
              
       
     
       <jsp:include page="M2/categories.jsp"/>
       <jsp:include page="M2/authors.jsp"/>
        <div id="content">
               <h3>Ecco il profilo di ${target.getName()} ${target.getSurname()}</h3>
               <img src="<c:url value="${target.getImgUrl()}"/>" alt="Immagine Profilo" width="168"/>
               <br/>
        </div>
         <jsp:include page="M2/footer.jsp"/>
    </body>
</html>
