/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.google.gson.Gson;
import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author nonle
 */
@WebServlet(name="SearchServlet", urlPatterns={"/search"})
public class SearchServlet extends HttpServlet {
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");
        List<Book> books = null;
        if (searchTerm != null && !searchTerm.isEmpty()) {
            try {
                BookDAO bookDao = new BookDAO();
                books = bookDao.searchBooks(searchTerm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Nếu không có từ khóa tìm kiếm, lấy tất cả sách
            try {
                BookDAO bookDao = new BookDAO();
                books = bookDao.getAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//         Chuyển danh sách sách sang dạng JSON và gửi về trình duyệt
        String json = new Gson().toJson(books);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
