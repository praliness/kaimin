<%-- 
    Document   : main
    Created on : 2014/11/10, 16:29:17
    Author     : 
--%>

<%@page language="java" contentType="text/html; charest=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>快眠屋</title>
    </head>
    <body background="haikei1.gif">
        <h1>レビューページ</h1>        
        <p>
            <c:out value="${userId}" />さん、ログイン中
        <p>お客様の購入した布団についてのご感想をお聞かせください。<br>
        布団の種類の後に1マス空白をあけて、感想をお書きください。<br>
        布団の種類<br>
        bed　タオルケット<img src="bed1.jpg" width="320" height="213">
        bed2　     羽毛<img src="bed2.jpg" width="320" height="213"><br></p>
         <a href="/ad4549/Logout">ログアウト</a>
        </p>
        <p><a href="/ad4549/Main">更新</a></p>
        <form action="/ad4549/Main" method="post">
            <input type="text" name="text">
            <input type="submit" value="つぶやく">
        </form>
        <c:if test="${not empty errorMsg}" >
            <p>${errorMsg}</p>
        </c:if>
        <c:forEach var="mutter" items="${mutterList}">
            <p><c:out value="${mutter.userId}" />さん<br>　
                <c:out value="${mutter.item}" />　
                <c:out value="${mutter.review}" /></p>
        </c:forEach>
    </body>
</html>