import java.io.*;
import java.util.*;

public class StudentManager extends StudentDAO implements IStudentManager, Comparable<Student>, Comparator<Student> {
    private ArrayList<Student> al;

    public StudentManager() {
        al = new ArrayList<Student>();
    }


    public void addStudent(Student s) {
        al.add(s);
        addToFile(al);

    }


    public void editStudent(int id, Student n) throws IOException {
        //Scanner scan = new Scanner(System.in);
        boolean found = false;
        String old;

        for (Student s : al) {
            if (s.getId() == id) {
                old = s.toString();
                s = n;
                String toReplace = n.toString();
                editFile(old, toReplace);
                System.out.println("Da update thong tin hoc sinh voi ma id " + id);
                found = true;
            }
            if (!found) {
                System.out.println("Loi ko tim thay hoc sinh voi ma id " + id);
            }
        }
        /*Student[] s = (Student[]) al.stream().filter(Student -> Student.getId() == id).toArray();
        if (s.length!=0) {
            s[0] = nhap();

        }
        else {
            System.out.println("Loi ko tim thay hoc sinh voi ma id " + id);
        }*/
           /* System.out.print("Nhap ten can sua: ");
            String name = scan.next();
            s[0].setName(String name);
            System.out.print("Nhap tuoi can sua ");
            int age = checkInput(1, Integer)*/

    }


    public void deleteStudent(int id) throws Exception {
        //boolean removed = false;
        try {
            while (al.size() > 0) {
                for (Student s : al) {
                    if (s.getId() == id) {

                        deleteFromFile(s.toString());
                        System.out.println("Da xoa hoc sinh voi ma id " + id);
                        al.remove(s);
                        //  removed = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Loi ko tim thay hoc sinh voi ma id " + id);
            e.printStackTrace();
        }
    }

        /*ArrayList<Student> toRemove = new ArrayList<Student>();
       al.stream().filter(Student -> Student.getId() == id).forEach(Student -> toRemove.add(Student));
       //PrintWriter pw = new PrintWriter("")
       if (toRemove.size()!=0) {
           al.removeAll(toRemove);
           System.out.println("Da xoa hoc sinh voi id " + id);
       }
       else{
           System.out.println("Ko tim thay hoc sinh voi id "+ id);
       }*/



   /* static class Sortbygpa implements Comparator<Student>{
        public int compare(Student a, Student b){
            return a.getGpa();
        }
    }*/

    public int compareTo(Student b) {
        return 0;
    }


    public int compare(Student a, Student b) {
        return a.getGpa() - b.getGpa();

    }


    public void sortStudent(String choice) throws IOException {
        try {
            sortFile(choice);
        } catch (Exception e) {
            System.out.println("Exception occurred: ");
            e.printStackTrace();
        }

    }

    // Error: type void is not allowed here
    public void showStudent() {
        for (Student s : al) {
            System.out.println(s.toString());
        }
        //al.stream().forEach(System.out.println(toString()));

    }

    public Student findStudentById(int id) {
        for (Student s : al) {
            if (s.getId() == id)
                return s;
        }
        System.out.println("Cannot find Student with id " + id);
        return null;
    }


    /*public Optional<Student> findStudentById(int id){
        Optional<Student> n = al.stream().filter(Student -> Student.getId() == id).findFirst();
        if(n.getClass().equals("Student"))
            return n;
        else{
            System.out.println("Cannot find Student with id "+ id );
            return null;
        }
    }*/

    @Override
    public void exit() {
        return;
    }


    private static int checkInput(int a, int b) {
        Scanner scan = new Scanner(System.in);
        try {
            int choice = scan.nextInt();

            while (choice < a || choice > b) {
                System.out.println("Du lieu nhap khong phu hop voi yeu cau. Vui long nhap lai:");
                choice = scan.nextInt();
            }


            return choice;
        } catch (Exception e) {
            System.out.println("Du lieu nhap khong phu hop voi yeu cau. Vui long nhap lai:");
            return checkInput(a, b);
        }
    }


    //List<String> result = names.stream()
    //     .filter(name -> name.startsWith("A"))
    //     .collect(Collectors.toList());
}
