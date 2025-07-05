package model;

public class User {
    private String username;
    private String password;
    private String role;
    private String studentId; // null nếu là giảng viên
    private String instructorId;
    private String name; // tên người dùng

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String role, String studentId, String name, String instructorId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.studentId = studentId;
        this.name = name;
        this.instructorId = instructorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
