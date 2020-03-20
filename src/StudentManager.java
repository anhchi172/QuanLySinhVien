import java.io.*;
import java.util.*;

public class StudentManager implements IStudentManager, Comparable<Student>, Comparator<Student> {
    private ArrayList<Student> al;

    public StudentManager(){
        al = new ArrayList<Student>();
    }


    public void addStudent(Student s) {
        al.add(s);
        try {
            File file = new File("C://Users//Chi Hoang//,IdeaProjects//StudentManager//src//Student.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s.toString());
            bw.close();
            System.out.println("Da add student vao file");
        } catch (IOException ioe) {
            System.out.println("Exception occurred: ");
            ioe.printStackTrace();

        }
    }


    public void editStudent(int id, Student n) throws IOException {
        Scanner scan = new Scanner(System.in);
        //boolean found = false;
        String old = findStudentById(id).toString();
        File fileToBeModified = new File("C://Users//Chi Hoang//IdeaProjects//StudentManager//src//Student.txt");
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        String line = reader.readLine();
        while (line != null) {
            oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll(old.toString(), n.toString());
        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(newContent);
        reader.close();
        writer.close();

      /* for (Student s: al){
            if (s.getId() == id){
                s = n;
                System.out.println("Da update thong tin hoc sinh voi ma id " + id);
                found = true;
            }
            if (!found){
                System.out.println("Loi ko tim thay hoc sinh voi ma id " + id);
            }
        }*/
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
        String filePath = "C://Users//Chi Hoang//IdeaProjects//StudentManager//src//Student.txt";
        String result = fileToString(filePath);
        result = result.replaceAll(findStudentById(id).toString(),"" );
        PrintWriter writer = new PrintWriter(new File(filePath));
        writer.append(result);
        writer.flush();
        System.out.println("Delete student successful");
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
    }

    public String fileToString (String filePath) throws Exception{

        String input = null;
        Scanner sc = new Scanner(new File("C://Users//Chi Hoang//IdeaProjects//StudentManager//src//Student.txt"));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }
   /* static class Sortbygpa implements Comparator<Student>{
        public int compare(Student a, Student b){
            return a.getGpa();
        }
    }*/

   public int compareTo(Student b){
            return 0;
        }


    public int compare(Student a, Student b) {
        return a.getGpa() - b.getGpa();

    }


    public void sortStudent(String choice) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C://Users//Chi Hoang//IdeaProjects//StudentManager//src//Student.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        String currentLine = br.readLine();
        while (currentLine!= null){
            lines.add(currentLine);
            currentLine = br.readLine();
        }
        if(choice.equalsIgnoreCase("name")) {
            Collections.sort(lines);
            /*System.out.println("\nSorted by name");
            for (int i = 0; i < al.size(); i++)
                System.out.println(al.get(i).toString());
                */

        }
        else {
            Collections.sort(lines);
           /* for (int i = 0; i < al.size(); i++)
                System.out.println(al.get(i).toString());
                */

        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("C://Users//Chi Hoang//IdeaProjects//StudentManager//src//Student.txt"));
        for (String line : lines){
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
    // Error: type void is not allowed here
    public void showStudent(){
       for(Student s: al){
           System.out.println(s.toString());
       }
        //al.stream().forEach(System.out.println(toString()));

    }

    public Optional<Student> findStudentById(int id){
        Optional<Student> n = al.stream().filter(Student -> Student.getId() == id).findFirst();
        if(n.getClass().equals("Student"))
            return n;
        else{
            System.out.println("Cannot find Student with id "+ id );
            return null;
        }
    }

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
