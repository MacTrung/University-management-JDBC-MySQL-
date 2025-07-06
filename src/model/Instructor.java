package model;

public class Instructor {
    private String instructorId;
    private String name;
    private String email;

    public Instructor() {
    }

    public Instructor(String instructorId, String name, String email) {
        this.instructorId = instructorId;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
