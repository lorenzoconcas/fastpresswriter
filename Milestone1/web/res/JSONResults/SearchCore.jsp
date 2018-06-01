<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="news" items="${foundNews}">
        <json:object>
            <json:property name="id" value="${news.getId()}"/> 
            <json:property name="title" value="${news.getTitle()}"/>
            <json:property name="content" value="${news.getContentPreview()}"/> 
            
        </json:object>
    </c:forEach>
</json:array>
