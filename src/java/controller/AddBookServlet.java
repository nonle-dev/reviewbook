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
import java.sql.Timestamp;
import model.Book;

/**
 *
 * @author nonle
 */
@WebServlet(name = "AddBookServlet", urlPatterns = {"/AddBookServlet"})
public class AddBookServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin từ request
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String genre = request.getParameter("genre");
        String image = request.getParameter("image");
        String content = request.getParameter("content");

        // Tạo một đối tượng Book
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setGenre(genre);
        book.setImage(image);
        book.setContent(content);
        book.setDatecreated(new Timestamp(System.currentTimeMillis())); // Lấy thời gian hiện tại

        // Gọi phương thức insertBook từ BookDao để thêm sách vào cơ sở dữ liệu
        BookDAO bookDao = new BookDAO();
        boolean success = bookDao.insertBook(book); // Trả về thông báo lỗi
        if (success) {
            response.getWriter().write("Book added successfully!"); // Trả về thông báo thành công
        } else {
            response.getWriter().write("Failed to add book."); // Trả về thông báo lỗi
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
