import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentManagerFixed implements IStudentManager{
    private static Scanner scanner = new Scanner(System.in);
    private List<StudentFix> studentList;
    private StudentDaoFixed studentDaoFixed;

    public StudentManagerFixed(){
        studentDaoFixed = new StudentDaoFixed();
        studentList = studentDaoFixed.read();
    }

    public void addStudent(){
        int id = inputId();
        System.out.println("Student id: " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        float gpa = inputGpa();
        StudentFix student = new StudentFix(id, name, age, address, gpa);
        studentList.add(student);
        studentDaoFixed.write(studentList);
    }

    public void editStudent(int id){
        boolean existed = false;
        int size = studentList.size();
        for (int i = 0; i< size; i++){
            if (studentList.get(i).getId() == id){
                existed = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setGpa(inputGpa());
                break;

            }
        }
        if (!existed){
            System.out.println("id = "+ id + "does not exist");

        }
        else{
            studentDaoFixed.write(studentList);
        }

    }

    public void deleteStudent(int id){
        StudentFix student = null;
        int size = studentList.size();
        for (int i = 0; i< size; i++){
            if (studentList.get(i).getId() == id){
                student = studentList.get(i);
                break;
            }
        }
        if (student != null){
            studentList.remove(student);
            studentDaoFixed.write(studentList);
        } else{
            System.out.println("id "+ id + "does not exist.");
        }
    }

    public void sortStudentByName(){
        Collections.sort(studentList, new SortStudentbyName());
    }

    public void sortStudentByGpa(){
        Collections.sort(studentList, new SortStudentbyGpa());
    }

    public void showStudent(){
        for (StudentFix student : studentList){
            System.out.format("%5d | ", student.getId());
            System.out.format("%20s | ", student.getName());
            System.out.format("%3d | ", student.getAge());
            System.out.format("%20s | ", student.getAddress());
            System.out.format("%10.1f%n", student.getGpa());


        }
    }

    public int inputId(){
        System.out.print("Input student id: ");
        while (true){
            try{
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            }
            catch(NumberFormatException ex){
                System.out.print("invalid: input student id ");
            }
        }
    }

    public String inputName(){
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    private String inputAddress(){
        System.out.print("Input student address: ");
        return scanner.nextLine();
    }

    public byte inputAge(){
        System.out.print("Input student age: ");
        while (true){
            try{
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age <0 || age >150){
                    throw new NumberFormatException();
                }

                return age;

            }catch (NumberFormatException ex){
                System.out.print("Invalid. Input student id again: ");

            }

        }
    }

    public float inputGpa(){
        System.out.print("Imput student gpa: ");
        while (true){
            try{
                float gpa = Float.parseFloat((scanner.nextLine()));
                if (gpa<0 || gpa>100){
                    throw new NumberFormatException();
                }
                return gpa;

            } catch (NumberFormatException ex){
                System.out.print("Invalid. Input gpa again: ");
            }
        }
    }

    public List<StudentFix> getStudentList(){
        return studentList;
    }

    public void setStudentList(List<StudentFix> studentList){
        this.studentList = studentList;
    }
}
