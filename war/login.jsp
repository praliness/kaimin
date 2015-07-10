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
        <h1>ログイン成功</h1>        
        <p>
            <%=user.getNickname() %>さん、ログイン中...<br></p>
        <div><a href="/main.jsp">レビューページへ</a></div>
         <a href="/logout">Logout</a>
        </p>
    </body>
</html>