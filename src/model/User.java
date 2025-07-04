package model;

public class User {
    private String username;
    private String password;
    private String role;
    private Integer studentId; // null nếu là giảng viên
    private Integer instructorId;
    private String name; // tên người dùng

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String role, Integer studentId, Integer instructorId, String name) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.studentId = studentId;
        this.instructorId = instructorId;
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }
}
