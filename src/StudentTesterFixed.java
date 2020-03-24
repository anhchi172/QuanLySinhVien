import javax.swing.text.html.StyleSheet;
import java.util.Scanner;

public class StudentTesterFixed {
  public static  Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        IStudentManager studentManager = (IStudentManager) new StudentManagerFixed();
        int studentId;

        showMenu();
        while (true){
            choose = scan.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.editStudent(studentId);
                    break;
                case "3":
                    studentId = studentManager.inputId();
                    studentManager.deleteStudent(studentId);
                    break;
                case "4":
                    studentManager.sortStudentByGpa();
                    break;
                case "5":
                    studentManager.sortStudentByName();
                case "0":
                    System.out.println("Exit");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid. Please choose action in menu below: ");
                    break;
            }
            if (exit) {
                break;
            }

            showMenu();


            }
        }

        public static void showMenu(){
        System.out.println("Choose: ");
        System.out.println("1. Add student");
        System.out.println("2. Edit student by id");
        System.out.println("3. Delete student by id");
        System.out.println("Sort student by gpa");
        System.out.println("Sort student by name");
        System.out.println("6. SHow student");
        System.out.println("0. Exit");


    }
}
