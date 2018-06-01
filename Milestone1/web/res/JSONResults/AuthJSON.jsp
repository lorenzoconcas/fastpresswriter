<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="author" items="${authors}">
        <json:object>
            <json:property name="authName" value="${author.getName()}"/>  
            <json:property name="authSurname" value="${author.getSurname()}"/>
            <json:property name="authID" value="${author.getId()}"/>
        </json:object>
    </c:forEach>
</json:array>
