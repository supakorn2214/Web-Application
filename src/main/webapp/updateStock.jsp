<br><%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Item" %>
<!DOCTYPE html>
<html>
    <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');
            *{
            padding: 2;
            margin: 2;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
            }
            body {background-color: #f79f79fd;}
            .submit{
            font-size: 1em;
            margin-top: 0.8em;
            background-color: #587ef4;
            border: none;
            outline: none;
            color: #fff;
            padding: 0.6em 1.2em;
            border-radius: 0.3em;
            cursor: pointer;
            }
            
        </style>
    <body>
        <h1><center><font size = "10px">Edit</font></center></h1>
        <%
            Item item = (Item) session.getAttribute("item");
        %>
        <form action="AddNewStock2">
            <center>Name : <input type="text" name="name" value="<%= item.getName()%>"><br><br>
            Type : <input type="text" name="type" value="<%= item.getType()%>"><br><br>
            Price : <input type="text" name="price" value="<%= item.getPrice()%>"><br><br>
            <input class="submit" type="submit" value="Edit"></center>
        </form>
        <% session.removeAttribute("item"); %>
    </body>
</html>