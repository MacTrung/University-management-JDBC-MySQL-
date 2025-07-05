package model;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private String majorId;

    public Student() {
    }

    public Student(String studentId, String name, int age, String majorId) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.majorId = majorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
}
