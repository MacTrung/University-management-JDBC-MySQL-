import controller.StudentController;
import dao.StudentDAO;
import dao.UserDAO;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentView view = new StudentView();
        UserDAO userDAO = new UserDAO();

        StudentController controller = new StudentController(studentDAO, view, userDAO);
        controller.run();
    }
}
