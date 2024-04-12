<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>

            body {
                background-size: cover;
                font-family: Arial, sans-serif;
                color: white;
                margin: 0px
               
            }
            .login{
                padding: 260px;
                 background-image: url('images/register.jpg');  
                background-size: cover; /* Hiệu ứng zoom hình nền */
                background-position: center; /* Căn giữa hình nền */
            }
            form {
                background-color: #aaa8a875;
                width: 40%;
                padding: 40px;
                border-radius: 10px;
                
            }

            label {
                float: left;
                color: white;
            }

            input[type="text"], input[type="password"]{
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
        </style>
</head>
<body>
    <center>
        <div class="login">
            <form action="users" method="post">
            <input type="hidden" name="action" value="login">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" autocomplete="current-password" required><br><br>
            <input type="submit" value="Login">
        </form>
        </div>
        
    </center>
   
</body>
</html>
