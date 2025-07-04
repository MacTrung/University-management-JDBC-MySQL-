package controller;

import dao.StudentDAO;
import dao.UserDAO;
import model.Student;
import model.User;
import view.StudentView;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentDAO dao;
    private StudentView view;
    private UserDAO userDAO;


    public StudentController(StudentDAO dao, StudentView view, UserDAO userDAO) {
        this.dao = dao;
        this.view = view;
        this.userDAO = userDAO;
    }

    public void showAllStudents() {
        List<Student> students = dao.getAllStudents();
        view.displayStudents(students);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tên đăng nhập: ");
        String username = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String password = sc.nextLine();

        User user = UserDAO.login(username, password);
        if (user == null) {
            System.out.println("Đăng nhập thất bại.");
            return;
        }

        System.out.println("Đăng nhập thành công với vai trò: " + user.getRole());

        if ("instructor".equalsIgnoreCase(user.getRole())) {
            view.displayInstructorInfo(user.getName(), user.getUsername());
            List<Student> students = StudentDAO.getAllStudents();

            view.displayStudents(students);
        } else if ("student".equalsIgnoreCase(user.getRole()) && user.getStudentId() != null) {
            Student s = StudentDAO.getStudentById(user.getStudentId());

            view.displayStudent(s);
        } else {
            System.out.println("Vai trò không hợp lệ .");
        }
    }


}
