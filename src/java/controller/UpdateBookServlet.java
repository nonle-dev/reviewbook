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
import model.Book;
import java.sql.Timestamp;

/**
 *
 * @author nonle
 */
@WebServlet(name = "UpdateBookServlet", urlPatterns = {"/updatebook"})
public class UpdateBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        if (idParameter != null && !idParameter.isEmpty()) {
            int id = Integer.parseInt(idParameter);

            // Lấy thông tin cuốn sách cần cập nhật từ ID
            BookDAO bookDAO = new BookDAO();
            Book bookToUpdate = bookDAO.getBookById(id);

            // Đặt thuộc tính 'book' trong request và chuyển hướng đến trang cập nhật
            request.setAttribute("book", bookToUpdate);
            request.getRequestDispatcher("updatebook.jsp").forward(request, response);
        } else {
            // Nếu không có ID được cung cấp, chuyển hướng người dùng đến trang không tìm thấy
            response.getWriter().write("Failed to add book.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin cập nhật từ các tham số form
        String idParameter = request.getParameter("id");
        if (idParameter != null && !idParameter.isEmpty()) {
            int id = Integer.parseInt(idParameter);
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String description = request.getParameter("description");
            String genre = request.getParameter("genre");
            String image = request.getParameter("image");
            String content = request.getParameter("content");
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

            // Tạo đối tượng sách với thông tin cập nhật
            Book updatedBook = new Book(id, title, author, description, genre, image, content, currentTimestamp);

            // Gọi phương thức cập nhật sách từ lớp BookDAO
            BookDAO bookDAO = new BookDAO();
            boolean updateSuccess = bookDAO.updateBook(updatedBook);

            if (updateSuccess) {
                // Nếu cập nhật thành công, chuyển hướng người dùng đến trang danh sách sách
                response.sendRedirect("listbook");
            } else {
                // Nếu cập nhật không thành công, hiển thị thông báo lỗi
                response.getWriter().println("Update failed. Please try again.");
            }
        } else {
            // Nếu không có tham số "id" được gửi trong request, xử lý lỗi hoặc chuyển hướng người dùng đến trang không tìm thấy
            response.getWriter().println("Error: No book ID provided.");
        }
    }

}
