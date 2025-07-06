package dao;

import model.Instructor;
import util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {
    public static List<Instructor> getAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        String sql = "SELECT * FROM instructors";

        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Instructor i = new Instructor(
                        rs.getString("instructor_id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                instructors.add(i);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        } catch (Exception e) {
            System.out.print("Lỗi "+e);
        }
        return instructors;
    }

    public static Instructor getInstructorById(String instructorId) {
        String sql = "SELECT * FROM instructors WHERE instructor_id = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, instructorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Instructor(
                        rs.getString("instructor_id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        } catch (Exception e) {
            System.out.print("Lỗi "+e);
        }
        return null;
    }

    public void insertInstructor(String id, String name, String email) {
        String sql = "INSERT INTO instructors (instructor_id, name, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);

            int rows = stmt.executeUpdate();
            System.out.println("Đã thêm thành công giảng viên: " + name + " với mã: " + id);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        } catch (Exception e) {
            System.out.print("Lỗi "+e);
        }
    }

    public void updateInstructor(String id, String name, String email) {
        String sql = "UPDATE instructors SET name = ?, email = ? WHERE instructor_id = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, id);

            int rows = stmt.executeUpdate();
            System.out.println("Đã cập nhật giảng viên: " + name);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        } catch (Exception e) {
            System.out.print("Lỗi "+e);
        }
    }

    public void deleteInstructor(String id) {
        String sql = "DELETE FROM instructors WHERE instructor_id = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            int rows = stmt.executeUpdate();
            System.out.println("Đã xoá thành công giảng viên với mã: " + id);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        } catch (Exception e) {
            System.out.print("Lỗi "+e);
        }
    }
}


