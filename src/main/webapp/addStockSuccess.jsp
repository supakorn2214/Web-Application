<%-- 
    Document   : SPXIX
    Created on : Aug 12, 2023, 9:12:21 PM
    Author     : SPXIX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            text-decoration: none;
            }
            
        </style>
    <body>
        <h1><center><font size = "10px">Add Stock Complete</font></center></h1>
        <%
            Item item = (Item) session.getAttribute("item");
        %>
        <center><font size = "5px">Name : <%= item.getName() %><br><br>
        Type : <%= item.getType() %><br><br>
        Price : <%= item.getPrice() %><br><br>
        <a class="submit"   href="updateStock.jsp">Edit</a></font></center>
    </body>
</html>
