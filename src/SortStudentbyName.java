import java.util.Comparator;

public class SortStudentbyName implements Comparator<StudentFix> {
    @Override
    public int compare(StudentFix a, StudentFix b){
        return (a.getName().compareTo(b.getName()));

    }
}
