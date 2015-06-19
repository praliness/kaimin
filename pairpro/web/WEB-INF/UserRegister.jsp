<%-- 
    Document   : UserRegister
    Created on : 2014/12/22, 16:52:32
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
        <form action="/ad4549/UserRegister" method="post">
            ユーザーID：<input type="text" name="userID"><br>
            パスワード：<input type="password" name="pass"><br>
            年齢：<input type="text" name="age"><br>
            性別：<input type="text" name="gender"><br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>
