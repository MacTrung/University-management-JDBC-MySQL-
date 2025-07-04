package model;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private int majorId;

    public Student() {
    }

    public Student(int studentId, String name, int age, int majorId) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.majorId = majorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
}
