package controller;

import dao.StudentDAO;
import dao.UserDAO;
import model.Student;
import model.User;
import view.StudentView;

import java.lang.classfile.instruction.SwitchCase;
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

            while (true) {
                System.out.println("\n--- Menu Giảng Viên ---");
                System.out.println("1. Hiển thị danh sách sinh viên");
                System.out.println("2. Thêm sinh viên");
                System.out.println("3. Sửa sinh viên");
                System.out.println("4. Xoá sinh viên");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> showAllStudents();
                    case 2 -> {
                        System.out.print("ID: ");
                        String id = sc.nextLine();
                        System.out.print("Tên: ");
                        String name = sc.nextLine();
                        System.out.print("Tuổi: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Mã ngành: ");
                        String majorId = sc.nextLine();
                        dao.insertStudent(id, name, age, majorId);
                    }
                    case 3 -> {
                        System.out.print("ID cần sửa: ");
                        String id = sc.nextLine();

                        System.out.print("Tên mới: ");
                        String name = sc.nextLine();

                        System.out.print("Tuổi mới: ");
                        int age = sc.nextInt();

                        System.out.print("Mã ngành mới: ");
                        String majorId = new Scanner(System.in).nextLine();

                        dao.UpdateStudent(id, name, age, majorId);
                    }
                    case 4 -> {
                        System.out.print("ID cần xoá: ");
                        String id = sc.nextLine();
                        dao.DeleteStudent(id, "", 0, "");
                    }
                    case 0 -> {
                        System.out.println("Đăng xuất...");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            }

        } else if ("student".equalsIgnoreCase(user.getRole()) && user.getStudentId() != null) {
            Student s = StudentDAO.getStudentById(user.getStudentId());

            view.displayStudent(s);


        } else {
            System.out.println("Vai trò không hợp lệ .");
        }
    }


}
