package view;

import model.Student;

import java.util.List;

public class StudentView {
    public void displayStudents(List<Student> students) {
        System.out.println("--- Danh sách sinh viên ---");
        for (Student s : students) {
            System.out.printf("ID: %s | Name: %s | Age: %d | Major ID: %s\n",
                    s.getStudentId(), s.getName(), s.getAge(), s.getMajorId());
        }
    }
    public void displayStudent(Student s) {
        if (s != null) {
            System.out.printf("ID: %s | Name: %s | Age: %d | Major ID: %s\n",
                    s.getStudentId(), s.getName(), s.getAge(), s.getMajorId());
        } else {
            System.out.println("Không tìm thấy thông tin sinh viên.");
        }
    }
    public void displayInstructorInfo(String name, String username) {
        System.out.printf("Thông tin giảng viên\nTên: %s\nEmail: %s\n", name, username);
    }
}
