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
import model.Book;

/**
 *
 * @author nonle
 */
@WebServlet(name = "NewestServlet", urlPatterns = {"/newest"})
public class NewestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Tạo một đối tượng BookDAO để tương tác với cơ sở dữ liệu
        BookDAO bookDAO = new BookDAO();

        // Gọi phương thức getNewestBook() để lấy thông tin về cuốn sách mới nhất
        Book newestBook = bookDAO.getNewestBook();

        // Convert the newestBook object to JSON using Gson
        Gson gson = new Gson();
        String json = gson.toJson(newestBook);

        // Set the content type and write the JSON response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
