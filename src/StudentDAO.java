import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentDAO {
    public void addToFile(ArrayList<Student> al) {
        try {
            File file = new File("D://Student.txt");
            /*if (!file.exists()) {
                file.createNewFile();
            }*/
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student s: al) {
                bw.write(s.toString());
                bw.write("\n");
            }
            bw.close();
            System.out.println("Da add student vao file");
        } catch (
                IOException ioe) {
            System.out.println("Exception occurred: ");
            ioe.printStackTrace();

        }
    }

    public void editFile(String old, String n) throws IOException {
        //System.out.println(old +" ***");
        File fileToBeModified = new File("D://Student.txt");
        String oldContent = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        String line = reader.readLine();
        while (line != null) {
            oldContent = oldContent + line + System.lineSeparator();
            line = reader.readLine();
        }
        String newContent = oldContent.replaceAll(old, n);

        FileWriter writer = new FileWriter(fileToBeModified);
        writer.write(newContent);
        System.out.println("Edit thanh cong ***");
        reader.close();
        writer.close();
    }

    public String fileToString (String filePath) throws Exception{

        String input = null;
        Scanner sc = new Scanner(new File("D://Documents//Student.txt"));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }
    public void deleteFromFile(String s){
        try{
        String filePath = "D://Documents//Student.txt";
        String result = fileToString(filePath);
        result = result.replaceAll(s,"" );
        PrintWriter writer = new PrintWriter(new File(filePath));
        writer.append(result);
        writer.flush();
        System.out.println("Delete student successful");}
        catch (Exception e){
            System.out.println("Exception occurred: ");
            e.printStackTrace();

        }
    }

    public void sortFile (String choice) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D://Documents//Student.txt"));
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
        BufferedWriter bw = new BufferedWriter(new FileWriter("D://Documents//Student.txt"));
        for (String line : lines){
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
