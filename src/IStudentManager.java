import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStudentManager {


    public void addStudent(Student s);
    public void editStudent(int id, Student n) throws IOException;
    public void deleteStudent(int id) throws Exception;
    public void sortStudent(String choice) throws IOException;
    public void showStudent();
    public void exit();


}
