<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Registration</title>
        <style>

            body {
                background-size: cover;
                font-family: Arial, sans-serif;
                color: white;
                padding: 30px;
                background-image: url('images/register.jpg');  
                background-size: cover; /* Hiệu ứng zoom hình nền */
                background-position: center; /* Căn giữa hình nền */
            }

            form {
                background-color: #aaa8a875;
                /*background-image: url('https://media.istockphoto.com/id/1134753656/vector/glowing-light-explodes-on-black-background-vector-illustration-of-light-decoration-effect.jpg?s=612x612&w=0&k=20&c=U_fvGdPZRruvch6E92eUgXuqGxJ7rTBMRzyRoyMbp-c=');  Đường dẫn đến hình nền */
                width: 40%;
                padding: 40px;
                border-radius: 10px;
                
            }

            label {
                float: left;
                color: white;
            }

            input[type="text"],
            input[type="number"], input[type="password"] ,#gender{
                width: 90%;
                padding: 10px;
                margin-bottom: 10px;
                border-radius: 5px;
                border: none;
                background-color: rgba(255, 255, 255, 0.2); /* Màu nền của trường nhập */
                color: white;
                
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }
            option{
                background-color:buttontext;
/*                color: #aaa8a875;*/
            }
        </style>
    </head>
    <body>
        <!--<h2>User Registration</h2>-->
        <center>
            <form class="form" action="users" method="post">
                <input type="hidden" name="action" value="add">
                <label for="username">Username</label><br><br>
                <input type="text" id="username" name="username" required><br><br>
                <label for="password">Password</label><br><br>
                <input type="password" id="password" name="password" required><br><br>
                <label for="fullname">Full Name</label><br><br>
                <input type="text" id="fullname" name="fullname" required><br><br>
                <label for="age">Age</label><br><br>
                <input type="number" id="age" name="age" required><br><br>
                <label for="gender">Gender</label><br><br>
                <select id="gender" name="gender">
                    <option value="true">Male</option>
                    <option value="false">Female</option>
                </select><br><br>
                <input type="submit" value="Register">
            </form>
        </center>
        

    </body>
</html>
