/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO extends DBContext {

    // Method to add a new user to the database
    public boolean addUser(User user) {
        String sql = "INSERT INTO users (username, password, fullname, age, gender) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4, user.getAge());
            statement.setBoolean(5, user.isGender());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
            return false;
        }
    }
    // Kiểm tra xem người dùng có tồn tại và mật khẩu khớp không

    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String hashedPasswordFromDB = resultSet.getString("password");
                    return BCrypt.checkpw(password, hashedPasswordFromDB);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    // Method to retrieve a user from the database by ID
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractUserFromResultSet(resultSet);
                }
            }
        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
        }
        return null;
    }

    // Method to retrieve all users from the database
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                userList.add(user);
            }
        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
        }
        return userList;
    }

    // Method to update information of a user in the database
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET username=?, password=?, fullname=?, age=?, gender=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4, user.getAge());
            statement.setBoolean(5, user.isGender());
            statement.setLong(6, user.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
            return false;
        }
    }

    // Method to delete a user from the database by ID
    public boolean deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            // Handle the exception appropriately
            ex.printStackTrace();
            return false;
        }
    }

    // Method to extract user information from ResultSet
    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setFullname(resultSet.getString("fullname"));
        user.setAge(resultSet.getInt("age"));
        user.setGender(resultSet.getBoolean("gender"));
        return user;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Retrieve all users from the database
        List<User> userList = userDAO.getAllUsers();

        // Print the details of each user
        for (User user : userList) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Full Name: " + user.getFullname());
            System.out.println("Age: " + user.getAge());
            System.out.println("Gender: " + (user.isGender() ? "Male" : "Female"));
            System.out.println();
        }
    }

}
