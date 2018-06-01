<%@page contentType="application/json" pageEncoding="UTF-8"%> 
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:array>
    <c:forEach var="Notizia" items="${newsList}">
        <json:object>
            <json:property name="post_user_icon" value="${Notizia.getAuthor().getImgUrl()}"/>
            <json:property name="post_author" value="${Notizia.getAuthor().getName()} ${Notizia.getAuthor().getSurname()}"/>  
            <json:property name="news_pic" value="${Notizia.getImageUrl()}"/>
            <json:property name="post_title" value="${Notizia.getTitle()}"/>                   
            <json:property name="post_content" value="${Notizia.getContentPreview()}"/>
            <json:property name="post_date" value="${Notizia.getDate()}"/>
            <json:property name="post_category" value="${Notizia.getCategory()}"/>
            <json:property name="post_open" value="notizia.html?nid=${Notizia.getId()}"/>
        </json:object>
    </c:forEach>
</json:array>

