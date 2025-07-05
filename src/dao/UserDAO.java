package dao;

import model.User;
import util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User login(String username, String password) {
        String sql = "SELECT a.*, i.name AS instructor_name FROM accounts a LEFT JOIN instructors i ON a.username = i.email WHERE a.username = ? AND a.password = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getObject("student_id") != null ? rs.getString("student_id") : null,
                        rs.getObject("instructor_id") != null ? rs.getString("instructor_id") : null,
                        rs.getString("instructor_name")
                );
            }
        } catch (SQLException e) {
            System.out.println("Lỗi Truy Vấn: "+e.getMessage());
        }
        return null;
    }
}
