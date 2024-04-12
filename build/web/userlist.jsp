<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Table</title>
        <!-- Thêm thư viện jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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

            th, td {
                border: 1px solid #fee90624 ;
                padding: 8px;
                text-align: left;

            }

        </style>
    </head>
    <body>
        <table id="userTable" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dữ liệu sẽ được thêm vào đây bằng JavaScript -->
            </tbody>
        </table>

        <script>
            // Khi trang được tải, gọi hàm để lấy danh sách người dùng
            $(document).ready(function () {
                getAllUsers();
            });

            function getAllUsers() {
                $.ajax({
                    type: "GET",
                    url: "users?action=getAll",
                    dataType: "json",
                    success: function (response) {
                        displayUsers(response);
                    },
                    error: function (xhr, status, error) {
                        console.error("Error fetching users:", error);
                    }
                });
            }

            function displayUsers(users) {
                var tableBody = $('#userTable tbody');
                tableBody.empty(); // Xóa bảng trước khi thêm dữ liệu mới

                $.each(users, function (index, user) {
                    var gender = user.gender ? "Male" : "Female"; // Chuyển giới tính thành chuỗi
                    var row = '<tr>' +
                            '<td>' + user.id + '</td>' +
                            '<td>' + user.username + '</td>' +
                            '<td>' + user.password + '</td>' +
                            '<td>' + user.fullname + '</td>' +
                            '<td>' + user.age + '</td>' +
                            '<td>' + gender + '</td>' +
                            '</tr>';
                    tableBody.append(row);
                });
            }
        </script>
    </body>
</html>
