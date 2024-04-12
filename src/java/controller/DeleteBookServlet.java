/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author nonle
 */
@WebServlet(name = "DeleteBookServlet", urlPatterns = {"/DeleteBookServlet"})
public class DeleteBookServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteBookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                // Chuyển đổi giá trị của tham số "id" thành số nguyên
                int bookId = Integer.parseInt(idParameter);

                // Gọi phương thức xóa cuốn sách từ lớp BookDAO
                BookDAO bookDAO = new BookDAO();
                bookDAO.delete(bookId);

                // Chuyển hướng đến trang danh sách sách sau khi xóa
                response.sendRedirect("listbook");
            } catch (NumberFormatException e) {
                // Xử lý nếu giá trị của tham số "id" không phải là một số nguyên hợp lệ
                e.printStackTrace(); // Hoặc thực hiện xử lý khác tùy theo yêu cầu của ứng dụng
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
