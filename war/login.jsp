<%@ page language="java" contentType="text/html; charset=utf8"
        pageEncoding="utf8" %>
<%@ page import="com.google.appengine.api.users.*" %>
<%
User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8">
        <title>Login Page</title>
    </head>
    <body background="haikei1.gif">
        <h1>レビューページ</h1>        
        <p>
            <%=user.getNickname() %>さん、ログイン中
        <p>お客様の購入した布団についてのご感想をお聞かせください。<br>
        布団の種類の後に1マス空白をあけて、感想をお書きください。<br>
        布団の種類<br>
        bed　タオルケット<img src="bed1.jpg" width="320" height="213">
        bed2　     羽毛<img src="bed2.jpg" width="320" height="213"><br></p>
         <a href="/logout">Logout</a>
        </p>
        <p><a href="/login">更新</a></p>
        <form action="/add" method="post">
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