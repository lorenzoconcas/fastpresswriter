<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="news" items="${categories}">
        <json:object>
            <json:property name="catName" value="${news}"/>            
        </json:object>
    </c:forEach>
</json:array>
