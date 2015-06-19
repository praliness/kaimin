<%-- 
    Document   : loginOK
    Created on : 2014/12/09, 11:07:51
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>快眠屋</title>
    </head>
    <body bgcolor="#F0FFFF">
        <p>ようこそ<c:out value="${userId}" />さん</p>
        <a href="/ad4549/Main"><img src="button.png" onmouseover="this.src='button.png'"
                                    onmouseout="this.src='button.png'"></a><br>
        <a href="/ad4549/WelcomeServlet">トップへ</a>
    </body>
</html>
