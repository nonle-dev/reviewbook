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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author nonle
 */
@WebServlet(name="BookDetailServlet", urlPatterns={"/detail"})
public class BookDetailServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");

        // Lấy id của cuốn sách từ request parameter
        int bookId = Integer.parseInt(request.getParameter("id"));

        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin chi tiết của cuốn sách dựa trên id
        BookDAO bookDao = new BookDAO();
        Book book = bookDao.getBookById(bookId);

        // Chuyển đổi đối tượng Book thành chuỗi JSON
        Gson gson = new Gson();
        String json = gson.toJson(book);

        // Gửi chuỗi JSON về cho client
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}