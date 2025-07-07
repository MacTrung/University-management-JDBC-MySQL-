package dao;

import model.Student;
import util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getString("student_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("major_id")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("nhập sai kiểu dữ liệu rồi");
        }catch (Exception e){
            System.out.print("Lỗi "+e);
        }
        return students;
    }

    public static Student getStudentById(String studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("student_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("major_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("nhập sai kiểu dữ liệu rồi");
        }catch (Exception e){
            System.out.print("Lỗi "+e);
        }
        return null;
    }

    public void insertStudent(String id, String name, int age, String majorId) {
        //String sql = "INSERT INTO students (student_id, name, age, major_id) VALUES (?, ?, ?, ?)";
        String sql = "CALL AddNewStudent(?, ?, ?, ?, 'sv' ?, '123456')"; //cho pass

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, majorId);
            stmt.setString(5, id);

            int rows = stmt.executeUpdate();
            System.out.println("Đã thêm thành công sinh viên: " + name +", với mã: "+id);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("nhập sai kiểu dữ liệu rồi");
        }catch (Exception e){
            System.out.print("Lỗi "+e);
        }
    }

    public void UpdateStudent(String id, String name, int age, String majorId) {
        String sql = "UPDATE students SET name = ?, age = ?, major_id = ? WHERE student_id = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, majorId);
            stmt.setString(4, id);

            int rows = stmt.executeUpdate();
            System.out.println("truy vấn thành công: "+rows);
            System.out.println("Đã sửa sinh viên: " + name);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("nhập sai kiểu dữ liệu rồi");
        }catch (Exception e){
            System.out.print("Lỗi "+e);
        }
    }

    public void DeleteStudent(String id, String name, int age, String majorId) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            //stmt.setString(2, name);
            //stmt.setInt(3, age);
            //stmt.setString(4, majorId);

            int rows = stmt.executeUpdate();
            System.out.println("truy vấn thành công: "+rows);
            System.out.println("Đã xoá thành công sinh viên: " + name +" với mã: "+id);
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn rồi: "+e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("nhập sai kiểu dữ liệu rồi");
        }catch (Exception e){
            System.out.print("Lỗi "+e);
        }
    }



}
