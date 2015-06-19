<%-- 
    Document   : login
    Created on : 2014/12/09, 11:04:15
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>快眠屋</title>
    </head>
    <body bgcolor="#F0FFFF">
        <form action="/ad4549/LoginServlet" method="post">
            ユーザーID：<input type="text" name="userID"><br>
            パスワード：<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>