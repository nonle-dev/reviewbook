<%-- 
    Document   : updatebook
    Created on : Apr 7, 2024, 4:49:38 PM
    Author     : nonle
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-size: cover;
                font-family: Arial, sans-serif;
                color: white;
                /*padding: 20px;*/
            }

            form {
                background-image: url('https://media.istockphoto.com/id/1134753656/vector/glowing-light-explodes-on-black-background-vector-illustration-of-light-decoration-effect.jpg?s=612x612&w=0&k=20&c=U_fvGdPZRruvch6E92eUgXuqGxJ7rTBMRzyRoyMbp-c='); /* Đường dẫn đến hình nền */

                padding: 40px;
                border-radius: 10px;
                background-size: cover; /* Hiệu ứng zoom hình nền */
                background-position: center; /* Căn giữa hình nền */
            }

            label {
                font-weight: bold;
            }

            input[type="text"],
            textarea {
                width: 95%;
                padding: 10px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: none;
                background-color: rgba(255, 255, 255, 0.2); /* Màu nền của trường nhập */
                color: white;
                font-family: Arial, sans-serif;
            }

            button[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <form action="updatebook" method="post">
            <input type="hidden" id="id" name="id" value="${requestScope.book.id}">
            <label for="title">Title:</label><br>
            <input type="text" id="title" name="title" value="${requestScope.book.title}" required><br>

            <label for="author">Author:</label><br>
            <input type="text" id="author" name="author" value="${requestScope.book.author}" required><br>

            <label for="description">Description:</label><br>
            <textarea id="description" name="description" required>${requestScope.book.description}</textarea><br>

            <label for="genre">Genre:</label><br>
            <input type="text" id="genre" name="genre" value="${requestScope.book.genre}" required><br>

            <label for="image">Image URL:</label><br>
            <input type="text" id="image" name="image" value="${requestScope.book.image}" required><br>

            <label for="content">Content:</label><br>
            <textarea id="content" name="content" required style="height: 200px;">${requestScope.book.content}</textarea><br>

            <div>
                <button type="submit" value="UPDATE">Update Book</button>
            </div>
        </form>
    </body>
</html>
