<%-- 
    Document   : index
    Created on : 24-apr-2018, 17.57.20
    Author     : lorec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html> 
    <head>
        <!-- non viene utilizzato <base href> perch0è va in conflitto con la ricerca delle varie jsp-->
        <title>Fast Press Writer</title>
        <link rel="stylesheet" type="text/css" href="M2/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_left.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/aside_right.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="M2/posts.css" media="screen"/>
        <link rel="shortcut icon" href="M2/logo_old.png" type="image/x-icon" />
                  <meta name="author" content="Lorenzo L. Concas">
        <meta name="keywords" content="Non,loggato,fast,press,writer">
    </head>
    
       
       <jsp:include page="M2/header.jsp" />   
              
     
       <jsp:include page="M2/categories.jsp"/>
       <jsp:include page="M2/authors.jsp"/>
        <div id="content">
            <h3>Devi essere loggato per procedere</h3>
        </div>
        <br/>
      
     
</html>
