import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoFixed {
private static final String FILE_NAME = "Student.txt";
public void write(List<StudentFix> s){
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    try{
        File file = new File(FILE_NAME);
        if (!file.exists()){
            file.createNewFile();
        }
        fos = new FileOutputStream(file);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
    } catch(IOException e){
        e.printStackTrace();
    } finally {
        closeStream(fos);
        closeStream(oos);

    }
}

public void closeStream(InputStream is){
    if (is!=null)
    {
        try{
            is.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

public List<StudentFix> read(){
    List<StudentFix> studentList = new ArrayList<>();
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try {
        fis = new FileInputStream(new File(FILE_NAME));
        ois = new ObjectInputStream(fis);
        studentList = (List<StudentFix>) ois.readObject();
    }
    catch(FileNotFoundException e) {
        System.out.println("Student list is empty");
    }
    catch (IOException ioe) {
        ioe.printStackTrace();
    }
    catch (ClassNotFoundException c){
        c.printStackTrace();
    } finally {
        closeStream(fis);
        closeStream(ois);
    }

    return studentList;
}

private void closeStream(OutputStream os){
    if (os!= null){
        try {
            os.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
}
