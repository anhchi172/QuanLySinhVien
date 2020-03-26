import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStudentManager {


    void addStudent();
    void editStudent(int id);
    void deleteStudent(int id);
    void sortStudentByName();
    void sortStudentByGpa();
    void showStudent();
    int inputId();

}
