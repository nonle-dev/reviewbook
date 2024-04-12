/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Timestamp;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nonle
 */
public class BookDAO extends DBContext {

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = "select * from books";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book c = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("description"), rs.getString("genre"), rs.getString("image"),
                        rs.getString("content"), rs.getTimestamp("datecreated"));
                list.add(c);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //insert
    public boolean insertBook(Book book) {
        String sql = "INSERT INTO books (title, author, description, genre, image, content, datecreated) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getDescription());
            statement.setString(4, book.getGenre());
            statement.setString(5, book.getImage());
            statement.setString(6, book.getContent());
            statement.setTimestamp(7, book.getDatecreated());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
            return false;
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }

    public boolean updateBook(Book book) {
        String sql = "UPDATE books SET title=?, author=?, description=?, genre=?, image=?, content=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getDescription());
            statement.setString(4, book.getGenre());
            statement.setString(5, book.getImage());
            statement.setString(6, book.getContent());
            statement.setInt(7, book.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
            return false;
        }
    }

//tìm book khi có id
    public Book getBookById(int id) {
        String sql = "select * from books where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book c = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("description"), rs.getString("genre"), rs.getString("image"),
                        rs.getString("content"), rs.getTimestamp("datecreated"));
                return c;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // Hàm tìm kiếm sách theo từ khóa
    public List<Book> searchBooks(String searchTerm) throws SQLException {

        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR genre LIKE ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, "%" + searchTerm + "%");
            st.setString(2, "%" + searchTerm + "%");
            st.setString(3, "%" + searchTerm + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("description"), rs.getString("genre"), rs.getString("image"), rs.getString("content"), rs.getTimestamp("datecreated"));
                list.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error while searching books: " + e.getMessage());
        }
        // In ra dữ liệu đã được truy vấn
        System.out.println("Searched books for term '" + searchTerm + "': " + list);
        return list;
    }

    // Phương thức để lấy thông tin về cuốn sách mới nhất
    public Book getNewestBook() {
        String sql = "SELECT * FROM books ORDER BY datecreated DESC LIMIT 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book newestBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                        rs.getString("description"), rs.getString("genre"), rs.getString("image"),
                        rs.getString("content"), rs.getTimestamp("datecreated"));
                return newestBook;
            }
        } catch (SQLException e) {
            System.out.println("Error getting newest book: " + e.getMessage());
        }
        return null;
    }

    private Book extractBookFromResultSet(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
                rs.getString("description"), rs.getString("genre"), rs.getString("image"),
                rs.getString("content"), rs.getTimestamp("datecreated"));
    }

    public static void main(String[] args) {
        BookDAO c = new BookDAO();
        List<Book> list = c.getAll();
        System.out.println(list.get(0).getTitle());
        
        BookDAO bookDAO = new BookDAO();
    
    // Kiểm tra phương thức getNewestBook()
    Book newestBook = bookDAO.getNewestBook();
    if (newestBook != null) {
        System.out.println("Newest Book:");
        System.out.println("ID: " + newestBook.getId());
        System.out.println("Title: " + newestBook.getTitle());
        System.out.println("Author: " + newestBook.getAuthor());
        System.out.println("Description: " + newestBook.getDescription());
        System.out.println("Genre: " + newestBook.getGenre());
        System.out.println("Image: " + newestBook.getImage());
        System.out.println("Content: " + newestBook.getContent());
        System.out.println("Date Created: " + newestBook.getDatecreated());
    } else {
        System.out.println("No newest book found.");
    }
    }
}
