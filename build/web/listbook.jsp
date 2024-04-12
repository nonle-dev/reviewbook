<%-- 
    Document   : listbook
    Created on : Apr 7, 2024, 1:40:06 PM
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
                padding: 20px;
            }

            table {
                background-image: url('https://media.istockphoto.com/id/1134753656/vector/glowing-light-explodes-on-black-background-vector-illustration-of-light-decoration-effect.jpg?s=612x612&w=0&k=20&c=U_fvGdPZRruvch6E92eUgXuqGxJ7rTBMRzyRoyMbp-c='); /* Đường dẫn đến hình nền */
                border-collapse: collapse;
                padding: 40px;
                border-radius: 10px;
                background-size: cover; /* Hiệu ứng zoom hình nền */
                background-position: center; /* Căn giữa hình nền */
                width: 100%;
            }

            tr th {
                font-weight: bold;
                text-align: center;
                border: none;
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
            }

            button[type="submit"] {
                background-color: #8c871c;
                color: white;
                padding: 10px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin: 2px 0px 0px 0px;
                width: 60px;
            }

            button[type="submit"]:hover {
                background-color: #96958094;
            }

            th, td {
                border: 1px solid #fee90624 ;
                padding: 8px;
                text-align: left;
                
            }

            /* CSS styles for buttons */
            .btn ,.review{
                padding: 8px 12px;
                border: none;
                cursor: pointer;
            }
            .review{
                border: 2.5px solid #ebcf0cc4;
                border-radius: 5px;
                margin-bottom: 3px;
                background-color: black;
                color: white;
            }
            .review[type="rw"]:hover {
                background-color: #96958094;
            }
            a {
                text-decoration: none;
            }
            
        </style>
        <script >
            function doDelete(id) {
                if (confirm(" are U sure to delete book with id=" + id)) {
                    window.location = "DeleteBookServlet?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <h3><a type="rw" class="review" href="review.jsp">Review</a></h3>    
    <center>
        <c:if test="${empty books}">
            <p>No books available.</p>
        </c:if>
        <c:if test="${not empty books}">
            <table >
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Genre</th>
                    <th>Action</th>
                </tr>

                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.description}</td>
                        <td>${book.genre}</td>
                        <td>
                            <button type="submit" class="btn edit" onclick="window.location = 'updatebook?id=${book.id}'">Edit</button>
                            <button type="submit" class="btn delete" onclick="doDelete(${book.id})" href="#">Delete</button>                      
                        </td> 
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <!--<h3><a href="review.jsp">Review</a></h3>-->

    </center>
</body>
</html>

