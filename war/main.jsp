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
        <title>レビューページ</title>
        
        <script type="text/javascript" src="lib.js"></script>
        <script type="text/javascript">
        <!--
        function callback(request){
            var json = eval(request.responseText);
            var res = '';
            if (json.length == 1){
                res += '<tr><td>' + json[0].id +'</td></tr>';
                res += '<tr><td>' + json[0].title +'</td></tr>';
                res += '<tr><td>' + json[0].comment +'</td></tr>';
            } else {
                for (var i = 0;i < json.length;i++){
                    res += '<tr><td><a href="javascript:return false;" onclick="getData(' + json[i].id +');">' + json[i].id + '</a></td>';
                    res += '<td>' + json[i].title + '</a></td>' +
                    '<td><a href="edit.html?id=' + json[i].id + '">Edit</td>' +
                    '<td><a href="del.html?id=' + json[i].id + '">Delete</td></tr>';
                }
            }
            var obj = document.getElementById("datatable");
            obj.innerHTML = res;
        }
        //-->
        </script>
        
    </head>
    <body background="haikei1.gif">
    <body onload="getData(null);">
        <h1>レビューページ</h1>        
        <p>
            <%=user.getNickname() %>さん、ログイン中
        <p>お客様の購入した布団についてのご感想をお聞かせください。<br>
        布団の種類の後に1マス空白をあけて、感想をお書きください。<br>
        布団の種類<br>
        bed1　タオルケット<br>
        <img src="bed1.jpg" width="320" height="213"><br>
        bed2 羽毛<br>
        <img src="bed2.jpg" width="320" height="213"><br></p>
        <div><a href="add.html">感想コメント</a></div>
        <table id="datatable" border="1">
      <tr>
        <td>wait...</td>
      </tr>
    </table>
         <a href="/logout">Logout</a>
        </p>
    </body>
</html>
