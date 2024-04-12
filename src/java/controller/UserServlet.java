
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dal.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "UserServlet", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();
    private final Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý yêu cầu POST
        // Lấy thông tin từ request
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "login": // Thêm trường hợp đăng nhập
                    loginUser(request, response);
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println("Invalid action.");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Action parameter is missing.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý yêu cầu GET
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "get":
                    getUser(request, response);
                    break;
                case "getAll":
                    getAllUsers(request, response);
                    break;
                default:
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().println("Invalid action.");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Action parameter is missing.");
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Thêm mới một user
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(username, hashedPassword, fullname, age, gender);
        boolean success = userDAO.addUser(user);

        if (success) {
            response.getWriter().println("User added successfully.");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Failed to add user.");
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra xem người dùng có tồn tại và mật khẩu khớp không
        boolean authenticated = userDAO.authenticateUser(username, password);

        if (authenticated) {
            // Đăng nhập thành công, thiết lập thuộc tính session
            request.getSession().setAttribute("authenticated", true);
            // Chuyển hướng sang trang listbook.jsp
            response.sendRedirect("listbook");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Invalid username or password.");
        }
    }

    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> userList = userDAO.getAllUsers();

        // Chuyển đổi danh sách người dùng sang JSON
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // Định dạng ngày tháng nếu cần
        String json = gson.toJson(userList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Cập nhật thông tin của user
        // Lấy thông tin từ request
        Long userId = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

        User user = new User(userId, username, password, fullname, age, gender);
        boolean success = userDAO.updateUser(user);

        if (success) {
            response.getWriter().println("User updated successfully.");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Failed to update user.");
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Xóa một user
        // Lấy thông tin từ request
        Long userId = Long.parseLong(request.getParameter("id"));
        boolean success = userDAO.deleteUser(userId);

        if (success) {
            response.getWriter().println("User deleted successfully.");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Failed to delete user.");
        }
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Lấy thông tin của một user dựa trên ID
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userDAO.getUserById(userId);

        if (user != null) {
            String json = gson.toJson(user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("User not found.");
        }
    }

}
